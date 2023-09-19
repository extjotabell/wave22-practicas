package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.ProductDto;

import java.util.List;

public interface IProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProductById(int productId);
    void addProducto(ProductDto productDto);

}
