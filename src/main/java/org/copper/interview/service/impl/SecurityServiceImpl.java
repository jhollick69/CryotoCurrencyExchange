package org.copper.interview.service.impl;

import java.io.IOException;

import org.copper.interview.model.AuthResponse;
import org.copper.interview.test.constants.URLConstants;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SecurityServiceImpl implements SecurityService {

	@Override
	public String getBearerAuth(String clientId, String client_secret) throws IOException {
		String json = null;
		try {
			String url = URLConstants.DERIBIT_TEST_API_BASE_URL + "public/auth?client_id=" + clientId
					+ "&client_secret=" + client_secret + "&grant_type=client_credentials";
			// make a request
			ResponseEntity<AuthResponse> response = new RestTemplate().exchange(url, HttpMethod.GET, null,
					AuthResponse.class);
			// get JSON response
			json = response.getBody().result.access_token;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return json;
	}

}
