package com.tracyvelasquezsite;

public class League{

    public String name;
    public String coords;
    public int price;

    public League(String name, String coords, int price) {
        this.name = name;
        this.coords = coords;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
