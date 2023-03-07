package com.hogwarts.character;

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
}
