package org.copper.interview.service.impl;

import java.io.IOException;

public interface SecurityService {
	 String getBearerAuth(String clientId, String client_secret) throws IOException;
}
