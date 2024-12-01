package com.user.processor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.processor.dto.User;
import com.user.processor.publisher.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * PipelineService is responsible for processing messages received from Kafka.
 */
@Service
public class PipelineService {

    private static final Logger logger = Logger.getLogger(PipelineService.class.getName());

    private final KafkaProducer kafkaProducer;
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Constructor for PipelineService.
     *
     * @param kafkaProducer The KafkaProducer used to send messages.
     */
    @Autowired
    public PipelineService(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    /**
     * Processes the incoming message.
     *
     * @param message The message to be processed.
     */
    public void processMessage(String message) {
        try {
            processUser(message);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error processing message: " + message, e);
        }
    }

    /**
     * Processes the user information.
     *
     * @param userJson The JSON string representing the user.
     */
    private void processUser(String userJson) {
        try {
            User user = objectMapper.readValue(userJson, User.class);

            // Process user: Filtering NY locale users only
            if (!"NY".equals(user.getLocale())) {
                logger.info("User locale is not NY, skipping processing.");
                return;
            }

            String processedUserJson = objectMapper.writeValueAsString(user);
            kafkaProducer.sendMessage(processedUserJson);
            logger.info("Message sent successfully after processing: " + processedUserJson);
        } catch (JsonProcessingException e) {
            logger.log(Level.SEVERE, "Error processing user JSON: " + userJson, e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error processing user: " + userJson, e);
        }
    }
}