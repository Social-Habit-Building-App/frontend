package com.example.andrey.socialhabitbuildingapp.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.andrey.socialhabitbuildingapp.Models.DataContainer;
import com.example.andrey.socialhabitbuildingapp.Models.Group;
import com.example.andrey.socialhabitbuildingapp.R;

public class GroupActivity extends AppCompatActivity {

    private Group group;
    private RecyclerView messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        Bundle bundle = getIntent().getExtras();

        int index = bundle.getInt("index");
        group = DataContainer.getInstance().getGroups().get(index);

        messageList = findViewById(R.id.messages);
        MessageAdapter adapter = new MessageAdapter(group.messages);
        messageList.setAdapter(adapter);
        messageList.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }
}
