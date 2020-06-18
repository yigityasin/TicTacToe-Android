package com.example.yasin.tictactoe;

import android.widget.Button;

public abstract class AbstractUser {

    private int points;
    private String myLetter;

    public String getMyLetter() {
        return myLetter;
    }

    public AbstractUser(String myLetter) {
        this.myLetter = myLetter;
        this.points = 0;
    }

    public void setMyLetter(String myLetter) {
        this.myLetter = myLetter;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void incrementPoints() {
        points++;
    }

    public void makeAMove(Button button) {
    }


}
