package com.hogwarts.character;

import java.util.Random;

public class Enemy extends AbstractEnemy {

    public Enemy(String name, int level,int healthPoints, int manaPoints) {
        super(name, level, healthPoints, manaPoints);
    }


    @Override
    public void takeDamage(int damage) {
        int actualDamage = Math.max(damage - getDefense(), 0);
        setCurrentHealth(getCurrentHealth() - actualDamage);
        System.out.println(getName() + " a subi " + actualDamage + " points de dégâts.");
        if (getCurrentHealth() <= 0) {
            die();
        }
    }

    @Override
    public void attack(Character character, int attackPower) {
        int damage = attackPower - character.getDefense();
        character.takeDamage(damage);
        System.out.println(getName() + " attaque " + character.getName() + " pour " + damage + " dégâts.");
        }

    public static AbstractEnemy generateEnemy() {
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

    public static AbstractEnemy EnemyLevel1() {
        return new Enemy("Troll", 1, 200, 0);
    }
}
