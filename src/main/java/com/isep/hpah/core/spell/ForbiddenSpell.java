package com.isep.hpah.core.spell;

public class ForbiddenSpell extends Spell {
    public ForbiddenSpell(String name, int level, double successRate, int spellPower) {
        super(name, level, successRate, spellPower);

    }

    @Override
    public void castSpell() {
        System.out.println(getName() + " is a forbidden spell and should not be used!");
    }
}
