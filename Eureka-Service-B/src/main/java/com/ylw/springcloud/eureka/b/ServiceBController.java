package com.ylw.springcloud.eureka.b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ServiceBController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    private int requestCount = 1;


    @RequestMapping("/discoveryClient")
    public String discoveryClient() {

        String serviceUrl = getServiceUrl() + "/getMember";
        return "请求地址为 -> " + serviceUrl;
    }

    @RequestMapping("/getOrder")
    public String getOrder() {

        String serviceUrl = getServiceUrl() + "/getMember";
        ResponseEntity<String> response = restTemplate.getForEntity(serviceUrl, String.class);
        System.out.println("statusCode:" + response.getStatusCode());
        return "Body -> " + response.getBody();
    }

    @RequestMapping("/getServiceUrl")
    private String getServiceUrl() {
        List<ServiceInstance> instances = discoveryClient.getInstances("app-service-a");
        if (instances == null || instances.size() == 0) {
            return null;
        }
        int size = instances.size();
        int index = requestCount % size;
        requestCount++;
        return instances.get(index).getUri().toString();
    }
}
