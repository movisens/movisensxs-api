package com.movisens.xs.api.test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.movisens.xs.api.XSApi;
import com.movisens.xs.api.XSService;
import com.movisens.xs.api.exceptions.AuthorizationException;
import com.movisens.xs.api.exceptions.MovisensXSException;
import com.movisens.xs.api.models.*;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.zip.ZipFile;

import static com.jayway.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'Juergen' at '22.06.14 22:50' with Gradle 1.11
 *
 * @author Juergen, @date 22.06.14 22:50
 */
public class ApiTest {
	private static final String SERVER_URL = "https://xs.movisens.com";
	private static final String API_KEY = "0qlvej2aosjwv7mimvebd7dsz4won2kj4zun4x4o";
	private static final String USER_EMAIL = "Juergen.Stumpp+movisensXSContinuousIntegration@gmail.com";
	private static final Integer STUDY_ID = 5180;
	private static final Integer PARTICIPANT_ID = 1;

	XSService service = new XSApi.Builder(API_KEY).setServer(SERVER_URL).setLogLevel(Level.BASIC).build().create(XSService.class);

	@Test
	public void testGetMessages() throws AuthorizationException, IOException, MovisensXSException {
		Call<List<Message>> call = service.getMessages(STUDY_ID, PARTICIPANT_ID);
		List<Message> messages = call.execute().body();
		assertEquals("getMessages should return list with first message text is 'Hallo'", "Hallo",
				messages.get(0).getMessage());
	}

	@Test
	public void testSendMessage() throws AuthorizationException, IOException, MovisensXSException {
		Call<List<Message>> call = service.getMessages(STUDY_ID, PARTICIPANT_ID);
		int nrOfMessages = call.execute().body().size();
		Call<Message> sendMessageCall = service.sendMessage(STUDY_ID, PARTICIPANT_ID, USER_EMAIL, "Unit Test");
		Message message = sendMessageCall.execute().body();
		call = service.getMessages(STUDY_ID, PARTICIPANT_ID);
		int nrOfMessagesAfterSending = call.execute().body().size();
		assertEquals("getMessages should return one more message after sending", 1,
				nrOfMessagesAfterSending - nrOfMessages);
		assertEquals("sendMessage should return one message with the text 'Unit Test'", "Unit Test",
				message.getMessage());
	}

	@Test
	public void testGetStudy() throws AuthorizationException, IOException, MovisensXSException {
		Study study = service.getStudy(STUDY_ID).execute().body();
		assertEquals("getStudy should return study with id STUDY_ID", (long) STUDY_ID, study.getId());
		assertEquals("getStudy should return study which name is 'movisensXS API for Java", "movisensXS API for Java", study.getName());
	}

	@Test
	public void testGetProbands() throws AuthorizationException, IOException, MovisensXSException {
		List<Proband> probands = service.getProbands(STUDY_ID).execute().body();
		assertEquals("getProbands should return 3 result", 3, probands.size());
		assertEquals("getProbands user 2 should have status 'unknown'", "unknown", probands.get(1).getStatus());
	}

	private List<Proband> asyncProbands = null;

	@Test
	public void testGetProbandsAsync() throws MovisensXSException {
		Call<List<Proband>> call = service.getProbands(STUDY_ID);
		call.enqueue(new Callback<List<Proband>>() {

			@Override
			public void onResponse(Call<List<Proband>> call, Response<List<Proband>> response) {
				asyncProbands = response.body();
			}

			@Override
			public void onFailure(Call<List<Proband>> call, Throwable t) {
				fail("Error receiving probands: " + t.getMessage());
			}
		});
		await().atMost(5, SECONDS).until(new Callable<Boolean>() {
			public Boolean call() throws Exception {
				return asyncProbands != null;
			}
		});
		assertEquals("getProbands should return 3 result", 3, asyncProbands.size());
		assertEquals("getProbands user 2 should have status 'unknown'", "unknown", asyncProbands.get(1).getStatus());
	}

