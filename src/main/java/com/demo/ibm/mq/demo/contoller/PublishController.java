package com.demo.ibm.mq.demo.contoller;


import com.demo.ibm.mq.demo.dto.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@RestController
public class PublishController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/add-triangle")
    public String addTriangle(@RequestParam double length, @RequestParam double height) {
        Triangle triangle = new Triangle(length, height);
        jmsTemplate.convertAndSend("DEV.QUEUE.3", triangle);
        return "Triangle data sent to the queue";
    }

}
