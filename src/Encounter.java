// Added word wrap so it looks perhaps a little bit prettier. If it's broken lmk because it works on my end. A lot of the layout is just for testing but I have it saved on my computer so if we/you want to delete everything don't feel bad about losing code because it's backed up. There are optimizations to be made such as initializing the player and enemy data elsewhere but this works for now.

import java.util.Objects;
import java.util.Scanner;

public class Encounter {

    public static void TestEncounter() {
        Character enemy = new Character("Foul Creature", 20, 4, "basic");
        Scanner pointless = new Scanner(System.in);
        System.out.println("hmm... it appears there's a fork in the road. Shall you go left or right?");
        String input = pointless.nextLine();
        if (Objects.equals(input, "left")) {
            System.out.println("You move towards the left path but you are accosted!!!!11!1one");
            Battle(enemy);

        } else if (Objects.equals(input, "right")) {
            System.out.println("You sprint towards the right path but you see a SCARY MONSTER AAAAAAA");
            Battle(enemy);
        } else {
            System.out.println("Imma be real there's a path between the " +
                    "two and the monster can go between them so he's gonna come at you regardless" +
                    " so here's a battle");
            Battle(enemy);
        }
    }

    public static void Battle(Character enemy) {
        //attack variance would be super easy to add. just add rand.nextInt(0, 6) to an attack and boom some luck.
        //also critical hits could work but I won't add them in this simple program
        //adding speed variables could work, or it can be a case-by-case basis. I'm just gonna default to player start
        //also an enemy charged mega attack to give the "block" action meaning will probably be added but not here
        //if anything we can make multiple battle types where we copy this basic code and add more attacks.\
        boolean turnTimer = true;
        //Keeping all these for function because I don't think we need them anywhere else/ more complicated.
        boolean battle = true;
        boolean block = false;

        //initializing the player and monster in the battle is probably bad but I couldn't figure out how to not do it. still works.
//        Character player = new Character("Albert", 60, 5, "doesn't matter" ); //forgor about the null thing
        Character player = Main.playerCharacter;
//        Character enemy = new Character("Foul Creature", 20, 4, "basic"); //change the enemy type to "pipebomb" to get a different result. did it just to show different enemy types


        System.out.println("It appears you hath been accosted by a " + enemy.getName() + "!");
        Scanner scanCool = new Scanner(System.in);

        while (battle) {
            label:
            while (turnTimer) {
                if (player.getHealthPoints() <= 0) {
                    System.out.println(player.getName() + "'s mind has been corrupted and dominated by the " + enemy.getName());
                    battle = false;
                    break;
                }

                System.out.println("shall you (A)ttack (B)lock or (F)lee?");
                String input = scanCool.nextLine();

                switch (input) {
                    case "a":
                        player.attack(enemy);
                        System.out.println("The " + enemy.getName() + " has been struck for " + player.getAttack() + " damage leaving it with " + enemy.getHealthPoints() + " Health!");
                        //100% the line above will not be kept. I'm just using it to see whats working. i would prefer grpahics or atleast some less basic text
                        turnTimer = false;
                        break;
                    case "b":
                        block = true;
                        System.out.println(" You brace and pray for resilience");
                        turnTimer = false;
                        break;
                    case "f":
                        player.setHealthPoints(player.getHealthPoints() - 5);
                        System.out.println("You successfully escape, but your cowardly behaviour leaves your mind vulnerable.");
                        System.out.println(player.getHealthPoints()); //delete this I just needed it for testing
                        battle = false;
                        break label;
                    default:
                        System.out.println("Your mind races and you fail to comprehend your surroundings");
                        player.setHealthPoints(player.getHealthPoints() - 1);
                        //don't take this one too seriously I just thought it was funny
                        break;
                }
            }
            if (Objects.equals(enemy.getEnemyType(), "basic")) {
                while (!turnTimer) {
                    if (enemy.getHealthPoints() <= 0) {
                        System.out.println("The " + enemy.getName() + " has been slain.");
                        battle = false;
                        break;
                    }
                    if (!block) {
                        enemy.attack(player);
                        System.out.println("The " + enemy.getName() + " clonks you dealing " + enemy.getAttack() + " damage! You have " + player.getHealthPoints() + " health.");
                        turnTimer = true;
                    } else {
                        enemy.attackButBlock(player); //I decided to third the attack to make it more rewarding to use block correctly
                        System.out.println("The " + enemy.getName() + " clonks you dealing " + (enemy.getAttack() / 3) + " damage!");
                        //the "(enemyATK/3)" and all other statements will have to be changed if we add randomness to damage
                        block = false;
                        turnTimer = true;
                    }

                }
            }
            if (battle && Objects.equals(enemy.getEnemyType(), "pipebomb")) { //the boolean before the check was just for dialogue and it works but idk a proper fix
                System.out.println("you are holding a pipe bomb and it explodes");
                player.setHealthPoints(0);
                turnTimer = true;
            }
        }
    }
}

