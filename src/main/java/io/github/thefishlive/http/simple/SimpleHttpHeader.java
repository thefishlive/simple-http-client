package io.github.thefishlive.http.simple;

import io.github.thefishlive.http.common.HttpHeader;

public final class SimpleHttpHeader implements HttpHeader {
	
	private final String name;
	private final String value;
	
	public SimpleHttpHeader(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public String getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "{" + name + ":" + value + "}";
	}
	
}
