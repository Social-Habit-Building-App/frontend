package com.example.andrey.socialhabitbuildingapp.Views;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andrey.socialhabitbuildingapp.Models.Group;
import com.example.andrey.socialhabitbuildingapp.Models.Message;
import com.example.andrey.socialhabitbuildingapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {

    private List<Group> data;
    private onGroupClickListener onGroupClickListener;

    public GroupAdapter(List<Group> data) {
        this.data = data;
        data.get(0).messages = new ArrayList<Message>(Arrays.asList(
                new Message("Ilya", "Hello!", "18:00"),
                new Message("Batman", "Hi!", "18:00"),
                new Message("Ilya", "Some example of long message which contains a lot of characters\nand some new line characters.", "18:00")));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_group, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        Group group = data.get(i);
        viewHolder.groupName.setText(group.name);
        viewHolder.groupDescription.setText(group.description);
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGroupClickListener.onClickGroup(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnGroupClickListener(GroupAdapter.onGroupClickListener onGroupClickListener) {
        this.onGroupClickListener = onGroupClickListener;
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

    interface onGroupClickListener {
        void onClickGroup(int index);
    }

}
