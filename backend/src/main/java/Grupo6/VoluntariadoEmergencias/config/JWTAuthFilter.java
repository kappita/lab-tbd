package Grupo6.VoluntariadoEmergencias.config;

import Grupo6.VoluntariadoEmergencias.services.DetallesUsuariosService;
import Grupo6.VoluntariadoEmergencias.services.JWTUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private DetallesUsuariosService detallesUsuariosService;

    @Override
    protected void doFilterInternal(HttpServletRequest solicitud, HttpServletResponse respuesta, FilterChain filterChain){
        final String authHeader = solicitud.getHeader("Authorization");
        final String jwtToken;
        final String emailUsuario;
        if (authHeader == null || authHeader.isBlank()){
            try {
                filterChain.doFilter(solicitud, respuesta);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        jwtToken = authHeader.substring(7);
        emailUsuario = jwtUtils.extraerUsername(jwtToken);
        if (emailUsuario != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = detallesUsuariosService.loadUserByUsername(emailUsuario);

            if(jwtUtils.TokenValido(jwtToken, userDetails)){
                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(solicitud));
                securityContext.setAuthentication(token);
                SecurityContextHolder.setContext(securityContext);
            }
        }
        //filterChain.doFilter(solicitud,respuesta);
    }
}
