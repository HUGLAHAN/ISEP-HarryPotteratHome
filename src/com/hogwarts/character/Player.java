package com.hogwarts.character;

public class Player extends Character {
    private int manaPoints;

    public Player(String name, int level, int healthPoints, int manaPoints) {
        super(name, level, healthPoints);
        this.manaPoints = manaPoints;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    @Override
    public void attack(Character character) {
        int damage = getAttack() - character.getDefense();
        if (damage <= 0) {
            System.out.println(getAttack());
            System.out.println(character.getDefense());
            System.out.println(getAttack() - character.getDefense());
            System.out.println(getName() + "'s attack was ineffective against " + character.getName() + "!");
        } else {
            damage = Math.max(1, damage); // On s'assure que les dégâts infligés sont au moins de 1.
            System.out.println(getName() + " attacks " + character.getName() + " for " + damage + " damage!");
            character.takeDamage(damage);
        }
    }


    public void castSpell(Character character, int manaCost, int spellPower) {
        if (manaCost > getManaPoints()) {
            System.out.println("Not enough mana to cast spell!");
        } else {
            int damage = spellPower - character.getDefense();
            if (damage <= 0) {
                System.out.println(getName() + "'s spell was ineffective against " + character.getName() + "!");
            } else {
                System.out.println(getName() + " casts a spell on " + character.getName() + " for " + damage + " damage!");
                character.takeDamage(damage);
                setManaPoints(getManaPoints() - manaCost);
            }
        }
    }
}