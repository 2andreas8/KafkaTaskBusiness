package com.project.jewelry.kafka;
import com.project.jewelry.dto.JewelryDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class JewelryProducer {
    private final KafkaTemplate<String, JewelryDTO> kafkaTemplate;
    public void sendJewelry(JewelryDTO dto) {
        log.info("Sending to Kafka: {}", dto);
        kafkaTemplate.send("jewelry-topic", dto);
    }
}