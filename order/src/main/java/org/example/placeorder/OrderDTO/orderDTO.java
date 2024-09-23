package org.example.placeorder.OrderDTO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@NoArgsConstructor
@AllArgsConstructor

//this one create automatically getters
@Data

public class orderDTO {

    private int id;
    private int itemId;
    private String orderDate;
    private int amount;

}
