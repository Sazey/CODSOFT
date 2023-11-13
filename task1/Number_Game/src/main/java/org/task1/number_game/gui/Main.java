package org.task1.number_game.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        stage.setResizable(false);
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/main_window.fxml"));
        Scene scene = new Scene(loader.load(),320,350);
        stage.setTitle("Number Guessing Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
