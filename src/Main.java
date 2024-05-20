public class Main {
    public static void main(String[] args) {
        GameManager game = new GameManager();
        game.initializeGame();
        // GameManager class will have actual logic for game
        // the main method in Main class will pretty much only be doing
        // method calls / class instantiations
        Character character = new Character("Angel", "archer", 75, 5);
//        Character enemy = new Character("Bad Guy", "Really bad guy");
    }
}