package com.rest_api_java.api.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JwtTokenProvider {

    //----------------------------------------------------------------------
    //Attributes
    //----------------------------------------------------------------------

    @Value("${security.jwt.token.secret-key:secret-key")
    private String secretKey;

    @Value("${security.jwt.token.expire-length:3000000")
    private long timeExpiration = 3000000;

    @Autowired
    private AppUserDetails appUserDetails;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    //----------------------------------------------------------------------
    //Methods
    //----------------------------------------------------------------------

    public String createToken(String username, List<UserRoles> userRoles) {

        Claims claims = Jwts.claims().setSubject(username);
        claims.put("auth", userRoles.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority())).filter(Objects::nonNull).collect(Collectors.toList()));

        Date now = new Date();
        Date validity = new Date(new Date().getTime() + timeExpiration);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    //----------------------------------------------------------------------

    public Authentication getAuthentication(String token) {

        UserDetails userDetailsFound = appUserDetails.loadUserByUsername(getEmail(token));
        return new UsernamePasswordAuthenticationToken(appUserDetails, "", userDetailsFound.getAuthorities());
    }

    //----------------------------------------------------------------------

    public String getEmail(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    //----------------------------------------------------------------------

    public String resolveToken(HttpServletRequest req) {

        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    //----------------------------------------------------------------------

    public boolean validateToken(String token) {

        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        }catch(JwtException | IllegalArgumentException ex){
            throw new JwtException("Expired or invalid JWT token", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}