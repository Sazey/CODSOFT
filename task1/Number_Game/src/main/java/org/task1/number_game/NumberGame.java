package org.task1.number_game;

import org.task1.number_game.gui.InterfaceController;
import org.task1.number_game.gui.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public NumberGame(){
        random = new Random();
        problems = new int[9];
        create_problems();
        interfaceController = new InterfaceController();
    }

    private InterfaceController interfaceController;
    int[] problems;

    Random random;


    public void create_problems() {
//        System.out.println("Round 1!");
//        System.out.println("I'm thinking of a number between 0 to 10");
        for (int i = 1; i <= 9; i++) {
            int range = Integer.parseInt("1" + String.format("%0" + i + "d", 0)) + 1;

            problems[i - 1] = random.nextInt(range);
//            System.out.println(problems[i-1]);
        }
    }

    public void guess(Player player){
//        System.out.println("\uD83E\uDD0D".repeat(player.getAttempts_left()));
        if(canGuess(player)) {
//            System.out.println("Enter a number: ");
            player.enter_guess(interfaceController.submitAnswer());
            int current_guess = player.getGuess();
            int current_round = player.getCurrent_round();
            int current_solution = problems[current_round - 1];
            if (current_guess == current_solution) {
//                System.out.println("Correct! the answer was: " + current_solution);
                interfaceController.setResponse("Correct! the answer was: " + current_solution);
                System.out.println("Continue playing? (y/n)");

                String play = new Scanner(System.in).nextLine();
                if (play.equalsIgnoreCase("y")) {
                    player.nextRound();
                    roundStart(player);
                } else {
                    Main.play = false;
                }
            } else if (current_guess > current_solution) {
                System.out.println("Your guess is high");
                player.minusAttempt();
            } else if (current_guess < current_solution) {
                System.out.println("Your guess is low");
                player.minusAttempt();
            }
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
//        System.out.println("Round " + current_round + "!");
        interfaceController.setCurrentRound(current_round);
        interfaceController.setNumberToGuess(current_round);
//        System.out.println("I'm thinking of a number between 0 " + "1" + String.format("%0" + current_round + "d", 0));
    }

}
