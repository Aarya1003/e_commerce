package com.ecommerce.sandhyaLand.request;

public class AddItemRequest {
    private Long productId;
    private String size;
    private int quantity;
    private Integer price;

    public AddItemRequest() {
    }

    public AddItemRequest(Integer price, Long productId, int quantity, String size) {
        this.price = price;
        this.productId = productId;
        this.quantity = quantity;
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
