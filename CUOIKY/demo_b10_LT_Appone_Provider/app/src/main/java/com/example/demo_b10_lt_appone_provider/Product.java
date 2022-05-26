package com.example.demo_b10_lt_appone_provider;

public class Product {
    private int id;
    private String name;
    private String unit;
    private String madeIn;

    public Product() {
    }

    public Product(int id, String name, String unit, String madeIn) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.madeIn = madeIn;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", madeIn='" + madeIn + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }
}
