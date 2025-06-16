package alvarez.wilfredo.reactive_stocktaking.datasource.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Random;

@Table
public class Product implements Persistable<Long> {
    @Id
    private Long barcode;
    private String item;
    private String category;
    private Integer price;
    private Integer discount;
    private String available;

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public Long getId() {
        return this.barcode;
    }

    @Override
    public boolean isNew() {
        if (this.barcode == null) {
            Long ramdomId = new Random().nextLong(99999999);
            this.setBarcode(ramdomId);
            return true;
        }
        return false;
    }
}
