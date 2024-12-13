
package com.noteapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class Main extends Application {
    private final FileHandler fileHandler = new FileHandler();
    private final AppManager appManager = new AppManager();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        showWelcomePage(stage);
    }

    private void showWelcomePage(Stage stage) {
        Image backgroundImg = new Image("img.jpg");
        ImageView backgroundView = new ImageView(backgroundImg);
        backgroundView.fitWidthProperty().bind(stage.widthProperty());
        backgroundView.fitHeightProperty().bind(stage.heightProperty());

        Label label = new Label("WELCOME TO \n NOTEHUB");
        label.setFont(new Font("Britannic Bold", 60));
        label.setTextFill(Color.SKYBLUE);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.DARKBLUE);
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);
        label.setEffect(dropShadow);

        label.layoutXProperty().bind(stage.widthProperty().subtract(label.widthProperty()).divide(2));
        label.layoutYProperty().bind(stage.heightProperty().subtract(label.heightProperty()).divide(2));

        Button nextButton = new Button("Next");
        nextButton.setFont(new Font("Britannic Bold", 16));
        nextButton.setStyle("-fx-background-color: darkblue; -fx-text-fill: skyblue; -fx-padding: 10px 20px;");
        
        nextButton.setOnMouseEntered(e -> nextButton.setStyle("-fx-background-color: darkblue; -fx-text-fill: white; -fx-padding: 10px 20px;"));
        nextButton.setOnMouseExited(e -> nextButton.setStyle("-fx-background-color: darkblue; -fx-text-fill: skyblue; -fx-padding: 10px 20px;"));
        nextButton.setLayoutX(750);
        nextButton.setLayoutY(430);
        nextButton.setOnAction(e -> showLoginPage(stage));

        Pane root = new Pane();
        root.getChildren().addAll(backgroundView, label, nextButton);

        Scene scene = new Scene(root, 1000, 600); // Set initial window size
        stage.setTitle("WELCOME TO NOTEHUB");
        stage.setScene(scene);
        stage.show();
    }

    private void showLoginPage(Stage stage) {
        Image backgroundImg = new Image("img.jpg");
        ImageView backgroundView = new ImageView(backgroundImg);
        backgroundView.fitWidthProperty().bind(stage.widthProperty());
        backgroundView.fitHeightProperty().bind(stage.heightProperty());

      
        VBox root = new VBox(20); // Root layout with spacing between buttons
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.DARKBLUE);
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);

        Button loginButton = new Button("Login");
        loginButton.setFont(new Font("Britannic Bold", 16));
        loginButton.setStyle("-fx-background-color: darkblue; -fx-text-fill: skyblue; -fx-padding: 10px 20px;");
        loginButton.setOnMouseEntered(e -> loginButton.setStyle("-fx-background-color: darkblue; -fx-text-fill: white; -fx-padding: 10px 20px;"));
        loginButton.setOnMouseExited(e -> loginButton.setStyle("-fx-background-color: darkblue; -fx-text-fill: skyblue; -fx-padding: 10px 20px;"));
     
        Button signupButton = new Button("Signup");
        signupButton.setFont(new Font("Britannic Bold", 16));
        signupButton.setStyle("-fx-background-color: darkblue; -fx-text-fill: skyblue; -fx-padding: 10px 20px;");
        signupButton.setOnMouseEntered(e -> signupButton.setStyle("-fx-background-color: darkblue; -fx-text-fill: white; -fx-padding: 10px 20px;"));
        signupButton.setOnMouseExited(e -> signupButton.setStyle("-fx-background-color: darkblue; -fx-text-fill: skyblue; -fx-padding: 10px 20px;"));
     
        Button backButton = new Button("Back");
        backButton.setFont(new Font("Britannic Bold", 16));
        backButton.setStyle("-fx-background-color: darkblue; -fx-text-fill: skyblue; -fx-padding: 10px 20px;");
        backButton.setOnMouseEntered(e -> backButton.setStyle("-fx-background-color: darkblue; -fx-text-fill: white; -fx-padding: 10px 20px;"));
        backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: darkblue; -fx-text-fill: skyblue; -fx-padding: 10px 20px;"));

        backButton.setOnAction(e -> showWelcomePage(stage));
        loginButton.setOnAction(e -> showLoginForm(stage));
        signupButton.setOnAction(e -> showSignupForm(stage));
        
        root.getChildren().addAll(loginButton, signupButton,backButton);
        backButton.setEffect(dropShadow);
        signupButton.setEffect(dropShadow);
        loginButton.setEffect(dropShadow);
        root.setAlignment(Pos.CENTER);
        StackPane mainRoot = new StackPane();
        mainRoot.getChildren().addAll(backgroundView, root);
        Scene loginScene = new Scene(mainRoot,1000, 600);

        stage.setScene(loginScene);
        stage.show();
    }

    private void showLoginForm(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/login.fxml"));
            Scene loginFormScene = new Scene(loader.load(),1000,600);
            LoginController controller = loader.getController();
         //  controller.setFileHandler(fileHandler); // Pass the FileHandler to the controller
            stage.setScene(loginFormScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showSignupForm(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/signupForm.fxml"));
            Scene signupFormScene = new Scene(loader.load(),1000,600);
            SignupController controller = loader.getController();
            controller.setFileHandler(fileHandler); // Pass the FileHandler to the controller
            stage.setScene(signupFormScene);
          //  stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
