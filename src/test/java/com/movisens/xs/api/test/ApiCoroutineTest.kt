package com.movisens.xs.api.test

import com.movisens.xs.api.XSApi
import com.movisens.xs.api.XSService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import retrofit2.await

@OptIn(ExperimentalCoroutinesApi::class)
class ApiCoroutineTest {

    companion object {
        private const val SERVER_URL = "https://xs.movisens.com"
        private const val API_KEY = "0qlvej2aosjwv7mimvebd7dsz4won2kj4zun4x4o"
        private const val USER_EMAIL = "Juergen.Stumpp+movisensXSContinuousIntegration@gmail.com"
        private const val STUDY_ID = 5180
        private const val PARTICIPANT_ID = 1
    }

    private val service =
        XSApi.Builder(API_KEY)
            .setServer(SERVER_URL)
            .setLogLevel(HttpLoggingInterceptor.Level.BASIC)
            .build()
            .create(XSService::class.java)

    @Test
    fun testCoroutine() = runTest {
        val study = service.getStudy(STUDY_ID).await()
        assertNotNull(study)
        assertEquals(STUDY_ID, study.id)
        assertEquals("movisensXS API for Java", study.name)
    }
}