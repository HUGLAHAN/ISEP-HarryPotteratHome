package com.hogwarts.game;

import com.hogwarts.belongings.*;
import com.hogwarts.character.*;
import com.hogwarts.spell.Spell;
import com.hogwarts.SortingHat.*;
import java.util.Random;
import java.util.Scanner;


public class Game {
    private Wizard wizard;
    private AbstractEnemy enemy;
    private int turnCount;
    private House house;

    public Game() {
        this.wizard = new Wizard("Harry Potter", 1, 100, 100);
        this.enemy = generateEnemy();
        this.turnCount = 1;
        Wand wand = new Wand(Core.PHOENIX_FEATHER, 11);
        this.wizard.setWand(wand);
        this.wizard.setHouse(SortingHat.sort());
        this.wizard.setPet(Pet.OWL);
        this.wizard.setManaPoints(100);
        this.wizard.setHealthPoints(100);
        this.wizard.learnSpell((Spell) Spell.AVADA_KEDAVRA);
        this.wizard.learnSpell((Spell) Spell.EXPELLIARMUS);
        this.wizard.addPotion(Potion.manaPotion);
        this.wizard.addPotion(Potion.healingPotion);
    }

    private AbstractEnemy generateEnemy() {
        Random random = new Random();
        int type = random.nextInt(4);
        if (type == 0) {
            return new Enemy("Goblin", 1, 50, 50);
        } else if (type == 1) {
            return new Enemy("Orc", 2, 75, 50);
        } else {
            return new Boss("Voldemort", 3, 120, 50);
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hogwarts Battle!");
        System.out.println("Your opponent is " + enemy.getName() + "!");
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
            if (choice == 1) {
                wizard.attack(enemy, 5);
            } else if (choice == 2) {
                wizard.defend();
            } else if (choice == 3) {
                Spell spell = Spell.chooseSpell();
                spell.setTarget(enemy);
                if (wizard.getManaPoints() >= 10) {
                    wizard.setManaPoints(wizard.getManaPoints() - 10);
                    spell.castSpell();
                }
                else {
                    System.out.println("You do not have enough Mana to cast this spell!");
                }
            } else if (choice == 4) {
                System.out.println("Which potion will you drink?");
                System.out.println("1. Mana potion (+30 Mana)");
                System.out.println("2. Health potion (+50 Health)");
                int potionChoice = scanner.nextInt();
                if (potionChoice == 1) {
                    wizard.usemanaPotion(Potion.manaPotion, 30);
                } else if (potionChoice == 2) {
                    wizard.useheathPotion(Potion.healingPotion, 50);
                } else {
                    System.out.println("Invalid");
                }
            }
            turnCount = turnCount + 1;
            enemy.attack(wizard, 10);
        }
    }
}