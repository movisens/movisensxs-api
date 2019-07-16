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

	@GET("studies/{studyId}/probands/{participantId}/results")
	Call<List<Result>> getResults(@Path("studyId") Integer studyId, @Path("participantId") Integer participantId) throws MovisensXSException;

	@GET("studies/{studyId}/probands/{participantId}/results")
	Call<JsonElement> getResultsAsJson(@Path("studyId") Integer studyId, @Path("participantId") Integer participantId) throws MovisensXSException;

	@Streaming
	@GET("studies/{studyId}/probands/{participantId}/unisens")
	Call<ResponseBody> getMobileSensingAsUnisensZip(@Path("studyId") Integer studyId, @Path("participantId") Integer participantId) throws MovisensXSException;

	@GET("studies/{studyId}/probands/{probandId}/messages")
	Call<List<Message>> getMessages(@Path("studyId") Integer studyId, @Path("probandId") Integer probandId)
			throws MovisensXSException;

	@POST("studies/{studyId}/probands/{probandId}/messages")
	Call<Message> sendMessage(@Path("studyId") Integer studyId, @Path("probandId") Integer probandId,
			@Query("sendingUserEmail") String sendingUserEmail, @Query("textMessage") String textMessage)
			throws MovisensXSException;

	@POST("studies/{studyId}/probands/{probandId}/compliance/{date}")
	Call<String> sendCompliance(@Path("studyId") Integer studyId, @Path("probandId") Integer probandId,
							  @Path("date") String date, @Body Compliance compliance)
			throws MovisensXSException;
}