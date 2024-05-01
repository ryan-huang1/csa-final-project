import java.util.Scanner;

public class Player {
    private String[] names; // Array to store player names
    private int[] scores; // Array to store player scores
    private int playerCount; // Counter for the number of players

    public Player(Scanner scanner) {
        names = new String[10]; // Assuming a maximum of 10 players for simplicity
        scores = new int[10]; // Corresponding scores array
        playerCount = 0; // Initialize player count

        System.out.print("Enter your name: ");
        addPlayer(scanner.nextLine());
    }

    // Method to add a player
    public void addPlayer(String name) {
        if (playerCount < names.length) {
            names[playerCount] = name;
            scores[playerCount] = 0; // Initialize score to 0
            playerCount++; // Increment the count of players
            System.out.println("Welcome, " + name + "! Your adventure begins.");
        } else {
            System.out.println("Maximum player limit reached.");
        }
    }

    // Method to increase the player's score
    public void increaseScore(int index, int points) {
        if (index < playerCount) {
            scores[index] += points;
            System.out.println(names[index] + "'s current score: " + scores[index]);
        } else {
            System.out.println("Invalid player index.");
        }
    }

    // Method to reset the player's score
    public void resetScore(int index) {
        if (index < playerCount) {
            scores[index] = 0;
        } else {
            System.out.println("Invalid player index.");
        }
    }

    // Getter for the player's name
    public String getName(int index) {
        if (index < playerCount) {
            return names[index];
        } else {
            return "Invalid player index.";
        }
    }

    // Getter for the player's score
    public int getScore(int index) {
        if (index < playerCount) {
            return scores[index];
        } else {
            return -1; // Indicates an error
        }
    }

    // Initialize player at the specified index if they have not been initialized
    public void initializePlayerAtIndex(int index) {
        if (index < playerCount) {
            System.out.println("Welcome, " + names[index] + "! Your adventure begins.");
        } else {
            System.out.println("Player index out of bounds.");
        }
    }
}
