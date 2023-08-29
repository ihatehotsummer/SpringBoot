package com.example.testproject.data.dao;

import com.example.testproject.data.entity.ProductEntity;

public interface ProductDAO {

    ProductEntity saveProduct(ProductEntity productEntity); // 상품 생성
    ProductEntity getProduct(String productId); // 상품 조회
}
