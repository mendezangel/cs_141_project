public class Character {
    // Fields
    private String name;
    private int level;
    private int healthPoints;
    private int manaPoints;
    private final String characterClass;

    // Constructor
    public Character(String name, String characterClass) {
        this.name = name;
        this.level = 1;
        this.healthPoints = 100;
        this.manaPoints = 50;
        this.characterClass = characterClass;
    }

    // Methods
    public void attack(Character target) {
        System.out.println(this.name + " attacks " + target.getName() + "!");
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

    public String getCharacterClass() {
        return characterClass;
    }
}
