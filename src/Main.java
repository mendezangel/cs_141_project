import java.util.*;

public class Main {
    static Character playerCharacter;

    public static void main(String[] args) {
        // GameManager game = new GameManager();
        // Character playerCharacter = Character.createPlayerCharacter();
        // game.initializeGame(playerCharacter.getName());
        // GameManager class will have actual logic for game
        // the main method in Main class will pretty much only be doing
        // method calls / class instantiations
        // Character enemy = new Character("enemy", 10, 10, null);
        // playerCharacter.attack(enemy);
        // enemy.attack(playerCharacter);
        // Encounter.Gargoyle();
        // try this one
        // Encounter.Jehovah();
        // or even this one!
        intro();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(3500);
            Encounter.pickRandomEncounter();
        }
        // Endgame Boss Battle. Either a Set Battle or a
    }

    public static void intro() {
        System.out.println("The lone survivor stumbles through wreckage, and lays eyes upon the devastation to the surrounding city.");
        Thread.sleep(3000);
        System.out.println("They began to cough as smoke clogged their lungs, but even still it was more refreshing than where they'd been. ");
        Thread.sleep(3000);
        System.out.println("Their group had all passed, left withering in the bunker where they'd decided to hide out. It didn't last. ");
        Thread.sleep(3000);
        System.out.println("The survivor traced a finger along their handgun, it was a symbol of their identity. The grip had their name engraved on it...");
        playerCharacter = Character.createPlayerCharacter();
        Thread.sleep(3000);
        System.out.println(playerCharacter.getName() + " continued through the debris. Something other wordly had impacted their environment creating a sort of 'in-between'. ");
        Thread.sleep(3000);
        System.out.println(" It was called the Fracture; and" + playerCharacter.getName() 
        + " had to get through it if they wanted a chance to live.");
        Thread.sleep(3000);
        Encounter.livingOoze();
    }
}
