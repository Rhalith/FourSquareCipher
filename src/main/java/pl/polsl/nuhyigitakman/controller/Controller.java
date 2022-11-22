/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.nuhyigitakman.controller;

import pl.polsl.nuhyigitakman.model.Coder;
import pl.polsl.nuhyigitakman.model.Matrices;

/**
 *
 * @author Nuh Yigit Akman
 *
 * @version 1.1
 */
public class Controller {


    /**
     * Matrices class for encoding
     */
    private final Matrices matrices;

    /**
     * Coder class for encoding
     */
    private final Coder coder;

    /**
     * Constructor for controller
     * @param matrices matrices class
     * @param coder coder class
     */

    public Controller(Matrices matrices, Coder coder) {
        this.matrices = matrices;
        this.coder = coder;
    }

    /**
     * Fill the array with specific key or randomized key.
     * @param number 1 for Q1/Q4, 2 for Q2, 3 for Q3
     * @param keyInput specific key
     */
    private void plotArray(int number, String keyInput){
        switch (number){
            case 1:
                matrices.plotAlphabets(matrices.getPlot(), matrices.getRemove());
                break;
            case 2:
                if (!keyInput.isEmpty()) matrices.plotKey(matrices.getPlotTwo(), keyInput, matrices.getRemove());
                else matrices.randomizeKey(matrices.getPlotTwo(), matrices.getRemove());
                break;
            case 3:
                if (!keyInput.isEmpty()) matrices.plotKey(matrices.getPlotThree(), keyInput, matrices.getRemove());
                else matrices.randomizeKey(matrices.getPlotThree(), matrices.getRemove());
        }

    }

    /**
     * Calls the method that filling array with key
     * @param number 1 for Q1/Q4, 2 for Q2, 3 for Q3
     * @param key specific key, if you want random put ""
     */
    public void updateController(int number, String key){
        plotArray(number, key);
    }

    /**
     * encoding the text by using model
     * @param choice encryption or decryption choice
     * @param text text that want to be encode
     * @return result of encoding
     */
    public String updateController(String choice, String text){
        String output;
        if (choice.equals("E")){
            output = coder.encodeText(text, true, matrices.getPlot(), matrices.getPlotTwo(), matrices.getPlotThree());
        }
        else{
            output = coder.encodeText(text, false, matrices.getPlot(), matrices.getPlotTwo(), matrices.getPlotThree());
        }
        return output;
    }

    public String getMatrices(String choice){
        String output;
        if(choice.equals("one")){
            output = matrices.getPlotTwo().toString();

        } else {
            output = matrices.getPlotThree().toString();
        }
        return output;
    }
}
