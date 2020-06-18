package com.example.yasin.tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int round_count;
    private boolean turnX = true;
    private Button[][] buttons = new Button[3][3];
    private TextView userXPoint;
    private TextView userOPoint;

    private User userX = new User("X");
    private User userO = new User("O");
    private WinnerController winnerController = new WinnerController(buttons);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int resourceID = getResources().getIdentifier("button_" + i + j, "id", getPackageName());
                buttons[i][j] = findViewById(resourceID);
            }
        }
        userXPoint = findViewById(R.id.userXPoints);
        userOPoint = findViewById(R.id.userOPoints);

        userXPoint.setText("0");
        userOPoint.setText("0");
    }

    public boolean button_onclick(View view) {

        Button button = findViewById(view.getId());
        button.setEnabled(false);
        if (turnX) {
            userX.makeAMove(button);
            turnX = false;
            if (winnerController.isWinner(userX)) {
                userX.incrementPoints();
                userXPoint.setText(String.format("%d", userX.getPoints()));
                showWinner(userX);
                resetGame();
                return false;
            }
        } else {
            userO.makeAMove(button);
            turnX = true;
            if (winnerController.isWinner(userO)) {
                userO.incrementPoints();
                userOPoint.setText(String.format("%d", userO.getPoints()));
                showWinner(userO);
                resetGame();
                return false;

            }

        }
        if (round_count++ == 8 && !winnerController.isWinner(userX) && !winnerController.isWinner((userO))) {
            resetGame();
            showDraw();
        }
        return true;
    }

    public void resetOnclick(View view) {
        resetGame();
    }

    public void resetGame() {
        round_count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
            turnX = true;
        }
    }

    public void showWinner(User user) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("TicTacToe");
        builder.setMessage(user.getMyLetter() + " WON!!!");
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    public void showDraw() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("TicTacToe");
        builder.setMessage("DRAW");
        builder.setPositiveButton("OK", null);
        builder.show();
    }

}
