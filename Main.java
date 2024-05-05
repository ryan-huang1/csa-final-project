import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player(scanner); // Pass scanner to Player constructor
        Pet pet = new Pet(scanner); // Pass scanner to Pet constructor
        GameEngine gameEngine = new GameEngine(player, pet);
        HashMap<String, Double> hashMap = new HashMap<>();

        // Initialize the game
        gameEngine.initializeGame();

        // Game loop control variable
        boolean isRunning = true;

        // Main game loop
        while (isRunning) {
            showMenu();
            System.out.print("Enter your choice or 'clear' to clear screen: ");
            String input = scanner.nextLine().trim();
            System.out.println(); // Adds a new line after user input for visual separation

            // Check if the user wants to clear the terminal
            if ("clear".equalsIgnoreCase(input)) {
                clearScreen();
                continue; // Skip the rest of the loop and show the menu again
            }

            // Attempt to parse the input as an integer choice
            try {
                int choice = Integer.parseInt(input);

                // Process the user's input
                switch (choice) {
                    case 1:
                        gameEngine.feedPet();
                        break;
                    case 2:
                        gameEngine.playWithPet();
                        break;
                    case 3:
                        gameEngine.cleanPet();
                        break;
                    case 4:
                        gameEngine.showPetStats();
                        break;
                    case 5:
                        System.out.println("\nExiting game...");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please enter a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid command. Please enter a number or 'clear'.");
            }
        }

        // Close the scanner object
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Feed Pet");
        System.out.println("2. Play with Pet");
        System.out.println("3. Clean Pet");
        System.out.println("4. View Stats");
        System.out.println("5. Exit");
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
