package io.github.thefishlive.http.common;

import java.io.OutputStream;
import java.util.List;

import io.github.thefishlive.http.HttpMethod;
import io.github.thefishlive.http.URI;

public interface HttpRequest {

	public HttpMethod getMethod();
	
	public void setMethod(HttpMethod method);
	
	public URI getTarget();
	
	public void setTarget(URI uri);
	
	public OutputStream getContent();
	
	public List<HttpHeader> getHeaders();
	
	public HttpHeader addHeader(HttpHeader header);
	
	public HttpHeader addHeader(String name, String value);
	
}
