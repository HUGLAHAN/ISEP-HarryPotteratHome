package com.hogwarts.spell;

import com.hogwarts.character.Character;

public abstract class AbstractSpell {
    private String name;
    private int level;
    private Character target;
    private int spellPower;

    public static final AbstractSpell AVADA_KEDAVRA = new Spell("Avada Kedavra", 7);
    public static final AbstractSpell EXPELLIARMUS = new Spell("Expelliarmus", 3);
    public static final AbstractSpell INCENDIO = new Spell("Incendio", 5);

    public AbstractSpell(String name, int level) {
        this.name = name;
        this.level = level;
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
        System.out.println("Casting spell " + getName() + " at level " + getLevel());
    }
}
