package com.example.andrey.socialhabitbuildingapp.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrey.socialhabitbuildingapp.Models.Group;
import com.example.andrey.socialhabitbuildingapp.Models.Habit;
import com.example.andrey.socialhabitbuildingapp.R;

import java.util.Arrays;

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
        GroupAdapter habitAdapter = new GroupAdapter(Arrays.asList(
                new Group("Group 1", "Description for group 1"),
                new Group("Group 2", "Description for group 2"),
                new Group("Group 3", "Description for group 3")
        ));
        groupList = v.findViewById(R.id.group_list);
        groupList.setAdapter(habitAdapter);
        groupList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        return v;
    }

}
