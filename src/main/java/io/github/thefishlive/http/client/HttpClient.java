package io.github.thefishlive.http.client;

import io.github.thefishlive.http.HttpMethod;
import io.github.thefishlive.http.URI;
import io.github.thefishlive.http.common.HttpRequest;
import io.github.thefishlive.http.common.HttpResponse;

public interface HttpClient {

	public HttpRequest createRequest(URI target);
	
	public HttpRequest createRequest(URI target, HttpMethod method);
	
	public HttpRequest createRequest(URI target, HttpMethod method, String content);
	
	public HttpResponse sendRequest(HttpRequest request) throws java.io.IOException;
	
}
