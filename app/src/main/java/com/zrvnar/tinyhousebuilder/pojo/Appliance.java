package com.zrvnar.tinyhousebuilder.pojo;

public class Appliance {
    private String name;
    private int kwh;
    private int quantity;

    public Appliance(String name, int kwh, int quantity) {
        this.name = name;
        this.kwh = kwh;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKwh() {
        return kwh;
    }

    public void setKwh(int kwh) {
        this.kwh = kwh;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return this.name + this.kwh +" " + this.quantity;
    }

}
