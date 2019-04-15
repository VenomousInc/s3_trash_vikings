package com.github.venomousinc.studies.game.trashviking;

import com.github.venomousinc.studies.game.trashviking.world.entity.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrashVikings {

    private static final Logger LOGGER = LoggerFactory.getLogger( TrashVikings.class );
    
    public static final String PROJECT_NAME = "Trash Vikings";

    private final PlayerHandler playerHandler;
    /**
     * Is the game running in a Singleplayer Instance Mode?
     * @see #isSingleplayer()
     */
    private boolean singleplayerMode;

    public final GameOutput output;

    public TrashVikings(boolean singleplayerMode, GameOutput gameOutput) {
        this.singleplayerMode = singleplayerMode;
        this.output = gameOutput;
        playerHandler = new PlayerHandler(this);

        if(this.singleplayerMode) {
            Player p = getPlayers().startSPInstance();
            LOGGER.info("Creating SP Instance...");
        }
    }

    /**
     * Controls the population of Players.
     * @return The {@link PlayerHandler} instance.
     */
    public PlayerHandler getPlayers() {
        return playerHandler;
    }

    /**
     * Is the game running in Singleplayer mode?
     * @return {@link #singleplayerMode}
     */
    public boolean isSingleplayer() {
        return singleplayerMode;
    }

    public boolean input(String input, String playerIdentifier) {
        Player player = getPlayers().getPlayer(playerIdentifier);
        if(player != null) {
            return player.handleInput(input);
        }
        LOGGER.info("INPUT: \"{}\" from non-existent PID:{}", input, playerIdentifier);
        return false;
    }
}
