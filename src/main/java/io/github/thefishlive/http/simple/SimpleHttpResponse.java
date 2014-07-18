package io.github.thefishlive.http.simple;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import io.github.thefishlive.http.HttpStatusCode;
import io.github.thefishlive.http.common.HttpHeader;
import io.github.thefishlive.http.common.HttpResponse;

public class SimpleHttpResponse implements HttpResponse {

	private InputStream content;
	private List<HttpHeader> headers;
	private HttpStatusCode status;
	
	public SimpleHttpResponse(InputStream content, List<HttpHeader> headers, HttpStatusCode status) {
		this.content = content;
		this.headers = headers;
		this.status = status;
	}

	public InputStream getContent() {
		return this.content;
	}

	public HttpStatusCode getStatus() {
		return this.status;
	}

	public List<HttpHeader> getHeaders() {
		return new ArrayList<HttpHeader>(headers);
	}

	@Override
	public HttpHeader getHeader(String string) {
		for (HttpHeader header : this.headers) {
			if (header.getName().equals(string)) {
				return header;
			}
		}
		return null;
	}

	@Override
	public void close() throws IOException {
		content.close();
	}

}
