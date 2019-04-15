package com.github.venomousinc.studies.game.trashviking.world.entity.player;

import com.github.venomousinc.studies.game.trashviking.GameOutput;
import com.github.venomousinc.studies.game.trashviking.PlayerHandler;
import com.github.venomousinc.studies.game.trashviking.TrashVikings;
import com.github.venomousinc.studies.game.trashviking.world.entity.Entity;
import com.github.venomousinc.studies.game.trashviking.world.entity.Inventory;
import com.github.venomousinc.studies.game.trashviking.world.entity.Loadout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Users Player Character instance.
 */

public class Player extends Entity {

    private static final Logger LOGGER = LoggerFactory.getLogger( Player.class );
    /**
     * The Identifier assigned to this Player Character.
     * @see com.github.venomousinc.studies.game.trashviking.PlayerHandler#SINGLEPLAYER_IDENTIFIER
     */
    public final String IDENTIFIER;

    /**
     * The experience level of this player.
     */
    private long experience;


    public Player(final TrashVikings instance, final String IDENTIFIER) {
        super(instance,"Unknown Player", "A Player Character.", createBasicInventory(), createBasicLoadout(), 100);
        // Makes sure that the Inventorys parent is correctly set.
        getInventory().setParent(this);

        this.IDENTIFIER = IDENTIFIER;
        this.experience = 0;
    }

    @Override
    public int getLevel() {
        return 10;
    }

    /**
     * Handles the Users command input for it's Player Character.
     * @param input the user input.
     * @return currently always true.
     */
    public boolean handleInput(String input) {
        GameOutput out = this.INSTANCE.output;
        if(inputRequest != null) {

        } else {
            switch(input) {
                case "save":
                    out.systemMessage(String.format("Saving Players... %d not saved.", INSTANCE.getPlayers().savePlayers()));
                    break;

                case "lvl":
                case "level":
                    out.playerMessage(this, String.format("I am level %d.", this.getLevel()));
                    break;
                case "inv":
                case "inventory":
                    String[] output = {
                            "I seem to have a bag...",
                            this.getInventory().getDescription(),
                            this.getInventory().getPrintOut()
                    };
                    out.playerMessage(this, output);
                    break;

                case "gear":

                    break;
            }
        }
        return true;
    }

    private Object inputRequest = null;
    public void setInputRequest(Object obj) {
        inputRequest = obj;
    }

    /**
     * Creates a basic default inventory
     * @return 100 slot Inventory
     */
    private static Inventory createBasicInventory() {
        return new Inventory("Torn Backpack", 100, null);
    }


    private static Loadout createBasicLoadout() {
        return new Loadout();
    }

}
