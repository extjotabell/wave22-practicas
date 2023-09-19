package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.ProductDto;
import bootcamp.socialMeli.entity.Product;

import java.util.List;

public interface IProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProductDtoById(int productId);
    void addProducto(ProductDto productDto);
    Product getProductById(int productId);
}
