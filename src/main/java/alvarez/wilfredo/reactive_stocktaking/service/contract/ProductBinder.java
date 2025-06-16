package alvarez.wilfredo.reactive_stocktaking.service.contract;

import alvarez.wilfredo.reactive_stocktaking.datasource.entity.Product;
import alvarez.wilfredo.reactive_stocktaking.service.contract.to.ProductTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductBinder {
    ProductBinder PRODUCT_BINDER = Mappers.getMapper( ProductBinder.class );

    ProductTO bind(Product product);

    Product bind(ProductTO productTO);

    default Product bind(ProductTO productTO, Product product) {
        product.setAvailable(productTO.getAvailable());
        product.setPrice(productTO.getPrice());
        product.setCategory(productTO.getCategory());
        product.setItem(productTO.getItem());
        product.setDiscount(productTO.getDiscount());
        return product;
    }
}
