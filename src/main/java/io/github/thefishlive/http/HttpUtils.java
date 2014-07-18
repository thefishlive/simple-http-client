package io.github.thefishlive.http;

import java.io.InputStream;

public class HttpUtils {
	
	private HttpUtils() {}
	
	public static String toString(InputStream in) {
		try(java.util.Scanner s = new java.util.Scanner(in)) { 
			return s.useDelimiter("\\A").hasNext() ? s.next() : ""; 
		}
	}
}
