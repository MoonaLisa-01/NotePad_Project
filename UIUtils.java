package com.noteapp;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UIUtils {

    /**
     * Display an alert dialog to the user.
     *
     * @param type    The type of the alert (INFO, WARNING, ERROR).
     * @param title   The title of the alert window.
     * @param message The message content of the alert.
     */
    public static void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Apply a custom CSS stylesheet to the scene.
     *
     * @param scene      The current scene.
     * @param stylesheet Path to the CSS file.
     */
    public static void applyStylesheet(javafx.scene.Scene scene, String stylesheet) {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(stylesheet);
    }
}
