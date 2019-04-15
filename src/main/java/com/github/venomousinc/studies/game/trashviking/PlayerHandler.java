package com.github.venomousinc.studies.game.trashviking;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.venomousinc.studies.game.trashviking.world.entity.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Handles the Users Player Characters.
 */

public class PlayerHandler {
    
    private static final Logger LOGGER = LoggerFactory.getLogger( PlayerHandler.class );
    public static final String SINGLEPLAYER_IDENTIFIER = "THE_SINGLEPLAYER_USER";
    
    private TrashVikings parent;
    private LinkedList<Player> players;

    PlayerHandler(TrashVikings parent) {
        this.parent = parent;
        this.players = new LinkedList<>();
    }

    public int savePlayers() {
        int unsaved = players.size();

        for(Player player : players) {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(String.format("%s.json", player.IDENTIFIER));
                    // player.getClass().getClassLoader().getResource(String.format("/%s.json", player.IDENTIFIER)).getFile());
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, player);
                unsaved--;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return unsaved;
    }

    /**
     * Find the player with the given identifier.
     * @param identifier What to look for within {@link PlayerHandler}
     * @return The {@link Player} or null if this player doesn't exist.
     */
    public Player getPlayer(String identifier) {
        return players.stream()
                .filter(player -> player.IDENTIFIER.equals(identifier))
                .findFirst()
                .orElse(null);
    }

    /**
     * @see Player
     * @see #getPlayer(String)
     * @see #containsPlayer(Player)
     * @param identifier the players identifier.
     * @return if the player was found.
     */
    public boolean containsPlayer(final String identifier) {
        return getPlayer(identifier) != null;
    }

    /**
     * @param player The {@link Player} to check for within {@link #players}
     * @return If the {@link Player} was found.
     */
    public boolean containsPlayer(final Player player) {
        if(player == null) return false;
        return players.contains(player);
    }

    /**
     * @return null if SP Instance already started, or if {@link TrashVikings#isSingleplayer()} is false,
     * otherwise return the newly created Singleplayer instance.
     */
    public Player startSPInstance() {
        if(getParent().isSingleplayer() && players.size() == 0) {
            return addPlayer( new Player(getParent(), SINGLEPLAYER_IDENTIFIER));
        }
        return null;

    }

    /**
     * Warning this method is not finished, see TODO.
     * @param identifier the player to load or create fresh.
     * @return
     */
    public Player startPlayerInstance(final String identifier) {
        if(!containsPlayer(identifier)) {
            /**
             * TODO: Check if player has a save file, and load it.
             */
            addPlayer( new Player(getParent(), identifier));
        }
        return null;
    }

    /**
     * Get the Singleplayer Instance if it has already been started.
     * @see #startSPInstance()
     * @see TrashVikings#isSingleplayer()
     * @return null, or Singleplayer instance.
     */
    public Player getSPInstance() {
        if(getParent().isSingleplayer()) {
            if(players.size() == 1 && players.getFirst() != null) {
                Player player = players.getFirst();
                if(player.equals(SINGLEPLAYER_IDENTIFIER)) {
                    return addPlayer(player);
                } else {
                    LOGGER.error(String.format("isSingleplayer()e=true, but Player ID:%s", player.IDENTIFIER));
                    return null;
                }
            } else {
                LOGGER.error("Singleplayer Instance not started!");
                return null;
            }
        }
        LOGGER.error("Not in Singleplayer Instance!");
        return null;
    }

    /**
     * Add a player to the {@link #players} LinkedList.
     * <ul>Player will not be added if:
     * <li>{@link Player} is null.</li>
     * <li>List contains player > {@link #containsPlayer(Player)} is true.</li></ul>
     * @param player The player to add to the LinkedList.
     * @return The {@link Player} if successful, null if not.
     */
    private Player addPlayer(final Player player) {
        if(player != null) {
            if(containsPlayer(player)) {
                LOGGER.error( String.format("Attempted to add %s, but that player already exists!",
                        player.toString()) );
                return null;
            }
            /**
             * This will never return false, but just for posterity reasons.
             * @see {@link LinkedList#add(Object)}
             */
            if(players.add(player)) {
                return player;
            }
        }
        LOGGER.error("Attempted to add NULL Player!");
        return null;
    }

    public TrashVikings getParent() {
        return parent;
    }
}
