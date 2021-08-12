package org.generation.blogPessoal.configuration;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	/**
	 * Método public Docket api() Define a package onde estão as classes do
	 * tipo @RestController, para que o Swagger mapeie todas as classes e seus
	 * respectivos endpoints para montar a documentação do projeto.
	 * 
	 * .apis(RequestHandlerSelectors.basePackage("br.org.generation.blogpessoal.controller"))
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("org.generation.blogPessoal.controller"))
				.paths(PathSelectors.any()).build().apiInfo(metadata()).useDefaultResponseMessages(false)
				.globalResponses(HttpMethod.GET, responseMessage()).globalResponses(HttpMethod.POST, responseMessage())
				.globalResponses(HttpMethod.PUT, responseMessage())
				.globalResponses(HttpMethod.DELETE, responseMessage());
	}

	/**
	 * Método public static ApiInfo metadata() Define o titulo da sua aplicação que
	 * será exibida na documentação.
	 */
	public static ApiInfo metadata() {
		return new ApiInfoBuilder().title("API - Blog Pessoal da Jakers <3").description("Projeto API Spring - Blog Pessoal")
				.version("1.0.0").license("Apache License Version 2.0")
				.licenseUrl("https://github.com/jaque20050/BlogPessoal.git").contact(contact()).build();
	}

	/**
	 * Método private static Contact contact() Define os dados do Desenvolvedor
	 * (Nome, Website e o E-mail).
	 * 
	 */
	private static Contact contact() {
		return new Contact("Jaqueline Camilo Dias", "https://github.com/jaque20050/BlogPessoal.git", "jaque20050@hotmail.com");
	}

	/**
	 * Método private static List responseMessage() Define as mensagens
	 * personalizadas para os códigos de Resposta do protocolo http (http Response)
	 * para todos os verbos (GET, POST, PUT e DELETE). Cada linha é referente a um
	 * Status Code.
	 * 
	 */
	private static List<Response> responseMessage() {
		return new ArrayList<Response>() {
			private static final long serialVersionUID = 1L;
			{
				add(new ResponseBuilder().code("200").description("Sucesso!").build());
				add(new ResponseBuilder().code("201").description("Criado!").build());
				add(new ResponseBuilder().code("400").description("Erro na requisição!").build());
				add(new ResponseBuilder().code("401").description("Não Autorizado!").build());
				add(new ResponseBuilder().code("403").description("Proibido!").build());
				add(new ResponseBuilder().code("404").description("Não Encontrado!").build());
				add(new ResponseBuilder().code("500").description("Erro!").build());
			}
		};
	}
}
