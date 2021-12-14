package com.edso.wiserouter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private RedisTemplate<String, String> template;

    public void sendMessage(String msg) {
        template.opsForValue().set("a", msg);
        template.convertAndSend("order", msg);
        System.out.println("Redis send message " + template.opsForValue().get("a"));
        kafkaTemplate.send("demo", msg);
        System.out.println("Topic demo: send " + msg + " to kafka");
    }

    @PostMapping
    public String send (@RequestParam String message) {
        sendMessage(message);
        return "ok";
    }
}
