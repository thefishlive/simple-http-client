package io.github.thefishlive.http.common;

import java.io.Closeable;
import java.io.InputStream;
import java.util.List;

import io.github.thefishlive.http.HttpStatusCode;

public interface HttpResponse extends Closeable {
	
	public InputStream getContent();
	
	public HttpStatusCode getStatus();
	
	public List<HttpHeader> getHeaders();

	public HttpHeader getHeader(String string);
	
}
