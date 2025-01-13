package com.ticketing.auth_service.config;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

	private final Environment environment;

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("API Documentation").version("1.0"))
				.servers(List.of(
						new io.swagger.v3.oas.models.servers.Server()
								.url("http://localhost:8080")
								.description("Direct to Local"),
						new io.swagger.v3.oas.models.servers.Server()
								.url("http://localhost:" + environment.getProperty("local.server.port") + "/auth")
								.description("Through API Gateway")
				))
				.paths(new Paths()
						.addPathItem("/login", new PathItem()
								.post(new io.swagger.v3.oas.models.Operation()
										.requestBody(new io.swagger.v3.oas.models.parameters.RequestBody()
												.content(new io.swagger.v3.oas.models.media.Content()
														.addMediaType("application/json", new io.swagger.v3.oas.models.media.MediaType()
																.schema(new io.swagger.v3.oas.models.media.Schema()
																		.addProperties("username", new io.swagger.v3.oas.models.media.Schema()
																				.type("string"))
																		.addProperties("password", new io.swagger.v3.oas.models.media.Schema()
																				.type("string"))
																)
														)
												)
										)
										.responses(new ApiResponses()
												.addApiResponse("200", new ApiResponse()
														.description("Success"))
												.addApiResponse("500", new ApiResponse()
														.description("Internal Server Error")))
								)
						)
				);
	}
}
