package com.example.drink_en_eet;

public class Food {
    private String name;
    private int calories;
    private int protein;
    private int carbs;
    private int fat;

    public Food(String food, int calories, int protein, int carbs, int fat){
        this.name = food;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getFat() {
        return fat;
    }
}
