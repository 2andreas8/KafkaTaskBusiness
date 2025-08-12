package com.project.jewelry.controller;
import com.project.jewelry.dto.JewelryDTO;
import com.project.jewelry.entity.Jewelry;
import com.project.jewelry.kafka.JewelryProducer;
import com.project.jewelry.service.JewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/jewelry")
public class JewelryController {
    private final JewelryService service;
    private final JewelryProducer producer;
    @Autowired
    public JewelryController(JewelryService service, JewelryProducer producer) {
        this.service = service;
        this.producer = producer;
    }
    @GetMapping
    public List<Jewelry> getAllJewelry() {
        return service.getAllJewelry();
    }
    @PostMapping
    public Jewelry createJewelry(@RequestBody JewelryDTO dto) {
        Jewelry jewelry = service.createJewelry(dto);
        // Kafka
        producer.sendJewelry(dto);
        return jewelry;
    }
    @GetMapping("/{id}")
    public Jewelry getJewelryById(@PathVariable Long id) {
        return service.getJewelryById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteJewelry(@PathVariable Long id) {
        service.deleteJewelry(id);
    }
    @PutMapping("/{id}")
    public Jewelry updateJewelry(@PathVariable Long id, @RequestBody JewelryDTO dto) {
        return service.updateJewelry(id, dto);
    }
}