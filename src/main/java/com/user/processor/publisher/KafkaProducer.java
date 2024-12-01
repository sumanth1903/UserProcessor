package com.user.processor.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

/**
 * KafkaProducer is responsible for publishing messages to Kafka topics.
 */
@Service
public class KafkaProducer {

    private static final Logger logger = Logger.getLogger(KafkaProducer.class.getName());

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String producerTopic;

    /**
     * Constructor for KafkaProducer.
     *
     * @param kafkaTemplate The KafkaTemplate used for sending messages.
     * @param producerTopic The topic to which messages will be sent.
     */
    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, @Value("${PRODUCER_TOPIC:user-login-processed}") String producerTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.producerTopic = producerTopic;
    }

    /**
     * Sends a message to the configured Kafka topic.
     *
     * @param message The message to be sent.
     */
    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(producerTopic, message);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                logger.info("Message has been successfully sent to the topic: " + producerTopic);
            } else {
                logger.severe("Failed to send message to the topic: " + producerTopic + " due to: " + ex.getMessage());
            }
        });
    }
}