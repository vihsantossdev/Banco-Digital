package br.com.cdb.bancodigital.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API Banco")
                .version("1.0.0")
                .description("API do sistema bancário com endpoints de clientes, contas e transações"));
    }
}
