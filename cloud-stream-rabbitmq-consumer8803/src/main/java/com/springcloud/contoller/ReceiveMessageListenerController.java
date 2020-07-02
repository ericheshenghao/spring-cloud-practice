package com.springcloud.contoller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void setPort(Message<String> message) {
        System.out.println("消费者1号,----->接收到的消息:" +message.getPayload()+"\t port"+port);
    }
}
