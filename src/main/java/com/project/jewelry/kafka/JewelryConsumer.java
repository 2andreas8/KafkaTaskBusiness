package com.project.jewelry.kafka;
import com.project.jewelry.dto.JewelryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class JewelryConsumer {
    @KafkaListener(topics = "jewelry-topic", groupId = "jewelry-group", containerFactory = "jewelryKafkaListenerContainerFactory")
    public void consume(JewelryDTO dto) {
        log.info("Consumed from Kafka: {}", dto);
    }
}