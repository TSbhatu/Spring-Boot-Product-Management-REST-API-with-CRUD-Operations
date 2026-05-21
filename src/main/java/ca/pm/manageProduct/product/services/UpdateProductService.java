package ca.pm.manageProduct.product.services;

import ca.pm.manageProduct.Command;
import ca.pm.manageProduct.product.ProductRepository;
import ca.pm.manageProduct.product.model.Product;
import ca.pm.manageProduct.product.model.ProductDTO;
import ca.pm.manageProduct.product.model.UpdateProductCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {

    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> productOptional = productRepository.findById(command.getId());
        if(productOptional.isPresent()){
            Product product = command.getProduct();
            product.setId(command.getId());
            productRepository.save(product);
        return ResponseEntity.ok(new ProductDTO(product));
        }

         //throw an exception if id not found
        return null;
    }
}
