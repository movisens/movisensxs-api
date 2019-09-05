package com.movisens.xs.api;

import java.util.List;

import com.google.gson.JsonElement;
import com.movisens.xs.api.exceptions.MovisensXSException;
import com.movisens.xs.api.models.*;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface XSService {
	@GET("studies/{studyId}")
	Call<Study> getStudy(@Path("studyId") Integer studyId) throws MovisensXSException;

	@GET("studies/{studyId}/probands")
	Call<List<Proband>> getProbands(@Path("studyId") Integer studyId) throws MovisensXSException;

	@GET("studies/{studyId}/results")
	Call<List<Result>> getResults(@Path("studyId") Integer studyId) throws MovisensXSException;

	@GET("studies/{studyId}/results")
	Call<JsonElement> getResultsAsJson(@Path("studyId") Integer studyId) throws MovisensXSException;

	@GET("studies/{studyId}/probands/{probandId}/results")
	Call<List<Result>> getResults(@Path("studyId") Integer studyId, @Path("probandId") Integer probandId) throws MovisensXSException;

	@GET("studies/{studyId}/probands/{probandId}/results")
	Call<JsonElement> getResultsAsJson(@Path("studyId") Integer studyId, @Path("probandId") Integer probandId) throws MovisensXSException;

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
	Call<ApiSuccessResponse> sendMonitoring(@Path("studyId") Integer studyId, @Body MonitoringRequest monitoringRequest)
			throws MovisensXSException;

	@GET("studies/{studyId}/monitoring")
	Call<ApiSuccessResponse> getMonitoring(@Path("studyId") Integer studyId)
			throws MovisensXSException;

	@GET("studies/{studyId}/monitoring/proband/{probandId}")
	Call<ApiSuccessResponse> getMonitoringPerProband(@Path("studyId") Integer studyId,
			@Path("probandId") Integer probandId, @Query("date") String date)
			throws MovisensXSException;
}