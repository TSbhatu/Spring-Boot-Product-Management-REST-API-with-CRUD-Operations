package ca.pm.manageProduct.product.services;

import ca.pm.manageProduct.Command;
import ca.pm.manageProduct.product.ProductRepository;
import ca.pm.manageProduct.product.model.Product;
import ca.pm.manageProduct.product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<Product, ProductDTO> {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {
        Product savedproduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedproduct));
    }
}
