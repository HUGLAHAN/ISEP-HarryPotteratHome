package com.hogwarts.spell;

import com.hogwarts.SortingHat.SortingHat;
import com.hogwarts.belongings.House;
import com.hogwarts.character.Character;
import com.hogwarts.SortingHat.SortingHat;
import com.hogwarts.character.Wizard;
import com.hogwarts.game.Game;


import java.util.Random;
import java.util.Scanner;

public class Spell extends AbstractSpell {

    public static final Spell AVADA_KEDAVRA = new Spell("Avada Kedavra", 1, 0.82, 100);
    public static final Spell EXPELLIARMUS = new Spell("Expelliarmus", 1, 0.92, 30);
    public static final Spell INCENDIO = new Spell("Incendio", 1, 0.92, 50);
    public static final Spell WINGARDIUM_LEVIOSA = new Spell("Wingardium Leviosa", 1, 0.97, 20);
    public static final Spell ACCIO = new Spell("Accio", 1, 0.97, 40);
    public static final Spell EXPECTO_PATRONUM = new Spell("Expecto Patronum", 1, 0.90, 80);
    public static final Spell SECTUMSEMPRA = new Spell("Sectumsempra", 1, 0.86, 70);

    public Spell(String name, int level, double successRate, int spellPower) {
        super(name, level, successRate, spellPower);
    }

    public static Spell chooseSpell() {
        System.out.println("Choose a spell:");
        System.out.println("1. Avada Kedavra");
        System.out.println("2. Expelliarmus");
        System.out.println("3. Incendio");
        System.out.println("4. Wingardium Leviosa");
        System.out.println("5. Accio");
        System.out.println("6. Expecto Patronum");
        System.out.println("7. Sectumsempra");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return AVADA_KEDAVRA;
            case 2:
                return EXPELLIARMUS;
            case 3:
                return INCENDIO;
            case 4:
                return WINGARDIUM_LEVIOSA;
            case 5:
                return ACCIO;
            case 6:
                return EXPECTO_PATRONUM;
            case 7:
                return SECTUMSEMPRA;
            default:
                System.out.println("Invalid choice, please choose again.");
                return chooseSpell();
        }
    }
    @Override
    public void castSpell() {
        Random random = new Random();
        double rand = random.nextDouble();
//        System.out.println(successRate);
//        System.out.println(rand);
        if (rand <= successRate) {
            Character target = getTarget();
            int spellPower = getSpellPower();
            if (target == null) {
                System.out.println(getName() + "'s spell has no effect, no target selected!");
                return;
            }
//            System.out.println(House.SLYTHERIN);
    //        System.out.println(house);
    //        house = wizard.getHouse();
    //        if (house == House.SLYTHERIN) {
    //            System.out.println("Slytherin");
    //            spellPower *= 1.3; // Coefficient multiplicateur de 1.3 pour les sorts utilisées par les membres de Slytherin.
    //        }

            int damage = spellPower - target.getDefense();
            if (damage <= 0) {
                System.out.println(getName() + "'s spell was ineffective against " + target.getName() + "!");
            } else {
                System.out.println(getName() + " casts a spell on " + target.getName() + " for " + damage + " damage!");
                target.takeDamage(damage);
            }
        } else {
            System.out.println("Spell " + getName() + " failed to cast!");
        }
    }
}
