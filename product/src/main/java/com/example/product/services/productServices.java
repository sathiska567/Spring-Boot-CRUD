package com.example.product.services;

import com.example.product.dto.productDTO;
import com.example.product.model.productModel;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.product.repo.productRepo;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class productServices {

    @Autowired
    private productRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;


//     create user
    public productModel saveProduct(productDTO saveProductDTO) {
        return productRepo.save(modelMapper.map(saveProductDTO , productModel.class));
    }

//    get all users
    public List<productModel> getAllProducts() {

        return productRepo.findAll();
    }

//    get user considering user id
    public productDTO getProductById(int id) {
        Optional<productModel> product = productRepo.findById(id);

        return modelMapper.map(product , productDTO.class);
    }

//    update considering user
    public productDTO updateProduct(productDTO productDTO) {
         productRepo.save(modelMapper.map(productDTO , productModel.class));
        return productDTO;
    }

//    delete products
    public String deleteProduct(int id) {
        productRepo.deleteById(id);

        return "Product deleted";

    }


}
