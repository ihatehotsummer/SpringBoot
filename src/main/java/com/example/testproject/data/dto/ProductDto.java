package com.example.testproject.data.dto;

import com.example.testproject.data.entity.ProductEntity;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto { // Data Transfer Object
    // DTO는 VO(Value Object)로 불리기도 하며, 계층간 데이터 교환(클라이언트 -> 콘트롤러, 콘트롤러->서비스)을 위한 객체를 의미한다.
    // Entity와 다른점 : 엔티티는 DB테이블과 1:1로 연결되어있지만, DTO는 Entity와 같은 필드값(productId,Name ...etc)을 가질 수 있지만 데이터 베이스의 컬럼과 독립적임
    // VO의 경우 Read Only 개념을 가지고 있음.

    @NotNull
    // @Size(min = 8, max = 8)
    private String productId;

    @NotNull
    private String productName;

    @NotNull
    @Min(value= 500)
    @Max(value= 3000000)
    private int productPrice; // 500원에서 300만원

    @NotNull
    @Min(value= 0)
    @Max(value= 9999)
    private int productStock;

    public ProductEntity toEntity(){
        return ProductEntity.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }
}
