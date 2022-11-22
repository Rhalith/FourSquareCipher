package pl.polsl.nuhyigitakman.view;

import pl.polsl.nuhyigitakman.controller.Controller;

import javax.swing.*;
import java.util.*;
import java.util.List;

/**
 *
 * @author Nuh Yigit Akman
 *
 * @version 1.1
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
        new Menu(controller);
    }



}

class Menu{
    /**
     * User's key input one
     */
    String keyOneInput;
    /**
     * User's key input two
     */
    String keyTwoInput;
    /**
     * User's input for encryption or decryption
     */
    String userText;
    /**
     * Result of encoding
     */
    String output;
    /**
     * user cryption choice for submission.
     * 0 - Encrypt - Manual
     * 1 - Encrypt - Random
     * 2 - Decrypt - Manual
     * 3 - Decrypt - Random
     */
    int userCryptionChoice;

    List<String> keyOneInputs = new ArrayList<>();
    List<String> keyTwoInputs = new ArrayList<>();
    List<String> userTexts = new ArrayList<>();
    List<String> outputs = new ArrayList<>();
    Menu(Controller controller){
        JFrame frame = new JFrame("Four-Square Cipher by Rhalith");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel keyOneText, keyTwoText, userInputText;

        keyOneText = new JLabel("Key One :");
        keyTwoText = new JLabel("Key Two :");
        userInputText = new JLabel("Input :");

        String cryptInfo = "<html>Welcome to four-square cipher. <br/>You can either encrypt your plain text, <br/>or decrypt your encrypted text<html/>";
        JComponent cryptionInformation = new JLabel(cryptInfo);
        String keyInfo = "<html>You can either enter your own keys,<br/> or can generate randomly new ones.<html/>";
        JComponent keyInformation = new JLabel(keyInfo);

        JTextField keyOne = new JTextField();
        JTextField keyTwo = new JTextField();
        JTextField userInput = new JTextField();

        JLabel cryptionChoice;

        cryptionChoice = new JLabel("Encrypt - Manual");

        JButton enter = new JButton("Enter");

        JMenu mainMenu = new JMenu("Menu");

        JMenuBar menuBar = new JMenuBar();

        JMenu encryptionMenu = new JMenu("Encrypt");
        JMenu decryptionMenu = new JMenu("Decrypt");

        JMenuItem history = new JMenuItem("History");

        JMenuItem manualEncryption = new JMenuItem("Manual");
        JMenuItem randomEncryption = new JMenuItem("Random");

        JMenuItem manualDecryption = new JMenuItem("Manual");
        JMenuItem randomDecryption = new JMenuItem("Random");

        encryptionMenu.add(manualEncryption);
        encryptionMenu.add(randomEncryption);

        decryptionMenu.add(manualDecryption);
        decryptionMenu.add(randomDecryption);

        mainMenu.add(encryptionMenu);
        mainMenu.add(decryptionMenu);
        mainMenu.add(history);

        menuBar.add(mainMenu);

        frame.setJMenuBar(menuBar);

        cryptionChoice.setBounds(120,170,120,30);
        keyOneText.setBounds(10,200,80,30);
        keyOne.setBounds(80,200,250,30);
        keyTwoText.setBounds(10,250,80,30);
        keyTwo.setBounds(80,250,250,30);
        userInputText.setBounds(30,300,80,30);
        userInput.setBounds(80,300,250,30);
        enter.setBounds(100,350,80,30);


        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, cryptionInformation, keyInformation);

        splitPane.setBounds(10,10,365,150);
        frame.add(cryptionChoice);
        frame.add(splitPane);
        frame.add(keyOneText);
        frame.add(keyTwoText);
        frame.add(userInputText);
        frame.add(keyOne);
        frame.add(keyTwo);
        frame.add(userInput);
        frame.add(enter);



        frame.setSize(400,450);
        frame.setLayout(null);
        frame.setVisible(true);

        manualEncryption.addActionListener(e -> {
            ManualChoice(frame, userInputText, userInput, enter, keyOneText, keyTwoText, keyOne, keyTwo);
            cryptionChoice.setText("Encrypt - Manual");
            userCryptionChoice = 0;
        });

        randomEncryption.addActionListener(e -> {
            RandomChoice(frame, userInputText, userInput, enter, keyOneText, keyTwoText, keyOne, keyTwo);
            cryptionChoice.setText("Encrypt - Random");
            userCryptionChoice = 1;
        });
        manualDecryption.addActionListener(e -> {
            ManualChoice(frame, userInputText, userInput, enter, keyOneText, keyTwoText, keyOne, keyTwo);
            cryptionChoice.setText("Decrypt - Manual");
            userCryptionChoice = 2;
        });

        randomDecryption.addActionListener(e -> {
            RandomChoice(frame, userInputText, userInput, enter, keyOneText, keyTwoText, keyOne, keyTwo);
            cryptionChoice.setText("Decrypt - Random");
            userCryptionChoice = 3;
        });

        enter.addActionListener(e -> {
            switch (userCryptionChoice){
                case 0:
                    keyOneInput = keyOne.getText().toUpperCase(Locale.forLanguageTag("en"));
                    keyTwoInput = keyTwo.getText().toUpperCase(Locale.forLanguageTag("en"));
                    userText = userInput.getText().toUpperCase(Locale.forLanguageTag("en"));
                    controller.updateController(2, keyOneInput);
                    controller.updateController(3, keyTwoInput);
                    controller.updateController(1,"");
                    output = controller.updateController("E", userText);
                    break;
                case 1:
                    keyOneInput = "";
                    keyTwoInput = "";
                    userText = userInput.getText();
                    controller.updateController(2, keyOneInput);
                    controller.updateController(3, keyTwoInput);
                    controller.updateController(1,"");
                    output = controller.updateController("E", userText);
                    break;
                case 2:
                    keyOneInput = keyOne.getText().toUpperCase(Locale.forLanguageTag("en"));
                    keyTwoInput = keyTwo.getText().toUpperCase(Locale.forLanguageTag("en"));
                    userText = userInput.getText().toUpperCase(Locale.forLanguageTag("en"));
                    controller.updateController(2, keyOneInput);
                    controller.updateController(3, keyTwoInput);
                    controller.updateController(1,"");
                    output = controller.updateController("D", userText);
                    break;
                case 3:
                    keyOneInput = "";
                    keyTwoInput = "";
                    userText = userInput.getText();
                    controller.updateController(2, keyOneInput);
                    controller.updateController(3, keyTwoInput);
                    controller.updateController(1,"");
                    output = controller.updateController("D", userText);
                    break;
            }
            if(!userText.matches("[a-zA-Z]+(\\s+[a-zA-Z]+)*") || !keyOneInput.matches("[a-zA-Z]+(\\s+[a-zA-Z]+)*") || !keyTwoInput.matches("[a-zA-Z]+(\\s+[a-zA-Z]+)*")){
                JOptionPane.showMessageDialog(frame,"Please enter only English letters.");
            } else if (userText.length() < 1) {
                JOptionPane.showMessageDialog(frame,"Please enter more than 2 letters");
            }
            else{
                JOptionPane.showMessageDialog(frame,output);
                keyOneInputs.add(controller.getMatrices("one"));
                keyTwoInputs.add(controller.getMatrices("two"));
                userTexts.add(userText);
                outputs.add(output);

                System.out.println(keyOneInputs);
                System.out.println(keyTwoInputs);
                System.out.println(userTexts);
                System.out.println(outputs);
            }

        });

        history.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Not ready");
            frame.dispose();
        });
    }

    private void ManualChoice(JFrame frame, JComponent userInputText, JComponent userInput, JComponent enter, JComponent... components)
    {
        for (JComponent component : components) {
            component.setVisible(true);
        }
        frame.setSize(400,450);
        userInputText.setBounds(30,300,80,30);
        userInput.setBounds(80,300,250,30);
        enter.setBounds(100,350,80,30);
    }
    private void RandomChoice(JFrame frame, JComponent userInputText, JComponent userInput, JComponent enter, JComponent... components)
    {
        for (JComponent component : components) {
            component.setVisible(false);
        }
        frame.setSize(400,350);
        userInputText.setBounds(30,200,80,30);
        userInput.setBounds(80,200,250,30);
        enter.setBounds(100,250,80,30);
    }



}