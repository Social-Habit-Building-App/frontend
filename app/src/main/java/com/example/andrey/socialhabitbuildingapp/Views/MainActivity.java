package com.example.andrey.socialhabitbuildingapp.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.andrey.socialhabitbuildingapp.IMainView;
import com.example.andrey.socialhabitbuildingapp.Presenters.MainPresenter;
import com.example.andrey.socialhabitbuildingapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MvpAppCompatActivity implements IMainView {

    @InjectPresenter
    public MainPresenter presenter;

    @BindView(R.id.login)
    public EditText login;

    @BindView(R.id.password)
    public EditText password;

    @BindView(R.id.login_button)
    public Button btn;

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
                presenter.login("1", "1");
            }
        });
    }

    private void setProgress(boolean flag){
        if(flag){
            login.setVisibility(View.GONE);
            password.setVisibility(View.GONE);
            btn.setVisibility(View.GONE);
            progress.setVisibility(View.VISIBLE);
        }else{
            login.setVisibility(View.VISIBLE);
            password.setVisibility(View.VISIBLE);
            btn.setVisibility(View.VISIBLE);
            progress.setVisibility(View.GONE);
        }
    }

    @Override
    public void load() {
        setProgress(true);
    }

    @Override
    public void ok() {
        Intent intent = new Intent(getApplicationContext(), ApplicationActivity.class);
        startActivity(intent);
    }

    @Override
    public void error() {
        setProgress(false);
        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
    }
}
