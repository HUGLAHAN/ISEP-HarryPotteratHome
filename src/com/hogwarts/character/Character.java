package com.hogwarts.character;

public abstract class Character {
    private String name;
    private int level;
    private int maxHealth;
    private int currentHealth;
    private int attack;
    private int defense;

    public Character(String name, int level, int healthPoints) {
        this.name = name;
        this.level = level;
        this.maxHealth = healthPoints;
        this.currentHealth = healthPoints;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
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
        int damageTaken = Math.max(damage - defense, 0);
        setCurrentHealth(currentHealth - damageTaken);
    }
    public void defend() {
        setDefense(getDefense() * 2);
    }

    public abstract void attack(Character character);
}
