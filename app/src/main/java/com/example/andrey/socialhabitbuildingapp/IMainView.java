package com.example.andrey.socialhabitbuildingapp;

import com.arellomobile.mvp.MvpView;

public interface IMainView extends MvpView {
    void load();

    void ok();

    void error();
}
