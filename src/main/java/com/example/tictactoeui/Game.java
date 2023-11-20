package com.example.tictactoeui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application {

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args){
        launch();
    }
}
