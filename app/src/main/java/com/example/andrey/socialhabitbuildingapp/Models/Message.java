package com.example.andrey.socialhabitbuildingapp.Models;

public class Message {
    public String author;
    public String text;
    public String date = "18:00";

    public Message(String author, String text, String date) {
        this.author = author;
        this.text = text;
        this.date = date;
    }
}
