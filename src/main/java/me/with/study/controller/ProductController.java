package me.with.study.controller;

import me.with.study.common.Constants;
import me.with.study.common.exception.SpringBootStudyException;
import me.with.study.data.dto.ProductDto;
import me.with.study.data.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    // http://localhost:8080/api/v1/product-api/product/{productId}
    @GetMapping("/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId){

        long startTime = System.currentTimeMillis();
        LOGGER.info("[ProductController] perform {} of SpringBootStudy API.", "getProduct");

        ProductDto productDto = productService.getProduct(productId);
        LOGGER.info("[ProductContoller] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms",
                productDto.getProductId(), productDto.getProductName(), productDto.getProductName(), productDto.getProductPrice(),
                productDto.getProductStock(), (System.currentTimeMillis() - startTime));

        return productDto;
    }

    // http://localhost:8080/api/v1/product-api/product
    @PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto){ // 유효성 검사를 하려면 @Valid 추가해야 함

        // Validation Code Example
//        if (productDto.getProductId().equals("") || productDto.getProductId().isEmpty()){
//            LOGGER.error("[createProduct] failed Response :: productId is Empty");
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productDto);
//        }

        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        ProductDto response = productService.saveProduct(productId, productName, productPrice, productStock);
        LOGGER.info("[createProduct] Response >> productId = {}, productName = {}, productPrice = {}, productStock = {}",
                response.getProductId(), response.getProductName(), response.getProductPrice(), response.getProductStock());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // http://localhost:8080/api/v1/product-api/product/{productId}
    @DeleteMapping(value = "/product/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId) {
        return null;
    }

    @PostMapping(value = "/product/exception")
    public void exceptionTest() throws SpringBootStudyException{
        throw new SpringBootStudyException(Constants.ExceptionClass.PRODUCT, HttpStatus.FORBIDDEN, "접근이 금지되었습니다. ");
    }
}
