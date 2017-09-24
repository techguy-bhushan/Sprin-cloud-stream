package com.producer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {

    private ProduceConfig produceConfig;

    @Autowired
    public HelloApi(ProduceConfig produceConfig) {
        this.produceConfig = produceConfig;
    }

    @GetMapping("hello/{name}")
    public void hello(@PathVariable String name) {
        produceConfig.publishHelloTo(name);
    }
}
