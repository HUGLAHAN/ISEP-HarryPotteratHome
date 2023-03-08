package com.hogwarts.character;

import com.hogwarts.belongings.*;
import com.hogwarts.spell.*;

import java.util.ArrayList;
import java.util.List;

import com.hogwarts.spell.AbstractSpell;
public class Wizard extends Character {
    private int manaPoints;
    private int healthPoints;
    private House house;
    private Pet pet;
    private Wand wand;
    private List<Spell> knownSpells;
    private List<Potion> potions;

    public Wizard(String name, int level, int healthPoints, int manaPoints) {
        super(name, level, healthPoints, manaPoints);
        this.manaPoints = manaPoints;
        this.healthPoints = healthPoints;
        knownSpells = new ArrayList<>();
        potions = new ArrayList<>();
    }

    public Pet getPet() {
        return pet;
    }


    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public List<Spell> getKnownSpells() {
        return knownSpells;
    }

    public void learnSpell(Spell spell) {
        knownSpells.add(spell);
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void addPotion(Potion potion) {
        potions.add(potion);
    }

    public void defend() {
        setDefense(getDefense() + 5);
        System.out.println(getName() + " est en position défensive !");
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public void setKnownSpells(List<Spell> spells) {
        this.knownSpells = spells;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }

    public void useheathPotion(Potion potion, int healthPoints) {
        if (house == House.HUFFLEPUFF) {
            System.out.println("HUFFLEPUFF");
            healthPoints *= 1.5; // Coefficient multiplicateur de 1.5 pour les potions utilisées par les membres de Hufflepuff
        }
        if (potions.contains(potion)) {
            potions.remove(potion);
//            System.out.println("on est lax!");
//            System.out.println(getHealthPoints());
//            System.out.println("on est laxdwdwadawdwd!");
//            System.out.println(getCurrentHealth());
//            System.out.println("on est laaxx!");
//            System.out.println(healthPoints);
//            System.out.println("on est laaaxxx!");
//            System.out.println(getMaxHealthPoints());
            setHealthPoints(Math.min(getCurrentHealth() + healthPoints, getMaxHealthPoints()));
        } else {
            System.out.println("You don't have that potion in your inventory!");
        }
    }

    public void usemanaPotion(Potion potion, int manaPoints) {
        if (house == House.HUFFLEPUFF) {
            System.out.println("HUFFLEPUFF");
            manaPoints *= 1.5; // Coefficient multiplicateur de 1.5 pour les potions utilisées par les membres de Hufflepuff
        }
        if (potions.contains(potion)) {
            potions.remove(potion);
            System.out.println("on est la!");
            System.out.println(getManaPoints());
            System.out.println("on est laa!");
            System.out.println(manaPoints);
            System.out.println("on est laaa!");
            System.out.println(getMaxManaPoints());
            setManaPoints(Math.min(getManaPoints() + manaPoints, getMaxManaPoints()));
        } else {
            System.out.println("You don't have that potion in your inventory!");
        }
    }

    public void attack(Character character, int attackPower) {
        int damage = attackPower - character.getDefense();
        if (damage <= 0) {
            //System.out.println(attackPower);
            //System.out.println(character.getDefense());
            //System.out.println(attackPower - character.getDefense());
            System.out.println(getName() + "'s attack was ineffective against " + character.getName() + "!");
        } else {
            damage = Math.max(1, damage); // On s'assure que les dégâts infligés sont au moins de 1.
            System.out.println(getName() + " attacks " + character.getName() + " for " + damage + " damage!");
            character.takeDamage(damage);
        }
    }
//    public void castSpell() {
//        Character target = getTarget();
//        int spellPower = getSpellPower();
//        if (target == null) {
//            System.out.println(getName() + "'s spell has no effect, no target selected!");
//            return;
//        }
//        System.out.println(House.SLYTHERIN);
//
////        System.out.println(house);
////        house = wizard.getHouse();
////        if (house == House.SLYTHERIN) {
////            System.out.println("Slytherin");
////            spellPower *= 1.3; // Coefficient multiplicateur de 1.3 pour les sorts utilisées par les membres de Slytherin.
////        }
//
//        int damage = spellPower - target.getDefense();
//        if (damage <= 0) {
//            System.out.println(getName() + "'s spell was ineffective against " + target.getName() + "!");
//        } else {
//            System.out.println(getName() + " casts a spell on " + target.getName() + " for " + damage + " damage!");
//            target.takeDamage(damage);
//        }
//    }
}