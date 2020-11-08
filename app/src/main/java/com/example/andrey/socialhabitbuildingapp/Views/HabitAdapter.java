package com.example.andrey.socialhabitbuildingapp.Views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andrey.socialhabitbuildingapp.Models.Habit;
import com.example.andrey.socialhabitbuildingapp.R;

import java.util.List;

public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.ViewHolder> {

    private List<Habit> data;
    private OnClickHabitListener onClickHabitListener;


    public HabitAdapter(List<Habit> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_habit, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder,
                                 @SuppressLint("RecyclerView") final int i) {
        final Habit habit = data.get(i);
        viewHolder.view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onClickHabitListener.onClickHabit(i);
            }
        });
        viewHolder.habitName.setText(habit.getHabitName());
//        viewHolder.habitDescription.setText(habit.description);
//        viewHolder.habitCount.setText(habit.count1 + "/" + habit.count2);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnClickHabitListener(OnClickHabitListener onClickHabitListener) {
        this.onClickHabitListener = onClickHabitListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private TextView habitName;
//        private TextView habitCount;
//        private TextView habitDescription;

        @SuppressLint("CutPasteId")
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            habitName = view.findViewById(R.id.name_habit);
//            habitCount = view.findViewById(R.id.count);
//            habitDescription = view.findViewById(R.id.habit_description);
        }
    }

    interface OnClickHabitListener {
        void onClickHabit(Integer index);
    }

}
