package com.example.andrey.socialhabitbuildingapp.Views;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.andrey.socialhabitbuildingapp.Models.DataContainer;
import com.example.andrey.socialhabitbuildingapp.Models.Habit;
import com.example.andrey.socialhabitbuildingapp.Models.Progress;
import com.example.andrey.socialhabitbuildingapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HabitsFragment extends Fragment {

    private RecyclerView habitList;
    private FloatingActionButton createHabit;

    public static HabitsFragment newInstance() {
        Bundle args = new Bundle();
        HabitsFragment fragment = new HabitsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public HabitsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_habits, container, false);

        createHabit = view.findViewById(R.id.create_habit);
        createHabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                View dialogView = inflater.inflate(R.layout.create_habit_dialog, null);
                final EditText habitName = dialogView.findViewById(R.id.name_habit);
                final EditText habitCategory = dialogView.findViewById(R.id.category);
                final EditText habitMU = dialogView.findViewById(R.id.measure_units);
                (new AlertDialog.Builder(getActivity())).setView(dialogView).setTitle("Create habit")
                        .setPositiveButton("Create", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DataContainer.getInstance().getHabits()
                                        .add(new Habit(habitName.getText().toString(),
                                                new ArrayList<Progress>(),
                                                habitCategory.getText().toString(),
                                                habitMU.getText().toString()));
                                habitList.getAdapter().notifyDataSetChanged();
                            }
                        }).setNegativeButton("Cancel", null).create().show();
            }
        });

        HabitAdapter habitAdapter = new HabitAdapter(DataContainer.getInstance().getHabits());

        habitAdapter.setOnClickHabitListener(new HabitAdapter.OnClickHabitListener() {
            @Override
            public void onClickHabit(Integer index) {
                //TODO normally!!!
                Intent intent = new Intent(getContext(), HabitActivity.class);
                intent.putExtra("index", index);
                startActivity(intent);
            }
        });

        habitList = view.findViewById(R.id.habit_list);
        habitList.setAdapter(habitAdapter);
        habitList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return view;
    }

}
