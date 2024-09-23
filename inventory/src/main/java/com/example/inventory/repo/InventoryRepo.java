package com.example.inventory.repo;

import com.example.inventory.model.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<InventoryModel, Integer> {
    @Query(value = "SELECT * FROM inventory WHERE itemId = ?1", nativeQuery = true)
    InventoryModel getInventoryByItemId(Integer itemId);
}
