package com.github.venomousinc.studies.game.trashviking;


import com.github.venomousinc.studies.game.trashviking.world.entity.Entity;
import com.github.venomousinc.studies.game.trashviking.world.entity.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    
    private static final Logger LOGGER = LoggerFactory.getLogger( Main.class );

    public static void main(String[] args) {
        GameOutput gameOutput = new GameOutput() {
            @Override
            public void systemMessage(String output) {
                System.out.format("{System} %s%n", output);
            }

            @Override
            public void systemMessage(String[] output) {
                systemMessage(String.join("\n > ", output));
            }

            @Override
            public void playerMessage(Player player, String output) {
                System.out.format("%s says: %s%n", player != null ?  player.getName() : "NULL_PLAYER", output);
            }

            @Override
            public void playerMessage(Player player, String[] output) {
                playerMessage(player, String.join("\n ", output));
            }

            @Override
            public void npcMessage(Entity entity, String output) {
                System.out.format("%s{NPC}: %s%n", entity != null ? entity.getName() : "NULL_NPC", output);
            }

            @Override
            public void npcMessage(Entity entity, String[] output) {
                npcMessage(entity, String.join("\n ", output));
            }

        };

        TrashVikings trashVikings = new TrashVikings(true, gameOutput);

        try(Scanner sc = new Scanner(System.in)) {
            LOGGER.info("Starting to take User Input...");
            while(sc.hasNext()) {
                if(!trashVikings.input(sc.nextLine(), PlayerHandler.SINGLEPLAYER_IDENTIFIER)) {
                    break;
                }
                //LOGGER.info("WHILE_LOOP#{}", Main.class);
            }
            LOGGER.info("NO LONGER TAKING USER INPUT!");
        } catch(InputMismatchException | NullPointerException e) {
            e.printStackTrace();
        }

    }

}
