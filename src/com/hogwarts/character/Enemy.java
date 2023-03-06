package com.hogwarts.character;

public class Enemy extends AbstractEnemy {

    public Enemy(String name, int health, int strength) {
        super(name, health, strength);
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
    public void attack(Character character) {
        int damage = getLevel() * 2;
        character.takeDamage(damage);
        System.out.println(getName() + " attaque " + character.getName() + " pour " + damage + " dégâts.");
    }
}
