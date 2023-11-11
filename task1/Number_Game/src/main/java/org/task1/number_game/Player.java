package org.task1.number_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    String player_name;
    int attemps_left;
    int current_round;

    int current_guess;

    int player_score;

    List<Integer> guesses = new ArrayList<>();

    public Player(String player_name){
        this.player_name = player_name;
        attemps_left = 9;
        current_round = 1;
        player_score = 0;
        current_guess = 0;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public int getAttempts_left() {
        return attemps_left;
    }

    public int getCurrent_round() {
        return current_round;
    }

    public void minusAttempt(){
        attemps_left--;
    }

    public void nextRound(){
        current_round++;
    }

    public void addGuess(int guess){
        guesses.add(guess);
    }

    public void enter_guess(int current_guess){
        this.current_guess = current_guess;
        guesses.add(current_guess);
    }

    public int getGuess(){
        return current_guess;
    }

    public void restart() {
        this.attemps_left = 9;
        this.guesses.clear();
        this.current_round = 1;
        this.current_guess = 0;
    }
}
