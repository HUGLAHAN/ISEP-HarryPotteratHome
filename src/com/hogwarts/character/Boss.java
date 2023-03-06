package com.hogwarts.character;

public class Boss extends AbstractEnemy {
    private int bonusHealth;
    private int bonusAttack;

    public Boss(String name, int health, int strength, int bonusHealth, int bonusAttack) {
        super(name, health, strength);
        this.bonusHealth = bonusHealth;
        this.bonusAttack = bonusAttack;
    }

    public int getBonusHealth() {
        return bonusHealth;
    }

    public void setBonusHealth(int bonusHealth) {
        this.bonusHealth = bonusHealth;
    }

    public int getBonusAttack() {
        return bonusAttack;
    }

    public void setBonusAttack(int bonusAttack) {
        this.bonusAttack = bonusAttack;
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (getCurrentHealth() <= 0) {
            setCurrentHealth(0);
            System.out.println(getName() + " has been defeated!");
        }
    }

    public void useSpecialAttack(Character target) {
        int damage = getAttack() + bonusAttack;
        target.takeDamage(damage);
        System.out.println(getName() + " used special attack on " + target.getName() + " for " + damage + " damage!");
    }

    @Override
    public void attack(Character character) {
        int damage = getAttack() - character.getDefense();
        if (damage <= 0) {
            System.out.println(getName() + "'s attack was ineffective against " + character.getName() + "!");
        } else {
            System.out.println(getName() + " attacks " + character.getName() + " for " + damage + " damage!");
            character.takeDamage(damage);
        }
    }
}
