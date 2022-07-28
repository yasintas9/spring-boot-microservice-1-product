package com.sha.springbootmicroservice1product.controller;

import com.sha.springbootmicroservice1product.model.Product;
import com.sha.springbootmicroservice1product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping //API/PRODUCT
    public ResponseEntity saveProduct(@RequestBody Product product){
        return new ResponseEntity(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("{productId}")   // api/product/productId
    public ResponseEntity deleteProduct(Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping//API/PRODUCT
    public ResponseEntity getAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }
}
