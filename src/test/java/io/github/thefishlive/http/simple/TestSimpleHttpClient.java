package io.github.thefishlive.http.simple;

import static org.junit.Assert.*;

import java.io.IOException;

import io.github.thefishlive.http.HttpMethod;
import io.github.thefishlive.http.HttpStatusCode;
import io.github.thefishlive.http.URI;
import io.github.thefishlive.http.common.HttpRequest;
import io.github.thefishlive.http.common.HttpResponse;

import org.junit.Before;
import org.junit.Test;

public class TestSimpleHttpClient {
	
	private static final String TEST_URL = "http://www.google.com";
	private SimpleHttpClient client;

	@Before
	public void setup() {
		client = new SimpleHttpClient();
	}

	@Test
	public void testRequest() throws IOException {
		HttpRequest request = client.createRequest(new URI(TEST_URL), HttpMethod.GET);
		assertEquals(TEST_URL, request.getTarget().toString());
		
		HttpResponse response = client.sendRequest(request);
		assertEquals(HttpStatusCode.OK, response.getStatus());
	}
}
