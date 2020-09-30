package model;

import java.io.Serializable;

public class Product implements Serializable {

    private String productId;
    private String category;
    private String productName;
    private double price;
    private String description;
    private String image;

    public Product(String productId, String category, String productName, double price, String description, String image) {
        this.productId = productId;
        this.category = category;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.image = image;
    }


    @Override
    public String toString() {
        return "product{" +
                "productId='" + productId + '\'' +
                ", category='" + category + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
