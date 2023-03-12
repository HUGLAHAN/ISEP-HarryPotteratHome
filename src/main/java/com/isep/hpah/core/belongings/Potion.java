package com.isep.hpah.core.belongings;

import com.isep.hpah.core.character.Character;


public class Potion {
    public static Potion healingPotion;
    public static Potion manaPotion;
    private String name;
    private int healingPower;


    public Potion(String name, int healingPower) {
        this.name = name;
        this.healingPower = healingPower;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void usepotion(Character target) {
        System.out.println(target.getName() + " drinks a " + getName() + " and regains " + healingPower + " health points!");
        target.setCurrentHealth(target.getCurrentHealth() + healingPower);
    }

}
