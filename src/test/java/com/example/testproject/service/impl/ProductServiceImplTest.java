package com.example.testproject.service.impl;

import static org.mockito.Mockito.verify;

import com.example.testproject.data.dto.ProductDto;
import com.example.testproject.data.handler.impl.ProductDataHandlerimpl;
import com.example.testproject.data.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.testproject.data.entity.ProductEntity;


//@SpringBootTest(classes = {ProductDataHandlerimpl.class, ProductServiceImpl.class})
@ExtendWith(SpringExtension.class)
@Import({ProductDataHandlerimpl.class, ProductServiceImpl.class})
public class ProductServiceImplTest {

  @MockBean
  ProductDataHandlerimpl productDataHandler;

  @Autowired
  ProductServiceImpl productService;

  @Test
  public void getProductTest() {
    //given
    Mockito.when(productDataHandler.getProductEntity("123"))
        .thenReturn(new ProductEntity("123", "pen", 2000, 3000));

    ProductDto productDto = productService.getProduct("123");

    Assertions.assertEquals(productDto.getProductId(), "123");
    Assertions.assertEquals(productDto.getProductName(), "pen");
    Assertions.assertEquals(productDto.getProductPrice(), 2000);
    Assertions.assertEquals(productDto.getProductStock(), 3000);

    verify(productDataHandler).getProductEntity("123");
  }

  @Test
  public void saveProductTest() {
    //given
    Mockito.when(productDataHandler.saveProductEntity("123", "pen", 2000, 3000))
        .thenReturn(new ProductEntity("123", "pen", 2000, 3000));

    ProductDto productDto = productService.saveProduct("123", "pen", 2000, 3000);

    Assertions.assertEquals(productDto.getProductId(), "123");
    Assertions.assertEquals(productDto.getProductName(), "pen");
    Assertions.assertEquals(productDto.getProductPrice(), 2000);
    Assertions.assertEquals(productDto.getProductStock(), 3000);

    verify(productDataHandler).saveProductEntity("123", "pen", 2000, 3000);
  }


}
