package com.example.andrey.socialhabitbuildingapp.Views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.andrey.socialhabitbuildingapp.R;

public class ApplicationActivity extends AppCompatActivity {

    private UserFragment userFragment;
    private GroupsFragment groupsFragment;
    private HabitsFragment habitsFragment;

    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        userFragment = UserFragment.newInstance();
        groupsFragment = GroupsFragment.newInstance();
        habitsFragment = HabitsFragment.newInstance();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_application, habitsFragment).commit();
        initBottomNavigation();

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private void initBottomNavigation() {
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @SuppressLint("CommitTransaction")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_tasks:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_application, habitsFragment).commit();
                        return true;
                    case R.id.navigation_groups:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_application, groupsFragment).commit();
                        return true;
                    case R.id.navigation_profile:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame_application, userFragment).commit();
                        return true;
                }
                return false;
            }
        };
    }

}
