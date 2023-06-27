package fr.orionbs.transaction_manager.adapter.input.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.UUID;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, CorsConfiguration corsConfiguration) throws Exception {

        httpSecurity.cors(httpSecurityCorsConfigurer -> {
            UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
            urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
            httpSecurityCorsConfigurer.configurationSource(urlBasedCorsConfigurationSource);
        });

        httpSecurity.csrf(httpSecurityCsrfConfigurer -> {
            httpSecurityCsrfConfigurer.csrfTokenRepository(new HttpSessionCsrfTokenRepository());
        });

        httpSecurity.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
            authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.GET, "/v3/api-docs/**", "/swagger-ui/**").permitAll();
        });


        httpSecurity.oauth2Login(httpSecurityOAuth2LoginConfigurer -> {
            httpSecurityOAuth2LoginConfigurer.successHandler(new SavedRequestAwareAuthenticationSuccessHandler());
        });

        httpSecurity.oauth2ResourceServer().jwt();

        httpSecurity.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
            authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
        });

        return httpSecurity.build();
    }


    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration clientRegistration = ClientRegistration
                .withRegistrationId(UUID.randomUUID().toString())
                .clientId("90990976801-719cok681qov49minpkglva7i7ssh8js.apps.googleusercontent.com")
                .clientSecret("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")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .issuerUri("https://accounts.google.com")
                .authorizationUri("https://accounts.google.com/o/oauth2/auth")
                .tokenUri("https://oauth2.googleapis.com/token")
                .redirectUri("https://www.getpostman.com/oauth2/callback")
                .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
                .build();
        return new InMemoryClientRegistrationRepository(clientRegistration);
    }

    @Bean
    public CorsConfiguration corsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("http://localhost:9000");
        corsConfiguration.addAllowedOrigin("https://accounts.google.com");
        corsConfiguration.addAllowedOriginPattern("http://localhost:9000");
        corsConfiguration.addAllowedOriginPattern("https://accounts.google.com");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod(HttpMethod.GET);
        return corsConfiguration;
    }


}
