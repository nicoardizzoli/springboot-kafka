package com.nicoardizzoli.springbootkafka.listeners;

import com.nicoardizzoli.springbootkafka.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "nicoardizzoli", groupId = "groupId", containerFactory = "messageKafkaListenerContainerFactory")
    void listener(Message data) {
        System.out.println("Listener received " + data);
    }
}
