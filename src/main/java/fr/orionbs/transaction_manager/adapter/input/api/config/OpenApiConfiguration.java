package fr.orionbs.transaction_manager.adapter.input.api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Transaction Manager")
                                .description("This project is made to handle the management of user's transactions, also enhanced group's transactions management. It expose an API, it can be managed through a CLI, it get his data from a persistence and it send email through smtp.")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .name("Orion Beauny-Sugot")
                                                .email("obeaunysugot@gmail.com")
                                                .url("https://orionbs.fr")
                                )
                )
                .addServersItem(
                        new Server()
                                .url("http://localhost:9000")
                                .description("Local development server")

                )
                .components(
                        new Components()
                                .addSecuritySchemes(
                                        "basic",
                                        new SecurityScheme()
                                                .name("basic")
                                                .scheme("basic")
                                                .type(SecurityScheme.Type.HTTP)
                                                .in(SecurityScheme.In.HEADER)
                                )
                                /*.addSecuritySchemes(
                                        "oauth2",
                                        new SecurityScheme()
                                                .name("oauth2")
                                                .scheme("oauth2")
                                                .type(SecurityScheme.Type.OAUTH2)
                                                .flows(
                                                        new OAuthFlows()
                                                                .authorizationCode()
                                                )
                                )*/
                );
    }

}
