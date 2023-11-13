package org.task1.number_game.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.task1.number_game.Player;

import java.util.Random;
import java.util.Scanner;

public class InterfaceController {

    public InterfaceController(){
        curent_round  = new Label();
        number_to_guess  = new Text();
        attempts_left  = new Label();
        response = new Label();
        text_field = new TextField();
        submit_button = new Button();
        yes_button = new Button();
        no_button = new Button();
        player = new Player("Test Player");
        random = new Random();
        problems = new int[9];
        create_problems();
    }

    Player player = new Player("Test Player");
    private InterfaceController interfaceController;
    int[] problems;

    Random random;
    @FXML
    private Label curent_round;

    @FXML
    private Text number_to_guess;

    @FXML
    private Label attempts_left;

    @FXML
    private Label response;

    @FXML
    private TextField text_field;

    @FXML
    private Button submit_button;

    @FXML
    private Button yes_button;

    @FXML
    private Button no_button;

    int guess;

    @FXML
    public void setCurrentRound(int round) {
        this.curent_round.setText("Round " + round);
    }

    @FXML
    public void setNumberToGuess(int current_round) {
        this.number_to_guess.setText("I'm thinking of a number between 0 - " + "1" + String.format("%0" + current_round + "d", 0));
    }

    @FXML
    public void setAttemptsLeft(int attemps_left) {
        this.attempts_left.setText("Attempts Left: " + attemps_left);
    }

    @FXML
    public int submitAnswer(){
        try {
            guess = Integer.parseInt(text_field.getText());
            text_field.clear();
        }
        catch (NumberFormatException e){
            text_field.clear();
            throw new NumberFormatException();
        }
        return guess;
    }

    public void setResponse(String response) {
        this.response.setText(response);
    }

    public void continuePlay(){
        this.yes_button.setOnAction(event -> {
        });
    }

    public void stopPlay(){
        this.no_button.setOnAction(event -> {
        });
    }

    public void create_problems() {
        for (int i = 1; i <= 9; i++) {
            int range = Integer.parseInt("1" + String.format("%0" + i + "d", 0));

            problems[i - 1] = random.nextInt(range)+1;
//            System.out.println(problems[i-1]);
        }
    }

    public boolean canGuess(Player player){
        if(player.getAttempts_left() > 0){
            return true;
        }
        else {
            return false;
        }
    }

    public void roundStart(Player player){
        player.nextRound();
        int current_round = player.getCurrent_round();
        setCurrentRound(current_round);
        setNumberToGuess(current_round);
        setResponse("");
//        System.out.println("I'm thinking of a number between 0 " + "1" + String.format("%0" + current_round + "d", 0));
    }

    public void guess(){
        if(canGuess(player)) {
            try {
                player.enter_guess(submitAnswer());
            }
            catch (NumberFormatException e){
                setResponse("Enter a number");
                return;

            }
            int current_guess = player.getGuess();
            int current_round = player.getCurrent_round();
            int current_solution = problems[current_round - 1];
            if (current_guess == current_solution) {
                continueToPlay();
            } else if (current_guess > current_solution) {
                setResponse("Your guess is high");
                player.minusAttempt();
                setAttemptsLeft(player.getAttempts_left());
            } else if (current_guess < current_solution) {
                setResponse("Your guess is low");
                player.minusAttempt();
                setAttemptsLeft(player.getAttempts_left());
            }
        }else {
            restartGame();
        }

    }
    @FXML
    private VBox main_window;

    public void continueToPlay(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Continue Playing?",
                ButtonType.YES, ButtonType.NO);
        alert.setTitle("Correct!");
        if(alert.showAndWait().get() == ButtonType.YES){
            roundStart(player);
        }else {
            Stage stage = (Stage) main_window.getScene().getWindow();
            stage.close();
        }
    }

    public void restartGame(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Restart Game?",
                ButtonType.YES, ButtonType.NO);
        alert.setTitle("Restart Game?");
        if(alert.showAndWait().get() == ButtonType.YES){
            create_problems();
            player.restart();
            setCurrentRound(1);
            setNumberToGuess(player.getCurrent_round());
            setResponse("");
            text_field.clear();
            setAttemptsLeft(player.getAttempts_left());
        }else {
            Stage stage = (Stage) main_window.getScene().getWindow();
            stage.close();
        }
    }

}
