package com.example.testproject.data.repository;

import com.example.testproject.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> { // entity와 id 데이터값(pk값 = primary key)
    // Jpa 레포지토리를 사용한다는것은 우리가 코드를 작성하지 않아도 기본적인 CRUD 메소드를 제공한다
    // Entity에 의해 생성된 데이터베이스에 접근하는 메소드를 사용하기 위한 인터페이스
    // Service와 DB를 연결하는 고리의 역할을 수행
    // 데이터베이스에 적용하고자 하는 CRUD를 정의하는 영역

    // *JPA- ORM(Object Relational Mapping) 어플리케이션 객체와 관계형 데이터베이스의 데이터를 자동으로 매핑해주는것
    // Java의 데이터 클래스와 DB의 테이블을 매핑
    // Hibernate- ORM Framework 중 하나이며 JPA 실제 구현체중 하나, 제일 많이 쓰임
}
