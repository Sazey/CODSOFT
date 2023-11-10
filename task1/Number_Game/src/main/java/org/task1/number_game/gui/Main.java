package org.task1.number_game.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.task1.number_game.NumberGame;
import org.task1.number_game.Player;

import java.io.IOException;

public class Main extends Application{
    public static boolean play = true;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("main_window.fxml"));
        Scene scene = new Scene(loader.load(),320,460);
        stage.setTitle("Number Guessing Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        NumberGame game = new NumberGame();
        Player player = new Player("Test Player");
        launch();

        while (play){
            game.guess(player);
        }
    }
}
