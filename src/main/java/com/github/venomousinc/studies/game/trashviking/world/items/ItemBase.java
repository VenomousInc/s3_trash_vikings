package com.github.venomousinc.studies.game.trashviking.world.items;

import com.github.venomousinc.studies.game.trashviking.utils.StringUtils;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

/**
 * The Base for all Items (Weapon, Armour, etc.)
 */

public class ItemBase {

    private String name;
    /**
     * A short optional description.
     */
    private String description;
    /**
     * The currency value
     */
    private int value;

    /**
     * Item Tags, such as currency, quest item, or rarity.
     */
    private final EnumSet<ItemTag> itemTags;

    public ItemBase(String name, String description, int value, @Nullable EnumSet<ItemTag> itemTags) {
        this.name = name;
        this.description = description;
        this.value = value;
        if(itemTags == null || itemTags.isEmpty()) {
            this.itemTags = EnumSet.of(ItemTag.COMMON);
        } else {
            this.itemTags = itemTags;
        }
    }

    public String getName() {
        return StringUtils.capitalize(name == null ? "Null Item" : name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description == null ? String.format("It appears to be a %s.", getName()) : description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return A set of Item Tags, such as Quest Item, or Item Rarity.
     */
    public EnumSet<ItemTag> getItemTags() {
        if(itemTags == null || itemTags.isEmpty()) {
            return EnumSet.of(ItemTag.COMMON);
        }
        return itemTags;
    }
}
