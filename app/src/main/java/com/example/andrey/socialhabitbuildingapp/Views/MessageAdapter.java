package com.example.andrey.socialhabitbuildingapp.Views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andrey.socialhabitbuildingapp.Models.Message;
import com.example.andrey.socialhabitbuildingapp.R;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private List<Message> messages;

    public MessageAdapter(List<Message> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MessageAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_message, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Message message = messages.get(i);
        viewHolder.author.setText(message.author);
        viewHolder.text.setText(message.text);
        viewHolder.date.setText(message.date);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView author;
        private TextView text;
        private TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            text = itemView.findViewById(R.id.text_message);
            date = itemView.findViewById(R.id.date);
        }
    }
}
