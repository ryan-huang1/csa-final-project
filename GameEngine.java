public class GameEngine {
    private Pet pet;
    private Player player;

    public GameEngine(Player player, Pet pet) {
        this.pet = pet; // Use the passed Pet object
        this.player = player; // Use the passed Player object
    }

    public void initializeGame() {
        System.out.println("\nWelcome to Virtual Tamagotchi!");
        pet.initializeStats();
        player.initializePlayer();
    }

    public void feedPet() {
        if (pet.isHungry()) {
            pet.eatFood();
            player.increaseScore(10); // Reward the player for taking care of the pet
        } else {
            System.out.println("Pet is not hungry right now.\n");
        }
    }

    public void playWithPet() {
        if (pet.isBored()) {
            pet.play();
            player.increaseScore(15); // Reward for playing with the pet
        } else {
            System.out.println("Pet doesn't feel like playing right now.\n");
        }
    }

    public void cleanPet() {
        if (pet.isDirty()) {
            pet.clean();
            player.increaseScore(8); // Reward for cleaning the pet
        } else {
            System.out.println("Pet is already clean.\n");
        }
    }

    public void showPetStats() {
        System.out.println("\nPet Stats:");
        System.out.println("Health: " + pet.getHealth());
        System.out.println("Hunger: " + pet.getHungerLevel());
        System.out.println("Happiness: " + pet.getHappiness());
        System.out.println("Cleanliness: " + pet.getCleanliness());

        if (pet.getHealth() == 100 && pet.getHungerLevel() == 50 && pet.getHappiness() == 100
                && pet.getCleanliness() == 100) {
            System.out.println(pet.getName() + " is in perfect condition! Maybe it's time to teach " + pet.getName()
                    + " new tricks or explore new activities.\n");
        }
    }
}
