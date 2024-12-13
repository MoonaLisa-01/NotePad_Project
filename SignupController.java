package com.noteapp;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignupController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private FileHandler fileHandler;

    /**
     * Sets the FileHandler instance for file operations.
     *
     * @param fileHandler the FileHandler instance
     */
    public void setFileHandler(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }
 

    /**
     * Handles the signup action when the signup button is clicked.
     */
    @FXML
    private void handleSignup() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        final AppManager appManager = new AppManager();

        
      //  Validate input
        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter both a username and a password.");
            return;
        }

        // Save user credentials to file
        try {
            if (fileHandler == null) {
                throw new IllegalStateException("FileHandler is not set. Please set it before using this controller.");
            }

            // Check if the username already exists
            if (fileHandler.doesUserExist(username)) {
                showAlert(Alert.AlertType.ERROR, "Signup Failed", "The username already exists. Please choose a different one.");
                return;
            }

            // Save credentials
            fileHandler.saveUser(username, password);
            showAlert(Alert.AlertType.INFORMATION, "Signup Successful", "You have successfully signed up!");
            
            // Clear fields after successful signup
            usernameField.clear();
            passwordField.clear();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while signing up. Please try again.");
        }
    }

    /**
     * Displays an alert dialog with the given type, title, and content.
     *
     * @param alertType the type of alert
     * @param title     the title of the alert
     * @param content   the content of the alert
     */
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}


// package com.noteapp;

// import javafx.fxml.FXML;
// import javafx.scene.Scene;
// import javafx.scene.control.Alert;
// import javafx.scene.control.PasswordField;
// import javafx.scene.control.TextField;

// public class SignupController {
//     @FXML
//     private TextField usernameField;

//     @FXML
//     private PasswordField passwordField;

//     private FileHandler fileHandler;

//     /**
//      * Sets the FileHandler instance for file operations.
//      *
//      * @param fileHandler the FileHandler instance
//      */
//     public void setFileHandler(FileHandler fileHandler) {
//         this.fileHandler = fileHandler;
//     }

//     /**
//      * Handles the signup action when the signup button is clicked.
//      */
//     @FXML
//     private void handleSignup() {
//         String username = usernameField.getText().trim();
//         String password = passwordField.getText().trim();

//         // Validate input
//         if (username.isEmpty() || password.isEmpty()) {
//             showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter both a username and a password.");
//             return;
//         }

//         // Save user credentials to file
//         try {
//             if (fileHandler == null) {
//                 throw new IllegalStateException("FileHandler is not set. Please set it before using this controller.");
//             }

//             // Check if the username already exists
//             if (fileHandler.doesUserExist(username)) {
//                 // If the username exists, allow updating the password
//                 fileHandler.updateUserPassword(username, password);
//                 showAlert(Alert.AlertType.INFORMATION, "Password Updated", "Your password has been successfully updated!");
//             } else {
//                 // Save new user credentials
//                 fileHandler.saveUser(username, password);
//                 showAlert(Alert.AlertType.INFORMATION, "Signup Successful", "You have successfully signed up!");
//             }

//             // Clear fields after successful signup
//             usernameField.clear();
//             passwordField.clear();
//         } catch (Exception e) {
//             e.printStackTrace();
//             showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while signing up. Please try again.");
//         }
//     }

//     /**
//      * Displays an alert dialog with the given type, title, and content.
//      *
//      * @param alertType the type of alert
//      * @param title     the title of the alert
//      * @param content   the content of the alert
//      */
//     private void showAlert(Alert.AlertType alertType, String title, String content) {
//         Alert alert = new Alert(alertType);
//         alert.setTitle(title);
//         alert.setHeaderText(null);
//         alert.setContentText(content);
//         alert.showAndWait();
//     }
// }
