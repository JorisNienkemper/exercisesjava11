package com.infosupport.lab01.behavior.parameterization;

public class Apple {
    private String color;
    private int weight;

    public Apple(String color, int weight) {
        setColor(color);
        setWeight(weight);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
