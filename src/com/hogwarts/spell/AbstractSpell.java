package com.hogwarts.spell;

import com.hogwarts.belongings.House;
import com.hogwarts.character.Character;
import com.hogwarts.character.Wizard;

import java.util.Random;

public abstract class AbstractSpell {
    private String name;
    private int level;
    private Character target;
    private int spellPower;
    private double successRate;
    private House house;

    public AbstractSpell(String name, int level, double successRate, int spellPower) {
        this.name = name;
        this.level = level;
        this.successRate = successRate;
        this.spellPower = spellPower;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Character getTarget() {
        return target;
    }

    public void setTarget(Character target) {
        this.target = target;
    }

    public int getSpellPower() {
        return spellPower;
    }

    public void setSpellPower(int spellPower) {
        this.spellPower = spellPower;
    }

    public void castSpell() {
        Random random = new Random();
        double rand = random.nextDouble();
        if (rand <= successRate) {
            System.out.println("Casting spell " + getName() + " at level " + getLevel() + " and causing " + spellPower + " damage!");
            target.takeDamage(spellPower);
        } else {
            System.out.println("Spell " + getName() + " failed to cast!");
        }
    }
}
