package cord;

import category.Category;

import java.time.LocalDateTime;
import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private Double price;
    private Integer stock;
    private Integer remainingStock;
    private UUID categoryId;

    public Product(UUID id, String name, Double price, Integer stock, Integer remainingStock, UUID categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.remainingStock = remainingStock;
        this.categoryId = categoryId;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public Integer getStock() {
        return this.stock;
    }

    public Integer getRemainingStock() {
        return this.remainingStock;
    }

    public UUID getCategoryId() {
        return this.categoryId;
    }

    @Override
    public String toString() {
        return "cord.Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", remainingStock=" + remainingStock +
                ", categoryId=" + categoryId +
                '}';
    }

    public String getCategoryName() throws Exception {
        for (Category category : StaticConstants.CATEGORY_LIST) {
            if (getCategoryId().toString().equals(category.getId().toString())) {
                return category.getName();
            }

        }
        throw new Exception("Category is not found," + getName());

    }

    public LocalDateTime getDeliveryDueDate() throws Exception {
        for (Category category:StaticConstants.CATEGORY_LIST){
            if(category.getId().toString().equals(getCategoryId().toString())){
              return   category.findDeliveryDueDate();
            }

        }
        throw new Exception("Category not found," + getName());

    }

    public void setRemainingStock(Integer remainingStock) {
        this.remainingStock = remainingStock;
    }
}