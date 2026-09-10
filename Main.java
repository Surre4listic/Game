import java.util.Scanner;

public class Main {

    static Player player;

    public static void main(String[] args) {

        Scanner readInput = new Scanner(System.in);

        // Get player name and create a new player object with that name.
        System.out.print(" Please choose a name for your character: ");
        Main.player = new Player(readInput.nextLine());
        Output.Send(" Welcome to the game, " + player.name + "!");
        player.room.New();

        while (player.input.Get(readInput.nextLine())) {;}
        
        readInput.close();

    }


}