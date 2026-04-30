package com.les.decisionsupport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.time.Duration;

@EnableAsync
@SpringBootApplication
public class DecisionSupportApplication {

    public static void main(String[] args) {
        SpringApplication.run(DecisionSupportApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder.setConnectTimeout(Duration.ofMillis(4000)).setReadTimeout(Duration.ofMillis(30000)).build();
        restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory() {{
            setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.110.132", 8000)));
        }});
        return restTemplate;
    }

    @Bean
    public RestTemplate outRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.setConnectTimeout(Duration.ofMillis(4000)).setReadTimeout(Duration.ofMillis(60000)).build();
    }

}
