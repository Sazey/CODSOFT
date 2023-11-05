import java.io.IOException;

public class Game {
    public static boolean play = true;
    public static void main(String[] args) throws IOException {
        NumberGame game = new NumberGame();
        Player player = new Player("Test Player");

        while (play){
            game.guess(player);
            Runtime.getRuntime().exec("clear");
        }
        System.out.println("No more Attempts left!");
        System.out.print("Game Over!");
    }
}
