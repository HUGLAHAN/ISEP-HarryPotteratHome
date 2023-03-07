package com.hogwarts.spell;

public class ForbiddenSpell extends AbstractSpell {
    public ForbiddenSpell(String name, int level) {
        super(name, level);
    }

    @Override
    public void castSpell() {
        System.out.println("Casting forbidden spell " + getName() + " at level " + getLevel());
    }
}