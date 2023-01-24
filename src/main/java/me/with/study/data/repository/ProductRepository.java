package me.with.study.data.repository;

import me.with.study.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
