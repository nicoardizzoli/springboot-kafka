package com.nicoardizzoli.springbootkafka.controller;

import com.nicoardizzoli.springbootkafka.dto.MessageDto;
import com.nicoardizzoli.springbootkafka.model.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    @PostMapping
    public void publish(@RequestBody MessageDto messageDto){
        Message message = new Message(messageDto.message(), LocalDateTime.now());
        kafkaTemplate.send(messageDto.topic(), message);
    }





    public MessageController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
}
