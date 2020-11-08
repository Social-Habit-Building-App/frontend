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
}
