package com.example.product.repo;

import com.example.product.model.productModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface productRepo extends JpaRepository<productModel,Integer> {
    @Query(value = "SELECT * FROM prodcut WHERE product_id = ?1", nativeQuery = true)
    productModel getProductById(Integer productId);

}