	@Test
	public void testGetResults() throws AuthorizationException, IOException, MovisensXSException {
		List<Result> results = service.getResults(STUDY_ID).execute().body();
		assertEquals("getResults should return 2 results", 2, results.size());
	}

	@Test
	public void testGetResultsPerParticipant() throws AuthorizationException, IOException, MovisensXSException {
		List<Result> results = service.getResults(STUDY_ID).execute().body();
		assertEquals("getResults should return 2 results", 2, results.size());
	}

	@Test
	public void testGetResultsAsJson() throws AuthorizationException, IOException, MovisensXSException {
		JsonElement jsonResults = service.getResultsAsJson(STUDY_ID).execute().body();

		Gson gson = new Gson();
		Type collectionType = new TypeToken<List<MyResult>>() {
		}.getType();
		List<MyResult> results = gson.fromJson(jsonResults, collectionType);

		assertEquals("getResults should return 2 results", 2, results.size());
		assertEquals("getResults first result should have others_1 set to 0", 0, results.get(0).others_1);
		assertEquals("getResults first result should have others_2 set to 1", 1, results.get(0).others_2);
		assertEquals("getResults second result should have happy_sad set to 25", 69, results.get(1).happy_sad);
	}

	private List<Result> asyncResults = null;

	@Test
	public void testGetResultsAsync() throws MovisensXSException {
		Call<List<Result>> call = service.getResults(STUDY_ID);
		call.enqueue(new Callback<List<Result>>() {

			@Override
			public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
				asyncResults = response.body();
			}

			@Override
			public void onFailure(Call<List<Result>> call, Throwable t) {
				fail("Error receiving results: " + t.getMessage());
			}
		});

		await().atMost(5, SECONDS).until(new Callable<Boolean>() {
			public Boolean call() throws Exception {
				return asyncResults != null;
			}
		});
		assertEquals("getResults should return 2 results", 2, asyncResults.size());
	}

	@Test
	public void testGetMobileSensingResultsAsUnisens() throws AuthorizationException, IOException, MovisensXSException {
		InputStream unisensZipStream = service.getMobileSensingAsUnisensZip(STUDY_ID, PARTICIPANT_ID).execute().body().byteStream();

		File targetFile = new File("test.unisenszip");
		FileUtils.copyInputStreamToFile(unisensZipStream, targetFile);
		unisensZipStream.close();
		assertEquals("Unisens file should be valid", zipIsValid(targetFile), true);
	}

	@Test
	public void testSendCompliance() throws AuthorizationException, IOException, MovisensXSException {

		Compliance compliance = new Compliance(PARTICIPANT_ID, "2019-07-16");
		ArrayList<ComplianceData> dataList = new ArrayList<ComplianceData>();

		ComplianceData complianceData1 = new ComplianceData("forms", ComplianceLevel.HIGH, "<h2>Hello</2>", true);
		ComplianceData complianceData2 = new ComplianceData("sensor", ComplianceLevel.LOW, "<h2>Participant does not complete the study</2>", true);
		ComplianceData complianceData3 = new ComplianceData("mobile sensor", ComplianceLevel.HIGH, "<h2>No participation in the study</2>", false);
		ComplianceData complianceData4 = new ComplianceData("custom", ComplianceLevel.LOW, "<h2>Study was completed</2>", false);

		dataList.add(complianceData1);
		dataList.add(complianceData2);
		dataList.add(complianceData3);
		dataList.add(complianceData4);

		compliance.setComplianceData(dataList);
		compliance.setNotifyByEmail(true);

		Call<String> sendComplianceCall = service.sendCompliance(STUDY_ID, Arrays.asList(compliance));
		String result = sendComplianceCall.execute().body();

		assertEquals("sendCompliance should return message with the text 'Success'", "Success",
				result);
	}

	private static boolean zipIsValid(final File file) {
		ZipFile zipfile = null;
		try {
			zipfile = new ZipFile(file);
			return true;
		} catch (IOException e) {
			return false;
		} finally {
			try {
				if (zipfile != null) {
					zipfile.close();
					zipfile = null;
				}
			} catch (IOException e) {
			}
		}
	}


}
