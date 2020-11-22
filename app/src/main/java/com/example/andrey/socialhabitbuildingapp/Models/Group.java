package com.example.andrey.socialhabitbuildingapp.Models;

import java.util.ArrayList;

public class Group {
    public String name;
    public String description;
    public ArrayList<Message> messages = new ArrayList<>();

    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
