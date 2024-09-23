package com.example.inventory.dto;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class InventoryDTO {
    private int id;
    private int itemId;
    private int productId;
    private int quantity;
}
