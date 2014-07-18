package io.github.thefishlive.http.simple;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.github.thefishlive.http.HttpMethod;
import io.github.thefishlive.http.HttpStatusCode;
import io.github.thefishlive.http.URI;
import io.github.thefishlive.http.client.HttpClient;
import io.github.thefishlive.http.common.HttpHeader;
import io.github.thefishlive.http.common.HttpRequest;
import io.github.thefishlive.http.common.HttpResponse;

public class SimpleHttpClient implements HttpClient {

	@Override
	public HttpResponse sendRequest(HttpRequest request) throws IOException {
		HttpURLConnection connection = request.getTarget().openConnection();
		connection.setRequestMethod(request.getMethod().name());
		connection.setDoInput(request.getMethod().doInput());
		connection.setDoOutput(request.getMethod().doOutput());
		
		for (HttpHeader header : request.getHeaders()) {
			connection.addRequestProperty(header.getName(), header.getValue());
		}
		
		if (request.getMethod().doOutput()) {
			OutputStream output = connection.getOutputStream();
			// TODO copy content to output buffer
			output.flush();
			output.close();
		}
		
	    List<HttpHeader> headers = new ArrayList<HttpHeader>();
	    
	    for (Map.Entry<String, List<String>> entry : connection.getHeaderFields().entrySet()) {
	    	for (String value : entry.getValue()) {
	    		headers.add(new SimpleHttpHeader(entry.getKey(), value));
	    	}
	    }
		
		return new SimpleHttpResponse(connection.getInputStream(), headers, HttpStatusCode.fromCode(connection.getResponseCode()));
	}

	@Override
	public HttpRequest createRequest(URI target) {
		return createRequest(target, HttpMethod.GET);
	}

	@Override
	public HttpRequest createRequest(URI target, HttpMethod method) {
		return new SimpleHttpRequest(method, target);
	}

}
