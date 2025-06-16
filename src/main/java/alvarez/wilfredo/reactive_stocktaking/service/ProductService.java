package alvarez.wilfredo.reactive_stocktaking.service;

import alvarez.wilfredo.reactive_stocktaking.service.contract.to.ProductTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<ProductTO> findAllProducts();
    Mono<ProductTO> getProduct(Long productId);
    Mono<ProductTO> createProduct(ProductTO productTO);
    Mono<ProductTO> updateProduct(Long productId, ProductTO productTO);
    Mono<Void> deleteProduct(Long productId);
}
