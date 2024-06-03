import java.util.Scanner;

public class GameManager {
    // This class is going to be in charge of a playthrough from start to finish
    // will have methods such as initialize game, etc etc
    public GameManager() {

    }

    public void initializeGame(String playerName) {
        // in here we will handle all game initialization
        // we can meet to discuss what that might mean for our game
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "The lone survivor stumbles through wreckage, and lays eyes upon the devastation to the surrounding city. They began to cough as smoke clogged their lungs, but even still it was more refreshing than where they'd been. Their group had all passed, left withering in the bunker where they'd decided to hide out. It didn't last. The survivor traced a finger along their handgun, it was a symbol of their identity. The grip had their name engraved on it...");
        System.out.print("Please choose a name: ");
        System.out.println();
        System.out.println(playerName
                + " continued through the debris. Something other wordly had impacted their environment creating a sort of 'in-between'. It was called the Fracture; and "
                + playerName + " had to get through it if they wanted a chance to live.");

        scanner.close();
    }
}
