package com.example.yasin.tictactoe;

import android.widget.Button;

public class WinnerController {
    private Button[][] buttons;

    public WinnerController(Button[][] buttons) {
        this.buttons = buttons;
    }


    public boolean isWinner(User user) {
        String userLetter = user.getMyLetter();
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(userLetter) &&
                    buttons[i][1].getText().equals(userLetter) &&
                    buttons[i][2].getText().equals(userLetter)) {
                return true;
            } else if (buttons[0][i].getText().equals(userLetter) &&
                    buttons[1][i].getText().equals(userLetter) &&
                    buttons[2][i].getText().equals(userLetter)) {
                return true;
            }
        }
        if (buttons[0][0].getText().equals(userLetter) &&
                buttons[1][1].getText().equals(userLetter) &&
                buttons[2][2].getText().equals(userLetter)) {
            return true;
        } else if (buttons[0][2].getText().equals(userLetter) &&
                buttons[1][1].getText().equals(userLetter) &&
                buttons[2][0].getText().equals(userLetter)) {
            return true;
        }

        return false;


    }

}


