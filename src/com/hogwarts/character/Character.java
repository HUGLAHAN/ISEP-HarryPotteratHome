package com.hogwarts.character;

public abstract class Character {
    public String name;
    public int level;
    public int maxHealth;
    public int maxMana;
    public int currentHealth;
    public int currentMana;
    public int attack;
    public int defense;
    public int healthPoints;

    public Character(String name, int level, int healthPoints, int manaPoints) {
        this.name = name;
        this.level = level;
        this.maxHealth = healthPoints;
        this.maxMana = manaPoints;
        this.currentHealth = healthPoints;
        this.currentMana = manaPoints;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }


    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setHealthPoints(int healthPoints) {
        //this.maxHealth = healthPoints;
        this.currentHealth = healthPoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void takeDamage(int damage) {
        int damageTaken = damage - defense;
        if (damageTaken < 0) {
            damageTaken = 0;
        }
        currentHealth -= damageTaken;
    }

    public void setCurrentHealth(int currentHealth) {
        if (currentHealth < 0) {
            this.currentHealth = 0;
        } else if (currentHealth > maxHealth) {
            this.currentHealth = maxHealth;
        } else {
            this.currentHealth = currentHealth;
        }
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public int getMaxHealthPoints() {
        return maxHealth;
    }
    public int getMaxManaPoints() {
        return maxMana;
    }


    public void defend() {
        // TODO: Implement defend method
    }

}
