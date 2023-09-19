package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProducts();
    void save(Product product);
    Product getById(int id);

}
