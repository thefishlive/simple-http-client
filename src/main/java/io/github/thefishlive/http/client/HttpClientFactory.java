package io.github.thefishlive.http.client;

import io.github.thefishlive.http.simple.SimpleHttpClient;

public class HttpClientFactory {

	private HttpClientFactory() {}
	
	public static HttpClient createHttpClient() {
		return new SimpleHttpClient();
	}
	
}
