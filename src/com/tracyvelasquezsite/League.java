package com.tracyvelasquezsite;

public class League{

    public String name;
    public String coords;
    public int radius;
    public int price;

    public League(String name, String coords, int radius, int price) {
        this.name = name;
        this.coords = coords;
        this.radius = radius;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoords() {
        return coords;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
