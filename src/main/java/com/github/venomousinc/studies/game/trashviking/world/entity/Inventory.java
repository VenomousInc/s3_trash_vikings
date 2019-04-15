package com.github.venomousinc.studies.game.trashviking.world.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.venomousinc.studies.game.trashviking.world.items.ItemBase;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

/**
 * A Container such as a Backpack, Bag, or Crate.
 * @author VenomousInc
 */

public class Inventory {

    private static final Logger LOGGER = LoggerFactory.getLogger( Inventory.class );
    /**
     * The name of this container.
     * <p>For Example: {@code "Backpack", "Trash Bag"}</p>
     */
    private String name;

    /**
     * How many slots this {@link Inventory} contain.
     */
    private int size;

    /**
     * The {@link ItemBase} held within the {@link Inventory} container.
     */
    private LinkedList<ItemBase> slots;

    /**
     * The Entity that claims ownership of this Container.
     */
    @Nullable
    @JsonIgnore
    private Entity parent;

    public Inventory(String name, int size, @Nullable Entity parent) {
        this.name = name;
        this.size = size;
        this.slots = new LinkedList<>();
        this.parent = parent;

    }

    /**
     * If there is enough room, add the {@link ItemBase} to this container.
     * @param item what to store in this container.
     * @return success of adding the Item.
     */
    public boolean addItem(ItemBase item) {
        return getFreeSlots() > 0 && slots.add(item);
    }

    /**
     * Checks that this Inventory contains the specified item.
     * @param item the item to check the inventory container for.
     * @return if the inventory contains this item.
     */
    public boolean hasItem(ItemBase item) {
        if(slots == null
        || slots.size() == 0
        || item == null) {
            LOGGER.error( String.format("slotsIsNull > %b, slots.size() > %d, itemIsNull > %b",
                    slots == null, (slots == null ? -1 : slots.size()), item == null));
            return false;
        }
        return slots.contains(item);
    }

    /**
     * @param item The item to get the slot for.
     * @return The index of the Item, or -1 if the item didn't exist.
     */
    public int getItemSlot(ItemBase item) {
        if(item != null && slots != null && slots.size() > 0) {
            for(int i = 0; i < slots.size(); i++) {
                if(slots.get(i).equals(item)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Removes the {@link ItemBase} from the {@link #slots} of this container.
     * @param item what to delete
     * @return success of deleting the item.
     */
    public boolean deleteItem(ItemBase item) {
        if(slots == null || slots.size() == 0) {
            LOGGER.error( String.format("slotsIsNull > %b, slots.size() > %d, itemIsNull > %b",
                    slots == null, (slots == null ? -1 : slots.size()), item == null));
            return false;
        }
        return slots.remove(item);
    }

    /**
     *
     * @param swapping the item to be swapped/replaced by {@code swappedFor}.
     * @param swappedFor the new item that replaces {@code swapping}
     * @return the success of the swap
     */
    public boolean swapItem(ItemBase swapping, ItemBase swappedFor) {
        if(hasItem(swapping) && swapping != null && swappedFor != null) {
            int index = getItemSlot(swapping);
            if(index != -1) {
                if(slots.set(index, swappedFor).equals(swappedFor)) {
                    return true;
                }
            }
        }
        LOGGER.error( String.format("slotsIsNull > %b, slots.size() > %d, swappingIsNull > %b, swappedForIsNull > %b",
                slots == null, (slots == null ? -1 : slots.size()), swapping == null, swappedFor == null));
        return false;
    }

    /**
     * @return The name of this {@link Inventory} container, e.g a backpack.
     */
    public String getName() {
        return name == null ? "Null" : name;
    }

    /**
     * Set the name of this {@link Inventory}
     * @param name new name of this container.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return How many more items can this container hold.
     */
    public int getFreeSlots() {
        if(slots == null)
            return -1;
        return getSize() - slots.size();
    }

    /**
     * @return how many Items currently held within this container.
     */
    public int getUsedSlots() {
        if(slots == null) return -1;
        return slots.size();
    }

    /**
     * The Maximum size of this container.
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Set the new maximum size of this Inventory,
     * if the new size is less than the current amount of Items held, then return false.
     * @param size the new size
     * @return true if size was set, false if not.
     */
    public boolean setSize(int size) {
        if(size > slots.size()) {
            LOGGER.error( String.format("\"%s\" of entity \"%s\": attempting to set incorrect size.",
                    getName(), (getParent() != null ? getParent().getName() : "N/A")) );
            return false;
        }

        this.size = size;
        return true;
    }


    @Nullable
    public Entity getParent() {
        return parent;
    }

    public void setParent(@Nullable Entity parent) {
        this.parent = parent;
    }

    /**
     * @return "It currently has {@code slots.size()} out of {@link #getSize()} items."
     */
    public String getDescription() {
        return String.format("It contains %d out of %d items.", slots.size(), getSize());
    }

    public String getPrintOut() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append('[').append(getUsedSlots()).append('/').append(getSize()).append(']');

        slots.forEach(itemBase -> sb.append(String.format("%n  * %20s | \"%s\"", itemBase.getName(), itemBase.getDescription())));

        return sb.toString();
    }


}
