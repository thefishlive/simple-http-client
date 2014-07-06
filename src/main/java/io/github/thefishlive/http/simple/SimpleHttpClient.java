package io.github.thefishlive.http.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
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
			output.write(request.getContent().getBytes(Charset.forName("UTF-8")));
			output.flush();
			output.close();
		}
		
		InputStream input = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	    String line;
	    StringBuffer response = new StringBuffer(); 
	    while((line = reader.readLine()) != null) {
	        response.append(line);
	        response.append('\n');
	    }
	    reader.close();
	    
	    List<HttpHeader> headers = new ArrayList<HttpHeader>();
	    
	    for (Map.Entry<String, List<String>> entry : connection.getHeaderFields().entrySet()) {
	    	for (String value : entry.getValue()) {
	    		headers.add(new SimpleHttpHeader(entry.getKey(), value));
	    	}
	    }
		
		return new SimpleHttpResponse(response.toString(), headers, HttpStatusCode.fromCode(connection.getResponseCode()));
	}

	public HttpRequest createRequest(URI target) {
		return createRequest(target, HttpMethod.GET);
	}

	public HttpRequest createRequest(URI target, HttpMethod method) {
		return new SimpleHttpRequest(method, target);
	}

	public HttpRequest createRequest(URI target, HttpMethod method, String content) {
		HttpRequest request = createRequest(target, method); 
		request.setContent(content);
		return request;
	}

}
