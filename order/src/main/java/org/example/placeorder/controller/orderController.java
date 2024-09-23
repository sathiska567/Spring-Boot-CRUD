package org.example.placeorder.controller;

import org.example.placeorder.OrderDTO.orderDTO;
import org.example.placeorder.common.OrderResponse;
import org.example.placeorder.orderModel.orderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.placeorder.services.orderServices;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1")

public class orderController {
    @Autowired
    private orderServices orderServices;

//    Create Order
    @PostMapping("/createOrder")
    public OrderResponse createOrder(@RequestBody orderDTO orderDTO) {
        return orderServices.createOrder(orderDTO);
    }

//    Get Order
    @GetMapping("/get-order")
    public List<orderModel> getOrder() {
        return orderServices.getOrder();
    }

}
