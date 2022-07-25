package com.portfolioap.ap.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioAPPrincipal implements UserDetails {

    private String nombreUsuario;
    private String email;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioAPPrincipal() {
    }

    public UsuarioAPPrincipal(String nombreUsuario, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UsuarioAPPrincipal build(UsuarioAP usuarioAP) {
        List<GrantedAuthority> authorities = usuarioAP.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name()))
                .collect(Collectors.toList());

        return new UsuarioAPPrincipal(usuarioAP.getNombreUsuario(),
                usuarioAP.getEmail(), usuarioAP.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    
    public String getEmail() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
