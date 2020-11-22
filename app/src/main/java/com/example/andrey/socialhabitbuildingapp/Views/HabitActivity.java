package com.example.andrey.socialhabitbuildingapp.Views;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.andrey.socialhabitbuildingapp.Models.DataContainer;
import com.example.andrey.socialhabitbuildingapp.Models.Habit;
import com.example.andrey.socialhabitbuildingapp.Models.Progress;
import com.example.andrey.socialhabitbuildingapp.R;

public class HabitActivity extends AppCompatActivity {

    private Habit habit;

    //    @BindView(R.id.habit_text)
    private TextView habitText;
    private TextView category;
    private TextView progressText;

//    @BindView(R.id.add_progress)
//    public Button addProgress;

    private FloatingActionButton addProgress;

    private void refreshProgress() {
        String text = "";
        for (Progress p :
                habit.getProgresses()) {
            text += p.getUnitsValue() + " " + habit.getMeasureUnits() + " on " + p.getPubDate() + "\n";
        }
        progressText.setText(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit);

        Bundle bundle = getIntent().getExtras();

        int index = bundle.getInt("index");
        habit = DataContainer.getInstance().getHabits().get(index);

        habitText = findViewById(R.id.name_habit);
        category = findViewById(R.id.category);
        progressText = findViewById(R.id.progress_text);

        habitText.setText("Habit: " + habit.getHabitName());
        category.setText("Category: " + habit.getCategory());
        refreshProgress();

        addProgress = findViewById(R.id.add_progress);
        addProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                @SuppressLint("InflateParams") View dialogView = inflater.inflate(R.layout.add_progress_dialog, null);
                final EditText date = dialogView.findViewById(R.id.date);
                final EditText units = dialogView.findViewById(R.id.units);
                units.setHint("Enter progress in " + habit.getMeasureUnits());
                (new AlertDialog.Builder(HabitActivity.this)).setView(dialogView).setTitle("Add progress")
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                habit.getProgresses().add(
                                        new Progress(
                                                Integer.valueOf(String.valueOf(units.getText())),
                                                String.valueOf(date.getText())));
                                refreshProgress();
//                                habitList.getAdapter().notifyDataSetChanged();
                            }
                        }).setNegativeButton("Cancel", null).create().show();
            }
        });

//        final StringBuilder shownText = new StringBuilder(habit.getHabitName() + "\n\n\n");
//
//        for (int i = 0; i < habit.getProgresses().size(); ++i) {
//            shownText.append(habit.getProgresses().get(i).getPubDate()).append("\t\t\t").append(habit.getProgresses().get(i).getUnitsValue());
//        }

//        habitText = findViewById(R.id.habit_text);
//        habitText.setText(shownText.toString());

//        addProgress.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TODO
//                APIHelper.createProgress(habit.getHabitName(), 5);
//            }
//        });
    }
}
