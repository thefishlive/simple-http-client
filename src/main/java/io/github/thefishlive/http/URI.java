package io.github.thefishlive.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class URI {

	public String uri;
	
	public URI(String uri) {
		this.uri = uri;
	}
	
	public URI(String base, String... parts) {
		this.uri = base + join(parts, '/');
	}
	
	public URI(URI base, String... parts) {
		this.uri = base.toString() + join(parts, '/');
	}
	
	public URI(URL url) {
		this.uri = url.toExternalForm();
	}

	public URI(java.net.URI uri) {
		this.uri = uri.toASCIIString();
	}

	private String join(String[] parts, char c) {
		StringBuilder builder = new StringBuilder();
		for (String part : parts) {
			builder.append(part).append(c);
		}
		return builder.toString();
	}
	
	public HttpURLConnection openConnection() throws IOException {
		return (HttpURLConnection) java.net.URI.create(this.uri).toURL().openConnection();
	}
	
	@Override
	public String toString() {
		return this.uri;
	}
}
