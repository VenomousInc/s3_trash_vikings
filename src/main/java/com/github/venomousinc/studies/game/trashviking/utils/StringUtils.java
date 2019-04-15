package com.github.venomousinc.studies.game.trashviking.utils;

import java.util.Arrays;

public final class StringUtils {

    /**
     * Passes {@link #capitalize(String, String[])} with {@code null} specialWords.
     * @see #capitalize(String, String[])
     * @param s The String to capitalize properly.
     * @return Lowercase String, with the first letter of each separated word capitalized.
     */
    public static String capitalize(String s) {
        return capitalize(s,null);
    }


    /**
     * Special Word Set
     * @see #capitalize(String, String[])
     */
    public static final String[] SPECIAL_SET_1 = {
            "the", "of"
    };
    /**
     * @see #capitalize(String)
     * @param s The String to correctly capitalize.
     * @param specialWords words to set as all lowercase.
     * @return
     */
    public static String capitalize(String s, String[] specialWords) {
        if(s == null || s.length() == 0)
            return s;

        String[] words = s.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < words.length; i++) {
            if(i != 0) {
                sb.append(' ');
            }

            if(i == 0 || specialWords == null || !Arrays.stream(specialWords).anyMatch(words[i]::equalsIgnoreCase)) {
                sb.append(Character.toUpperCase(words[i].charAt(0)));
                if (words[i].length() > 1) {
                    sb.append(words[i].substring(1));
                }
            } else {
                sb.append(words[i]);
            }
        }

        return sb.toString();
    }
}