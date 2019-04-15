package com.github.venomousinc.studies.game.trashviking.world.items;

import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

/**
 * A subclass of an Item, and parent of Items such as:
 * Weapons, Armour
 *
 * @see ItemBase
 */

public class Equipment extends ItemBase {

    public Equipment(String name, String description, int value, @Nullable EnumSet<ItemTag> tags) {
        super(name, description, value, tags);

    }

    @Override
    public String getName() {
        String name = super.getName();

        /**
         * Append affix
         */

        return name;
    }

}
