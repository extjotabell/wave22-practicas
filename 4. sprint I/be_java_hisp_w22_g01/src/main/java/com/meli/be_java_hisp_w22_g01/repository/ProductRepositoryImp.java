package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepositoryImp  implements IProductRepository{

    private List<Product> products = new ArrayList<>();

    public ProductRepositoryImp() {
        // Productos falsos
        Product product1 = new Product(1, "Botella", "Tipo", "Genérica", "Rojo", "Notas");
        Product product2 = new Product(2, "Shelby", "Tipo", "AC Cars", "Azul", "Notas");

        this.products.add(product1);
        this.products.add(product2);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(this.products);
    }
}
