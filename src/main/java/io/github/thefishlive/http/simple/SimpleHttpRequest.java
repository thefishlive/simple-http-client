package io.github.thefishlive.http.simple;

import java.util.ArrayList;
import java.util.List;

import io.github.thefishlive.http.HttpMethod;
import io.github.thefishlive.http.URI;
import io.github.thefishlive.http.common.HttpHeader;
import io.github.thefishlive.http.common.HttpRequest;

public class SimpleHttpRequest implements HttpRequest {

	private HttpMethod method;
	private URI target;
	private String content;
	private List<HttpHeader> headers;
	
	public SimpleHttpRequest(HttpMethod method, URI target) {
		this.method = method;
		this.target = target;
		this.headers = new ArrayList<HttpHeader>();
	}
	
	public HttpMethod getMethod() {
		return this.method;
	}

	public void setMethod(HttpMethod method) {
		this.method = method;
	}

	public URI getTarget() {
		return this.target;
	}

	public void setTarget(URI uri) {
		this.target = uri;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<HttpHeader> getHeaders() {
		return this.headers;
	}

	public HttpHeader addHeader(HttpHeader header) {
		this.headers.add(header);
		return header;
	}

	public HttpHeader addHeader(String name, String value) {
		return addHeader(new SimpleHttpHeader(name, value)); 
	}

}
