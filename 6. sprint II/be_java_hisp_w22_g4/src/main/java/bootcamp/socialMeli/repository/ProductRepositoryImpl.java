package bootcamp.socialMeli.repository;

import bootcamp.socialMeli.entity.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository{
    HashMap<Integer, Product> productDatabase;

    public ProductRepositoryImpl() {
        productDatabase = loadProducts();
    }

    @Override
    public List<Product> getAllProduct() {
        return productDatabase.values().stream().toList();
    }

    @Override
    public Product getProductById(int productId) {
        return this.productDatabase.get(productId);
    }

    @Override
    public void addProducto(Product product) {
        productDatabase.put(product.getProductId(),product);
    }

    private HashMap<Integer, Product> loadProducts(){
        List<Product> products = loadDataBase();
        HashMap<Integer, Product> productHashMap = new HashMap<>();

        for (Product product : products) {
            productHashMap.put(product.getProductId(), product);
        }

        return productHashMap;
    }

    public List<Product> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:product.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Product>> typeRef = new TypeReference<>() {};
        List<Product> products = null;
        try {
            products = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
