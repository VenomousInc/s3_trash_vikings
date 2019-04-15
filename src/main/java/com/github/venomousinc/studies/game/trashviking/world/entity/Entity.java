package com.github.venomousinc.studies.game.trashviking.world.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.venomousinc.studies.game.trashviking.TrashVikings;

/**
 * The basis of a world Entity.
 * <p>E.G: Player Character, NPC
 */

public class Entity {

    /**
     * The Parent game instance.
     */
    @JsonIgnore
    public final TrashVikings INSTANCE;

    private String name;
    /**
     * A short basic description of this {@link Entity}
     */
    private String description;

    /**
     * The base health of this Entity.
     */
    private int baseHealth;
    /**
     * The current health of this Entity.
     */
    private int currentHealth;

    /**
     * This Entitys item container
     */
    private Inventory inventory;

    /**
     * The loadout of this Entity (Equipment: Weapon, etc)
     */
    private Loadout loadout;

    public Entity(final TrashVikings instance, String name, String description,
                  Inventory inventory, Loadout loadout, int baseHealth) {
        this.INSTANCE = instance;
        this.name = name;
        this.description = description;
        this.inventory = inventory;
        this.loadout = loadout;
        this.currentHealth = this.baseHealth = baseHealth;
    }

    /**
     * @return -1 by default
     */
    public int getLevel() {
        return -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Loadout getLoadout() {
        return loadout;
    }

    public void setLoadout(Loadout loadout) {
        this.loadout = loadout;
    }

}
