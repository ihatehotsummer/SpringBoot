package com.example.testproject.data.service;

import com.example.testproject.data.dto.ProductDto;

public interface ProductService { // loosecoupling
    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);
    // 데이터 베이스에 저장하는것

    ProductDto getProduct(String productId); // Id 값 만으로도 상품 정보를 조회하는것

}
