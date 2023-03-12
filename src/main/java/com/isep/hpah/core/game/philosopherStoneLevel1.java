package com.isep.hpah.core.game;

import com.isep.hpah.core.SortingHat.SortingHat;
import com.isep.hpah.core.belongings.*;
import com.isep.hpah.core.character.AbstractEnemy;
import com.isep.hpah.core.character.Enemy;
import com.isep.hpah.core.character.Wizard;
import com.isep.hpah.core.spell.Spell;

import java.util.Scanner;

public class philosopherStoneLevel1 {
    public static Wizard wizard;
    // on est passe de private a public
    private AbstractEnemy enemy;
    private int turnCount;
    public House house;
    // on est passe de private a public

    public philosopherStoneLevel1() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your wizard's name?");
        String wizardName = scanner.nextLine();

        System.out.println("Choose your wand core:");
        for (Core core : Core.values()) {
            System.out.println((core.ordinal() + 1) + ". " + core.name().toLowerCase().replace('_', ' '));
        }
        int coreChoice = scanner.nextInt();
        Core wandCore = Core.values()[coreChoice - 1];
        Wand wand = new Wand(wandCore, 10);


        this.wizard = new Wizard(wizardName, 1, 100, 100);
        this.wizard.setWand(wand);
        this.wizard.setHouse(SortingHat.sort());
        this.wizard.setPet(Pet.OWL);
        this.wizard.setManaPoints(100);
        this.wizard.setHealthPoints(100);
        this.wizard.learnSpell((Spell) Spell.AVADA_KEDAVRA);
        this.wizard.learnSpell((Spell) Spell.EXPELLIARMUS);
        this.wizard.addPotion(Potion.manaPotion);
        this.wizard.addPotion(Potion.healingPotion);

        this.enemy = Enemy.EnemyLevel1();
        this.turnCount = 1;

        System.out.println("Wizard " + wizardName + " has been created and equipped with a wand with a " + wandCore + " like core.");

    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to The Philosopher's Stone level!");
        System.out.println("You are in the toilets of the dungeon.");
        System.out.println("Your enemy is a troll.");
        System.out.println("To defeat the troll, you must use Wingardium Leviosa to drop objects on its head.");
        System.out.println("Press any key to start the level...");
        scanner.nextLine();

        while (wizard.getCurrentHealth() > 0 && enemy.getCurrentHealth() > 0) {
            System.out.println("Turn " + turnCount + "!");
            System.out.println("Your HP: " + wizard.getCurrentHealth() + "/" + wizard.getMaxHealthPoints());
            System.out.println("Your Mana: " + wizard.getManaPoints() + "/" + wizard.getMaxManaPoints());
            System.out.println(enemy.getName() + "'s HP: " + enemy.getCurrentHealth() + "/" + enemy.getMaxHealthPoints());
            System.out.println("What will you do?");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Cast a spell (costs 10 Mana)");
            System.out.println("4. Drink a potion");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    wizard.attack(enemy, 5);
                    break;
                case 2:
                    wizard.defend();
                    break;
                case 3:
                    Spell spell = Spell.chooseSpell();
                    spell.setTarget(enemy);
//                    System.out.println(spell);
//                    System.out.println(Spell.WINGARDIUM_LEVIOSA);
                    if (spell == Spell.WINGARDIUM_LEVIOSA) {
                        if (wizard.getManaPoints() >= 10) {
                            wizard.setManaPoints(wizard.getManaPoints() - 10);
                            spell.castSpell();
                        } else {
                            System.out.println("You do not have enough Mana to cast this spell!");
                        }
                    }else {
                        System.out.println("You do not choose the right spell!");
                        System.out.println("You do not know how to use this spell!");
                        System.out.println("You should use Wingardium Leviosa.");
                    }
                    break;
                case 4:
                    System.out.println("Which potion will you drink?");
                    System.out.println("1. Mana potion (+30 Mana)");
                    System.out.println("2. Health potion (+50 Health)");
                    int potionChoice = scanner.nextInt();
                    if (potionChoice == 1) {
                        wizard.usemanaPotion(Potion.manaPotion, 30);
                    } else if (potionChoice == 2) {
                        wizard.useheathPotion(Potion.healingPotion, 50);
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

            if (wizard.getCurrentHealth() > 0 && enemy.getCurrentHealth() > 0) {
                turnCount++;
                if (wizard.house == House.GRYFFINDOR) {
                    enemy.attack(wizard, 8);
                } else {
                    enemy.attack(wizard, 10);
                }
            }

            if (wizard.getCurrentHealth() <= 0) {
                System.out.println("You are dead");
                break;
            }
            if (enemy.getCurrentHealth() <= 0) {
                wizard.chooseUpgrade();
            }
        }

    }
}
