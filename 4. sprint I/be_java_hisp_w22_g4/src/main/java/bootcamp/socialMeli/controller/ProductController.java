package bootcamp.socialMeli.controller;

import bootcamp.socialMeli.dto.ProductDto;
import bootcamp.socialMeli.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getUsers()
    {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
}
