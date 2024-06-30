package com.vv.study1;

import com.vv.study1.controller.ValidatorController;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 01 - 01 08:06
 **/
public class WebClientTest {

    @Test
    public void test() {
        // https://github.com/spring-projects/spring-boot.git
        WebClient webClient = WebClient.builder().baseUrl("/validator").build();
        WebClient.RequestHeadersUriSpec<?> uriSpec = webClient.get();
        System.out.println(uriSpec);
    }

    @Test
    public void test1() {
        WebTestClient build = WebTestClient.bindToController(new ValidatorController()).build();
        WebTestClient.RequestHeadersUriSpec<?> requestHeadersUriSpec = build.get();
        WebTestClient.ResponseSpec exchange = requestHeadersUriSpec.exchange();
        WebTestClient.BodyContentSpec bodyContentSpec = exchange.expectBody();
        System.out.println(bodyContentSpec);

    }

    @Test
    public void test2() {
        WebTestClient client = WebTestClient.bindToController(new ValidatorController())
                // .configureClient().baseUrl("/validator")
                .build();
        WebTestClient.ResponseSpec responseSpec = client.get().uri("/validator")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON);
        WebTestClient.BodyContentSpec bodyContentSpec = responseSpec.expectBody();
        System.out.println(bodyContentSpec);



    }
}
