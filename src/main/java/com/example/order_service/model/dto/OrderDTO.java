package com.example.order_service.model.dto;

public class OrderDTO {
    private Long id;
    private String name;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return ", name='" + name + '\'' +
                ", itemName='" + itemName + '\'';
    }
}
