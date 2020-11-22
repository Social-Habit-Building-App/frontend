package com.example.andrey.socialhabitbuildingapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApplicationAPI {
    @GET("/auth/users/me")
    Call<User> getUserDataByToken(@Header("Authorization") String token);

    @POST("/auth/jwt/create/")
    Call<Token> requestJWTToken(@Body TokenRequestBody request);

    @POST("/auth/users/")
    Call<ResponseForRegister> registerNewUser(@Body RegistrationRequestBody request);

    @GET("/api/users/{name}")
    Call<HabitsResponce> getHabits(@Path("name") String username);

//    @GET("/api/users/{name}/habits/{habitname}")
//    Call<ProgressesResponce> getProgress(@Path("name") String username,
//                                         @Path("habitname") String habitname);

    @POST("/api/users/habbits/habbit/create")
    Call<Object> createHabit(@Body CreateHabitRequestBody request);

//    @POST("/api/users/{name}/habits/{habitname}")
//    Call<Object> createProgress(@Path("name") String username, @Path("habitname") String habitname,
//                                @Body CreateProgressRequestBody request);

    class CreateHabitRequestBody {

        @SerializedName("user")
        @Expose
        private Integer user;

        @SerializedName("habit_name")
        @Expose
        private String habitName;

        public CreateHabitRequestBody(Integer user, String habitName) {
            this.user = user;
            this.habitName = habitName;
        }

        public String getHabitName() {
            return habitName;
        }

        public void setHabitName(String habitName) {
            this.habitName = habitName;
        }
    }

    class CreateProgressRequestBody {

        @SerializedName("units_value")
        @Expose
        private Integer unitsValue;

        public Integer getUnitsValue() {
            return unitsValue;
        }

        public void setUnitsValue(Integer unitsValue) {
            this.unitsValue = unitsValue;
        }
    }

    class ProgressesResponce {
        @SerializedName("habit_name")
        @Expose
        private String habitName;
        @SerializedName("progresses")
        @Expose
        private List<Progress> progresses = null;

        public String getHabitName() {
            return habitName;
        }

        public void setHabitName(String habitName) {
            this.habitName = habitName;
        }

        public List<Progress> getProgresses() {
            return progresses;
        }

        public void setProgresses(List<Progress> progresses) {
            this.progresses = progresses;
        }

    }

    class HabitsResponce {
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("habits")
        @Expose
        private List<Habit> habits = null;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public List<Habit> getHabits() {
            return habits;
        }

        public void setHabits(List<Habit> habits) {
            this.habits = habits;
        }
    }

    class RegistrationRequestBody {
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("location")
        @Expose
        private String location;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }

    class ResponseForRegister {

        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("id")
        @Expose
        private Integer id;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    class TokenRequestBody {

        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("password")
        @Expose
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }


}
