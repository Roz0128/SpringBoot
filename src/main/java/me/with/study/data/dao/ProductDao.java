package me.with.study.data.dao;

import me.with.study.data.entity.ProductEntity;

public interface ProductDao {

    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);
}
