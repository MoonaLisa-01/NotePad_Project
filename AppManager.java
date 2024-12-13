package com.noteapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppManager {
    public Scene getLoginScene(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/login.fxml"));
            return new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Scene getMainScene(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/main.fxml"));
            return new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
