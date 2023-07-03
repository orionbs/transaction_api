package fr.orionbs.transaction_manager.adapter.output.context;

import fr.orionbs.transaction_manager.application.output.SelectOwnerPort;
import fr.orionbs.transaction_manager.domain.model.Owner;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OwnerContextAdapter implements SelectOwnerPort {

    @Override
    public Owner selectOwner() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) securityContext.getAuthentication();
        Jwt jwt = (Jwt) jwtAuthenticationToken.getPrincipal();
        Owner owner = new Owner();
        owner.setId(jwt.getSubject());
        owner.setEmail(jwt.getClaimAsString("email"));
        owner.setFullName(jwt.getClaimAsString("name"));
        return owner;
    }

}
