package me.with.study.data.service.impl;

import me.with.study.data.dto.ProductDto;
import me.with.study.data.entity.ProductEntity;
import me.with.study.data.handler.ProductDataHandler;
import me.with.study.data.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDataHandler productDataHandler; // 옵션사항, 데이터를 핸들링할 작업 필요 여부

    @Autowired
    public ProductServiceImpl (ProductDataHandler productDataHandler){
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);

        ProductDto productDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName()
                , productEntity.getProductPrice(), productEntity.getProductStock());

        return productDto;
    }

    @Override
    public ProductDto getProduct(String productId) {
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);

        ProductDto productDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName()
                , productEntity.getProductPrice(), productEntity.getProductStock());

        return productDto;
    }
}
