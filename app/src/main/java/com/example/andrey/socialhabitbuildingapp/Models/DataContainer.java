package com.example.andrey.socialhabitbuildingapp.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataContainer {
    private User currentUser;
    private Token token;
    private List<Habit> habits = new ArrayList<>();
    private ArrayList<Group> groups = new ArrayList<>(
            Arrays.asList(
                    new Group("Group 1", "Description for group 1"),
                    new Group("Group 2", "Description for group 2"),
                    new Group("Group 3", "Description for group 3")
            )
    );
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

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }
}
