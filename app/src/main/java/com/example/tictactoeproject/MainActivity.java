package com.example.tictactoeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnTopLeft;
    private Button btnTopMid;
    private Button btnTopRight;
    private Button btnMidLeft;
    private Button btnMid;
    private Button btnMidRight;
    private Button btnBottomLeft;
    private Button btnBottomMid;
    private Button btnBottomRight;
    private Button btnNewGame;
    private TextView playerTurnText;
    private TextView numTilesChosenText;
    private boolean playerXTurn = true;
    boolean isThereAWinner;
    private int xWins;
    private int oWins;
    private int numTilesChosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // References
        btnTopLeft = findViewById(R.id.btnTopLeft);
        btnTopMid = findViewById(R.id.btnTopMid);
        btnTopRight = findViewById(R.id.btnTopRight);
        btnMidLeft = findViewById(R.id.btnMidLeft);
        btnMid = findViewById(R.id.btnMid);
        btnMidRight = findViewById(R.id.btnMidRight);
        btnBottomLeft = findViewById(R.id.btnBottomLeft);
        btnBottomMid = findViewById(R.id.btnBottomMid);
        btnBottomRight = findViewById(R.id.btnBottomRight);
        btnNewGame = findViewById(R.id.btnNewGame);
        playerTurnText = findViewById(R.id.playerTurnText);
    }

    public void onClick(View v) {
        if (v == btnTopLeft && isTileEmpty(btnTopLeft)) {
            numTilesChosen++;
            changePlayerTurn();
            btnTopLeft.setText(printXO());
        }
        else if (v == btnTopMid && isTileEmpty(btnTopMid)) {
            numTilesChosen++;
            changePlayerTurn();
            btnTopMid.setText(printXO());
        }
        else if (v == btnTopRight && isTileEmpty(btnTopRight)) {
            numTilesChosen++;
            changePlayerTurn();
            btnTopRight.setText(printXO());
        }
        else if (v == btnMidLeft && isTileEmpty(btnMidLeft)) {
            numTilesChosen++;
            changePlayerTurn();
            btnMidLeft.setText(printXO());
        }
        else if (v == btnMid && isTileEmpty(btnMid)) {
            numTilesChosen++;
            changePlayerTurn();
            btnMid.setText(printXO());
        }
        else if (v == btnMidRight && isTileEmpty(btnMidRight)) {
            numTilesChosen++;
            changePlayerTurn();
            btnMidRight.setText(printXO());
        }
        else if (v == btnBottomLeft && isTileEmpty(btnBottomLeft)) {
            numTilesChosen++;
            changePlayerTurn();
            btnBottomLeft.setText(printXO());
        }
        else if (v == btnBottomMid && isTileEmpty(btnBottomMid)) {
            numTilesChosen++;
            changePlayerTurn();
            btnBottomMid.setText(printXO());
        }
        else if (v == btnBottomRight && isTileEmpty(btnBottomRight)) {
            numTilesChosen++;
            changePlayerTurn();
            btnBottomRight.setText(printXO());
        }
        else if (v == btnNewGame) {
            playerXTurn = false;
            clearTiles();
        }
        checkForWinner();
    }

    private void clearTiles() {
        numTilesChosen = 0;
        enableTiles();
        changePlayerTurn();
        btnTopLeft.setText("");
        btnTopLeft.setText("");
        btnTopMid.setText("");
        btnTopRight.setText("");
        btnMidLeft.setText("");
        btnMid.setText("");
        btnMidRight.setText("");
        btnBottomLeft.setText("");
        btnBottomMid.setText("");
        btnBottomRight.setText("");
    }

    private void disableTiles() {
        btnTopLeft.setEnabled(false);
        btnTopLeft.setEnabled(false);
        btnTopMid.setEnabled(false);
        btnTopRight.setEnabled(false);
        btnMidLeft.setEnabled(false);
        btnMid.setEnabled(false);
        btnMidRight.setEnabled(false);
        btnBottomLeft.setEnabled(false);
        btnBottomMid.setEnabled(false);
        btnBottomRight.setEnabled(false);
    }

    private void enableTiles() {
        btnTopLeft.setEnabled(true);
        btnTopLeft.setEnabled(true);
        btnTopMid.setEnabled(true);
        btnTopRight.setEnabled(true);
        btnMidLeft.setEnabled(true);
        btnMid.setEnabled(true);
        btnMidRight.setEnabled(true);
        btnBottomLeft.setEnabled(true);
        btnBottomMid.setEnabled(true);
        btnBottomRight.setEnabled(true);
    }

    private void checkForWinner() {
        if (numTilesChosen <= 9) {
            // TOP row
            if (btnTopLeft.getText() == btnTopMid.getText() && btnTopMid.getText() == btnTopRight.getText() && btnTopLeft.getText() != "") {
                isThereAWinner = true;
                updateWins();
                disableTiles();
            }   // MID row
            else if (btnMidLeft.getText() == btnMid.getText() && btnMid.getText() == btnMidRight.getText() && btnMidLeft.getText() != "") {
                isThereAWinner = true;
                updateWins();
                disableTiles();
            }   // BOTTOM row
            else if (btnBottomLeft.getText() == btnBottomMid.getText() && btnBottomMid.getText() == btnBottomRight.getText() && btnBottomLeft.getText() != "") {
                isThereAWinner = true;
                updateWins();
                disableTiles();
            }   // TOP LEFT to BOTTOM RIGHT diagonal
            else if (btnTopLeft.getText() == btnMid.getText() && btnMid.getText() == btnBottomRight.getText() && btnTopLeft.getText() != "") {
                isThereAWinner = true;
                updateWins();
                disableTiles();
            }   // BOTTOM LEFT to TOP RIGHT diagonal
            else if (btnBottomLeft.getText() == btnMid.getText() && btnMid.getText() == btnTopRight.getText() && btnTopRight.getText() != "") {
                isThereAWinner = true;
                updateWins();
                disableTiles();
            }   // LEFT column
            else if (btnTopLeft.getText() == btnMidLeft.getText() && btnMidLeft.getText() == btnBottomLeft.getText() && btnBottomLeft.getText() != "") {
                isThereAWinner = true;
                updateWins();
                disableTiles();
            }   // MID column
            else if (btnTopMid.getText() == btnMid.getText() && btnMid.getText() == btnBottomMid.getText() && btnBottomMid.getText() != "") {
                isThereAWinner = true;
                updateWins();
                disableTiles();
            }   // RIGHT column
            else if (btnTopRight.getText() == btnMidRight.getText() && btnMidRight.getText() == btnBottomRight.getText() && btnBottomRight.getText() != "") {
                isThereAWinner = true;
                updateWins();
                disableTiles();
            }
            else if (numTilesChosen == 9) {
                isThereAWinner = false;
                playerTurnText.setText("Tie Game");
                disableTiles();
            }
        }

        if (isThereAWinner) {
            isThereAWinner = false;
            if (printXO() == "X") {
                playerTurnText.setText("Player " + printXO() + " total wins: " + xWins);
            }
            else {
                playerTurnText.setText("Player " + printXO() + " total wins: " + oWins);
            }
        }
    }

    private void updateWins(){
        if (printXO().equals("X")){
            xWins++;
        }
        else {
            oWins++;
        }
    }

    private boolean isTileEmpty(Button btn) {
        if (btn.getText() == "") {
            return true;
        }
        return false;
    }

    private void changePlayerTurn() {
        if (playerXTurn) {
            playerTurnText.setText("Player O's Turn");
            playerXTurn = false;
        }
        else {
            playerTurnText.setText("Player X's Turn");
            playerXTurn = true;
        }
    }

    private String printXO() {
        if (playerXTurn) {
            return "O";
        }
        else {
            return "X";
        }
    }




}
