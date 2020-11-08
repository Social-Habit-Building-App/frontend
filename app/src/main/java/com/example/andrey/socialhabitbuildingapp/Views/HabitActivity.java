package com.example.andrey.socialhabitbuildingapp.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.andrey.socialhabitbuildingapp.Models.APIHelper;
import com.example.andrey.socialhabitbuildingapp.Models.DataContainer;
import com.example.andrey.socialhabitbuildingapp.Models.Habit;
import com.example.andrey.socialhabitbuildingapp.R;

import butterknife.BindView;

public class HabitActivity extends AppCompatActivity {

    private Habit habit;

    @BindView(R.id.habit_text)
    private TextView habitText;

    @BindView(R.id.add_progress)
    private Button addProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit);

        Bundle bundle = getIntent().getExtras();

        int index = bundle.getInt("index");
        habit = DataContainer.getInstance().getHabits().get(index);

        final StringBuilder shownText = new StringBuilder(habit.getHabitName() + "\n\n\n");

        for (int i = 0; i < habit.getProgresses().size(); ++i) {
            shownText.append(habit.getProgresses().get(i).getPubDate()).append("\t\t\t").append(habit.getProgresses().get(i).getUnitsValue());
        }

        habitText.setText(shownText.toString());

        addProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                APIHelper.createProgress(habit.getHabitName(), 5);
            }
        });
    }
}
