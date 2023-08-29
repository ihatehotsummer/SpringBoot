package com.example.testproject.data.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.example.testproject.data.dto.ProductDto;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "product") // 실제 데이터베이스의 테이블과 1:1로 매핑됨 -> 데이터베이스의 테이블을 만듬
public class ProductEntity {  // 이 클래스의 필드는 각 테이블 내부의 컬럼(Column)을 의미함
    // 데이터베이스에 쓰일 컬럼과 여러 엔티티 간의 연관관계를 정의
    // 데이터베이스의 테이블을 하나의 엔티티로 생각해 도 무방함

    // PK(primary key)
    @Id
    String productId;
    String productName;
    Integer productPrice;
    Integer productStock;

}
