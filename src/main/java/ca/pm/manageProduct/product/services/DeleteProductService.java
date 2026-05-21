package ca.pm.manageProduct.product.services;

import ca.pm.manageProduct.Command;
import ca.pm.manageProduct.product.ProductRepository;
import ca.pm.manageProduct.product.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;

@Service
public class DeleteProductService implements Command<Integer, Void> {

    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        // throw exception if not found
        return null;
    }
}
