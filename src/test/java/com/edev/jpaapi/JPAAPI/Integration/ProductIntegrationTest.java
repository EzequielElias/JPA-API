package com.edev.jpaapi.JPAAPI.Integration;

import com.edev.jpaapi.JPAAPI.Controllers.ProductController;
import com.edev.jpaapi.JPAAPI.Entities.ProductEntity;
import com.edev.jpaapi.JPAAPI.Repositories.ProductRepository;
import com.edev.jpaapi.JPAAPI.Vos.ProductVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductIntegrationTest {

    @Autowired
    private ProductController productController;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
    }

    private ProductEntity aProductEntity(String description) {
        final ProductEntity product = new ProductEntity();
        product.setDescription(description);
        product.setValue(10.0);
        return product;
    }

    @Test
    public void shouldFindAll() {

        productRepository.save(aProductEntity("Description"));
        productRepository.save(aProductEntity("Description"));

        List<ProductVO> products = productController.findAll();
        Assertions.assertThat(products).hasSize(2);
                
    }

    @Test
    public void shouldFindByDescription() {

        productRepository.save(aProductEntity("Description"));
        productRepository.save(aProductEntity("Description 2"));
        productRepository.save(aProductEntity("Qualquer coisa"));

        List<ProductEntity> productEntities =
                productController.findByDescription("Description");

        Assertions.assertThat(productEntities).hasSize(1);
    }

}
