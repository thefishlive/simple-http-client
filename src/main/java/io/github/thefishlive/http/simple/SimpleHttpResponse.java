package io.github.thefishlive.http.simple;

import java.util.ArrayList;
import java.util.List;

import io.github.thefishlive.http.HttpMethod;
import io.github.thefishlive.http.HttpStatusCode;
import io.github.thefishlive.http.common.HttpHeader;
import io.github.thefishlive.http.common.HttpResponse;

public class SimpleHttpResponse implements HttpResponse {

	private HttpMethod method;
	private String content;
	private List<HttpHeader> headers;
	private HttpStatusCode status;
	
	public SimpleHttpResponse(HttpMethod method, String content, List<HttpHeader> headers, HttpStatusCode status) {
		this.method = method;
		this.content = content;
		this.headers = headers;
		this.status = status;
	}
	
	public HttpMethod getMethod() {
		return this.method;
	}

	public String getContent() {
		return this.content;
	}

	public HttpStatusCode getStatus() {
		return this.status;
	}

	public List<HttpHeader> getHeaders() {
		return new ArrayList<HttpHeader>(headers);
	}

}
