package com.hogwarts.spell;

import com.hogwarts.character.Character;

public class Spell extends AbstractSpell {
    public Spell(String name, int level) {
        super(name, level);
    }

    @Override
    public void castSpell() {
        Character target = getTarget();
        int spellPower = getSpellPower();

        int damage = spellPower - target.getDefense();
        if (damage <= 0) {
            System.out.println(getName() + "'s spell was ineffective against " + target.getName() + "!");
        } else {
            System.out.println(getName() + " casts a spell on " + target.getName() + " for " + damage + " damage!");
            target.takeDamage(damage);
        }
    }
}
