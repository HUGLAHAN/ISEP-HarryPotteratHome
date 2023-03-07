package com.hogwarts.character;

import java.util.Random;

public abstract class AbstractEnemy extends Character {

    public AbstractEnemy(String name,int level, int healthPoints, int manaPoints) {
        super(name,level, healthPoints, manaPoints);
    }

    public void attack(Character character, int attackPower) {
        int damage = attackPower - character.getDefense();
        character.takeDamage(damage);
        System.out.println(getName() + " attaque " + character.getName() + " pour " + damage + " dégâts.");
    }

    public void takeDamage(int damage) {
        int actualDamage = Math.max(damage - getDefense(), 0);
        setCurrentHealth(getCurrentHealth() - actualDamage);
        System.out.println(getName() + " a subi " + actualDamage + " points de dégâts.");
        if (getCurrentHealth() <= 0) {
            die();
        }
    }

    public void die() {
        System.out.println(getName() + " a été vaincu !");
    }

    public void defend() {
        setDefense(getDefense() + new Random().nextInt(5));
        System.out.println(getName() + " est en position défensive !");
    }
}
