package com.hogwarts.game;

import com.hogwarts.character.*;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player;
    private AbstractEnemy enemy;
    private int turnCount;

    public Game() {
        this.player = new Player("Harry Potter", 1, 100, 50);
        this.enemy = generateEnemy();
        this.turnCount = 1;
    }

    private AbstractEnemy generateEnemy() {
        Random random = new Random();
        int type = random.nextInt(2);
        if (type == 0) {
            return new Enemy("Goblin", 50, 10);
        } else if (type == 1) {
            return new Enemy("Orc", 75, 15);
        } else {
            return new Boss("Voldemort", 100, 20, 50, 50);
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hogwarts Battle!");
        System.out.println("Your opponent is " + enemy.getName() + "!");
        while (player.getCurrentHealth() > 0 && enemy.getCurrentHealth() > 0) {
            System.out.println("Turn " + turnCount + "!");
            System.out.println("Your HP: " + player.getCurrentHealth() + "/" + player.getMaxHealth());
            System.out.println("Your Mana: " + player.getManaPoints());
            System.out.println(enemy.getName() + "'s HP: " + enemy.getCurrentHealth() + "/" + enemy.getMaxHealth());
            System.out.println("What will you do?");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Cast a spell (costs 10 Mana)");
            int choice = scanner.nextInt();
            if (choice == 1) {
                player.attack(enemy);
            } else if (choice == 2) {
                player.defend();
            } else if (choice == 3) {
                player.castSpell(enemy, 10, 20);
            }
            turnCount = turnCount +1;
        }
    }
}
