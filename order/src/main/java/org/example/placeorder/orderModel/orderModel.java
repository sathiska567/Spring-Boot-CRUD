package org.example.placeorder.orderModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data  // does not need to create getters , setters

public class orderModel {
    @Id
    private int id;
    private int itemId;
    private String orderDate;
    private int amount;
}
