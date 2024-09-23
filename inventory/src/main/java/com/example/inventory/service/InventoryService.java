package com.example.inventory.service;

import com.example.inventory.dto.InventoryDTO;
import com.example.inventory.model.InventoryModel;
//import com.example.inventory.repo.InventoryRepo;
import com.example.inventory.repo.InventoryRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class InventoryService {
    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private ModelMapper modelMapper;

//    create user
    public InventoryModel createInventory(InventoryDTO inventoryDTO) {
//        return inventoryDTO;
        return inventoryRepo.save(modelMapper.map(inventoryDTO , InventoryModel.class));

    }

//    get created inventory
    public List<InventoryModel> getAllInventory() {
        return inventoryRepo.findAll();
    }

//    get order using itemId
    public InventoryDTO getInventoryByItemId(Integer id) {
        InventoryModel item = inventoryRepo.findById(id).get();
        return modelMapper.map(item , InventoryDTO.class);
    }

}
