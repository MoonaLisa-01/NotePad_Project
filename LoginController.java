// package com.noteapp;

// import javafx.fxml.FXML;
// import javafx.scene.control.Alert;
// import javafx.scene.control.Button;
// import javafx.scene.control.PasswordField;
// import javafx.scene.control.TextField;
// import javafx.stage.Stage;

// public class LoginController {
//     @FXML
//     private TextField usernameField;

//     @FXML
//     private PasswordField passwordField;

//     @FXML
//     private Button loginButton;

//     @FXML
//     private Button registerButton;

//     private final FileHandler fileHandler = new FileHandler();
//     private final EncryptionUtil encryptionUtil = new EncryptionUtil();

//      @FXML
//     public void initialize() {
//         loginButton.setOnAction(event -> handleLogin());
//         registerButton.setOnAction(event -> handleRegistration());
//     }

//     private void handleLogin() {
//         String username = usernameField.getText();
//         String password = passwordField.getText();
//         String encryptedPassword = encryptionUtil.encrypt(password);

//         if (fileHandler.verifyUser(username, encryptedPassword)) {
//             Stage stage = (Stage) loginButton.getScene().getWindow();
//             AppManager appManager = new AppManager();
//             stage.setScene(appManager.getMainScene(stage));
//         } else {
//             System.out.println("Login failed. Please check your credentials.");
//         }
//     }

//     private void handleRegistration() {
//         String username = usernameField.getText();
//         String password = passwordField.getText();
//         String encryptedPassword = encryptionUtil.encrypt(password);

//         if (fileHandler.saveUser(username, encryptedPassword)) {
//             System.out.println("Registration successful. Please log in.");
//         } else {
//             System.out.println("Registration failed. Username may already exist.");
//         }
//     }
// }


package com.noteapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    private final FileHandler fileHandler = new FileHandler();
    private final EncryptionUtil encryptionUtil = new EncryptionUtil();

    @FXML
    public void initialize() {
        loginButton.setOnAction(event -> handleLogin());
        registerButton.setOnAction(event -> handleRegistration());
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Check if username or password is empty
        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Login Failed", "Username or Password cannot be empty.", AlertType.WARNING);
            return;
        }

        String encryptedPassword = encryptionUtil.encrypt(password);

        if (fileHandler.verifyUser(username, encryptedPassword)) {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            AppManager appManager = new AppManager();
            stage.setScene(appManager.getMainScene(stage));
        } else {
            showAlert("Login Failed", "Invalid credentials. Please try again.", AlertType.ERROR);
        }
    }

    private void handleRegistration() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Check if username or password is empty
        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Registration Failed", "Username or Password cannot be empty.", AlertType.WARNING);
            return;
        }

        String encryptedPassword = encryptionUtil.encrypt(password);

        if (fileHandler.saveUser(username, encryptedPassword)) {
            showAlert("Registration Successful", "You can now log in with your credentials.", AlertType.INFORMATION);
        } else {
            showAlert("Registration Failed", "Username may already exist. Please try another.", AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
