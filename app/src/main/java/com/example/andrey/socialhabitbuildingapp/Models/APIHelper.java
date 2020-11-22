package com.example.andrey.socialhabitbuildingapp.Models;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.Arrays;

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
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                DataContainer.getInstance().setCurrentUser(new User("ilya-kolomin@somemail.com", 1, "Ilya"));
                DataContainer.getInstance().setHabits(
                        new ArrayList<>(Arrays.asList(
                                new Habit("Habit1", new ArrayList<Progress>()),
                                new Habit("Habit2", new ArrayList<Progress>()),
                                new Habit("Habit3", new ArrayList<Progress>()),
                                new Habit("Habit4", new ArrayList<Progress>()),
                                new Habit("Habit5", new ArrayList<Progress>())
                        )));

//                    ApplicationAPI.TokenRequestBody request = new ApplicationAPI.TokenRequestBody();
//                    request.setUsername(login);
//                    request.setPassword(password);
//
//                    Token token = applicationAPI.requestJWTToken(request).execute().body();
//                    DataContainer.getInstance().setToken(token);
//
//                    User user = applicationAPI.getUserDataByToken("Bearer " + token.getAccess()).execute().body();
//                    DataContainer.getInstance().setCurrentUser(user);

//                    List<Habit> habits = applicationAPI.getHabits(user.getUsername()).execute().body().getHabits();
//                    DataContainer.getInstance().setHabits(habits);
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
//                ApplicationAPI.CreateHabitRequestBody request =
//                        new ApplicationAPI.CreateHabitRequestBody();
//                request.setHabitName(habitname);

//                applicationAPI.createHabit(DataContainer.getInstance()
//                        .getCurrentUser().getUsername(), request);

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

//                applicationAPI.createProgress(DataContainer.getInstance()
//                        .getCurrentUser().getUsername(), habitName, request);

                return null;
            }
        }.execute();
    }

    public interface LoginListener {
        void success();

        void failure();
    }

}
