package com.movisens.xs.api;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

import com.google.gson.JsonElement;
import com.movisens.xs.api.exceptions.MovisensXSException;
import com.movisens.xs.api.models.Message;
import com.movisens.xs.api.models.Proband;
import com.movisens.xs.api.models.Result;
import com.movisens.xs.api.models.Study;

public interface XSService {
	@GET("/studies/{studyId}")
	Study getStudy(@Path("studyId") Integer studyId) throws MovisensXSException;

	@GET("/studies/{studyId}")
	void getStudy(@Path("studyId") Integer studyId, Callback<Study> cb);

	@GET("/studies/{studyId}/probands")
	List<Proband> getProbands(@Path("studyId") Integer studyId)
			throws MovisensXSException;

	@GET("/studies/{studyId}/probands")
	void getProbands(@Path("studyId") Integer studyId,
			Callback<List<Proband>> cb);

	@GET("/studies/{studyId}/results")
	List<Result> getResults(@Path("studyId") Integer studyId)
			throws MovisensXSException;

	@GET("/studies/{studyId}/results")
	void getResults(@Path("studyId") Integer studyId, Callback<List<Result>> cb);

	@GET("/studies/{studyId}/results")
	JsonElement getResultsAsJson(@Path("studyId") Integer studyId)
			throws MovisensXSException;

	@GET("/studies/{studyId}/results")
	void getResultsAsJson(@Path("studyId") Integer studyId,
			Callback<JsonElement> cb);

	@GET("/studies/{studyId}/probands/{probandId}/messages")
	List<Message> getMessages(@Path("studyId") Integer studyId,
			@Path("probandId") Integer probandId) throws MovisensXSException;

	@GET("/studies/{studyId}/probands/{probandId}/messages")
	void getMessages(@Path("studyId") Integer studyId,
			@Path("probandId") Integer probandId, Callback<List<Message>> cb);

	@POST("/studies/{studyId}/probands/{probandId}/messages")
	Message sendMessage(@Path("studyId") Integer studyId,
			@Path("probandId") Integer probandId,
			@Query("sendingUserEmail") String sendingUserEmail,
			@Query("textMessage") String textMessage)
			throws MovisensXSException;

	@POST("/studies/{studyId}/probands/{probandId}/messages")
	void sendMessage(@Path("studyId") Integer studyId,
			@Path("probandId") Integer probandId,
			@Query("sendingUserEmail") String sendingUserEmail,
			@Query("textMessage") String textMessage, Callback<Message> cb);
}