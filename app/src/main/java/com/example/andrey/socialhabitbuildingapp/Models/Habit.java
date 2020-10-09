package com.example.andrey.socialhabitbuildingapp.Models;

public class Habit {
    public String name;
    public String description;
    public int count1, count2;

    public Habit(String name, String description, int count1, int count2) {
        this.name = name;
        this.description = description;
        this.count1 = count1;
        this.count2 = count2;
    }
}
