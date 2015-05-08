package com.movisens.xs.api;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

import com.google.gson.JsonElement;
import com.movisens.xs.api.models.Proband;
import com.movisens.xs.api.models.Result;
import com.movisens.xs.api.models.Study;

public interface XSService {
	@GET("/studies/{studyId}")
	Study getStudy(@Path("studyId") Integer studyId);

	@GET("/studies/{studyId}")
	void getStudy(@Path("studyId") Integer studyId,
			Callback<List<Study>> cb);
	
	@GET("/studies/{studyId}/probands")
	List<Proband> getProbands(@Path("studyId") Integer studyId);

	@GET("/studies/{studyId}/probands")
	void getProbands(@Path("studyId") Integer studyId,
			Callback<List<Proband>> cb);

	@GET("/studies/{studyId}/results")
	List<Result> getResults(@Path("studyId") Integer studyId);

	@GET("/studies/{studyId}/results")
	JsonElement getResultsAsJson(@Path("studyId") Integer studyId);

	@GET("/studies/{studyId}/results")
	void getResults(@Path("studyId") Integer studyId, Callback<List<Result>> cb);

	@GET("/studies/{studyId}/results")
	void getResultsAsJson(@Path("studyId") Integer studyId,
			Callback<List<JsonElement>> cb);
}