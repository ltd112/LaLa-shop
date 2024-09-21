package com.dat.LaLa_shop.service;

import com.dat.LaLa_shop.dto.ProductDto;
import com.dat.LaLa_shop.model.Product;
import com.dat.LaLa_shop.request.AddProductRequest;
import com.dat.LaLa_shop.request.ProductUpdateRequest;

import java.util.List;

public interface ProductService {
    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    void deleteProduct(Long id);
    Product updateProduct(Long id, ProductUpdateRequest product);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByNameAndBrand(String name, String brand);
    Long countProductsByBrandAndName(String brand, String name);

    List<ProductDto> getConvertedProducts(List<Product> products);
    ProductDto convertedProduct(Product product);

}
