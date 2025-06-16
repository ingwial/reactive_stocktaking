package alvarez.wilfredo.reactive_stocktaking.datasource;

import alvarez.wilfredo.reactive_stocktaking.datasource.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
}
