package com.example.inventory.controller;


import com.example.inventory.dto.InventoryDTO;
import com.example.inventory.model.InventoryModel;
import com.example.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1")

public class InventoryController {
   @Autowired
    private InventoryService inventoryService;

    @PostMapping("/create")
    public InventoryModel createProduct(@RequestBody InventoryDTO inventoryDTO){
       return inventoryService.createInventory(inventoryDTO);
    }

    @GetMapping("/getInventory")
    public List<InventoryModel> getInverntory(){
        return inventoryService.getAllInventory();
    }

    @GetMapping("/item/{itemId}")
    public InventoryDTO getItemByItemId(@PathVariable Integer itemId){
         return inventoryService.getInventoryByItemId(itemId);
    }

}
