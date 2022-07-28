
package com.portfolioap.ap.security.jwt;

import com.portfolioap.ap.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {
    private static final Logger LOGGER=LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final long EXPIRED_DURATION=1*60*60*1000;
    @Value("${app.jwt.secret}")
    private String secretKey;
    
    public String generateAccesToken(User user){
        return Jwts.builder()
                .setSubject(user.getId()+","+user.getEmail())
                .setIssuer("CodeJava")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRED_DURATION))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();   
    }
    
    public boolean validateAccesToken(String token){
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            LOGGER.error("JWT expired", ex);
        } catch (IllegalArgumentException ex){
            LOGGER.error("Token is null", ex);
        } catch (MalformedJwtException ex){
            LOGGER.error("JWT invàlido", ex);
        } catch (UnsupportedJwtException ex){
            LOGGER.error("JWT no soportado", ex);
        } catch (SignatureException ex){
            LOGGER.error("Firma inválida", ex);
        }
        return false;
        }
    
    public String getSubject(String token){
        return parseClaims(token).getSubject();
    }
    
    public Claims parseClaims(String token){
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
    
}
