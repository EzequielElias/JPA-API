package com.edev.jpaapi.JPAAPI.Repositories;

import com.edev.jpaapi.JPAAPI.Entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByDescription(String description);
}
