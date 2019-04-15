package com.github.venomousinc.studies.game.trashviking;

import com.github.venomousinc.studies.game.trashviking.world.entity.Entity;
import com.github.venomousinc.studies.game.trashviking.world.entity.player.Player;

/**
 * Game Output Module, override and handle as you see fit.
 * @author VenomousInc
 */

public interface GameOutput {

    void systemMessage(String output);
    void systemMessage(String[] output);

    void playerMessage(Player player, String output);
    void playerMessage(Player player, String[] output);

    void npcMessage(Entity entity, String output);
    void npcMessage(Entity entity, String[] output);

}
