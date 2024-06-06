// Added word wrap so it looks perhaps a little bit prettier. If it's broken lmk because it works on my end. A lot of the layout is just for testing but I have it saved on my computer so if we/you want to delete everything don't feel bad about losing code because it's backed up. There are optimizations to be made such as initializing the player and enemy data elsewhere but this works for now.

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Encounter {

    // public static void TestEncounter() {
    // Character enemy = new Character("Foul Creature", 20, 4, "basic");
    // Scanner pointless = new Scanner(System.in);
    // System.out.println("hmm... it appears there's a fork in the road. Shall you
    // go left or right?");
    // String input = pointless.nextLine();
    // if (Objects.equals(input, "left")) {
    // System.out.println("You move towards the left path but you are
    // accosted!!!!11!1one");
    // Battle(enemy);
    //
    // } else if (Objects.equals(input, "right")) {
    // System.out.println("You sprint towards the right path but you see a SCARY
    // MONSTER AAAAAAA");
    // Battle(enemy);
    // } else {
    // System.out.println("Imma be real there's a path between the " +
    // "two and the monster can go between them so he's gonna come at you
    // regardless" +
    // " so here's a battle");
    // Battle(enemy);
    // }
    // }
    // keeping all this here for an example

    public static void pickRandomEncounter() {
        Random random = new Random();
        int num = random.nextInt(15);

        switch (num) {
            case 1:
                Jehovah();
            case 2:
                Gargoyle();
            case 3:
                Voices();
            case 4:
                guidingLight();
            case 5:
                fauxLight();
            case 6:
                rejuvinatingSlime();
            case 7:
                Rats();
            case 8:
                fireDumpster();
            case 9:
                buildingCrumbling();
            case 10:
                energyBar();
            case 11:
                firstaidPack();
            case 12:
                theUndead();
            case 13:
                theUndead2();
            case 14:
                livingOoze2();
            case 15:
                angryMites();
        }
    }

    public static void Jehovah() {
        boolean ending = false;
        Character player = Main.playerCharacter; // probably not good but it's for testing
        Character enemy = new Character("Cultist", 15, 7, "basic");
        Scanner s = new Scanner(System.in);
        System.out.println("A group of people dressed in pine colored robes approach " + player.getName() +
                ". The oldest one comes closest and asks,");
        // pause if possible
        Thread.sleep(3000);
        System.out.println("\"Do you have a minute to talk about our lord and saviour Cthulhu?\"");
        boolean talking = false;
        while (!talking) {
            String input = s.nextLine();
            if (Objects.equals(input, "yes")) {
                Thread.sleep(1000);
                System.out.println("\"Wonderful.\"");
                Thread.sleep(1000);
                System.out.println("As the elder cultist prattles on about how mighty it can make people" +
                ", " + player.getName() + " feels their mind weakening and yearning for power.");
                player.setHealthPoints(player.getHealthPoints() - 15);
                talking = true;
            } else if (Objects.equals(input, "no") || Objects.equals(input, "nope")) { // don't ask idek
                Thread.sleep(1000);
                System.out.println("He rolls his sleeves up to his elbows and raises his fists.");
                Thread.sleep(1000);
                System.out.println("\"Alright pal I'm going to have to teach you the old fashioned way.\"");
                talking = true;
                Battle(enemy);
            } else {
                Thread.sleep(1000);
                System.out.println("\"Listen pal it's a simple yes or no question. Quit mumbling.\"");
            }
        }

    }

    public static void Gargoyle() {
        Character player = Main.playerCharacter;
        Character enemy = new Character("Gargoyle", 25, 4, "Garg");
        System.out.println("As " + player.getName() + " wanders around ruins they seem to notice a statue slowly rising and" +
                        " falling almost as if it were breathing");
        Thread.sleep(3000);
        System.out.println("Almost without warning it turns its beastly head with an accompanying stone" +
                " grating. With it's target now located it lurches toward " + player.getName() + "!");
        Battle(enemy);
    }

    public static void Voices() {
        Character player = Main.playerCharacter;
        Character enemy = new Character("Eldritch Spectre", 1, 12, "Ghost");
        Scanner s = new Scanner(System.in);
        boolean spookyghost = true;
        System.out
                .println("As " + player.getName() + " walks along a disheveled path darkness suddenly envelops them.");
        Thread.sleep(3000);
        System.out.println(
                "Echoes shouting curses of impending doom in the voices of loved ones and some mirroring their own.");
        Thread.sleep(3000);
        System.out.println("What can be done to fight back the intangible voices?");
        while (spookyghost) {
            System.out.println("||(L)ash out into the darkness||");
            System.out.println("||(C)all out to the voices||");
            System.out.println("||(P)ray for safety||");
            String input = s.nextLine();
            if (Objects.equals(input, "l")) {
                Thread.sleep(1000);
                System.out.println(player.getName()
                        + " wildly strikes into the darkness only to be left with a wound opposite to where " +
                        "they had swung.");
                player.setHealthPoints(player.getHealthPoints() - 12);
            } else if (Objects.equals(input, "c")) {
                Thread.sleep(1000);
                System.out.println("As " + player.getName()
                        + " reaches out for help they can hear voices snickering and mocking them.");
                player.setHealthPoints(player.getHealthPoints() - 2);
            } else if (Objects.equals(input, "p")) {
                Thread.sleep(1000);
                System.out.println(player.getName() + " prays for safety.");
                Thread.sleep(1000);
                System.out.println(
                        "The voices silence themselves and the darkness weakens, revealing nearby pavement and debris.");
                Thread.sleep(2000);
                System.out.println("A ghostly figure, seemingly injured due to the prayer reveals itself.");
                Thread.sleep(2000);
                System.out.println("While not defenseless it can still be injured via prayer.");
                Battle(enemy);
                spookyghost = false;
            } else {
                Thread.sleep(1000);
                System.out.println(player.getName() + "'s voice calls out, \"You are confused and alone. This void " +
                        "will be your grave.\"");
                Thread.sleep(2000);
                System.out.println(player.getName() + " can feel their mind liquefying");
                player.setHealthPoints(player.getHealthPoints() - 2);
            }
        }
    }

    public static void Rats() {
        Character player = Main.playerCharacter;
        Character enemy = new Character("Rat Swarm", 10, 2, "Rodent");
        System.out.println("Pebbles begin to tremble, and out of their peripheral " + player.getName() + " notices " +
                "something billowing out of the city drains. ");
        Thread.sleep(2000);
        System.out.println(player.getName() + " runs instinctively but the swarm swiftly meets their heels.");
        Battle(enemy);
    }

    public static void rejuvinatingSlime() {
        Character player = Main.playerCharacter;
        Character enemy = new Character("Rejuvinating Jelly", 10, 0, "Jelly");
        System.out.println(player.getName() + " leaned against a brick building as they collected themself." +
                " The smoke inhalation from the dense smog was catching up to them.");
        Thread.sleep(3000);
        System.out.println("They looked up at the sky and saw a Gelatinous Liquid descending down the wall" +
                " straight towards them.");
        Thread.sleep(3000)
        System.out.println("The Jelly was transparent and aqua. Not particularly fast," +
                "it looked oddly appetizing.");
        Battle(enemy);
    }

    // player makes a pathing decision, and can be moderately punished if they
    // choose wrong.
    public static void fauxLight() {
        Character player = Main.playerCharacter;
        Scanner movement = new Scanner(System.in);
        System.out.println("As our Survivor traversed, the buildings around them became warped, creaking" +
                " as if they were crying out.");
        Thread.sleep(3000);
        System.out.println("The tavern to " + player.getName()
                + "'s right was illuminated by a hopeful light, streaming through the space where a car had " +
                "tunneled through it.");
        Thread.sleep(3000);
        System.out.println("Then again, our Survivor was sure they were heading the right direction.");
        Thread.sleep(2000);
        System.out.print("Should " + player.getName() + " go (right) or (continue) forward?");
        boolean decision = false;
        while (decision == false) {
            String input = movement.nextLine();
            if (Objects.equals(input, "right")) {
                Thread.sleep(1000);
                System.out.println(player.getName() + " moves towards the tavern " +
                        "but as their hand passes through a ray of the hopeful light they are met with a"
                        + " searing pain.");
                Thread.sleep(3000);
                System.out.println("Clutching their arm, they continue through the streets...");
                player.setHealthPoints(player.getHealthPoints() - 10);
                Thread.sleep(1000);
                System.out.println(player.getName() + " has " + player.getHealthPoints() + " health!");
                decision = true;
            } else if (Objects.equals(input, "continue")) {
                Thread.sleep(1000);
                System.out.print(player.getName() + " continues ahead, and spares a glance behind themself." +
                        " The light through the tavern is gone.");
                decision = true;
            } else {
                Thread.sleep(1000);
                System.out.println(
                        "In their rumination, " + player.getName() + " failed to notice the light growing brighter." +
                                " A pain scorches the side of their face, forcing them away. The light disappears.");
                player.setHealthPoints(player.getHealthPoints() - 14);
                Thread.sleep(3000);
                System.out.println(player.getName() + " has " + player.getHealthPoints() + " health!");
                decision = true;
            }
        }
    }

    // This or that. If the player choose wrong, they could take serious damage.
    public static void buildingCrumbling() { // player makes a pathing decision, and is punished for it.
        Character player = Main.playerCharacter;
        Scanner movement = new Scanner(System.in);
        System.out.println("Slipping into a nearby print shop " + player.getName() + " quickly" +
                " realizes their grave error. The floor buckled underneath them, and they began to run.");
        Thread.sleep(3000);
        System.out.println(
                "They moved through building, and came to a stairwell. The basement of the building was flooded, " +
                        "however " + player.getName() + " knew they could potentially swim out.");
        Thread.sleep(3000);
        System.out.println("They could also take their chances ascending to the roof. But the building could collapse " +
                        "beneath them. They were stalled with alarm.");
        Thread.sleep(3000);
        System.out.println("Should " + player.getName() + " (ascend) or (descend)?");
        boolean decision = false;
        while (decision == false) {
            String input = movement.nextLine();
            if (Objects.equals(input, "ascend")) {
                Thread.sleep(1000);
                System.out.println(player.getName() + " frantically climbed the stairs, forcing their" +
                        " way through the fire escape at the top. The building swayed underneath them, they could fall " +
                        " to their death. ");
                Thread.sleep(3000);
                System.out.println(
                        "This confrontation pushed them to leap to a nearby buildings roof. Where they collapsed" +
                        " from exhaustion...");
                Thread.sleep(3000);
                decision = true;
            } else if (Objects.equals(input, "descend")) {
                Thread.sleep(1000);
                System.out.println(player.getName() + " dives into the water, hoping the building doesn't cave" +
                        " on top of them. ");
                Thread.sleep(2000);
                System.out.println("The darkness of the basement didn't seem to be broken up by anything, and " +
                        " our Survivor realized they had to return to the stairwell and climb to the roof.");
                Thread.sleep(2000);
                System.out.println(player.getName() + " frantically climbed the stairs but a piece of " +
                                "rubble above fell incapacitating them briefly.");
                Thread.sleep(2000);
                System.out.println("In a dazed manner, they made their way to the roof and leapt" +
                        " perilously to a nearby building before collapsing from exhaustion...");
                player.setHealthPoints(player.getHealthPoints() - 17);
                Thread.sleep(2000);
                System.out.println(player.getName() + " has " + player.getHealthPoints() + " health!");
                decision = true;
            } else {
                Thread.sleep(1000);
                System.out.println(player.getName() + "remained still as to not disturb the environment. They " +
                        "knew they had limited time... This decision was pivotal.");
                Thread.sleep(2000);
                System.out.print("Should" + player.getName() + " (ascend) or (descend)?" +
                        ">");
            }
        }
    }

    // If the player makes the correct decision they are Rewarded with a Heal!
    public static void guidingLight() {
        Character player = Main.playerCharacter;
        Scanner movement = new Scanner(System.in);
        System.out.println(player.getName() + " made their way into an alley as the street had become clouded with a" +
                " supernatural haze.");
        Thread.sleep(2000);
        System.out.println("Before they managed to reach the outlet, our Survivor realized their shadow was now" +
                " cast in front of them.");
        Thread.sleep(2000);
        System.out.println(
                "They turned around to see a blue light beaming from their entry more luminous than anything encountered...");
        Thread.sleep(2000);
        System.out.println("Should " + player.getName() + "go (forward) or (turn back)?");
        boolean decision = false;
        while (decision == false) {
            String input = movement.nextLine();
            if (Objects.equals(input, "forward")) {
                Thread.sleep(1000);
                System.out.print(player.getName() + " moves away from the light, returning to the street.");
                decision = true;
            } else if (Objects.equals(input, "turn back")) {
                Thread.sleep(1000);
                System.out.print(player.getName() + " approaches the light, a coolness washes over them. As if they " +
                        " had received a deep massage or had exited an ice cold shower.");
                player.setHealthPoints(player.getHealthPoints() + 20);
                Thread.sleep(2000);
                System.out.println(player.getName() + " has " + player.getHealthPoints() + " health!");
                decision = true;
            } else {
                Thread.sleep(1000);
                System.out.println("In their indecisiveness the light faded. Leaving them to continue on alone...");
                decision = true;
            }
        }
    }

    // Next 3 encounters are healing encounters!
    public static void fireDumpster() {
        Character player = Main.playerCharacter;
        System.out.println("The challenging landscape leveled out upon entrance to a parking lot.");
        Thread.sleep(2000);
        System.out.println(
                "A metal dumpster lit ablaze indicated other Survivors had made their way through. The thought grounded "
                        + player.getName() + ".");
        player.setHealthPoints(player.getHealthPoints() + 7);
        Thread.sleep(2000);
        System.out.println(player.getName() + " has " + player.getHealthPoints() + " health!");
    }

    public static void energyBar() {
        Character player = Main.playerCharacter;
        System.out.print(player.getName() + " stops at a crumbling grocery mart to scavenge for supplies.");
        Thread.sleep(2000);
        System.out.println(" Most of it was picked clean but they managed to find an energy bar forgotten" +
                " at a check-out stand.");
        player.setHealthPoints(player.getHealthPoints() + 10);
        Thread.sleep(2000);
        System.out.println(player.getName() + " has " + player.getHealthPoints() + " health!");
    }

    public static void firstaidPack() {
        Character player = Main.playerCharacter;
        System.out.println(
                "To see a child care center in such a state brought a deep sadness over " + player.getName() + ".");
        Thread.sleep(2000);
        System.out.println("They entered into the kitchen, and the scene indicated a struggle had occurred.");
        Thread.sleep(2000);
        System.out.println(
                "A basic first aid pack's contents were strewn about the floor. It was clear, it was not enough to assist with the wounds sustained by those who came before.");
        player.setHealthPoints(player.getHealthPoints() + 12);
        Thread.sleep(2000);
        System.out.println(player.getName() + " has " + player.getHealthPoints() + " health!");
    }

    // basic enemy
    public static void theUndead() {
        Character player = Main.playerCharacter;
        Character enemy = new Character("Undead Women", 20, 8, "basic");
        System.out.println("The door to a nearby town home is forced open... A human figure " +
                "stumbles through it. It seemed to be a resident. Her skin was pale, and peeling.");
        Thread.sleep(3000);
        System.out.println(player.getName() + " questioned how she was even living. What seemed like pained groans " +
                "were nothing but gas escaping her system. She wasn't alive.");
        Battle(enemy);
    }

    // basic enemy
    public static void theUndead2() {
        Character player = Main.playerCharacter;
        Character enemy = new Character("Undead Man", 20, 8, "basic");
        System.out.println(player.getName() + " knew the Fracture was a horrid phenomenon " +
                "but the recent sights they had witnessed challenged their mental fortitude.");
        Thread.sleep(2000);
        System.out.println("The man had an endless hunger, and devoured only god knows what with a ferocity unknown to "
                + player.getName() + ".");
        Thread.sleep(2000);
        System.out.println(
                "The figure faced our Survivor, his skin was pale and flaking. The corpse's eyes were piercing.");
        Battle(enemy);
    }

    // beginning encounter
    public static void livingOoze() {
        Character player = Main.playerCharacter;
        Character enemy = new Character("Living Ooze", 10, 1, "basic");
        Thread.sleep(3000);
        System.out.println("As " + player.getName() + " lungs finally adjusted to the fumes in the air" +
                " a gelatinous mass catches their attention. It had picked up pieces of debree like gravel, and" +
                " was stained with oil. A shoe circulated through the ooze. These were the creatures the Fracture" +
                " had brought with it.");
        Thread.sleep(1000);
        Battle(enemy);
        System.out.println("Beings from forgotten realms cried out. Buildings crumbled. Wreckage around" +
                " our Survivor shifted from damage and the creatures roaming inside them. Begrudingly,"
                + player.getName() + " moves onwards...");
    }

    // basic enemy
    public static void livingOoze2() {
        Character player = Main.playerCharacter;
        Character enemy = new Character("Living Ooze", 15, 5, "basic");
        System.out.println(player.getName() + " was halted underneath an overpass. A familiar foe " +
                "dropped down from the road above in a gooey mess. This time, animal parts and clothing were visible in the mixture.");
        Battle(enemy);
    }

    // An encounter thats simple but maybe a little annoying!

    public static void angryMites() {
        Character player = Main.playerCharacter;
        Character enemy = new Character("Fracture Mite", 3, 5, "basic");
        System.out.println("This part of the city had been leveled. Nervously, our Survivor made their" +
                " way out of cover and across this concrete plain. All was quiet, until something nicked " + player.getName());
        player.setHealthPoints(player.getHealthPoints() - 5);
        Thread.sleep(2000);
        System.out.println(player.getName() + " has " + player.getHealthPoints() + " health!");
        Thread.sleep(2000);
        System.out.println("The insectoid creature shook concrete dust off of itself.");
        Battle(enemy);
        System.out.println(player.getName() + " realized this entire plain could be full of these things." +
                " They began to carry on but were interrupted once again by-");
        Battle(enemy);
        System.out.println(
                player.getName() + " dashed back into wreckage. At least the decimated buildings provided cover...");
    }

     public static void cthulhuFight() {
        Character player = Main.playerCharacter;
        System.out.println(player.getName() + " marches toward the source of all terrible power, the start of the fracture.");
        Thread.sleep(2000);
        System.out.println("As they approach a pillar of ethereal light, pools of violent green liquid crackle along the path.");
        Thread.sleep(2000);
        System.out.println("Coming closer " + player.getName() + " notices a figure in stasis within the light");
        Thread.sleep(2000);
        System.out.println("A familiar voice calls out to " + player.getName() + ".");
        Thread.sleep(2000);
        System.out.println("\"Please come back " + player.getName() + "! Come back home, it's safer here.\"" );
        Thread.sleep(2000);
        System.out.println(player.getName() + " isn't fooled by the trickery and continues approaching.");
        Thread.sleep(2000);
        System.out.println("The pillar crackles into the sky splaying an aurora of devilish energy. The figure reveals ");
        Thread.sleep(2000);
        System.out.println("itself to be a massive dark-green humanoid draped in tentacles. It's eyes are pure darkness");
        Thread.sleep(2000);
        System.out.println("An unearthly voice appears in " + player.getName() + "'s head.");
        Thread.sleep(2000);
        System.out.println("\"You are alone. You hold no power over me. I will extinguish every light on this planet. ");
        Thread.sleep(2000);
        System.out.println("Your creator is your destroyer. You will cease existence.\"");
        Character enemy = new Character("Otherworldly Beast", 60, 8, "basic");
        bossBattle(enemy);
        System.out.println("The creature bleeds rotten blue blood as it remains kneeling");
        Thread.sleep(2000);
        System.out.println(player.getName() + " raises their firearm and aims it at the creature's head.");
        Scanner scanCool = new Scanner(System.in);

        boolean winner = false;
        while (winner == false) {
            System.out.println("shall you (A)ttack or (F)lee?");
            String input = scanCool.nextLine();
            if (Objects.equals(input, "a")) {
                System.out.println(player.getName() + " blasts the humanoid, staining the ground with otherworldly brains.");
                System.out.println("The sky returns to its usual speckled darkness, the ruins become quiet.");
                System.out.println("With their final goal achieved," + player.getName() + " closes their eyes and rests.");
                winner = true;
                //WIN
            }
            else if (Objects.equals(input, "f")) {
                System.out.println(player.getName() + " watches the creature kneel, almost begging for death.");
                Thread.sleep(2000);
                System.out.println("Whether it's sympathy, or wanting the beast to suffer," + player.getName() + " " +
                        "walks away from the whole scene.");
                Thread.sleep(2000);
                System.out.println("\"I will be mightier next time. Your reluctance to execute me will be your species's downfall\"");
                Thread.sleep(2000);
                System.out.println("A flash of light makes everything otherworldly disappear. regardless of if this is a warning or ");
                Thread.sleep(2000);
                System.out.println("just a motivator for the beast to grow stronger, one thing is for sure.");
                Thread.sleep(2000);
                System.out.println("The world is safe... for now.\"");
               winner = true;
                //WIN
            } else {
                System.out.println(player.getName() + " stands frozen, still choosing a decision.");
                Thread.sleep(2000);
            }
        }
    }


    
    // BATTLE STARTS HERE

    public static void Battle(Character enemy) {
        // attack variance would be super easy to add. just add rand.nextInt(0, 6) to an
        // attack and boom some luck.
        boolean turnTimer = true;
        boolean battle = true;
        boolean block = false;
        boolean deathmode = false; // this is for one enemy type but idk where else to put it
        int ghostmeter = 0;
        if (enemy.getEnemyType() == "Ghost") {
            ghostmeter = 3;
        } // same here but this one is worse
        Character player = Main.playerCharacter;

        Thread.sleep(2000);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("It appears " + player.getName() + " has been attacked by a " + enemy.getName() + "!");
        Thread.sleep(1500);
        Scanner scanCool = new Scanner(System.in);

        while (battle) {

            label: while (turnTimer) {
                if (player.getHealthPoints() <= 0) {
                    System.out.println(
                            player.getName() + "'s mind has been corrupted and dominated by the " + enemy.getName());
                    battle = false;
                    break;
                }

                System.out.println("shall you (A)ttack (B)lock or (F)lee?");
                String input = scanCool.next();

                switch (input) {
                    case "a":
                        if (ghostmeter > 0) {
                            Thread.sleep(1000);
                            System.out.println(player.getName() + " fires at the figure, but the apparition " +
                                    "doesn't even flicker.");
                            turnTimer = false;
                            break;
                        }
                        Thread.sleep(1000);
                        player.attack(enemy);
                        System.out.println(player.getName() + " blasts the " + enemy.getName() + " for "
                                + player.getAttack() + " damage leaving it with " + enemy.getHealthPoints() + " Health!");
                        Thread.sleep(750);
                        turnTimer = false;
                        break;
                    case "b":
                        Thread.sleep(1000);
                        if (ghostmeter > 0) {
                            block = true;
                            System.out.println(player.getName() + " braces and prays for resilience");
                            Thread.sleep(1000);
                            System.out.println("The figure seizes and shrieks as the darkness is pushed further away");
                            ghostmeter -= 1;
                            if (ghostmeter == 0) {
                                Thread.sleep(1000);
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
                        Thread.sleep(1000);
                        if (ghostmeter > 0) {
                            System.out.println(player.getName() + " cannot find a direction to move to. They " +
                                    "are trapped");
                            break label;
                        }
                        player.setHealthPoints(player.getHealthPoints() - 10);
                        System.out.println(player.getName() + " successfully escapes, but their cowardly behavior" +
                                " leaves their mind vulnerable.");
                        Thread.sleep(1000);
                        System.out.println(player.getName() + " has " + player.getHealthPoints() + " health!");
                        battle = false;
                        break label;
                    default:
                        Thread.sleep(1000);
                        System.out.println(
                                player.getName() + "'s mind races and they fail to comprehend their surroundings.");
                        player.setHealthPoints(player.getHealthPoints() - 1);
                        // don't take this one too seriously I just thought it was funny
                        break;
                }
                break;
            }

            if (Objects.equals(enemy.getEnemyType(), "basic")) {
                while (!turnTimer) {
                    if (enemy.getHealthPoints() <= 0) {
                        Thread.sleep(1000);
                        System.out.println("The " + enemy.getName() + " has been slain.");
                        player.setAttack(player.getAttack + 1);
                        System.out.println(player.getName() + " has " + player.getHealthPoints() + " health!");
                        System.out.println(player.getName() + " grows stronger! Their attack increased to " + player.getAttack + "!");
                        battle = false;
                        break;
                    }
                    if (block == false) {
                        enemy.attack(player);
                        Thread.sleep(1000);
                        System.out.println("The " + enemy.getName() + " strikes " + player.getName() + " dealing " +
                                enemy.getAttack() + " damage! " + player.getName() + " has " + player.getHealthPoints() + " health.");
                        turnTimer = true;
                    } else {
                        enemy.attackButBlock(player);
                        Thread.sleep(1000);
                        System.out.println("The " + enemy.getName() + " strikes " + player.getName() + " dealing " +
                                (enemy.getAttack() / 4) + " damage! " + player.getName() + " has " + player.getHealthPoints() + " health.");
                        block = false;
                        turnTimer = true;
                    }

                }
            }
            if (battle && Objects.equals(enemy.getEnemyType(), "pipebomb")) { // the boolean before the check was just
                                                                              // for dialogue and it works but idk a
                Thread.sleep(1000);                                                              // proper fix
                System.out.println("you are holding a pipe bomb and it explodes");
                player.setHealthPoints(0);
                turnTimer = true;
            }
            if (Objects.equals(enemy.getEnemyType(), "Garg")) {

                while (!turnTimer) {
                    if (enemy.getHealthPoints() <= 0) {
                        System.out.println("The " + enemy.getName() + " completely stops moving.");
                        Thread.sleep(750);
                        player.setAttack(player.getAttack + 3);
                        System.out.println(player.getName() + " has " + player.getHealthPoints() + " health!");
                        Thread.sleep(750);
                        System.out.println(player.getName() + " grows stronger! Their attack increased to " + player.getAttack + "!");
                        battle = false;
                        break;
                    }
                    if (!block) {
                        enemy.attack(player);
                        Thread.sleep(1000);
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
                            Thread.sleep(1000);
                            System.out.println("The gargoyle recesses back into its perch.");
                            deathmode = false;
                        }
                    } else {
                        enemy.attackButBlock(player);
                        Thread.sleep(1000);
                        System.out.println("The " + enemy.getName() + " strikes " + player.getName() + " dealing " +
                                (enemy.getAttack() / 4) + " damage! " + player.getName() + " has " + player.getHealthPoints() + " health.");
                        block = false;
                        turnTimer = true;
                        if (deathmode == false) {
                            enemy.setAttack(enemy.getAttack() * 3);
                            randGarg();
                            deathmode = true;
                        } else if (deathmode == true) {
                            enemy.setAttack(enemy.getAttack() / 3);
                            Thread.sleep(1000);
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
                        Thread.sleep(750);
                        player.setAttack(player.getAttack + 3);
                        System.out.println(player.getName() + " has " + player.getHealthPoints() + " health!");
                        Thread.sleep(750);
                        System.out.println(player.getName() + " grows stronger! Their attack increased to " + player.getAttack + "!");
                        battle = false;
                        break;
                    }
                    if (block == false) {
                        enemy.attack(player);
                        Thread.sleep(1000);
                        System.out.println("The " + enemy.getName() + " strikes " + player.getName() + " dealing " +
                                enemy.getAttack() + " damage! " + player.getName() + " has " + player.getHealthPoints()
                                + " health.");
                        turnTimer = true;
                    } else {
                        enemy.attackButBlock(player);
                        Thread.sleep(1000);
                        System.out.println("The " + enemy.getName() + " strikes " + player.getName() + " dealing " +
                                (enemy.getAttack() / 4) + " damage! " + player.getName() + " has "
                                + player.getHealthPoints() + " health.");
                        block = false;
                        turnTimer = true;
                    }

                }
            }
            if (Objects.equals(enemy.getEnemyType(), "Rodent")) { 
                Random rats = new Random();
                while (!turnTimer) {
                    int bites = rats.nextInt(2, 11); // Every turn, a random number of rats with limit, attack the player.
                    if (enemy.getHealthPoints() <= 0) {
                        System.out.println("The swarm retreats into the sewers...");
                        player.setAttack(player.getAttack + 3);
                        Thread.sleep(750);
                        System.out.println(player.getName() + " has " + player.getHealthPoints() + " health!");
                        Thread.sleep(750);
                        System.out.println(player.getName() + " grows stronger! Their attack increased to " + player.getAttack + "!");
                        battle = false;
                        break;
                    }
                    if (!block) {
                        Thread.sleep(1000);
                        for (int i = 0; i < bites; i++) { // blocking is ineffective, and actually does more harm than
                            enemy.attack(player);
                            System.out.println("A rat bites " + player.getName() + " dealing 1 damage!");
                            Thread.sleep(500);
                        }
                        System.out.println(player.getName() + " has " + player.getHealthPoints() + " health!");
                        turnTimer = true;
                    } else {
                        Thread.sleep(1000);
                        System.out.println(player.getName() + "'s attempts to block were futile! In their panic" +
                                " more of the swarm closes in!");
                        Thread.sleep(1000);
                        for (int i = -2; i < bites; i++) {
                            enemy.attack(player);
                            System.out.println("A rat bites " + player.getName() + " dealing 1 damage!");
                            Thread.sleep(500);
                        }
                        System.out.println(player.getName() + " has " + player.getHealthPoints() + " health!");
                        block = false;
                        turnTimer = true;
                    }

                }
            }
            if (Objects.equals(enemy.getEnemyType(), "Jelly")) { // MUST BE INSERTED INTO THE BATTLE METHOD FOR TESTING
                while (!turnTimer) {
                    if (enemy.getHealthPoints() <= 0) {
                        player.setHealthPoints(player.getHealthPoints() + 12);
                        System.out.println("Attacking the Jelly only seemed to make a mess. A soothing mess!");
                        Thread.sleep(750);
                        System.out.println(player.getName() + " has been healed 12 Health Points" +
                                " leaving them with " + player.getHealthPoints());
                        Thread.sleep(750);
                        System.out.println(
                                "The Jelly begins to scale the side of the building, back to the safety of the roof.");
                        player.setAttack(player.getAttack + 3);
                        Thread.sleep(750);
                        System.out.println(player.getName() + " grows stronger! Their attack increased to " + player.getAttack + "!");
                        battle = false;
                        break;
                    }
                    if (!block) {
                        player.setHealthPoints(player.getHealthPoints() + 5);
                        System.out.println("The Jelly spritzes " + player.getName() + " with refreshing mist!");
                        Thread.sleep(750);
                        System.out.println(player.getName() + " has " + player.getHealthPoints() + " health!");
                        turnTimer = true;
                    } else {
                        Thread.sleep(750);
                        System.out.println("The Jelly wiggles playfully!");
                        block = false;
                        turnTimer = true;
                    }
                }
            }
        System.out.println("--------------------------------------------------------------------");
        }
    }

    private static void randGarg() { // this is just for conciseness
        Random rand = new Random();
        int randy = rand.nextInt(1, 3);
        Thread.sleep(1000);
        if (randy == 3) {
            System.out.println("The gargoyle bares its fangs.");
        } else if (randy == 2) {
            System.out.println("The gargoyle's stone body shakes and tremors.");
        } else {
            System.out.println("The gargoyle opens its clawed hand.");
        }
    }
}

    public static void bossBattle(Character enemy) {
        //attack variance would be super easy to add. just add rand.nextInt(0, 6) to an attack and boom some luck.
        boolean turnTimer = true;
        boolean battle = true;
        boolean block = false;
        int evil = 1;
        Character player = Main.playerCharacter;

        System.out.println("--------------------------------------------------------------------");
        Thread.sleep(2000);
        System.out.println(player.getName() + " grips their armament with resolve. The " + enemy.getName() + " stares with malice.");
        Scanner scanCool = new Scanner(System.in);

        while (battle) {

            label:
            while (turnTimer) {
                if (player.getHealthPoints() <= 0) {
                    System.out.println("The " + enemy.getName() + " overpowers " + player.getName() + ". The world is doomed.");
                    battle = false;
                    break;
                }
                Thread.sleep(2000);
                System.out.println("shall you (A)ttack or (B)lock?");
                String input = scanCool.nextLine();
                Thread.sleep(750);
                switch (input) {
                    case "a":
                        if (evil == 0) {
                            player.setAttack(player.getAttack() * 3);
                            player.attack(enemy);
                            player.setAttack(player.getAttack() / 3);
                            System.out.println(player.getName() + " blasts the " + enemy.getName() + " for "
                                    + (player.getAttack() * 3) + " damage leaving it with " + enemy.getHealthPoints() + " Health!");
                            turnTimer = false;
                            break;
                        } else {
                            player.attack(enemy);
                            System.out.println(player.getName() + " blasts the " + enemy.getName() + " for "
                                    + player.getAttack() + " damage leaving it with " + enemy.getHealthPoints() + " Health!");
                            turnTimer = false;
                            break;
                        }
                    case "b":
                        block = true;
                        System.out.println(player.getName() + " braces and prays for resilience");
                        turnTimer = false;
                        break;
                    default:
                        System.out.println("\"You're losing focus. You hold no power.\"");
                        player.setHealthPoints(player.getHealthPoints() - 3);
                        //don't take this one too seriously I just thought it was funny
                        break;
                }
                break;
            }

            if (Objects.equals(enemy.getEnemyType(), "basic")) {
                while (!turnTimer) {
                    Thread.sleep(750);
                    if (enemy.getHealthPoints() <= 0) {
                        System.out.println("The " + enemy.getName() + " falls to it's knees.");
                        battle = false;
                        System.out.println("--------------------------------------------------------------------");
                        break;

                    }
                    if (evil == 0) {
                        System.out.println("The " + enemy.getName() + " recovers from it's exposed state.");
                        Thread.sleep(500);
                        System.out.println("The " + enemy.getName() + " twists its head and attempts to breach " +
                                player.getName() + "'s mind.");
                        evil = 4;
                        turnTimer = true;
                        block = false;

                    }
                    else if (evil == 1) {
                        System.out.print("The " + enemy.getName() + " swings its gargantuan arms...");
                        if (block) {
                            enemy.attackButBlock(player);
                            Thread.sleep(1000);
                            System.out.println("Luckily it only grazes past " + player.getName() +"'s defense.");
                            Thread.sleep(500);
                            System.out.println(player.getName() + " has " + player.getHealthPoints() + " health.");
                            evil++;
                            turnTimer = true;
                            block = false;
                        } else {
                            enemy.attack(player);
                            Thread.sleep(1000);
                            System.out.println(" that pulverises " + player.getName() + " and launches them a fair distance away.");
                            Thread.sleep(500);
                            System.out.println(player.getName() + " has " + player.getHealthPoints() + " health.");
                            evil++;
                            turnTimer = true;
                        }
                    }
                    else if (evil == 2) {
                        System.out.println("The " + enemy.getName() + " prepares a mighty strike, however it lowers its");
                        System.out.println("ability to ward off prayer.");
                        evil++;
                        turnTimer = true;
                        block = false;

                    }
                    else if (evil == 3) {
                        System.out.println("The " + enemy.getName() + " strikes with a mix of mental and physical strength.");
                        if (block) {
                            Thread.sleep(1000);
                            System.out.println(player.getName() + "'s prayer seems to have made the creature vulnerable.");
                            Thread.sleep(750);
                            System.out.println("It pounds the ground leaving it crumbled and releases a terrifying shriek.");
                            evil = 0;
                            turnTimer = true;
                            block = false;
                        } else {
                            enemy.setAttack(enemy.getAttack() * 3);
                            enemy.attack(player);
                            enemy.setAttack(enemy.getAttack() / 3);
                            System.out.println(player.getName() + "'s mind is assaulted and their physical form is thoroughly thrashed.");
                            Thread.sleep(500);
                            System.out.println(player.getName() + " has " + player.getHealthPoints() + " health.");
                            evil++;
                            Thread.sleep(1000);
                            System.out.println("The " + enemy.getName() + " twists its head and attempts to breach " +
                                    player.getName() + "'s mind.");
                            turnTimer = true;

                        }

                    }
                    else if (evil == 4) {
                        if (block) {
                            System.out.println(player.getName() + " resists the onslaught and leaves unscathed.");
                            evil++;
                            Thread.sleep(1000);
                            System.out.println("The creature's holds a steadfast form.");
                            turnTimer = true;
                            block = false;
                        } else {
                        player.setAttack(player.getAttack() - 1);
                        System.out.println(player.getName() + "'s grip loosens. Their attack has become weaker.");
                        evil++;
                            Thread.sleep(1000);
                            System.out.println("The creature's holds a steadfast form.");
                            turnTimer = true;
                        }

                    }
                    else if (evil == 5) {
                        if (block) {
                            System.out.println("The " + enemy.getName() + " misguides your prayer and slightly recovers");
                            enemy.setHealthPoints(enemy.getHealthPoints() + 10);
                            evil = 1;
                            turnTimer = true;
                            block = false;
                        } else {
                            System.out.println(player.getName() + "'s attack overpowers the beast's bluff.");
                            evil = 1;
                            turnTimer = true;
                        }
                    }
                    }

                }
            }
        }
