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
    ObjectMapper mapper = new ObjectMapper();
    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepository.getAllProduct();
        if (productList.isEmpty()) throw new NotFoundException("No se encontraron productos en el sistema.");
        return productList.stream().
                map(product -> mapper.convertValue(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(int productId) {
        Product product = productRepository.getProductById(productId);
        if (product == null) throw new NotFoundException("No se encontro producto para el id solicitado.");
        return new ProductDto(
                product.getProductId(),
                product.getProduct_name(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
    }

    @Override
    public void addProducto(ProductDto productDto) {
        Product product = mapper.convertValue(productDto, Product.class);
        productRepository.addProducto(product);
    }
}
