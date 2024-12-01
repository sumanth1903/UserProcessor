package com.user.processor.consumer;

import com.user.processor.service.PipelineService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * KafkaConsumer is responsible for consuming messages from Kafka topics.
 * It utilizes the PipelineService to process incoming messages.
 */
@Service
@Slf4j
public class KafkaConsumer {

    private static final Logger logger = Logger.getLogger(KafkaConsumer.class.getName());

    private final PipelineService pipelineService;

    @Autowired
    public KafkaConsumer(PipelineService pipelineService) {
        this.pipelineService = pipelineService;
    }

    /**
     * Listener method to receive messages from Kafka.
     *
     * @param message The message received from the Kafka topic.
     */
    @KafkaListener(
            topics = "${CONSUMER_TOPIC:user-login}",
            groupId = "${GROUP_ID:group_id}",
            topicPartitions = @TopicPartition(topic = "${CONSUMER_TOPIC:user-login}", partitions = {"0"})
    )
    public void listener(String message) {
        logger.info("Message Received: " + message);
        pipelineService.processMessage(message);
    }

    @PostConstruct
    private void setup() {
        logger.info("KafkaConsumer initialized and ready to receive messages.");
    }
}
