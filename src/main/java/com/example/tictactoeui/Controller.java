package com.example.tictactoeui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    Label winnerLabel;
    @FXML
    Button button1;
    @FXML
    Button button2;
    @FXML
    Button button3;
    @FXML
    Button button4;
    @FXML
    Button button5;
    @FXML
    Button button6;
    @FXML
    Button button7;
    @FXML
    Button button8;
    @FXML
    Button button9;

    @FXML
    Button restartButton;

    ArrayList<Button> buttons;
    int playerTurn = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));
        buttons.forEach(button -> {
            setupButtons(button);
            button.setFocusTraversable(false);
        });
    }

    public void setupButtons(Button button){

        button.setOnMouseClicked(MouseEvent -> {
            if (!checkIfGameOver()){
                setPlayerSymbol(button);
                button.setDisable(true);
            }
            checkIfGameOver();
        });
    }

    public void setPlayerSymbol(Button button){
        if (playerTurn % 2 == 0){
            button.setText("X");
            button.setStyle("-fx-text-fill: #ff0000");
            playerTurn ++;
        } else {
            button.setText("O");
            button.setStyle("-fx-text-fill: #0000ff");
            playerTurn = 0;
        }
    }

    public void restart(ActionEvent event){
        buttons.forEach(this::restartButton);
        playerTurn = 0;
    }

    public void restartButton(Button button){
        button.setDisable(false);
        button.setText("");
        winnerLabel.setText("Tic-Tac-Toe");
        winnerLabel.setStyle("-fx-text-fill: black");
    }

    public boolean checkIfGameOver(){
        for (int i = 0; i < 8; i++) {
            String line = switch (i){
                case 0 -> button1.getText() + button2.getText() + button3.getText();
                case 1 -> button4.getText() + button5.getText() + button6.getText();
                case 2 -> button7.getText() + button8.getText() + button9.getText();
                case 3 -> button1.getText() + button5.getText() + button9.getText();
                case 4 -> button3.getText() + button5.getText() + button7.getText();
                case 5 -> button1.getText() + button4.getText() + button7.getText();
                case 6 -> button2.getText() + button5.getText() + button8.getText();
                case 7 -> button3.getText() + button6.getText() + button9.getText();
                default -> null;
            };

            if (line.equals("XXX")){
                winnerLabel.setText("X WINS !");
                winnerLabel.setStyle("-fx-text-fill: #F34447");
                return true;
            } else if (line.equals("OOO")) {
                winnerLabel.setText("O WINS !");
                winnerLabel.setStyle("-fx-text-fill: #4F7FEC");
                return true;
            }
        }
        return false;
    }

}
