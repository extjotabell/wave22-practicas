package bootcamp.socialMeli.repository;

import bootcamp.socialMeli.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository{
    @Override
    public List<Product> getAllProduct() {
        return null;
    }
}
