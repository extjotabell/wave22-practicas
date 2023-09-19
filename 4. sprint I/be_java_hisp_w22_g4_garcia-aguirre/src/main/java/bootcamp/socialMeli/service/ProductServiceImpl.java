package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.ProductDto;
import bootcamp.socialMeli.entity.Product;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.IProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService{
    private final IProductRepository productRepository;
    private final ObjectMapper objectMapper;
    public ProductServiceImpl(IProductRepository productRepository, ObjectMapper objectMapper) {
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepository.getAllProduct();
        if (productList.isEmpty()) throw new NotFoundException("No se encontraron productos en el sistema.");
        return productList.stream().
                map(product -> objectMapper.convertValue(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(int productId) {
        Product product = productRepository.getProductById(productId)
                .orElseThrow(
                        () -> new NotFoundException("No se encontro producto para el id solicitado.")
                );

        return objectMapper.convertValue(product, ProductDto.class);
    }

    @Override
    public void addProducto(ProductDto productDto) {
        Product product = objectMapper.convertValue(productDto, Product.class);
        productRepository.addProducto(product);
    }
}
