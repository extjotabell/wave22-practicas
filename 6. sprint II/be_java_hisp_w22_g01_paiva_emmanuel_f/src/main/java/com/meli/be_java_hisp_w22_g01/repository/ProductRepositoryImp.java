package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepositoryImp  implements IProductRepository{

    private final List<Product> products = new ArrayList<>();

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

    public Product getById(int id){
        return products.stream().filter(product -> product.getProduct_id() == id).findFirst().orElse(null);
    }

    @Override
    public void save (Product product){
        products.add(product);
    }
}
