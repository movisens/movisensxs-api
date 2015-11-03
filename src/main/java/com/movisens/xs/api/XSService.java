package com.movisens.xs.api;

import java.util.List;

import com.google.gson.JsonElement;
import com.movisens.xs.api.exceptions.MovisensXSException;
import com.movisens.xs.api.models.Message;
import com.movisens.xs.api.models.Proband;
import com.movisens.xs.api.models.Result;
import com.movisens.xs.api.models.Study;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

public interface XSService {
	@GET("studies/{studyId}")
	Call<Study> getStudy(@Path("studyId") Integer studyId) throws MovisensXSException;

	@GET("studies/{studyId}/probands")
	Call<List<Proband>> getProbands(@Path("studyId") Integer studyId) throws MovisensXSException;

	@GET("studies/{studyId}/results")
	Call<List<Result>> getResults(@Path("studyId") Integer studyId) throws MovisensXSException;

	@GET("studies/{studyId}/results")
	Call<JsonElement> getResultsAsJson(@Path("studyId") Integer studyId) throws MovisensXSException;

	@GET("studies/{studyId}/probands/{probandId}/messages")
	Call<List<Message>> getMessages(@Path("studyId") Integer studyId, @Path("probandId") Integer probandId)
			throws MovisensXSException;

	@POST("studies/{studyId}/probands/{probandId}/messages")
	Call<Message> sendMessage(@Path("studyId") Integer studyId, @Path("probandId") Integer probandId,
			@Query("sendingUserEmail") String sendingUserEmail, @Query("textMessage") String textMessage)
					throws MovisensXSException;

}