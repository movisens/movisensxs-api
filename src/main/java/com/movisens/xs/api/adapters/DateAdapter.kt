package com.movisens.xs.api.adapters

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.text.DateFormat
import java.text.SimpleDateFormat
import com.movisens.xs.api.adapters.DateAdapter
import java.io.IOException
import java.text.ParseException
import java.util.*

/**
 * Adapter for Date. Although this class appears stateless, it is not.
 * DateFormat captures its time zone and locale when it is created, which gives
 * this class state. DateFormat isn't thread safe either, so this class has
 * to synchronize its read and write methods.
 */
class DateAdapter : TypeAdapter<Date?>() {
    private val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    private val iso8601Format = buildIso8601Format()
    @Throws(IOException::class)
    override fun read(`in`: JsonReader): Date? {
        if (`in`.peek() == JsonToken.NULL) {
            `in`.nextNull()
            return null
        }
        return deserializeToDate(`in`.nextString())
    }

    @Synchronized
    private fun deserializeToDate(json: String): Date {
        try {
            return dateFormat.parse(json)
        } catch (ignored: ParseException) {
        }
        return try {
            iso8601Format.parse(json)
        } catch (e: ParseException) {
            throw JsonSyntaxException(json, e)
        }
    }

    @Synchronized
    @Throws(IOException::class)
    override fun write(out: JsonWriter, value: Date?) {
        if (value == null) {
            out.nullValue()
            return
        }
        val dateFormatAsString = iso8601Format.format(value)
        out.value(dateFormatAsString)
    }

    companion object {
        val FACTORY: TypeAdapterFactory = object : TypeAdapterFactory {
            // we use a runtime check to make sure the 'T's equal
            override fun <T> create(gson: Gson, typeToken: TypeToken<T>): TypeAdapter<T>? {
                return if (typeToken.rawType == Date::class.java) (DateAdapter() as TypeAdapter<T>) else null
            }
        }

        private fun buildIso8601Format(): DateFormat {
            val iso8601Format: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
            iso8601Format.timeZone = TimeZone.getTimeZone("UTC")
            return iso8601Format
        }
    }
}