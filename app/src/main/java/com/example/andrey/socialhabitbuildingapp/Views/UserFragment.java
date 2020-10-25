package com.example.andrey.socialhabitbuildingapp.Views;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrey.socialhabitbuildingapp.Models.Habit;
import com.example.andrey.socialhabitbuildingapp.R;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    private RecyclerView habitList;

    public static UserFragment newInstance() {
        Bundle args = new Bundle();
        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user, container, false);
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
        habitAdapter.setOnClickHabitListener(new HabitAdapter.OnClickHabitListener() {
            @Override
            public void onClickHabit(Habit habit) {
                //TODO normally!!!
                Intent intent = new Intent(getContext(), HabitActivity.class);
                startActivity(intent);
            }
        });
        habitList = v.findViewById(R.id.habit_list);
        habitList.setAdapter(habitAdapter);
        habitList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        return v;
    }

}
