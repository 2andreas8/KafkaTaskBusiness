package com.project.jewelry.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JewelryDTO {
    private String name;
    private double price;
    private String material;
    private String category;
}
