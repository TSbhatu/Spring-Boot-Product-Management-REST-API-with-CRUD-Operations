package ca.pm.manageProduct.product;

import ca.pm.manageProduct.product.model.Product;
import ca.pm.manageProduct.product.model.ProductDTO;
import ca.pm.manageProduct.product.model.UpdateProductCommand;
import ca.pm.manageProduct.product.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final CreateProductService createProductService;
    private final GetProductsService getProductsService;
    private final UpdateProductService updateProductService;
    private final DeleteProductService deleteProductService;
    private final GetProductService getProductService;

    public ProductController(CreateProductService createProductService,
                             GetProductsService getProductsService,
                             UpdateProductService updateProductService,
                             DeleteProductService deleteProductService,
                             GetProductService getProductService) {
        this.createProductService = createProductService;
        this.getProductsService = getProductsService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
        this.getProductService = getProductService;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product){

        return createProductService.execute(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getProducts(){

        return getProductsService.execute(null);
    }

    // also need to update the mapping , new get mapping for find by id
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> GetProduct(@PathVariable Integer id){
        return getProductService.execute(id);
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody Product product){

        return updateProductService.execute(new UpdateProductCommand(id,product));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){

        return deleteProductService.execute(id);
    }

}
