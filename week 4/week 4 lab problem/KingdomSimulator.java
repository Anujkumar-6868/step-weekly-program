import java.util.*;

/**
 * KingdomSimulator.java
 * Demonstrates MagicalStructure hierarchy, interactions, and a KingdomManager.
 */
public class KingdomSimulator {
    public static void main(String[] args) {
        MagicalStructure[] structures = new MagicalStructure[] {
                new WizardTower("North Tower"),                                   // default tower
                new WizardTower("Arcane Spire", new String[]{"Spark","Bolt"}),    // with spells
                new MysticLibrary("Grand Library", 120, "Old Quarter", true, 1200, "Elderspeech"),
                new EnchantedCastle("Stonekeep", 80, "Hill", true, 300, true),
                new DragonLair("Drake's Den", 200, "Volcanic Cave", true, "Red Drake", 5000)
        };

        KingdomManager manager = new KingdomManager(Arrays.asList(structures));
        manager.printSummary();

        System.out.println("\nKingdom total magic power: " + KingdomUtils.calculateKingdomMagicPower(structures));

        System.out.println("\nSample interactions:");
        System.out.println(KingdomUtils.performMagicBattle(structures[0], structures[4])); // tower vs dragon
        System.out.println(KingdomUtils.performMagicBattle(structures[3], structures[4])); // castle vs dragon (special)
        System.out.println(KingdomUtils.performMagicBattle(structures[1], structures[2])); // tower + library (knowledge boost)
    }
}

/* --------- Abstract base --------- */
abstract class MagicalStructure {
    protected String structureName;
    protected int magicPower;
    protected String location;
    protected boolean isActive;

    public MagicalStructure(String name, int magicPower, String location, boolean isActive) {
        this.structureName = (name == null || name.isBlank()) ? "Unnamed" : name;
        this.magicPower = Math.max(0, magicPower);
        this.location = (location == null) ? "Unknown" : location;
        this.isActive = isActive;
    }

    // convenience ctor
    public MagicalStructure(String name) {
        this(name, 50, "Unknown", true);
    }

    public String getName() { return structureName; }
    public int getMagicPower() { return magicPower; }
    public boolean isActive() { return isActive; }

    public abstract String castMagicSpell();
}

/* --------- WizardTower --------- */
class WizardTower extends MagicalStructure {
    private int spellCapacity;
    private List<String> knownSpells;

    public WizardTower(String name) {
        this(name, 60, "Tower District", true, 10, new String[]{"Spark"});
    }

    public WizardTower(String name, String[] spells) {
        this(name, 70, "Tower District", true, Math.max(5, spells.length * 2), spells);
    }

    public WizardTower(String name, int magicPower, String location, boolean isActive, int spellCapacity, String[] spells) {
        super(name, magicPower, location, isActive);
        this.spellCapacity = Math.max(1, spellCapacity);
        this.knownSpells = new ArrayList<>();
        if (spells != null) Collections.addAll(this.knownSpells, spells);
        if (this.knownSpells.isEmpty()) this.knownSpells.add("Spark");
    }

    public int getSpellCapacity() { return spellCapacity; }
    public List<String> getKnownSpells() { return Collections.unmodifiableList(knownSpells); }

    @Override
    public String castMagicSpell() {
        // return a random known spell (or default)
        String spell = knownSpells.get(new Random().nextInt(knownSpells.size()));
        return structureName + " casts " + spell + " (capacity " + spellCapacity + ")";
    }
}

/* --------- EnchantedCastle --------- */
class EnchantedCastle extends MagicalStructure {
    private int defenseRating;
    private boolean hasDrawbridge;

    public EnchantedCastle(String name) {
        this(name, 70, "Castle Grounds", true, 50, true);
    }

    public EnchantedCastle(String name, int magicPower, String location, boolean isActive, int defenseRating, boolean hasDrawbridge) {
        super(name, magicPower, location, isActive);
        this.defenseRating = Math.max(0, defenseRating);
        this.hasDrawbridge = hasDrawbridge;
    }

    public int getDefenseRating() { return defenseRating; }

    @Override
    public String castMagicSpell() {
        return structureName + " raises protective wards (defense " + defenseRating + ")";
    }
}

/* --------- MysticLibrary --------- */
class MysticLibrary extends MagicalStructure {
    private int bookCount;
    private String ancientLanguage;

    public MysticLibrary(String name, int magicPower, String location, boolean isActive, int bookCount, String ancientLanguage) {
        super(name, magicPower, location, isActive);
        this.bookCount = Math.max(0, bookCount);
        this.ancientLanguage = (ancientLanguage == null) ? "Old Tongue" : ancientLanguage;
    }

    public int getBookCount() { return bookCount; }

    @Override
    public String castMagicSpell() {
        return structureName + " invokes knowledge (" + bookCount + " tomes in " + ancientLanguage + ")";
    }
}

/* --------- DragonLair --------- */
class DragonLair extends MagicalStructure {
    private String dragonType;
    private int treasureValue;

    public DragonLair(String name, int magicPower, String location, boolean isActive, String dragonType, int treasureValue) {
        super(name, magicPower, location, isActive);
        this.dragonType = (dragonType == null) ? "Unknown Drake" : dragonType;
        this.treasureValue = Math.max(0, treasureValue);
    }

