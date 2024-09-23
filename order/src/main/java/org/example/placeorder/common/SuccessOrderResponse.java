package org.example.placeorder.common;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import org.example.placeorder.OrderDTO.orderDTO;

@Getter
public class SuccessOrderResponse implements OrderResponse{
     @JsonUnwrapped    // can get object in flat object
     private final orderDTO order;

//     create constructor
     public SuccessOrderResponse(orderDTO order){
         this.order = order;
     }
     
}
