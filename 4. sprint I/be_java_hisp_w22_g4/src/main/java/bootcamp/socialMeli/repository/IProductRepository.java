package bootcamp.socialMeli.repository;

import bootcamp.socialMeli.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProduct();
}
