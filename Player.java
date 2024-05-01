import java.util.Scanner;

public class Player {
    private String name;
    private int score;

    public Player(Scanner scanner) {
        System.out.print("Enter your name: ");
        this.name = scanner.nextLine();
        this.score = 0;
    }

    // Initialize player with a name
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    // Method to increase the player's score
    public void increaseScore(int points) {
        score += points;
        System.out.println(name + "'s current score: " + score);
    }

    // Method to reset the player's score
    public void resetScore() {
        score = 0;
    }

    // Method to initialize player data
    public void initializePlayer() {
        // Additional initialization logic can be added here
        System.out.println("Welcome, " + name + "! Your adventure begins.");
    }

    // Getter and setter for the player's name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter for the player's score
    public int getScore() {
        return score;
    }

    // Setter for the player's score
    public void setScore(int score) {
        this.score = score;
    }
}
