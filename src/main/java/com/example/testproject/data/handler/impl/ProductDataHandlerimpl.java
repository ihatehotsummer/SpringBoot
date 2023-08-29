package com.example.testproject.data.handler.impl;

import com.example.testproject.data.dao.ProductDAO;
import com.example.testproject.data.dto.ProductDto;
import com.example.testproject.data.entity.ProductEntity;
import com.example.testproject.data.handler.ProductDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductDataHandlerimpl implements ProductDataHandler {

    ProductDAO productDAO; // 여기선 DAO 사용함 -> 빽단으로 이동

    @Autowired // 의존성 주입
    public  ProductDataHandlerimpl(ProductDAO productDAO) {this.productDAO= productDAO;}

    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = new ProductEntity(productId, productName, productPrice,productStock);

        return productDAO.saveProduct(productEntity); // 여기서 Entity는 테이블과 1:1로 연결되어 있어서 return해 주면 문제 없이 잘 될거래 씨발아
    }

    @Override
    public ProductEntity getProductEntity(String productId) {
        return productDAO.getProduct(productId); // 데이터베이스에서 DAO가 Entity를 불러온다
    }
}
