package ca.pm.manageProduct.product.services;

import ca.pm.manageProduct.Query;
import ca.pm.manageProduct.product.ProductRepository;
import ca.pm.manageProduct.product.model.Product;
import ca.pm.manageProduct.product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsService implements Query<Void, List<ProductDTO>> {


    private final ProductRepository productRepository;

    public GetProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input) {

        List<Product> product = productRepository.findAll();
        List<ProductDTO> productDTOs = product.stream().map(ProductDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
    }
}
