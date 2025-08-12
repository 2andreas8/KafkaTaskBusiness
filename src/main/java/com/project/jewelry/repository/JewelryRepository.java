package com.project.jewelry.repository;

import com.project.jewelry.entity.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
public interface JewelryRepository extends JpaRepository<Jewelry, Long> {
}