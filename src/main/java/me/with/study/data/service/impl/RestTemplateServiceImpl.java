//package me.with.study.data.service.impl;
//
//import me.with.study.data.service.RestTemplateService;
//import me.with.study.dto.MemberDto;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.RequestEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.lang.reflect.Member;
//import java.net.URI;
//
//@Service
//public class RestTemplateServiceImpl implements RestTemplateService {
//
//    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//
//    @Override
//    public String getAroundHub() {
//        URI uri = UriComponentsBuilder // uri : 어떤 경로로 요청 할건지?
//                .fromUriString("http://localhost:9090")
//                .path("/api/server/around-hub")
//                .encode()
//                .build()
//                .toUri();
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
//
//        LOGGER.info("status code : {}", responseEntity.getStatusCode());
//        LOGGER.info("body : {}", responseEntity.getBody());
//
//        return responseEntity.getBody();
//    }
//
//    @Override
//    public String getName() {
//        URI uri = UriComponentsBuilder
//                .fromUriString("http://localhost:9090")
//                .path("/api/server/name")
//                .queryParam("name", "roze") // RequestParam 값
//                .encode()
//                .build()
//                .toUri();
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
//
//        LOGGER.info("status code : {}", responseEntity.getStatusCode());
//        LOGGER.info("body : {}", responseEntity.getBody());
//
//        return responseEntity.getBody();
//    }
//
//    @Override
//    public String getName2() {
//        URI uri = UriComponentsBuilder
//                .fromUriString("http://localhost:9090")
//                .path("/api/server/path-variable/{name}")
//                .encode()
//                .build()
//                .expand("roze") // 복수의 값을 넣어야 할 경우에는 , 를 추가하여 구분
//                .toUri();
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
//
//        LOGGER.info("status code : {}", responseEntity.getStatusCode());
//        LOGGER.info("body : {}", responseEntity.getBody());
//
//        return responseEntity.getBody();
//    }
//
//    @Override
//    public ResponseEntity<MemberDto> postDto() {
//
//        URI uri = UriComponentsBuilder
//                .fromUriString("http://localhost:9090")
//                .path("/api/server/member")
//                .queryParam("name", "roze")
//                .queryParam("email", "123@naver.com")
//                .queryParam("organization", "Roze's Study")
//                .encode()
//                .build()
//                .toUri();
//
//        MemberDto memberDto = new MemberDto();
//        memberDto.setName("ROZE!!!");
//        memberDto.setEmail("abc@aaa.com");
//        memberDto.setOrganization("STUDY!!!!!!");
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<MemberDto> responseEntity = restTemplate.postForEntity(uri, memberDto, MemberDto.class);
//
//        LOGGER.info("status code : {}", responseEntity.getStatusCode());
//        LOGGER.info("body : {}", responseEntity.getBody());
//
//        return responseEntity;
//    }
//
//    @Override
//    public ResponseEntity<MemberDto> addHeader() {
//        URI uri = UriComponentsBuilder
//                .fromUriString("http://localhost:9090")
//                .path("/api/server/add-header")
//                .encode()
//                .build()
//                .toUri();
//
//        MemberDto memberDto = new MemberDto();
//        memberDto.setName("ROZE!!!");
//        memberDto.setEmail("abc@aaa.com");
//        memberDto.setOrganization("STUDY!!!!!!");
//
//        RequestEntity<MemberDto> requestEntity = RequestEntity
//                .post(uri)
//                .header("around-header", "Roze Study")
//                .body(memberDto);
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<MemberDto> responseEntity = restTemplate.exchange(requestEntity, MemberDto.class);
//
//        LOGGER.info("status code : {}", responseEntity.getStatusCode());
//        LOGGER.info("body : {}", responseEntity.getBody());
//
//        return responseEntity;
//
//    }
//}
