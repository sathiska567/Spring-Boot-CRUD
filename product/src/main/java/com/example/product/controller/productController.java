package com.example.product.controller;


import com.example.product.dto.productDTO;
import com.example.product.model.productModel;
import com.example.product.services.productServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1")

public class productController {

    @Autowired
    private productServices productService;


    @PostMapping("/create")
    public productModel createProduct(@RequestBody productDTO productDTO) {
       return productService.saveProduct(productDTO);
    }

    @GetMapping("/getUser")
    public List<productModel> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/getUniqueUser/{userId}")
    public productDTO getProductsByProductId(@PathVariable int userId){

        return productService.getProductById(userId);
    }

    @PutMapping("/updateUser")
    public productDTO updateProduct (@RequestBody productDTO productDTO) {
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/deleterUser/{userId}")
    public String deleteProduct(@PathVariable int userId) {
        return productService.deleteProduct(userId);
    }


}
