package me.with.study.data.entity;

import lombok.*;
import me.with.study.data.dto.ProductDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class ProductEntity {

    @Id
    String productId;
    String productName;
    int productPrice;
    int productStock;

//    @Column
//    String sellerId;
//    String sellerPhoneNumber;

    public ProductDto toDto(){
        return ProductDto.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }
}
