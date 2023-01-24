package me.with.study.data.handler;

import me.with.study.data.entity.ProductEntity;

public interface ProductDataHandler {

    ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);

    ProductEntity getProductEntity(String productId);
}
