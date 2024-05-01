import java.util.Scanner;

public class Pet {
    private String name;
    private int health;
    private int hunger;
    private int happiness;
    private int cleanliness;

    public Pet(Scanner scanner) {
        System.out.print("What is your pet's name? ");
        this.name = scanner.nextLine();

        // Set initial values to encourage player interaction:
        this.health = 100;
        this.hunger = 70; // Close to hungry, encourages feeding
        this.happiness = 35; // Low, encourages playing
        this.cleanliness = 25; // Low, needs cleaning
    }

    public void decrementStats() {
        // Decrement stats slightly to simulate passing time
        hunger += 5; // Pet gets hungrier
        happiness -= 5; // Pet gets less happy
        cleanliness -= 5; // Pet gets dirtier

        // Ensure stats do not go out of valid range
        hunger = Math.min(hunger, 100);
        happiness = Math.max(happiness, 0);
        cleanliness = Math.max(cleanliness, 0);
    }

    public void initializeStats() {
        // Reset or initialize pet stats at the beginning of the game or after pet
        // revival
        health = 100;
        hunger = 70;
        happiness = 35;
        cleanliness = 25;
    }

    public void eatFood() {
        if (isHungry()) {
            hunger -= 20;
            happiness += 10;
            health += 5;
            System.out.println(name + " enjoyed the food! " + name + " is happy and healthier!");
        } else {
            System.out.println(name + " is too full to eat more right now.");
        }
        updateHealth();
    }

    public void play() {
        if (happiness < 100 && happiness >= 80) {
            happiness = 100;
            System.out.println("You lightly played with " + name + ". " + name + " is perfectly happy now!");
        } else if (isBored()) {
            happiness += 20;
            hunger += 10;
            System.out.println("You played with " + name + ". " + name + " is having a lot of fun!");
        } else {
            System.out.println(name + " is very happy right now and doesn't feel like playing.");
        }
        updateHealth();
    }

    public void clean() {
        if (isDirty()) {
            cleanliness = 100;
            happiness += 5;
            System.out.println("You cleaned " + name + ". " + name + " looks shiny and is a bit happier!");
        } else {
            System.out.println(name + " is already quite clean.");
        }
        updateHealth();
    }

    public boolean isHungry() {
        return hunger >= 70;
    }

    public boolean isBored() {
        return happiness < 50; // Adjusted to allow more frequent interaction
    }

    public boolean isDirty() {
        return cleanliness <= 30;
    }

    private void updateHealth() {
        // Adjust health based on other factors
        if (hunger < 30 || cleanliness < 30) {
            health -= 5;
            System.out.println(name + " is feeling a bit under the weather. Better take care of their needs!");
        }
        if (happiness > 70) {
            health += 5;
            System.out.println(name + " is quite happy, which makes them healthier!");
        }
        if (health > 100) {
            health = 100;
        }
        if (health < 0) {
            health = 0;
            System.out.println(name + " is in poor health! Immediate care is needed.");
        }
    }

    // Getters to access pet's current stats
    public int getHealth() {
        return health;
    }

    public int getHungerLevel() {
        return hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    // Getter for pet's name
    public String getName() {
        return name;
    }
}
