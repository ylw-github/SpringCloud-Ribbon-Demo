package com.ylw.springcloud.eureka.a;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAController {

    @RequestMapping("/getMember")
    public String getMember() {
        return "this is getMember from ServiceA2 ";
    }
}
