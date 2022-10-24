/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.nuhyigitakman.model;

import java.util.*;

/**
 *
 * @author Nuh Yigit Akman
 *
 * @version 1.0
 */
public class Matrices {


    /**
     * Array Q1 and Q4 for cipher
     */
    char[] plot = new char[25];
    /**
     * Array Q2 for cipher
     */
    char[] plotTwo = new char[25];
    /**
     * Array Q3 for cipher
     */
    char[] plotThree = new char[25];
    /**
     * Removed key for cipher
     */
    char remove = 'Q';

    /**
     * Get Q1 and Q4 arrays
     * @return Q1/Q4 array
     */
    public char[] getPlot() {
        return plot;
    }

    /**
     * Get Q2 array
     * @return Q2 array
     */
    public char[] getPlotTwo() {
        return plotTwo;
    }

    /**
     * Get Q3 array
     * @return Q3 array
     */
    public char[] getPlotThree() {
        return plotThree;
    }

    /**
     * Get removed key
     * @return removed key
     */
    public char getRemove() {
        return remove;
    }

    /**
     * fill array with letter of alphabets.
     * @param plot array that will be filled
     * @param remove letter that will not be used.
     */
    public void plotAlphabets(char[] plot, char remove) {
        int cursor = 0;
        for (int i = 0; i < plot.length; i++) {
            if ((char) ('A' + i) != remove)
            {
                plot[i] = (char) ('A' + cursor);
            }
            else
            {
                cursor++;
                plot[i] = (char) ('A' + cursor);
            }
            cursor++;
        }
    }

    /**
     * fill array with specific key
     * if key is not long enough rest of it will be filled with letters of alphabet
     * @param plot array that will be filled
     * @param key the key that will use for fill
     * @param remove letter that will not be used.
     */
    public void plotKey(char[] plot, String key, char remove) {
        int cursor = 0; // additional counter
        key = removeDuplicates(key);
        char[] ckey = key.toCharArray(); // fastest way to convert String to char array

        // plot initial key
        for (int i = 0; i < ckey.length; i++) {
            plot[i] = ckey[i];
        }

        for (int i = ckey.length; i < plot.length; i++) {

            if((char) ('A' + cursor) == remove) {
                // if the current letter is the one which be remove then skip
                cursor++;
            }

            int checks = 2; // number of checks
            for (int j = 0; j < checks; j++) {
                for (int k = 0; k < ckey.length; k++) {
                    // iterate to the key and compare each to the current character
                    if(ckey[k] == (char) ('A' + cursor)) {
                        cursor++;
                        break;
                    }
                }
            }

            if((char) ('A' + cursor) == remove) { // recheck
                // if the current letter is the one which be remove then skip
                cursor++;
            }

            plot[i] = (char) ('A' + cursor);
            cursor++;

        }
    }

    /**
     * fill array with randomized key
     * @param plot array that will be filled
     * @param remove letter that will not be used
     */
    public void randomizeKey(char[] plot, char remove){
        plotAlphabets(plot, remove);
        Random rand = new Random();

        for (int i = 0; i < plot.length; i++) {
            int randomIndexToSwap = rand.nextInt(plot.length);
            char temp = plot[randomIndexToSwap];
            plot[randomIndexToSwap] = plot[i];
            plot[i] = temp;
        }
    }

    /**
     * remove the duplicating letters from string if there is any
     * @param string the string to be cleared of duplicates
     * @return string without duplicates
     */
    private String removeDuplicates(String string) {
        string = string.toUpperCase();
        char[] characters = string.toCharArray();
        String filtered = "";
        for (int i = 0; i < characters.length; i++) {
            // iterate each char on the list
            boolean isReapeated = false;
            for (int j = 0; j < i; j++) {
                // compare one char (current) to all chars
                if(characters[i] == characters[j]) {
                    isReapeated = true;
                    break;
                }
            }

            if(!isReapeated) { // if the char is not repeated then add to output
                filtered += characters[i];
            }
        }
        return filtered; // sample input: LOLEEOEO, output: LEO
    }
}
