package com.pixelhubllc.customadapterdiffrentarraysize;

public class Model {
    private String itemName;
    private String itemDescription;

    public Model(String name, String description) {
        this.itemName = name;
        this.itemDescription = description;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }
}
