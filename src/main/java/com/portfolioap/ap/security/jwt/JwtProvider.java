package com.portfolioap.ap.security.jwt;

import com.portfolioap.ap.security.entity.UsuarioAPPrincipal;
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
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication) {
        UsuarioAPPrincipal usuarioAPPrincipal = (UsuarioAPPrincipal) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(usuarioAPPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expiration*1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    
    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    
     public boolean valdiateToken(String token){
         try{
             Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
             return true;
         } catch (MalformedJwtException e) {
             logger.error("Error en formación ed Token");
         } catch (UnsupportedJwtException e) {
             logger.error("Token no válido");
         }catch (ExpiredJwtException e) {
             logger.error("El token expiró");
         }catch (IllegalArgumentException e) {
             logger.error("El token está vacío");
         }catch (SignatureException e) {
             logger.error("Firma no válida o vacía");
         }
         return false;
     }

}