    public int getTreasureValue() { return treasureValue; }

    @Override
    public String castMagicSpell() {
        return structureName + " unleashes dragon breath (" + dragonType + ")";
    }
}

/* --------- Utility interactions --------- */
class KingdomUtils {
    // Simple interaction rule: both must be active
    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        return s1 != null && s2 != null && s1.isActive() && s2.isActive();
    }

    // Perform a "battle" using magicPower + special bonuses; uses instanceof to apply combos
    public static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (!canStructuresInteract(attacker, defender)) {
            return "Interaction not possible (one or both inactive).";
        }

        double attackPower = attacker.getMagicPower();
        double defensePower = defender.getMagicPower();

        // Special combos and bonuses:
        // WizardTower + MysticLibrary => Knowledge boost (tower attack increases)
        if (attacker instanceof WizardTower && defender instanceof MysticLibrary) {
            WizardTower tower = (WizardTower) attacker;
            attackPower += tower.getSpellCapacity() * 2; // knowledge boost from library synergy
        }
        if (attacker instanceof MysticLibrary && defender instanceof WizardTower) {
            attackPower += ((MysticLibrary) attacker).getBookCount() / 50.0;
        }

        // Castle + DragonLair => Dragon guard (if castle defending a lair, defense triples)
        if (defender instanceof EnchantedCastle && attacker instanceof DragonLair) {
            defensePower *= 3;
        }
        if (defender instanceof DragonLair && attacker instanceof EnchantedCastle) {
            // castle attack vs dragon: castle gets defense->attack bonus
            attackPower += ((EnchantedCastle) attacker).getDefenseRating() * 0.5;
        }

        // Multiple towers / networks could be handled outside; we keep pairwise logic here.

        // Final decision
        String result;
        if (attackPower > defensePower * 1.05) {
            result = attacker.getName() + " (attack " + (int)attackPower + ") defeats " + defender.getName() + " (defense " + (int)defensePower + ").";
        } else if (defensePower > attackPower * 1.05) {
            result = defender.getName() + " (defense " + (int)defensePower + ") holds against " + attacker.getName() + " (attack " + (int)attackPower + ").";
        } else {
            result = attacker.getName() + " and " + defender.getName() + " are evenly matched; stalemate.";
        }
        return result;
    }

    // Sum kingdom magic power plus small synergies
    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int total = 0;
        int towerCount = 0;
        int libraryBooks = 0;
        for (MagicalStructure s : structures) {
            if (s == null || !s.isActive()) continue;
            total += s.getMagicPower();
            if (s instanceof WizardTower) towerCount++;
            if (s instanceof MysticLibrary) libraryBooks += ((MysticLibrary)s).getBookCount();
        }
        // synergy: multiple towers create a network adding 10% per extra tower
        if (towerCount > 1) total += total * (towerCount - 1) / 10;
        // library knowledge adds small boost
        total += libraryBooks / 100;
        return total;
    }
}

/* --------- KingdomManager --------- */
class KingdomManager {
    private final List<MagicalStructure> structures;

    public KingdomManager(List<MagicalStructure> structures) {
        this.structures = new ArrayList<>(structures);
    }

    public void printSummary() {
        List<WizardTower> towers = new ArrayList<>();
        List<EnchantedCastle> castles = new ArrayList<>();
        List<MysticLibrary> libraries = new ArrayList<>();
        List<DragonLair> lairs = new ArrayList<>();

        for (MagicalStructure s : structures) {
            if (s instanceof WizardTower) towers.add((WizardTower)s);
            else if (s instanceof EnchantedCastle) castles.add((EnchantedCastle)s);
            else if (s instanceof MysticLibrary) libraries.add((MysticLibrary)s);
            else if (s instanceof DragonLair) lairs.add((DragonLair)s);
        }

        System.out.println("Kingdom Summary:");
        System.out.println(" Towers: " + towers.size());
        System.out.println(" Castles: " + castles.size());
        System.out.println(" Libraries: " + libraries.size());
        System.out.println(" Dragon Lairs: " + lairs.size());

        // Simple tax calculation by type (magicPower-based)
        double totalTax = 0;
        for (MagicalStructure s : structures) {
            double rate = getTaxRateFor(s);
            totalTax += s.getMagicPower() * rate / 100.0;
        }
        System.out.printf("Estimated annual magical tax income: %.2f units\n", totalTax);

        // Kingdom specialization
        int totalMagic = structures.stream().filter(Objects::nonNull).mapToInt(MagicalStructure::getMagicPower).sum();
        int totalDefense = castles.stream().mapToInt(EnchantedCastle::getDefenseRating).sum();
        String specialization;
        if (totalMagic > totalDefense * 2) specialization = "Magic-focused";
        else if (totalDefense > totalMagic) specialization = "Defense-focused";
        else specialization = "Balanced";
        System.out.println("Kingdom specialization: " + specialization);
    }

    private double getTaxRateFor(MagicalStructure s) {
        if (s instanceof WizardTower) return 12.0;
        if (s instanceof EnchantedCastle) return 8.0;
        if (s instanceof MysticLibrary) return 5.0;
        if (s instanceof DragonLair) return 15.0;
        return 10.0;
    }
}
