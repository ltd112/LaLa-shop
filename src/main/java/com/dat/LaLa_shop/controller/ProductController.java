package com.dat.LaLa_shop.controller;

import com.dat.LaLa_shop.dto.ProductDto;
import com.dat.LaLa_shop.exceptions.ResourceNotFoundException;
import com.dat.LaLa_shop.model.Product;
import com.dat.LaLa_shop.respone.ApiResponse;
import com.dat.LaLa_shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import java.util.List;

@RestController
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        List<ProductDto> productDto = productService.getConvertedProducts(products);
        return ResponseEntity.ok(new ApiResponse("success", productDto));
    }

    @GetMapping("product/{id}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long id){
        try {
            Product product = productService.getProductById(id);
            ProductDto productDto = productService.convertedProduct(product);
            return ResponseEntity.ok(new ApiResponse("success", productDto));
        }
        catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));

        }

    }


}
