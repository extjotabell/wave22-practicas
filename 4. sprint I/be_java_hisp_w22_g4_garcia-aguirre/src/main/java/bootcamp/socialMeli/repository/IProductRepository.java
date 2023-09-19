package bootcamp.socialMeli.repository;

import bootcamp.socialMeli.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<Product> getAllProduct();
    Optional<Product> getProductById(int productId);
    void addProducto(Product product);
}
