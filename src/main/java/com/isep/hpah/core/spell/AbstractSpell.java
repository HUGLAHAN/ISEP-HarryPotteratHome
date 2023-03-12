package com.isep.hpah.core.spell;

import com.isep.hpah.core.belongings.House;
import com.isep.hpah.core.character.Character;

public abstract class AbstractSpell {
    private String name;
    private int level;
    public Character target;
    public int spellPower;
    public double successRate;
    public House house;

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
    }
}
