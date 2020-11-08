package com.example.andrey.socialhabitbuildingapp.Models;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIHelper {

    private static ApplicationAPI applicationAPI =
            (new Retrofit.Builder().baseUrl("https://scb-app.herokuapp.com")
                    .addConverterFactory(GsonConverterFactory.create()).build())
                    .create(ApplicationAPI.class);

    public static void login(final String login, final String password, final LoginListener loginListener) {
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    ApplicationAPI.TokenRequestBody request = new ApplicationAPI.TokenRequestBody();
                    request.setUsername(login);
                    request.setPassword(password);

                    Token token = applicationAPI.requestJWTToken(request).execute().body();
                    DataContainer.getInstance().setToken(token);

                    User user = applicationAPI.getUserDataByToken("Bearer " + token.getAccess()).execute().body();
                    DataContainer.getInstance().setCurrentUser(user);

                    List<Habit> habits = applicationAPI.getHabits(user.getUsername()).execute().body().getHabits();
                    DataContainer.getInstance().setHabits(habits);
                } catch (IOException e) {
                    e.printStackTrace();
                    loginListener.failure();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                loginListener.success();
            }
        }.execute();
    }

    public static void createHabit(final String habitname) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                ApplicationAPI.CreateHabitRequestBody request =
                        new ApplicationAPI.CreateHabitRequestBody();
                request.setHabitName(habitname);

                applicationAPI.createHabit(DataContainer.getInstance()
                        .getCurrentUser().getUsername(), request);

                return null;
            }
        }.execute();
    }

    public static void createProgress(final String habitName, final int units) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                ApplicationAPI.CreateProgressRequestBody request =
                        new ApplicationAPI.CreateProgressRequestBody();
                request.setUnitsValue(units);

                applicationAPI.createProgress(DataContainer.getInstance()
                        .getCurrentUser().getUsername(), habitName, request);

                return null;
            }
        }.execute();
    }

    public interface LoginListener {
        void success();

        void failure();
    }

}
