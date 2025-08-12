package com.project.jewelry.service;
import com.project.jewelry.dto.JewelryDTO;
import com.project.jewelry.entity.Jewelry;
import com.project.jewelry.kafka.JewelryProducer;
import com.project.jewelry.repository.JewelryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelryService {
    private final JewelryRepository repository;
    private final JewelryProducer jewelryProducer;
    @Autowired
    public JewelryService(JewelryRepository repository, JewelryProducer jewelryProducer) {
        this.repository = repository;
        this.jewelryProducer = jewelryProducer;
    }
    public Jewelry createJewelry(JewelryDTO dto) {
        Jewelry jewelry = new Jewelry();
        jewelry.setName(dto.getName());
        jewelry.setPrice(dto.getPrice());
        jewelry.setMaterial(dto.getMaterial());
        jewelry.setCategory(dto.getCategory());
        Jewelry saved = repository.save(jewelry);
        jewelryProducer.sendJewelry(dto);
        return saved;
    }
    public List<Jewelry> getAllJewelry() {
        return repository.findAll();
    }
    public Jewelry getJewelryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jewelry not found with id " + id));
    }
    public void deleteJewelry(Long id) {
        repository.deleteById(id);
    }
    public Jewelry updateJewelry(Long id, JewelryDTO dto) {
        Jewelry jewelry = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jewelry not found with id " + id));
        jewelry.setName(dto.getName());
        jewelry.setPrice(dto.getPrice());
        jewelry.setMaterial(dto.getMaterial());
        jewelry.setCategory(dto.getCategory());
        return repository.save(jewelry); // returnezi obiectul salvat
    }
}