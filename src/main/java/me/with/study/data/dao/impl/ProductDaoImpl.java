package me.with.study.data.dao.impl;

import me.with.study.data.dao.ProductDao;
import me.with.study.data.entity.ProductEntity;
import me.with.study.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDaoImpl implements ProductDao {

    ProductRepository productRepository;

    @Autowired // 자동으로 연결(DI) - 의존성 주입
    public ProductDaoImpl (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId) {
        ProductEntity productEntity = productRepository.getById(productId);
        return productEntity;
    }
}
