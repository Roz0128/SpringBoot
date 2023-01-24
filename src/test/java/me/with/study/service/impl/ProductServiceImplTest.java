package me.with.study.service.impl;

import me.with.study.common.exception.SpringBootStudyException;
import me.with.study.data.dto.ProductDto;
import me.with.study.data.entity.ProductEntity;
import me.with.study.data.handler.impl.ProductDataHandlerImpl;
import me.with.study.data.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;

//@SpringBootTest(classes = {ProductDataHandlerImpl.class, ProductServiceImpl.class})
@ExtendWith(SpringExtension.class)
@Import({ProductDataHandlerImpl.class, ProductServiceImpl.class})
public class ProductServiceImplTest {
    @MockBean
    ProductDataHandlerImpl productDataHandler;

    @Autowired
    ProductServiceImpl productService;

    @Test
    public void getProductTest(){

        //given
        Mockito.when(productDataHandler.getProductEntity("123")) // ProductEntity가 "123"이라는 매개변수를 호출할 때 아래 값으로 Return 
                .thenReturn(new ProductEntity("123", "pen", 2000, 7000));

        ProductDto productDto = productService.getProduct("123");
        Assertions.assertEquals(productDto.getProductId(), "123");
        verify(productDataHandler).getProductEntity("123");

    }

    @Test
    public void saveProductTest(){

        //given

    }

}
