package com.bits.markoth.repository;

import com.bits.markoth.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProductRepository extends
        JpaRepository<ProductEntity, Long>,
        JpaSpecificationExecutor<ProductEntity>,
        ListCrudRepository<ProductEntity, Long> {
    //    Page<ProductEntity> findAllProductnameContainingIgnoreCase(Pageable pageable, String text);

    List<ProductEntity> findByTitleContainingIgnoreCaseAndDescriptionContainingIgnoreCaseAndCategoryContainingIgnoreCase(String title, String description, String category);
}