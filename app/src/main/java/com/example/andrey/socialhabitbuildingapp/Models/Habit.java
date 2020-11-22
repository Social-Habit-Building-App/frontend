package com.example.andrey.socialhabitbuildingapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Habit {
    @SerializedName("habit_name")
    @Expose
    private String habitName;
    @SerializedName("progresses")
    @Expose
    private List<Progress> progresses = null;

    private String category = "Sport";
    private String measureUnits = "times";

    public Habit(String habitName, List<Progress> progresses, String category, String measureUnits) {
        this.habitName = habitName;
        this.progresses = progresses;
        this.category = category;
        this.measureUnits = measureUnits;
    }

    public Habit(String habitName, List<Progress> progresses) {
        this.habitName = habitName;
        this.progresses = progresses;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public List<Progress> getProgresses() {
        return progresses;
    }

    public void setProgresses(List<Progress> progresses) {
        this.progresses = progresses;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMeasureUnits() {
        return measureUnits;
    }

    public void setMeasureUnits(String measureUnits) {
        this.measureUnits = measureUnits;
    }
}
