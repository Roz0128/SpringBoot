//package me.with.study.controller;
//
//import me.with.study.data.dto.ShortUrlResponseDto;
//import me.with.study.data.service.ShortUrlService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URL;
//
//@RestController
//@RequestMapping("/short-url")
//public class ShortUrlController {
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Value("${roze.hub.short.url.id}")
//    private String CLIENT_ID;
//
//    @Value("${roze.hub.short.url.secret}")
//    private String CLIENT_SECRETE;
//
//    ShortUrlService shortUrlService;
//
//    @Autowired
//    public ShortUrlController(ShortUrlService shortUrlService){
//        this.shortUrlService = shortUrlService;
//    }
//
//    // 객체의 생명주기를 고민해봐야 함.
//    @PostMapping()
//    public ShortUrlResponseDto generateShortUrl(String originalUrl){
//        logger.info("[generateShorUrl] perform API, CLIENT_ID :  {}, CLIENT_SECRET : {}", CLIENT_ID, CLIENT_SECRETE);
//        return shortUrlService.generateShortUrl(CLIENT_ID, CLIENT_SECRETE, originalUrl);
//    }
//
//    @GetMapping()
//    public ShortUrlResponseDto getShortUrl(String originalUrl){
//        ShortUrlResponseDto shortUrlResponseDto = new ShortUrlResponseDto("ss", "ss");
//        return shortUrlService.getShortUrl(CLIENT_ID, CLIENT_SECRETE, originalUrl);
//    }
//
//    @PutMapping("/")
//    public ShortUrlResponseDto updateShortUrl(String orgonalUrl){return null;}
//
//    @DeleteMapping("/")
//    public ResponseEntity<String> deleteShortUrl(String url){
//
//        try{
//            shortUrlService.deleteByShortUrl(url);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
//    }
//}
