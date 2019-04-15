package com.github.venomousinc.studies.game.trashviking.world.entity;

import com.github.venomousinc.studies.game.trashviking.world.items.Equipment;
import com.github.venomousinc.studies.game.trashviking.world.items.ItemBase;
import org.jetbrains.annotations.Nullable;

/**
 * An Entity loadout, the gear that they are currently wearing.
 */

public class Loadout {

    /**
     * Head armour
     */
    @Nullable
    private ItemBase head;
    /**
     * Body Armour
     */
    @Nullable
    private ItemBase chest;
    /**
     * Legwear
     */
    @Nullable
    private ItemBase legs;
    /**
     * Footwear
     */
    @Nullable
    private ItemBase feet;
    /**
     * Weapons
     */
    @Nullable
    private ItemBase mainHand;
    /**
     * Offhand, such as a shield.
     */
    @Nullable
    private ItemBase offHand;

    public Loadout() {
        this.head = null;
        this.chest = null;
        this.legs = null;
        this.feet = null;
        this.mainHand = null;
        this.offHand = null;
    }

    /**
     * The Entitys equipment loadout
     * @param head Helmet, Hat, Etc.
     * @param chest Shirt, Platebody, etc.
     * @param legs Platelegs, etc.
     * @param feet Crafted Boots, etc.
     * @param mainHand Sword, Axe, etc.
     * @param offHand Tin Can Shield, Tin Sword, Axe, etc.
     */
    public Loadout(@Nullable ItemBase head, @Nullable ItemBase chest, @Nullable ItemBase legs,
                   @Nullable ItemBase feet, @Nullable ItemBase mainHand, @Nullable ItemBase offHand) {
        this.head = head;
        this.chest = chest;
        this.legs = legs;
        this.feet = feet;
        this.mainHand = mainHand;
        this.offHand = offHand;
    }

    public ItemBase getHead() {
        return head;
    }

    public void setHead(@Nullable ItemBase head) {
        this.head = head;
    }

    @Nullable
    public ItemBase getChest() {
        return chest;
    }

    public void setChest(@Nullable ItemBase chest) {
        this.chest = chest;
    }

    @Nullable
    public ItemBase getLegs() {
        return legs;
    }

    public void setLegs(@Nullable ItemBase legs) {
        this.legs = legs;
    }

    @Nullable
    public ItemBase getFeet() {
        return feet;
    }

    public void setFeet(@Nullable ItemBase feet) {
        this.feet = feet;
    }

    @Nullable
    public ItemBase getMainHand() {
        return mainHand;
    }

    public void setMainHand(@Nullable ItemBase mainHand) {
        this.mainHand = mainHand;
    }

    @Nullable
    public ItemBase getOffHand() {
        return offHand;
    }

    public void setOffHand(@Nullable  ItemBase offHand) {
        this.offHand = offHand;
    }
}
