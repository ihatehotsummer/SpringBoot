package com.example.testproject.data.dao.impl;

import com.example.testproject.data.dao.ProductDAO;
import com.example.testproject.data.entity.ProductEntity;
import com.example.testproject.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO { //Data Access Object
    // 데이터베이스에 접근하는 객체를 의미함(Persistance Layer)
    // Service가 DB에 연결할 수 있게 해주는 역할
    // DB를 사용하여 데이터를 조회하거나 조작하는 기능을 전담
    // 접근하는 본질은 레포지토리, 메소드들을 활용하는건 DAO -> 직접적으로 사용하는건 DAO 객체이다.

    ProductRepository productRepository; // 싱글톤 기법의 기초로 먼저 객체 하나를 만들어 여러 클래스에서 이 객체를 Autowired 해서 주입

    @Autowired // 의존성 주입(DI) 생성자와 Autowired 를 통해 productRepository 객체를 이용한다.
    public ProductDAOImpl(ProductRepository productRepository){ // 생성자(Constructor) 만들기
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        productRepository.save(productEntity); // 레포지토리의 Jpa에 있는 save 메소드를 사용해서 entity 저장 => 데이터베이스 저장
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId) { // productId를 넘겨주고 productEntity를 가져옴 -> 조회하는것
        ProductEntity productEntity = productRepository.getById(productId); // id를 기반으로 Entity를 가져옴
        return productEntity;
    }
}
