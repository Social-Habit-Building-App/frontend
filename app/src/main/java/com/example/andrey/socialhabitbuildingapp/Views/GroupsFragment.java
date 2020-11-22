package com.example.andrey.socialhabitbuildingapp.Views;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrey.socialhabitbuildingapp.Models.DataContainer;
import com.example.andrey.socialhabitbuildingapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroupsFragment extends Fragment {


    private RecyclerView groupList;

    public static GroupsFragment newInstance() {
        Bundle args = new Bundle();
        GroupsFragment fragment = new GroupsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public GroupsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_groups, container, false);
        GroupAdapter groupAdapter = new GroupAdapter(DataContainer.getInstance().getGroups());
        groupAdapter.setOnGroupClickListener(new GroupAdapter.onGroupClickListener() {
            @Override
            public void onClickGroup(int index) {
                Intent intent = new Intent(getContext(), GroupActivity.class);
                intent.putExtra("index", index);
                startActivity(intent);
            }
        });
        groupList = v.findViewById(R.id.group_list);
        groupList.setAdapter(groupAdapter);
        groupList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        return v;
    }

}
