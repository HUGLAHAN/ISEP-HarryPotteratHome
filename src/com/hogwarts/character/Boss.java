package com.hogwarts.character;

public class Boss extends AbstractEnemy {
    private int bonusHealth;
    private int bonusAttack;

    public Boss(String name,int level, int healthPoints, int manaPoints) {
        super(name,level, healthPoints, manaPoints);
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
    public void attack(Character character, int attackPower) {
        int damage = attackPower - character.getDefense();
        if (damage <= 0) {
            System.out.println(attackPower);
            System.out.println(character.getDefense());
            System.out.println(attackPower - character.getDefense());
            System.out.println(getName() + "'s attack was ineffective against " + character.getName() + "!");
        } else {
            damage = Math.max(1, damage); // On s'assure que les dégâts infligés sont au moins de 1.
            System.out.println(getName() + " attacks " + character.getName() + " for " + damage + " damage!");
            character.takeDamage(damage);
        }
    }
}
