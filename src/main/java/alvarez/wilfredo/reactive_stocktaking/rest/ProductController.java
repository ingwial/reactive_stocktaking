package alvarez.wilfredo.reactive_stocktaking.rest;

import alvarez.wilfredo.reactive_stocktaking.service.ProductService;
import alvarez.wilfredo.reactive_stocktaking.service.contract.to.ProductTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Flux<ProductTO>> getAllProducts() {
        return ResponseEntity.ok(this.productService.findAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<ProductTO>> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(this.productService.getProduct(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<ProductTO>> updateProduct(@PathVariable Long id, @RequestBody ProductTO product) {
        return ResponseEntity.ok(this.productService.updateProduct(id, product));
    }

    @PostMapping
    public ResponseEntity<Mono<ProductTO>> createProduct(@RequestBody ProductTO product) {
        return ResponseEntity.ok(this.productService.createProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(this.productService.deleteProduct(id));
    }

    @GetMapping("/filter/price/{initial_range}/{final_range}")
    public ResponseEntity<Flux<ProductTO>> getFilteredProductsByPrice(@PathVariable("initial_range") Integer initialRange,
                                                                      @PathVariable("final_range") Integer finalRange
    ) {
        return ResponseEntity.ok(this.productService.getFilteredProductsByPrice(initialRange,finalRange));
    }

    @GetMapping("/sort/price")
    public ResponseEntity<Flux<ProductTO>> getSortedProductsByPrice() {
        return ResponseEntity.ok(this.productService.getSortedProductsByPrice());
    }
}
