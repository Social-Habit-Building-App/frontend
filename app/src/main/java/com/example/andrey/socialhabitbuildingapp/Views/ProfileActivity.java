package com.example.andrey.socialhabitbuildingapp.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.andrey.socialhabitbuildingapp.Models.Habit;
import com.example.andrey.socialhabitbuildingapp.R;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;

public class ProfileActivity extends AppCompatActivity {

//    @BindView(R.id.list)
    public RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        HabitAdapter habitAdapter = new HabitAdapter(Arrays.asList(
                new Habit("Push up", "Standard pushups", 10, 20),
                new Habit("Push down", "Standard pushdonws", 10, 20),
                new Habit("Habit 1", "Description for habit 1", 10, 20),
                new Habit("Habit 2", "Description for habit 2", 10, 20),
                new Habit("Habit 3", "Description for habit 3", 10, 20),
                new Habit("Habit 4", "Description for habit 4", 10, 20),
                new Habit("Habit 5", "Description for habit 5", 10, 20),
                new Habit("Habit 6", "Description for habit 6", 10, 20),
                new Habit("Habit 7", "Description for habit 7", 10, 20),
                new Habit("Habit 8", "Description for habit 8", 10, 20),
                new Habit("Habit 9", "Description for habit 9", 10, 20),
                new Habit("Sits", "Standard sits", 20, 40)));
        list = findViewById(R.id.list);
        list.setAdapter(habitAdapter);
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
