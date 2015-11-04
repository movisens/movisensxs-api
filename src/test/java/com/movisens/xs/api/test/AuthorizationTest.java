package com.movisens.xs.api.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.movisens.xs.api.XSApi;
import com.movisens.xs.api.XSService;
import com.movisens.xs.api.exceptions.AuthorizationException;
import com.movisens.xs.api.models.Study;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'Juergen' at '22.06.14 22:50' with Gradle 1.11
 *
 * @author Juergen, @date 22.06.14 22:50
 */
public class AuthorizationTest {
	private static final String SERVER_URL = "https://hoc-hc013.hoc.uni-karlsruhe.de";
	private static final String API_KEY = "WRONG KEY";

	XSService service = new XSApi.Builder(API_KEY).setServer(SERVER_URL).build().create(XSService.class);

	@Test
	public void testGetStudy() {
		Exception ex = null;
		Study study = null;
		try {
			retrofit.Call<Study> call = service.getStudy(989);
			study = call.execute().body();
		} catch (Exception e) {
			ex = e;
		}
		assertEquals("getStudy should be null", null, study);
		assertEquals("getStudy should throw UnauthorizedException when wrong key is supplied",
				ex instanceof AuthorizationException, true);
	}
}