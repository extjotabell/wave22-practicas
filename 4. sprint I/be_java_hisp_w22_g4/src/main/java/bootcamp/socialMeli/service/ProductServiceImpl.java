package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.ProductDto;
import bootcamp.socialMeli.entity.Product;
import bootcamp.socialMeli.repository.IProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService{
    private final IProductRepository productRepository;
    //private final IUserService userService;
    //private final IPostService postService;
    ObjectMapper mapper = new ObjectMapper();
    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepository.getAllProduct();
        return productList.stream().
                map(product -> mapper.convertValue(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(int productId) {
        Product product = productRepository.getProductById(productId);
        return new ProductDto(
                product.getProduct_id(),
                product.getProduct_name(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
    }
}
