package com.demo.ibm.mq.demo.listener;

import com.demo.ibm.mq.demo.dto.Triangle;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class MQListener {

    @JmsListener(destination = "DEV.QUEUE.3")
    public void receiveMessage(Triangle triangle) {
        double area = (triangle.getLength() * triangle.getHeight()) / 2;
        System.out.println("Received triangle with length " + triangle.getLength() + " and height " + triangle.getHeight());
        System.out.println("Calculated area: " + area);
    }
}