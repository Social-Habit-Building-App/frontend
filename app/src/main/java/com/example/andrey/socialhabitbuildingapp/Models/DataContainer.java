package com.example.andrey.socialhabitbuildingapp.Models;

import java.util.List;

public class DataContainer {
    private User currentUser;
    private Token token;
    private List<Habit> habits;
    private final static DataContainer instance = new DataContainer();

    public static DataContainer getInstance() {
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public List<Habit> getHabits() {
        return habits;
    }

    public void setHabits(List<Habit> habits) {
        this.habits = habits;
    }
}
