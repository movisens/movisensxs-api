package com.movisens.xs.api

import com.google.gson.JsonElement
import com.movisens.xs.api.exceptions.MovisensXSException
import com.movisens.xs.api.models.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface XSService {

    @GET("studies/{studyId}")
    @Throws(MovisensXSException::class)
    fun getStudy(@Path("studyId") studyId: Int): Call<Study>

    @GET("studies/{studyId}/probands")
    @Throws(MovisensXSException::class)
    fun getProbands(@Path("studyId") studyId: Int): Call<List<Proband>>

    @GET("studies/{studyId}/results")
    @Throws(MovisensXSException::class)
    fun getResults(@Path("studyId") studyId: Int): Call<List<Result>>

    @GET("studies/{studyId}/results")
    @Throws(MovisensXSException::class)
    fun getResultsAsJson(@Path("studyId") studyId: Int): Call<JsonElement>

    @Headers("Accept: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    @GET("studies/{studyId}/results")
    @Throws(MovisensXSException::class)
    fun getResultsAsXLSX(@Path("studyId") studyId: Int): Call<ResponseBody>

    @GET("studies/{studyId}/probands/{probandId}/results")
    @Throws(MovisensXSException::class)
    fun getResults(
        @Path("studyId") studyId: Int,
        @Path("probandId") probandId: Int
    ): Call<List<Result>>

    @GET("studies/{studyId}/probands/{probandId}/results")
    @Throws(MovisensXSException::class)
    fun getResultsAsJson(
        @Path("studyId") studyId: Int,
        @Path("probandId") probandId: Int
    ): Call<JsonElement>

    @Headers("Accept: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    @GET("studies/{studyId}/probands/{participantId}/results")
    @Throws(MovisensXSException::class)
    fun getResultsAsXLSX(
        @Path("studyId") studyId: Int,
        @Path("participantId") participantId: Int
    ): Call<ResponseBody>

    @Streaming
    @GET("studies/{studyId}/probands/{probandId}/unisens")
    @Throws(MovisensXSException::class)
    fun getMobileSensingAsUnisensZip(
        @Path("studyId") studyId: Int,
        @Path("probandId") probandId: Int
    ): Call<ResponseBody>

    @GET("studies/{studyId}/probands/{probandId}/messages")
    @Throws(MovisensXSException::class)
    fun getMessages(
        @Path("studyId") studyId: Int,
        @Path("probandId") probandId: Int
    ): Call<List<Message>>

    @POST("studies/{studyId}/probands/{probandId}/messages")
    @Throws(MovisensXSException::class)
    fun sendMessage(
        @Path("studyId") studyId: Int,
        @Path("probandId") probandId: Int,
        @Query("sendingUserEmail") sendingUserEmail: String,
        @Query("textMessage") textMessage: String
    ): Call<Message>

    @POST("studies/{studyId}/monitoring")
    @Throws(MovisensXSException::class)
    fun sendMonitoring(
        @Path("studyId") studyId: Int,
        @Body monitoringRequest: MonitoringRequest
    ): Call<ApiResponse>

    @POST("studies/{studyId}/probands/{probandId}/sendPushNotification")
    @Throws(MovisensXSException::class)
    fun sendPushNotification(
        @Path("studyId") studyId: Int,
        @Path("probandId") probandId: Int,
    ): Call<ApiResponse>
}