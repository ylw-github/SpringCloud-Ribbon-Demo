package com.ylw.springcloud.eureka.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    //@LoadBalanced//@LoadBalanced就能让这个RestTemplate在请求时拥有客户端负载均衡的能力（增加@LoadBalanced，就不能使用127.0.0.1,只能使用应用名)
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}