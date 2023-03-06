package com.hogwarts.character;

import java.util.Random;

public abstract class AbstractEnemy extends Character {

    public AbstractEnemy(String name, int health, int strength) {
        super(name, health, strength);
    }

    public abstract void attack(Character character);

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
