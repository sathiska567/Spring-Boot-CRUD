package org.example.placeorder.services;

import com.example.inventory.dto.InventoryDTO;
import com.example.product.dto.productDTO;
import jakarta.transaction.Transactional;
import org.example.placeorder.common.ErrorOrderResponse;
import org.example.placeorder.common.OrderResponse;
import org.example.placeorder.common.SuccessOrderResponse;
import org.example.placeorder.orderModel.orderModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.placeorder.OrderRepo.orderRepo;
import org.example.placeorder.OrderDTO.orderDTO;
import org.springframework.ui.Model;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

@Service
@Transactional

public class orderServices {

//    here webclient name want to equal config name
    private final WebClient inventoryWebClient;
    private final WebClient productWebClient;

    @Autowired
    private orderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

//    create a constructor adding web client
    public orderServices(WebClient inventoryWebClient ,WebClient productWebClient  , orderRepo orderRepo , ModelMapper modelMapper) {
        this.orderRepo = orderRepo;
        this.modelMapper = modelMapper;

//        Host is not specified
        this.inventoryWebClient =inventoryWebClient;
        this.productWebClient = productWebClient;
    }


    //    create order
    public OrderResponse createOrder(orderDTO orderDTO){

        Integer itemId = orderDTO.getItemId();

        try {
//            get inventory response
            InventoryDTO inventoryResponse =  inventoryWebClient.get()
                    .uri(uriBuilder -> uriBuilder.path("/item/{itemId}").build(itemId))
                    .retrieve()
                    .bodyToMono(InventoryDTO.class)
                    .block();

            assert inventoryResponse != null;  //  this mean if we go next step when inventoryResponse is does not equal null.

            Integer productId = inventoryResponse.getProductId();

//            get product response
            productDTO prodcutResponse =  productWebClient.get()
                    .uri(uriBuilder -> uriBuilder.path("/getUniqueUser/{userId}").build(productId))
                    .retrieve()
                    .bodyToMono(productDTO.class)
                    .block();

            assert prodcutResponse != null;


            if(inventoryResponse.getQuantity() > 0){
                if(prodcutResponse.getForSale() == 1){
                    orderRepo.save(modelMapper.map(orderDTO , orderModel.class));
                }else{
                    return new ErrorOrderResponse("Item Is Not For Sale");
                }
                 return new SuccessOrderResponse(orderDTO);
            }else{
                return new ErrorOrderResponse("Item Not Available. Please try later");
            }



        }catch (WebClientResponseException e) {
//            this is not best way
            if(e.getStatusCode().is5xxServerError()){
                return new ErrorOrderResponse("Item Not Found");
            }
        }

        return null;
    }

    //    get created order
    public List<orderModel> getOrder(){
        return orderRepo.findAll();
    }
}
