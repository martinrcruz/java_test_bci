package cl.bci.javatest.util;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public class JwtUtil {

//    @Value("${jwt.secret-key}")
    static String secretKey = "secret-key";

//    @Value("${jwt.expiration-time}")
    static int expirationTime = 864_000_000;

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
                .compact();
    }

    public static String extractData(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey.getBytes())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}