package io.github.thefishlive.http.common;

import java.util.List;

import io.github.thefishlive.http.HttpMethod;
import io.github.thefishlive.http.URI;

public interface HttpRequest {

	public HttpMethod getMethod();
	
	public void setMethod(HttpMethod method);
	
	public URI getTarget();
	
	public void setTarget(URI uri);
	
	public String getContent();
	
	public void setContent(String content);
	
	public List<HttpHeader> getHeaders();
	
	public HttpHeader addHeader(HttpHeader header);
	
	public HttpHeader addHeader(String name, String value);
	
}
