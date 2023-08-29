package com.example.testproject.controller;

import DTO.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    //http://localhost:8080/api/v1/post-api/default
    @PostMapping(value = "/default")
    public String postMethod() {
        return "Hello World";
    }

    // 4로 시작하는 에러는 클라이언트 에러, 5는 서버 에러
    //http://localhost:8080/api/v1/post-api/member
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n"); // 키 값과 발류 값으로 출력
        });
        return sb.toString();
    }

    //MemberDTO api 사용하기
    //http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value = "/member2")
    public String postMember2(@RequestBody MemberDTO memberDTO){
        return memberDTO.toString();
    }
}
