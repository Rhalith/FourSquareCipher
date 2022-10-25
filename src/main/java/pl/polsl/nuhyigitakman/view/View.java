package pl.polsl.nuhyigitakman.view;

import pl.polsl.nuhyigitakman.controller.Controller;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Nuh Yigit Akman
 *
 * @version 1.0
 */
public class View {
    /**
     * Scanner for using get inputs
     */
    Scanner scanner;
    /**
     * controller for connection
     */
    Controller controller;

    /**
     * Constructor for view
     * @param scanner scanner for using get inputs
     * @param controller controller for connection
     */
    public View(Scanner scanner, Controller controller) {
        this.scanner = scanner;
        this.controller = controller;
    }

    /**
     * Main run method for program.
     */
    public void run(){
        /**
         * User encoding choice
         */
        String userChoice = new String();
        /**
         * User's key choice(random or manual)
         */
        String keyChoice = new String();
        /**
         * User's key input
         */
        String keyInput = new String();
        /**
         * User's input for encryption or decryption
         */
        String userText = new String();
        /**
         * Result of encoding
         */
        String output = new String();
        /**
         * Question text for getting input from user
         */
        String questionText = new String();
        /**
         * Warning text for user to get right input.
         */
        String warningText = new String();


        questionText = "Encrypt for 'E', Decrypt for 'D'";
        warningText = "Please make your choice between 'E' or 'D'!";
        userChoice = getInput(scanner, questionText, warningText, "E", "D");

        System.out.println();

        questionText = "If you want to enter your own key enter 'M'\nIf you want to let computer to decides key randomly enter 'R'";
        warningText = "Please make your choice between 'M' or 'R'!";

        keyChoice = getInput(scanner, questionText, warningText, "M", "R");

        if(keyChoice.equals("M")){
            questionText = "Please enter key 1:";
            keyInput = getInput(scanner, questionText, true);

            controller.updateController(2, keyInput);
            questionText = "Please enter key 2:";
            keyInput = getInput(scanner, questionText, true);
            controller.updateController(3, keyInput);
        }
        else{
            controller.updateController(2, "");
            controller.updateController(3, "");
        }
        controller.updateController(1,"");
        questionText = "Please enter your text: ";
        userText = getInput(scanner, questionText, false);

        output = controller.updateController(userChoice, userText);

        getOutput(userText, output, userChoice);
    }


    /**
     * This method gets string input and checks if satisfies the program.
     * @param scanner scanner object
     * @param questionText question for user
     * @param warningText warning for wrong input
     * @param reqOne correct input one
     * @param reqTwo correct input two
     * @return satisfying string
     */
    private String getInput(Scanner scanner, String questionText, String warningText, String reqOne, String reqTwo){
        System.out.println(questionText);
        System.out.print("Input your choice: ");
        String userInput = new String();
        userInput = scanner.next();
        while (!(userInput.equals(reqOne) || userInput.equals(reqTwo))){
            System.out.println();
            if(!userInput.matches("[a-zA-Z]+"))
            {
                System.out.println("Please enter only English letters.");
            }
            System.out.println(warningText);
            System.out.print("Input your choice: ");
            userInput = scanner.next();
        }
        return userInput;
    }

    /**
     * This method gets string input and checks if satisfies the english letters.
     * @param scanner scanner object
     * @param inputText description of input for user
     * @param isKey checks for if the requirement is a key for cipher or text for input
     * @return satisfying string
     */
    private String getInput(Scanner scanner, String inputText, Boolean isKey){
        System.out.print(inputText);
        String userInput = new String();
        if(isKey){
            try{
                userInput = scanner.nextLine();
            }
            catch (Exception e){
                getInput(scanner, inputText, isKey);
            }
        }
        else{
            try{
                userInput = scanner.nextLine();
            }
            catch (Exception e){
                getInput(scanner, inputText, isKey);
            }
        }
        while (!userInput.matches("[a-zA-Z]+(\\s+[a-zA-Z]+)*")){
            if(!userInput.equals("")){
                System.out.println();
                System.out.println("Please enter only English letters.");
                System.out.print(inputText);
            }
            if(isKey){
                userInput = scanner.next();
            }
            else{
                userInput = scanner.nextLine();
            }
        }
        return userInput.toUpperCase(Locale.forLanguageTag("en"));
    }
    /**
     * Get result of encryption or decryption
     * @param input data for encryption or decryption
     * @param output result of encryption or decryption
     * @param userChoice check if encryption or decryption
     */

    public void getOutput(String input, String output, String userChoice){
        if(userChoice.equals("E")){
            System.out.println("Your text was: "+input);
            System.out.println("Your encrypted text is:"+output);
        }
        else{
            System.out.println("Your text was: "+input);
            System.out.println("Your decrypted text is:"+output);
        }
    }
}
