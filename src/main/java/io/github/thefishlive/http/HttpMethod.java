package io.github.thefishlive.http;

public enum HttpMethod {

	GET(true, false),
	POST(true, true),
	;
	
	private boolean input;
	private boolean output;

	private HttpMethod(boolean input, boolean output) {
		this.input = input;
		this.output = output;
	}
	
	public boolean doInput() {
		return input;
	}
	
	public boolean doOutput() {
		return output;
	}
	
}
