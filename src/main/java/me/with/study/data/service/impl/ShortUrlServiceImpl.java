//package me.with.study.data.service.impl;
//
//import me.with.study.data.dao.ShortUrlDao;
//import me.with.study.data.dto.NaverUriDto;
//import me.with.study.data.entity.ShortUrl;
//import me.with.study.data.repository.ShortUrlRedisRepository;
//import me.with.study.data.service.ShortUrlService;
//import me.with.study.data.dto.ShortUrlResponseDto;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.net.URI;
//import java.util.Arrays;
//import java.util.Optional;
//
//@Service
//public class ShortUrlServiceImpl implements ShortUrlService {
//
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    private final ShortUrlDao shortUrlDao;
//    private final ShortUrlRedisRepository shortUrlRedisRepository;
//
//
//    @Autowired
//    public ShortUrlServiceImpl(ShortUrlDao shortUrlDao, ShortUrlRedisRepository shortUrlRedisRepository){
//        this.shortUrlDao = shortUrlDao;
//        this.shortUrlRedisRepository = shortUrlRedisRepository;
//    }
//    @Override
//    public ShortUrlResponseDto getShortUrl(String clientId, String clientSecret, String originalUrl) {
//        logger.info("[getShortUrl] request data : {}", originalUrl);
//        ShortUrl getShortUrlEntity = shortUrlDao.getShortUrl(originalUrl);
//
//        // Cache Logic
//        Optional<ShortUrlResponseDto> foundResponseDto = ShortUrlRedisRepository.findById(originalUrl);
//        if(foundResponseDto.isPresent()){
//            logger.info("[getShortUrl] Cache Data existed.");
//            return foundResponseDto.get();
//        } else {
//            logger.info("[getShortUrl] Cache Data does not existed.");
//        }
//
//        ShortUrl getShortUrl = shortUrlDao.getShortUrl(originalUrl);
//
//        String orgUrl;
//        String shortUrl;
//
//        if(getShortUrlEntity == null){
//            logger.info("[getShortUrl] No Entity in Database.");
//            ResponseEntity<NaverUriDto> responseEntity = requestShortUrl(clientId, clientSecret, originalUrl);
//
//            orgUrl = responseEntity.getBody().getResult().getOrgUrl();
//            shortUrl = responseEntity.getBody().getResult().getUrl();
//            String hash = responseEntity.getBody().getResult().getHash();
//
//            ShortUrl shortUrlEntity = new ShortUrl();
//            shortUrlEntity.setOrgUrl(orgUrl);
//            shortUrlEntity.setUrl(shortUrl);
//            shortUrlEntity.setHash(hash);
//
//            ShortUrlDao.saveShortUrl(shortUrlEntity);
//
//        } else {
//            orgUrl = getShortUrlEntity.getOrgUrl();
//            shortUrl = getShortUrlEntity.getUrl();
//        }
//
//        ShortUrlResponseDto shortUrlResponseDto = new ShortUrlResponseDto(orgUrl, shortUrl);
//        logger.info("[getShortUrl] Response DTO : {}", shortUrlResponseDto.toString());
//        return shortUrlResponseDto;
//    }
//
//    @Override
//    public ShortUrlResponseDto generateShortUrl(String clientId, String clientSecret, String originalUrl) {
//        logger.info("[generateShortUrl] request date : {}", originalUrl);
//
//        if(originalUrl.contains("m2.do")){
//            throw new RuntimeException();
//        }
//
//        ResponseEntity<NaverUriDto> responseEntity = requestShortUrl(clientId, clientSecret, originalUrl);
//        String orgUrl = responseEntity.getBody().getResult().getOrgUrl();
//        String shortUrl = responseEntity.getBody().getResult().getUrl();
//        String hash = responseEntity.getBody().getResult().getHash();
//
//        ShortUrl shortUrlEntity = new ShortUrl();
//        shortUrlEntity.setOrgUrl(orgUrl);
//        shortUrlEntity.setUrl(shortUrl);
//        shortUrlEntity.setHash(hash);
//
//        shortUrlDao.saveShortUrl(shortUrlEntity);
//
//        ShortUrlResponseDto shortUrlResponseDto = new ShortUrlResponseDto(orgUrl, shortUrl);
//
//        // Cache Logic
//        shortUrlRedisRepository.save(shortUrlResponseDto);
//        logger.info("[generateShortUrl] Response Dto : {}", shortUrlResponseDto);
//
//        return shortUrlResponseDto;
//    }
//
//    @Override
//    public ShortUrlResponseDto updateShortUrl(String clientId, String clientSecret, String originalUrl) {
//        return null;
//    }
//
//    @Override
//    public void deleteByShortUrl(String url) {
//        if(url.contains("me2.do")){
//            logger.info("[deleteShortUrl] Request Url is 'ShortUrl.'");
//            deleteByShortUrl(url);
//        } else {
//            logger.info("[deleteShortUrl] Request Url is 'OriginalUrl.'");
//            deleteByOriginalUrl(url);
//        }
//    }
//
//    @Override
//    public void deleteByOriginalUrl(String url) {
//        logger.info("[deleteByOriginalUrl] delete record");
//        shortUrlDao.deleteByOriginalUrl(url);
//    }
//
//    private ResponseEntity<NaverUriDto> requestShortUrl(String clientId, String clientSecret,
//                                                        String originalUrl) {
//        logger.info("[requestShortUrl] client ID : ***, client Secret : ***, original URL : {}", originalUrl);
//
//        URI uri = UriComponentsBuilder
//                .fromUriString("https://openapi.naver.com")
//                .path("/v1/util/shorturl")
//                .queryParam("url", originalUrl)
//                .encode()
//                .build()
//                .toUri();
//
//        logger.info("[requestShortUrl] set HTTP Request Header");
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("X-Naver-Client-Id", clientId);
//        headers.set("X-Naver-Client-Secret", clientSecret);
//
//        HttpEntity<String> entity = new HttpEntity<>("", headers);
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        logger.info("[requestShortUrl] request by restTemplate");
//        ResponseEntity<NaverUriDto> responseEntity = restTemplate.exchange(uri, HttpMethod.GET,
//                entity, NaverUriDto.class);
//
//        logger.info("[requestShortUrl] request has been successfully complete.");
//
//        return responseEntity;
//    }
//}
