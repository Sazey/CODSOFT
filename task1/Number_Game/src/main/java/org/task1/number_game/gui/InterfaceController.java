package org.task1.number_game.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.task1.number_game.Player;

import java.util.Random;
import java.util.Scanner;

public class InterfaceController {

    public InterfaceController(){
        curent_round  = new Label();
        number_to_guess  = new Label();
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
    private Label number_to_guess;

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
        this.number_to_guess.setText("I'm thinking of a number between 0 " + "1" + String.format("%0" + current_round + "d", 0));
    }

    @FXML
    public void setAttemptsLeft(int attemps_left) {
        this.attempts_left.setText("Attempts Left: " + attemps_left);
    }

    @FXML
    public int submitAnswer(){
        System.out.println("here");
        guess = Integer.parseInt(text_field.getText());
        text_field.clear();
        System.out.println("Guess: " + guess);
        return guess;
    }

    public void setResponse(String response) {
        this.response.setText(response);
    }

    public void continuePlay(){
        this.yes_button.setOnAction(event -> {
            Main.play = true;
        });
    }

    public void stopPlay(){
        this.no_button.setOnAction(event -> {
            Main.play = false;
        });
    }

    public void create_problems() {
        for (int i = 1; i <= 9; i++) {
            int range = Integer.parseInt("1" + String.format("%0" + i + "d", 0)) + 1;

            problems[i - 1] = random.nextInt(range);
//            System.out.println(problems[i-1]);
        }
    }

    public boolean canGuess(Player player){
        if(player.getAttempts_left() > 0){
            return true;
        }
        else {
            Main.play = false;
            return false;
        }
    }

    public void roundStart(Player player){
        int current_round = player.getCurrent_round();
        setCurrentRound(current_round);
        setNumberToGuess(current_round);
//        System.out.println("I'm thinking of a number between 0 " + "1" + String.format("%0" + current_round + "d", 0));
    }

    public void guess(){
        if(canGuess(player)) {
            player.enter_guess(submitAnswer());
            int current_guess = player.getGuess();
            int current_round = player.getCurrent_round();
            int current_solution = problems[current_round - 1];
            if (current_guess == current_solution) {
                setResponse("Correct! the answer was: " + current_solution);
                System.out.println("Continue playing? (y/n)");


                if (true) {
                    player.nextRound();
                    roundStart(player);
                } else {
                    Main.play = false;
                }
            } else if (current_guess > current_solution) {
                setResponse("Your guess is high");
                player.minusAttempt();
                setAttemptsLeft(player.getAttempts_left());
            } else if (current_guess < current_solution) {
                setResponse("Your guess is low");
                player.minusAttempt();
                setAttemptsLeft(player.getAttempts_left());
            }
        }

    }

    public void continueToPlay(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    }

}
