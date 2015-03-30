package com.movisens.xs.api.test;

import static com.jayway.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.Callable;

import org.junit.Test;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.movisens.xs.api.AuthRequestInterceptor;
import com.movisens.xs.api.XSService;
import com.movisens.xs.api.models.Proband;
import com.movisens.xs.api.models.Result;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'Juergen' at '22.06.14 22:50' with Gradle 1.11
 *
 * @author Juergen, @date 22.06.14 22:50
 */
public class ApiTest {
	private static final String API_URL = "https://hoc-hc013.hoc.uni-karlsruhe.de/api/v2";

	AuthRequestInterceptor authRequestInterceptor = new AuthRequestInterceptor(
			"e4prtw8zcmw3a4evuesyjvzmfdfop25hl9zq9h2p");

	XSService service = new RestAdapter.Builder()
			.setRequestInterceptor(authRequestInterceptor)
			.setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(API_URL)
			.build().create(XSService.class);

	@Test
	public void testGetProbands() {
		List<Proband> probands = service.getProbands(989);
		assertEquals("getProbands should return 3 result", 3, probands.size());
		assertEquals("getProbands user 0 should have status 'finished'",
				"finished", probands.get(0).getStatus());
	}

	private List<Proband> asyncProbands = null;

	@Test
	public void testGetProbandsAsync() {
		service.getProbands(989, new Callback<List<Proband>>() {
			@Override
			public void success(List<Proband> probands, Response response) {
				asyncProbands = probands;
			}

			@Override
			public void failure(RetrofitError error) {
				fail("Error receiving probands: " + error.getMessage());
			}
		});
		await().atMost(5, SECONDS).until(new Callable<Boolean>() {
			public Boolean call() throws Exception {
				return asyncProbands != null;
			}
		});
		assertEquals("getProbands should return 3 result", 3,
				asyncProbands.size());
		assertEquals("getProbands user 0 should have status 'finished'",
				"finished", asyncProbands.get(0).getStatus());
	}

	@Test
	public void testGetResults() {
		List<Result> results = service.getResults(989);
		assertEquals("getResults should return 40 results", 40, results.size());
	}

	@Test
	public void testGetResultsAsJson() {
		JsonElement jsonResults = service.getResultsAsJson(989);

		Gson gson = new Gson();
		Type collectionType = new TypeToken<List<MyResult>>() {
		}.getType();
		List<MyResult> results = gson.fromJson(jsonResults, collectionType);

		assertEquals("getResults should return 40 results", 40, results.size());
		assertEquals("getResults first result should have item_65_2 set to 1",
				1, results.get(0).item_65_2);
	}

	private List<Result> asyncResults = null;

	@Test
	public void testGetResultsAsync() {
		service.getResults(989, new Callback<List<Result>>() {
			@Override
			public void success(List<Result> results, Response response) {
				asyncResults = results;
			}

			@Override
			public void failure(RetrofitError error) {
				fail("Error receiving results: " + error.getMessage());
			}
		});
		await().atMost(5, SECONDS).until(new Callable<Boolean>() {
			public Boolean call() throws Exception {
				return asyncResults != null;
			}
		});
		assertEquals("getResults should return 40 results", 40,
				asyncResults.size());
	}
}
