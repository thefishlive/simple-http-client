package io.github.thefishlive.http.common;

import java.util.List;

import io.github.thefishlive.http.HttpStatusCode;

public interface HttpResponse {
	
	public String getContent();
	
	public HttpStatusCode getStatus();
	
	public List<HttpHeader> getHeaders();
	
}
