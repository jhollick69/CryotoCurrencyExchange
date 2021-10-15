package org.copper.interview.controller;

import java.util.Base64;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class HttpUtils {

	public static HttpHeaders createHttpHeaders(String clientId, String key) {
		String notEncoded = clientId + ":" + key;
		String encodedAuth = Base64.getEncoder().encodeToString(notEncoded.getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Basic " + encodedAuth);
		return headers;
	}

}