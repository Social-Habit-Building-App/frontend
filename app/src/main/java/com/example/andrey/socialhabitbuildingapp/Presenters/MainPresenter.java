package com.example.andrey.socialhabitbuildingapp.Presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.andrey.socialhabitbuildingapp.Models.APIHelper;
import com.example.andrey.socialhabitbuildingapp.IMainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<IMainView> {


    public void login(String login, String password) {
        getViewState().load();
        APIHelper.login(new APIHelper.OnCallBack() {
            @Override
            public void callBack() {
                getViewState().ok();
            }

            @Override
            public void error() {
                getViewState().error();
            }
        });
    }

}
