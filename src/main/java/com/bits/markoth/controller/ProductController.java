package com.bits.markoth.controller;

import com.bits.markoth.domain.ProductEntity;
import com.bits.markoth.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/markoth/products")
public class ProductController extends GenericController<ProductEntity, Long> {
    @Autowired
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        super(productService);
    }


    @GetMapping(value = "/search", produces = "application/json")
    public List<ProductEntity> search(@RequestParam(value = "title",
            required = false) String title,
                                      @RequestParam(value =
                                              "description", required = false) String description,
                                      @RequestParam(value =
                                              "category", required = false) String category) {
        List<ProductEntity> products = productService.search(title,
                description, category);
        return products;
    }

    @GetMapping("/count")
    public Long getProductsCount() {
        return productService.getProductsCount();
    }


}