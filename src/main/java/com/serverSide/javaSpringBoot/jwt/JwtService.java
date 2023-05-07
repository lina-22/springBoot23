package com.serverSide.javaSpringBoot.jwt;

import com.serverSide.javaSpringBoot.services.securityService.AppUserDetails;
import io.jsonwebtoken.Claims;

import java.security.Key;

public interface JwtService {

    Claims extractClaims(String token);

    Key getKey();

    String generateToken(AppUserDetails userDetails);

    boolean isValidToken(String token);
}