// Added word wrap so it looks perhaps a little bit prettier. If it's broken lmk because it works on my end. A lot of the layout is just for testing but I have it saved on my computer so if we/you want to delete everything don't feel bad about losing code because it's backed up. There are optimizations to be made such as initializing the player and enemy data elsewhere but this works for now.

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Encounter {

//    public static void TestEncounter() {
//        Character enemy = new Character("Foul Creature", 20, 4, "basic");
//        Scanner pointless = new Scanner(System.in);
//        System.out.println("hmm... it appears there's a fork in the road. Shall you go left or right?");
//        String input = pointless.nextLine();
//        if (Objects.equals(input, "left")) {
//            System.out.println("You move towards the left path but you are accosted!!!!11!1one");
//            Battle(enemy);
//
//        } else if (Objects.equals(input, "right")) {
//            System.out.println("You sprint towards the right path but you see a SCARY MONSTER AAAAAAA");
//            Battle(enemy);
//        } else {
//            System.out.println("Imma be real there's a path between the " +
//                    "two and the monster can go between them so he's gonna come at you regardless" +
//                    " so here's a battle");
//            Battle(enemy);
//        }
//    }
    //keeping all this here for an example

    public static void Jehovah() {
        boolean ending = false;
        Character player = Main.playerCharacter; //probably not good but it's for testing
        Character enemy = new Character("Cultist", 15, 4, "basic");
        Scanner s = new Scanner(System.in);
        System.out.println("A group of people dressed in pine colored robes approach " + player.getName() +
                ". The oldest one comes closest and asks");
        //pause if possible
        System.out.println("Do you have a minute to talk about our lord and saviour Cthulhu?");
        boolean talking = false;
        while (!talking) {
            String input = s.nextLine();
            if (Objects.equals(input, "yes")) {
                System.out.println("Wonderful");
                System.out.println("As the elder cultist prattles on about how mighty it can make people" +
                        ", " + player.getName() + " feels their mind weakening and yearning for power");
                player.setHealthPoints(player.getHealthPoints() - 15);
                talking = true;
            } else if (Objects.equals(input, "no") || Objects.equals(input, "nope")) { //don't ask idek
                System.out.println("He rolls his sleeves up to his elbows and raises his fists");
                System.out.println("Alright pal I'm going to have to teach you the old fashioned way");
                talking = true;
                Battle(enemy);
            } else {
                System.out.println("Listen pal it's a simple yes or no question. Quit mumbling.");
            }
        }

    }

    public static void Gargoyle() {
        Character player = Main.playerCharacter;
        Character enemy = new Character("Gargoyle", 25, 2, "Garg");
        System.out.println("As " + player.getName() + " wanders around ruins they seem to notice a statue slowly rising and" +
                " falling almost as if it were breathing");
        System.out.println("Almost without warning it turns its beastly head with an accompanying stone" +
                " grating. With it's target now located it lurches toward " + player.getName() + "!");
        Battle(enemy);
    }

    public static void Voices() {
        Character player = Main.playerCharacter;
        Character enemy = new Character("Eldritch Spectre", 1, 12, "Ghost" );
        Scanner s = new Scanner(System.in);
        boolean spookyghost = true;
        System.out.println("As " + player.getName() + " walks along a disheveled path darkness suddenly envelops them.");
               System.out.println("Echoes shouting curses of impending doom in the voices of loved ones and some mirroring their own.");
        System.out.println("What can be done to fight back the intangible voices?");
        while(spookyghost) {
            System.out.println("||(L)ash out into the darkness||");
            System.out.println("||(C)all out to the voices||");
            System.out.println("||(P)ray for safety||");
            String input = s.nextLine();
            if (Objects.equals(input, "l")) {
System.out.println(player.getName() + " wildly strikes into the darkness only to be left with a wound opposite to where " +
        "they had swung.");
player.setHealthPoints(player.getHealthPoints() - 12);
            } else if (Objects.equals(input, "c")) {
System.out.println("As " + player.getName() + " reaches out for help they can hear voices snickering and mocking them.");
player.setHealthPoints(player.getHealthPoints() - 2);
            } else if (Objects.equals(input, "p")) {
System.out.println(player.getName() + " prays for safety.");
System.out.println("The voices silence themselves and the darkness weakens, revealing nearby pavement and debris.");
System.out.println("A ghostly figure, seemingly injured due to the prayer reveals itself.");
System.out.println("While not defenseless it can still be injured via prayer.");
          Battle(enemy);
          spookyghost = false;
            }else {
                System.out.println(player.getName() + "'s voice calls out, \"You are confused and alone. This void " +
                        "will be your grave\"");
                System.out.println(player.getName() + " can feel their mind liquefying");
                player.setHealthPoints(player.getHealthPoints() - 2);
            }
            }
        }



    public static void Battle(Character enemy) {
        //attack variance would be super easy to add. just add rand.nextInt(0, 6) to an attack and boom some luck.
        boolean turnTimer = true;
        boolean battle = true;
        boolean block = false;
        boolean deathmode = false; //this is for one enemy type but idk where else to put it
        int ghostmeter = 0;
        if (enemy.getEnemyType() == "Ghost") {ghostmeter = 3; } //same here but this one is worse
        Character player = Main.playerCharacter;


        System.out.println("It appears " + player.getName() + " has been attacked by a " + enemy.getName() + "!");
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
                        if (ghostmeter > 0) {
                        System.out.println(player.getName() + " fires at the figure, but the apparition " +
                                "doesn't even flicker.");
                        turnTimer = false;
                        break;
                        }
                            player.attack(enemy);
                            System.out.println(player.getName() + " blasts the " + enemy.getName() + " for "
                                    + player.getAttack() + " damage leaving it with " + enemy.getHealthPoints() + " Health!");
                            turnTimer = false;
                            break;
                            case "b":
                                if (ghostmeter > 0 ) {
                                    block = true;
                                    System.out.println(player.getName() + " braces and prays for resilience");
                                    System.out.println("The figure seizes and shrieks as the darkness is pushed further away");
                                    ghostmeter -= 1;
                                    if (ghostmeter == 0) {
                                        System.out.println("The figure reveals it's corporeal form, a twisting mass of" +
                                                " flesh and vines warped into a humanoid figure. it is now vulnerable ");
                                    }
                                    turnTimer = false;
                                    break;
                                }
                                block = true;
                                System.out.println(player.getName() + " braces and prays for resilience");
                                turnTimer = false;
                                break;
                            case "f":
                                if (ghostmeter > 0) {
                                    System.out.println(player.getName() + " cannot find a direction to move to. They " +
                                            "are trapped");
                                    break label;
                                }
                                player.setHealthPoints(player.getHealthPoints() - 5);
                                System.out.println(player.getName() + " successfully escapes, but their cowardly behavior" +
                                        " leaves their mind vulnerable.");
                                System.out.println(player.getHealthPoints());
                                battle = false;
                                break label;
                            default:
                                System.out.println(player.getName() + "'s mind races and they fail to comprehend their surroundings");
                                player.setHealthPoints(player.getHealthPoints() - 1);
                                //don't take this one too seriously I just thought it was funny
                                break;
                        }
                        break;
                }

            if (Objects.equals(enemy.getEnemyType(), "basic")) {
                while (!turnTimer) {
                    if (enemy.getHealthPoints() <= 0) {
                        System.out.println("The " + enemy.getName() + " has been slain.");
                        battle = false;
                        break;
                    }
                    if (block == false) {
                        enemy.attack(player);
                        System.out.println("The " + enemy.getName() + " strikes " + player.getName() + " dealing " +
                                enemy.getAttack() + " damage! " + player.getName() + " has " + player.getHealthPoints()
                                + " health.");
                        turnTimer = true;
                    } else {
                        enemy.attackButBlock(player);
                        System.out.println("The " + enemy.getName() + " strikes " + player.getName() + " dealing " +
                                (enemy.getAttack()/4) + " damage! " + player.getName() + " has " + player.getHealthPoints()
                                + " health.");
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
            if (Objects.equals(enemy.getEnemyType(), "Garg")) {

                while (!turnTimer) {
                    if (enemy.getHealthPoints() <= 0) {
                        System.out.println("The " + enemy.getName() + " completely stops moving.");
                        battle = false;
                        break;
                    }
                    if (!block) {
                        enemy.attack(player);
                        System.out.println("The " + enemy.getName() + " strikes " + player.getName() + " dealing " +
                                enemy.getAttack() + " damage! " + player.getName() + " has " + player.getHealthPoints()
                                + " health.");
                        turnTimer = true;
                        if (deathmode == false) {
                            enemy.setAttack(enemy.getAttack() * 3);
                            randGarg();
                            deathmode = true;
                        } else if (deathmode == true) {
                            enemy.setAttack(enemy.getAttack() / 3);
                            System.out.println("The gargoyle recesses back into its perch");
                            deathmode = false;
                        }
                    } else {
                        enemy.attackButBlock(player);
                        System.out.println("The " + enemy.getName() + " strikes " + player.getName() + " dealing " +
                                (enemy.getAttack()/4) + " damage! " + player.getName() + " has " + player.getHealthPoints()
                                + " health.");
                        block = false;
                        turnTimer = true;
                        if (deathmode == false) {
                            enemy.setAttack(enemy.getAttack() * 3);
                            randGarg();
                            deathmode = true;
                        } else if (deathmode == true) {
                            enemy.setAttack(enemy.getAttack() / 3);
                            System.out.println("The gargoyle recesses back into its perch");
                            deathmode = false;
                        }
                    }

                }
            }
            if (enemy.getEnemyType() == "Ghost") {
                while (!turnTimer) {
                    if (enemy.getHealthPoints() <= 0) {
                        System.out.println("The " + enemy.getName() + " vanishes with a flash of light.");
                        battle = false;
                        break;
                    }
                    if (block == false) {
                        enemy.attack(player);
                        System.out.println("The " + enemy.getName() + " strikes " + player.getName() + " dealing " +
                                enemy.getAttack() + " damage! " + player.getName() + " has " + player.getHealthPoints()
                                + " health.");
                        turnTimer = true;
                    } else {
                        enemy.attackButBlock(player);
                        System.out.println("The " + enemy.getName() + " strikes " + player.getName() + " dealing " +
                                (enemy.getAttack()/4) + " damage! " + player.getName() + " has " + player.getHealthPoints()
                                + " health.");
                        block = false;
                        turnTimer = true;
                    }

                }
            }
            }
        }

    private static void randGarg () { //this is just for conciseness
        Random rand = new Random();
        int randy = rand.nextInt(1, 3);
        if (randy == 3) {
            System.out.println("The gargoyle bares its fangs.");
        } else if (randy == 2) {
            System.out.println("The gargoyle's stone body shakes and tremors.");
        } else {
            System.out.println("The gargoyle opens its clawed hand.");
        }
    }
}



