package com.example.andrey.socialhabitbuildingapp.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.andrey.socialhabitbuildingapp.Models.APIHelper;
import com.example.andrey.socialhabitbuildingapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.login)
    public EditText login;

    @BindView(R.id.password)
    public EditText password;

    @BindView(R.id.login_button)
    public Button btn;

    @BindView(R.id.register_button)
    public Button register;

    @BindView(R.id.progressBar)
    public ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgress(true);
                APIHelper.login(login.getText().toString(), password.getText().toString(), new APIHelper.LoginListener() {
                    @Override
                    public void success() {
                        ok();
                    }

                    @Override
                    public void failure() {
                        error();
                    }
                });
            }
        });
    }

    private void setProgress(boolean flag){
        if(flag){
            login.setVisibility(View.GONE);
            password.setVisibility(View.GONE);
            btn.setVisibility(View.GONE);
            register.setVisibility(View.GONE);
            progress.setVisibility(View.VISIBLE);
        }else{
            register.setVisibility(View.VISIBLE);
            login.setVisibility(View.VISIBLE);
            password.setVisibility(View.VISIBLE);
            btn.setVisibility(View.VISIBLE);
            progress.setVisibility(View.GONE);
        }
    }

    public void load() {
        setProgress(true);
    }

    public void ok() {
        setProgress(false);
        Intent intent = new Intent(getApplicationContext(), ApplicationActivity.class);
        startActivity(intent);
    }

    public void error() {
        setProgress(false);
        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
    }
}
