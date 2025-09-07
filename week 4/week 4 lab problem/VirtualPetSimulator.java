import java.util.*;

/**
 * VirtualPetSimulator.java
 * Single-file demo for the VirtualPet class and a small daycare simulation.
 */
public class VirtualPetSimulator {
    public static void main(String[] args) {
        List<VirtualPet> daycare = new ArrayList<>();
        daycare.add(new VirtualPet());                              // Egg
        daycare.add(new VirtualPet("Fluffy"));                      // Baby
        daycare.add(new VirtualPet("Draco", "Dragon"));             // Child
        daycare.add(new VirtualPet("Luna", "Cat", 15, 80, 90, "Teen"));// Full ctor

        Random rnd = new Random();

        System.out.println("Starting Daycare Simulation...\n");
        for (int day = 1; day <= 7; day++) {
            System.out.println("=== Day " + day + " ===");
            for (VirtualPet pet : daycare) {
                // random care action
                int action = rnd.nextInt(4); // 0: feed, 1: play, 2: heal, 3: nothing
                switch (action) {
                    case 0 -> pet.feedPet();
                    case 1 -> pet.playWithPet();
                    case 2 -> pet.healPet();
                }
                pet.simulateDay();
                System.out.println(pet.getPetStatus());
            }

            // Ghosts can haunt others (twist)
            for (VirtualPet ghost : daycare) {
                if (ghost.isGhost()) {
                    for (VirtualPet other : daycare) {
                        if (other != ghost && !other.isGhost()) {
                            ghost.haunt(other);
                        }
                    }
                }
            }

            System.out.println();
        }

        System.out.println("Simulation ended.");
        System.out.println("Total pets created: " + VirtualPet.getTotalPetsCreated());
    }
}

/* -------- VirtualPet class -------- */
class VirtualPet {
    private final String petId;
    private String petName;
    private String species;
    private int age;
    private int happiness; // 0-100
    private int health;    // 0-100
    private String stage;

    static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    private static int totalPetsCreated = 0;

    // Full constructor (main target of chaining)
    public VirtualPet(String name, String species, int age, int happiness, int health, String stage) {
        this.petId = generatePetId();
        this.petName = (name == null || name.isBlank()) ? "Unnamed Pet" : name;
        this.species = (species == null || species.isBlank()) ? "Unknown" : species;
        this.age = Math.max(0, age);
        this.happiness = clamp(happiness);
        this.health = clamp(health);
        this.stage = (stage == null || stage.isBlank()) ? deduceStageByAge(this.age) : stage;
        totalPetsCreated++;
    }

    // Child constructor -> starts as Child
    public VirtualPet(String name, String species) {
        this(name, species, 3, 60, 60, EVOLUTION_STAGES[2]); // age 3 -> Child
    }

    // Baby constructor
    public VirtualPet(String name) {
        this(name, "Unknown", 1, 50, 50, EVOLUTION_STAGES[1]);
    }

    // Egg constructor (default)
    public VirtualPet() {
        this("Mysterious Egg", randomSpecies(), 0, 30, 30, EVOLUTION_STAGES[0]);
    }

    // Utilities
    public static String generatePetId() {
        return "PET-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private static String randomSpecies() {
        String[] list = {"Dragon", "Cat", "Dog", "Phoenix", "Unicorn"};
        return list[new Random().nextInt(list.length)];
    }

    public static int getTotalPetsCreated() {
        return totalPetsCreated;
    }

    private int clamp(int v) {
        return Math.max(0, Math.min(100, v));
    }

    private String deduceStageByAge(int age) {
        if (age <= 0) return EVOLUTION_STAGES[0];
        if (age < 3) return EVOLUTION_STAGES[1];
        if (age < 8) return EVOLUTION_STAGES[2];
        if (age < 15) return EVOLUTION_STAGES[3];
        if (age < 35) return EVOLUTION_STAGES[4];
        return EVOLUTION_STAGES[5];
    }

    // Evolve based on age and care (health/happiness)
    public void evolvePet() {
        if (isGhost()) return; // Ghost cannot evolve
        // If low happiness/health then slower evolution (skip)
        if (health < 20 || happiness < 20) return;

        String newStage = deduceStageByAge(this.age);
        this.stage = newStage;
    }

    // Actions
    public void feedPet() {
        if (isGhost()) return;
        health = clamp(health + 10);
        happiness = clamp(happiness + 5);
    }

    public void playWithPet() {
        if (isGhost()) return;
        happiness = clamp(happiness + 12);
        health = clamp(health - 2); // a bit tired
    }

    public void healPet() {
        if (isGhost()) return;
        health = clamp(health + 20);
    }

    // Simulate a day passing: age, random stat changes, evolution or death
    public void simulateDay() {
        if (isGhost()) return; // ghosts don't age
        age++;
        Random r = new Random();
        happiness = clamp(happiness - r.nextInt(5)); // small drop
        health = clamp(health - r.nextInt(7));       // small random damage

        if (health <= 0) {
            // pet dies -> turns into Ghost
            species = "Ghost";
            stage = "Ghost";
            health = 0;
            happiness = Math.max(0, happiness / 2); // ghosts lose some happiness
            return;
        }

        // Try to evolve if conditions permit
        evolvePet();
    }

    public String getPetStatus() {
        return String.format("%s [%s] - Age:%d Stage:%s Health:%d Happiness:%d ID:%s",
                petName, species, age, stage, health, happiness, petId);
    }

    public boolean isGhost() {
        return "Ghost".equalsIgnoreCase(this.species);
    }

    // Ghost special: haunt other pets reducing their happiness slightly
    public void haunt(VirtualPet other) {
        if (!isGhost() || other == null || other.isGhost()) return;
        other.happiness = other.clamp(other.happiness - 5);
    }
}
