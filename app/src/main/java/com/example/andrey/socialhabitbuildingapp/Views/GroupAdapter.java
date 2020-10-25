package com.example.andrey.socialhabitbuildingapp.Views;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andrey.socialhabitbuildingapp.Models.Group;
import com.example.andrey.socialhabitbuildingapp.R;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {

    private List<Group> data;

    public GroupAdapter(List<Group> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_group, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Group group = data.get(i);
        viewHolder.groupName.setText(group.name);
        viewHolder.groupDescription.setText(group.description);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private TextView groupName;
        //        private TextView habitCount;
        private TextView groupDescription;

        @SuppressLint("CutPasteId")
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            groupName = view.findViewById(R.id.name_group);
            groupDescription = view.findViewById(R.id.group_description);
        }
    }

}
