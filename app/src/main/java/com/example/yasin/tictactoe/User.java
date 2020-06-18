package com.example.yasin.tictactoe;

import android.widget.Button;

public class User extends AbstractUser {

    public User(String myLetter) {
        super(myLetter);
    }

    @Override
    public void makeAMove(Button button) {
        button.setTextSize(32);
        button.setText(getMyLetter());
    }
}