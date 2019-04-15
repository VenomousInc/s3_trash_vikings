package com.github.venomousinc.studies.game.trashviking.world.entity.npc;

import com.github.venomousinc.studies.game.trashviking.TrashVikings;
import com.github.venomousinc.studies.game.trashviking.world.entity.Entity;
import com.github.venomousinc.studies.game.trashviking.world.entity.Inventory;
import com.github.venomousinc.studies.game.trashviking.world.entity.Loadout;

public class NPC extends Entity {

    private final int level;

    public NPC(TrashVikings instance, String name, String description,
               Inventory inventory, int baseHealth, int level) {
        super(instance, name, description, inventory, null, baseHealth);
        this.level = level;
    }


    /**
     * Get the level of this NPC.
     * @return
     */
    @Override
    public int getLevel() {
        return level;
    }

}
