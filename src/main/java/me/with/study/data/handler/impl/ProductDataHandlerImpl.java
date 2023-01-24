package me.with.study.data.handler.impl;

import me.with.study.data.dao.ProductDao;
import me.with.study.data.entity.ProductEntity;
import me.with.study.data.handler.ProductDataHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    ProductDao productDao;

    @Autowired
    public ProductDataHandlerImpl(ProductDao productDao){
        this.productDao = productDao;
    }

    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = new ProductEntity(productId, productName, productPrice, productStock);
        return productDao.saveProduct(productEntity);
    }

    @Override
    public ProductEntity getProductEntity(String productId) {
        return productDao.getProduct(productId);
    }
}
