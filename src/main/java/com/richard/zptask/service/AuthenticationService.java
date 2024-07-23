package com.richard.zptask.service;

import com.richard.zptask.config.AuthenticationMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
 /**  This API key will not be hardcoded here on a typical system, it is usually stored somewhere (s3 bucket or some other db),
    and retrieve to check if it matches the API-key coming from requests Header*/

    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";
    private static final String AUTH_TOKEN = "14DFB1BA-063C-43D9-8D5C-3020B1D9782D";

    public static Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        if (apiKey == null || !apiKey.equals(AUTH_TOKEN)) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new AuthenticationMapper(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}
