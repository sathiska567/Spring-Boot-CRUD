package org.example.placeorder.OrderRepo;

import org.example.placeorder.orderModel.orderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface orderRepo extends JpaRepository<orderModel, Integer> {

}
