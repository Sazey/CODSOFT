package org.task1.number_game.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InterfaceController {
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
        guess = Integer.parseInt(text_field.getText());
        return guess;
    }

    public void setResponse(String response) {
        this.response.setText(response);
    }
}
