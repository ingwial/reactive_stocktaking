package alvarez.wilfredo.reactive_stocktaking.service.impl;

import alvarez.wilfredo.reactive_stocktaking.datasource.ProductRepository;
import alvarez.wilfredo.reactive_stocktaking.service.ProductService;
import alvarez.wilfredo.reactive_stocktaking.service.contract.to.ProductTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static alvarez.wilfredo.reactive_stocktaking.service.contract.ProductBinder.PRODUCT_BINDER;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<ProductTO> findAllProducts() {
        return this.productRepository.findAll()
                .map(PRODUCT_BINDER::bind);
    }

    @Override
    public Mono<ProductTO> getProduct(Long productId) {
        return this.productRepository.findById(productId)
                .map(PRODUCT_BINDER::bind);
    }

    @Override
    public Mono<ProductTO> createProduct(ProductTO productTO) {
        return this.productRepository.save(PRODUCT_BINDER.bind(productTO))
                .map(PRODUCT_BINDER::bind);
    }

    @Override
    public Mono<ProductTO> updateProduct(Long productId, ProductTO productTO) {
        return this.productRepository.findById(productId)
                .map(product -> PRODUCT_BINDER.bind(productTO, product))
                .flatMap(this.productRepository::save)
                .map(PRODUCT_BINDER::bind);
    }

    @Override
    public Mono<Void> deleteProduct(Long productId) {
        return this.productRepository.deleteById(productId);
    }
}
