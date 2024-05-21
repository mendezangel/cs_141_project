import java.util.Scanner;

public class Character {
    // Fields
    private String name;
    private int level;
    private int healthPoints;
    private int manaPoints;
    private int attack;
    private int defense;
    private String enemyType;

    // Constructor
    public Character(String name, int hp, int attack, String enemyType) {
        // some of these values (health, mana, attack) are hardcoded, in theory we will
        // want to implement some logic to set these values based on what class player chooses
        this.name = name;
        this.level = 1;
        this.healthPoints = hp;
        this.manaPoints = 50;
        this.attack = attack;
        this.enemyType = enemyType;
    }

    // Methods
    public static Character createPlayerCharacter() {
        Scanner console = new Scanner(System.in);
        System.out.print("please enter name for character: ");
        String name = console.next();
        int hp = 100;
        int attack = 5;
        return  new Character(name, hp, attack, null);
    }

    // Attack methods
    public void attack(Character target) {
        System.out.println(this.name + " attacks " + target.getName() + "!");
        int health = target.getHealthPoints();
        int newHealth = health - this.attack;
        target.setHealthPoints(newHealth);
        // Implement attack logic here
    }

    public void castSpell(Character target) {
        if (this.manaPoints >= 10) {
            System.out.println(this.name + " casts a spell on " + target.getName() + "!");
            // Implement spell casting logic here
            this.manaPoints -= 10;
        } else {
            System.out.println("Not enough mana to cast a spell!");
        }
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }


    public String getEnemyType() {
        return this.enemyType;
    }

    public void setEnemyType(String enemyType) {
        this.enemyType = enemyType;
    }
}
