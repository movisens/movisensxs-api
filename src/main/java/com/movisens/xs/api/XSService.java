package com.movisens.xs.api;

import com.google.gson.JsonElement;
import com.movisens.xs.api.exceptions.MovisensXSException;
import com.movisens.xs.api.models.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface XSService {
    @GET("studies/{studyId}")
    Call<Study> getStudy(@Path("studyId") Integer studyId) throws MovisensXSException;

    @GET("studies/{studyId}/probands")
    Call<List<Proband>> getProbands(@Path("studyId") Integer studyId) throws MovisensXSException;

    @GET("studies/{studyId}/results")
    Call<List<Result>> getResults(@Path("studyId") Integer studyId) throws MovisensXSException;

    @GET("studies/{studyId}/results")
    Call<JsonElement> getResultsAsJson(@Path("studyId") Integer studyId) throws MovisensXSException;

    @Headers({"Accept: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"})
    @GET("studies/{studyId}/results")
    Call<ResponseBody> getResultsAsXLSX(@Path("studyId") Integer studyId) throws MovisensXSException;

    @GET("studies/{studyId}/probands/{probandId}/results")
    Call<List<Result>> getResults(@Path("studyId") Integer studyId, @Path("probandId") Integer probandId) throws MovisensXSException;

    @GET("studies/{studyId}/probands/{probandId}/results")
    Call<JsonElement> getResultsAsJson(@Path("studyId") Integer studyId, @Path("probandId") Integer probandId) throws MovisensXSException;

    @Headers({"Accept: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"})
    @GET("studies/{studyId}/probands/{participantId}/results")
    Call<ResponseBody> getResultsAsXLSX(@Path("studyId") Integer studyId, @Path("participantId") Integer participantId) throws MovisensXSException;

    @Streaming
    @GET("studies/{studyId}/probands/{probandId}/unisens")
    Call<ResponseBody> getMobileSensingAsUnisensZip(@Path("studyId") Integer studyId, @Path("probandId") Integer probandId) throws MovisensXSException;

    @GET("studies/{studyId}/probands/{probandId}/messages")
    Call<List<Message>> getMessages(@Path("studyId") Integer studyId, @Path("probandId") Integer probandId)
            throws MovisensXSException;

    @POST("studies/{studyId}/probands/{probandId}/messages")
    Call<Message> sendMessage(@Path("studyId") Integer studyId, @Path("probandId") Integer probandId,
                              @Query("sendingUserEmail") String sendingUserEmail, @Query("textMessage") String textMessage)
            throws MovisensXSException;

    @POST("studies/{studyId}/monitoring")
    Call<ApiResponse> sendMonitoring(@Path("studyId") Integer studyId, @Body MonitoringRequest monitoringRequest)
            throws MovisensXSException;

    @GET("studies/{studyId}/monitoring")
    Call<ApiResponse> getMonitoring(@Path("studyId") Integer studyId)
            throws MovisensXSException;

    @GET("studies/{studyId}/monitoring/proband/{probandId}")
    Call<ApiResponse> getMonitoringPerProband(@Path("studyId") Integer studyId,
                                              @Path("probandId") Integer probandId, @Query("date") String date)
            throws MovisensXSException;
}