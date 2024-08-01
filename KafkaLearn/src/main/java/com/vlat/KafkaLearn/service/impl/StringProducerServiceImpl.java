package com.vlat.KafkaLearn.service.impl;

import com.vlat.KafkaLearn.service.StringProducerService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class StringProducerServiceImpl implements StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public StringProducerServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String string) {

        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("test-java-topic", null, string);

        future.whenComplete((res, exc) -> {
            if(exc != null){
                exc.printStackTrace();
            }
            else{
                System.out.println("-=-=-| Sent string to kafka");
            }
        });
    }
}
