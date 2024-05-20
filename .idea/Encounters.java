import java.util.*;

public class Encounters {
	public static void main(String[] args) {
	    Beginnings();
	}
	public static void Beginnings() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("The lone survivor stumbles through wreckage, and lays eyes upon the devastation to the surrounding city. They began to cough as smoke clogged their lungs, but even still it was more refreshing than where they'd been. Their group had all passed, left withering in the bunker where they'd decided to hide out. It didn't last. The survivor traced a finger along their handgun, it was a symbol of their identity. The grip had their name engraved on it...");
	    System.out.print("Please choose a name: ");
	    String playerName = scanner.next();
	    System.out.println();
	    System.out.println( playerName + " continued through the debris. Something other wordly had impacted their environment creating a sort of 'in-between'. It was called the Fracture; and " + playerName + " had to get through it if they wanted a chance to live.");
	    
	}
}

//{"encounter 1", "encounter 2", "encounter 3"}
//use Random to select encounter (index)
//difficulty level is used to make x number of random encounter selections
//Check each time a new encounter is selected to make sure it isn't a repeat