package com.example.order_service.model.request;

public class OrderRequest {
    private Long id;
    private String name;
    private Long itemId;
    private String itemName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'';
    }
}
