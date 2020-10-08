package com.example.andrey.socialhabitbuildingapp.Models;

import android.os.AsyncTask;

public class APIHelper {

    public interface OnCallBack {
        void callBack();
        void error();
    }

    public static void login(final OnCallBack callBack){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    callBack.error();
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                callBack.callBack();
            }
        }.execute();
    }

}
