package io.github.thefishlive.http.simple;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import io.github.thefishlive.http.HttpMethod;
import io.github.thefishlive.http.URI;
import io.github.thefishlive.http.common.HttpHeader;
import io.github.thefishlive.http.common.HttpRequest;

public class SimpleHttpRequest implements HttpRequest {

	private HttpMethod method;
	private URI target;
	private ByteArrayOutputStream content;
	private List<HttpHeader> headers;
	
	public SimpleHttpRequest(HttpMethod method, URI target) {
		this.method = method;
		this.target = target;
		this.content = new ByteArrayOutputStream();
		this.headers = new ArrayList<HttpHeader>();
	}
	
	@Override
	public HttpMethod getMethod() {
		return this.method;
	}

	@Override
	public void setMethod(HttpMethod method) {
		this.method = method;
	}

	@Override
	public URI getTarget() {
		return this.target;
	}

	@Override
	public void setTarget(URI uri) {
		this.target = uri;
	}

	@Override
	public OutputStream getContent() {
		return this.content;
	}

	@Override
	public List<HttpHeader> getHeaders() {
		return this.headers;
	}

	@Override
	public HttpHeader addHeader(HttpHeader header) {
		this.headers.add(header);
		return header;
	}

	@Override
	public HttpHeader addHeader(String name, String value) {
		return addHeader(new SimpleHttpHeader(name, value)); 
	}

}
