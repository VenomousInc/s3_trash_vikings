package com.github.venomousinc.studies.game.trashviking.world.items;

import java.awt.Color;

/**
 * Item tags, such as Currency, Quest Item, or the Rarity.
 * @author VenomousInc
 */
public enum ItemTag {
    QUEST_ITEM(-1, "Quest Item", new Color(0x64FF78)),
    CURRENCY(-1, "Currency", new Color(0xFFFF96)),
    COMMON(0, "Common", new Color(0xB9B9B9)),
    UNCOMMON(1, "Uncommon", new Color(0x00FF00)),
    RARE(2, "Rare", new Color(0x0000FF)),
    EPIC(3, "Epic", new Color(0xDCD600)),
    LEGENDARY(4, "Legendary", new Color(0xDC8700)),
    UNIQUE(Integer.MAX_VALUE, "Unique", new Color(0xFF00FF));

    /**
     * Indexing for randomizer
     */
    public final int index;
    /**
     * The proper name
     */
    public final String text;
    /**
     * Future use case
     */
    public final Color color;

    ItemTag(int index, String text, Color color) {
        this.index = index;
        this.text = text;
        this.color = color;
    }

    public static boolean isQuestItem(ItemBase item) {
        return false;
    }

}
