package ca.pm.manageProduct.product.services;

import ca.pm.manageProduct.Query;
import ca.pm.manageProduct.product.ProductRepository;
import ca.pm.manageProduct.product.model.Product;
import ca.pm.manageProduct.product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductService implements Query<Integer, ProductDTO> {

    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Integer input) {

        Optional<Product> productOptional = productRepository.findById(input);
        if(productOptional.isPresent()) {
            return ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }

        //throw an exception here

        return null;
    }
}
