package com.bits.markoth.service;

import com.bits.markoth.domain.ProductEntity;
import com.bits.markoth.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ProductService extends GenericService<ProductEntity, Long> {
    @Autowired
    ProductRepository repository;

    @Autowired
    public ProductService(final ProductRepository repository) {
        super(repository);
    }

    public List<ProductEntity> search(String title, String
            description, String category) {
        if (title == null) {
            title = "";
        }
        if (description == null) {
            description = "";
        }
        if (category == null) {
            category = "";
        }
        return repository.findByTitleContainingIgnoreCaseAndDescriptionContainingIgnoreCaseAndCategoryContainingIgnoreCase(title,
                description, category);
    }

    public Long getProductsCount() {
        return repository.count();
    }
}