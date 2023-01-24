package com.example.serverBox.controller;

import com.example.serverBox.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/server")
public class TestController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/around-hub")
    public String getTest1(){
        LOGGER.info("getTest1 호출");
        return "Hello. Roze's Study!";
    }

    @GetMapping("/name")
    public String getTest2(@RequestParam String name){
        LOGGER.info("getTest2 호출");
        return "Hello. " + name + "!";
    }

    @GetMapping("/path-variable/{name}")
    public String getTest3(@PathVariable String name){
        LOGGER.info("getTest3 호출");
        return "Hello. "+ name + "!";
    }

    @PostMapping("/member")
    public ResponseEntity<MemberDto> getMember(
            @RequestBody MemberDto memberDto,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization
    ) {
        LOGGER.info("getMember 호출");

        MemberDto memberDto1 = new MemberDto();
        memberDto1.setName(name);
        memberDto1.setEmail(email);
        memberDto1.setOrganization(organization);

        return ResponseEntity.status(HttpStatus.OK).body(memberDto1);
    }

    @PostMapping("/add-header")
    public ResponseEntity<MemberDto> addHeader(@RequestHeader("around-header") String header, @RequestBody MemberDto memberDto){
        LOGGER.info("add-header 호출");
        LOGGER.info("header 값 : {}", header);

//        return memberDto.getName() + " " + memberDto.getEmail() + " " + memberDto.getOrganization();
        return ResponseEntity.status(HttpStatus.OK).body(memberDto);
    }

}
