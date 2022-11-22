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

    String encryptOrDecrypt;


    List<History> histories = new ArrayList<>();

    JFrame historyFrame = new JFrame();

    Menu(Controller controller){
        controller.updateController(1,"");
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

        JMenuItem historyItem = new JMenuItem("History");

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
        mainMenu.add(historyItem);

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
                    output = controller.updateController("E", userText);
                    encryptOrDecrypt = "Encryption";
                    break;
                case 1:
                    keyOneInput = "";
                    keyTwoInput = "";
                    userText = userInput.getText().toUpperCase(Locale.forLanguageTag("en"));
                    controller.updateController(2, keyOneInput);
                    controller.updateController(3, keyTwoInput);
                    output = controller.updateController("E", userText);
                    encryptOrDecrypt = "Encryption";
                    break;
                case 2:
                    keyOneInput = keyOne.getText().toUpperCase(Locale.forLanguageTag("en"));
                    keyTwoInput = keyTwo.getText().toUpperCase(Locale.forLanguageTag("en"));
                    userText = userInput.getText().toUpperCase(Locale.forLanguageTag("en"));
                    controller.updateController(2, keyOneInput);
                    controller.updateController(3, keyTwoInput);
                    output = controller.updateController("D", userText);
                    encryptOrDecrypt = "Decryption";
                    break;
                case 3:
                    keyOneInput = "";
                    keyTwoInput = "";
                    userText = userInput.getText().toUpperCase(Locale.forLanguageTag("en"));
                    controller.updateController(2, keyOneInput);
                    controller.updateController(3, keyTwoInput);
                    output = controller.updateController("D", userText);
                    encryptOrDecrypt = "Decryption";
                    break;
            }
            if(userCryptionChoice == 0 || userCryptionChoice == 2){
                if(!userText.matches("[a-zA-Z]+(\\s+[a-zA-Z]+)*") || !keyOneInput.matches("[a-zA-Z]+(\\s+[a-zA-Z]+)*") || !keyTwoInput.matches("[a-zA-Z]+(\\s+[a-zA-Z]+)*")){
                    JOptionPane.showMessageDialog(frame,"Please enter only English letters.");
                } else if (userText.length() < 1) {
                    JOptionPane.showMessageDialog(frame,"Please enter more than 2 letters");
                }
                else{
                    JOptionPane.showMessageDialog(frame,output);
                    History history = new History(encryptOrDecrypt, controller.getMatrices("one"), controller.getMatrices("two"), userText, output);
                    histories.add(history);
                    controller.ClearMatrices();
                }
            }
            else{
                if(!userText.matches("[a-zA-Z]+(\\s+[a-zA-Z]+)*")){
                    JOptionPane.showMessageDialog(frame,"Please enter only English letters.");
                } else if (userText.length() < 1) {
                    JOptionPane.showMessageDialog(frame,"Please enter more than 2 letters");
                }
                else{
                    JOptionPane.showMessageDialog(frame,output);
                    History history = new History(encryptOrDecrypt, controller.getMatrices("one"), controller.getMatrices("two"), userText, output);
                    histories.add(history);
                    controller.ClearMatrices();
                }
            }


        });

        historyItem.addActionListener(e -> new History(historyFrame, histories));
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

class History{
    private String userChoice;
    private String keyOne;
    private String keyTwo;
    private String userText;
    private String output;

    boolean isFirst = false;


    History(JFrame frame, List<History> histories){
        isFirst = true;
        createHistoryPage(frame);
        if(histories.size() >= 1){
            if(!isFirst){
                isFirst = true;
                createHistoryPage(frame);
            }

            for (int i = 0; i < histories.size(); i++) {
                JLabel temporaryChoice, temporaryKeyOne, temporaryKeyTwo, temporaryUserText, temporaryOutput;

                temporaryChoice = new JLabel(histories.get(i).userChoice);
                temporaryKeyOne = new JLabel(histories.get(i).keyOne);
                temporaryKeyTwo = new JLabel(histories.get(i).keyTwo);
                temporaryUserText = new JLabel(histories.get(i).userText);
                temporaryOutput = new JLabel(histories.get(i).output);

                temporaryChoice.setBounds(10, (i+1)*30+10, 100 ,30);
                temporaryKeyOne.setBounds(220,(i+1)*30+10,240,30);
                temporaryKeyTwo.setBounds(520,(i+1)*30+10,240,30);
                temporaryUserText.setBounds(800,(i+1)*30+10,100,30);
                temporaryOutput.setBounds(1030,(i+1)*30+10,100,30);

                frame.add(temporaryChoice);
                frame.add(temporaryKeyOne);
                frame.add(temporaryKeyTwo);
                frame.add(temporaryUserText);
                frame.add(temporaryOutput);
            }
            frame.setLayout(null);
            frame.setSize(1200,500);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        else{
            JOptionPane.showMessageDialog(null, "You did not perform any action yet!");
        }
    }

    void createHistoryPage(JFrame frame){

        JLabel encryptOrDecrypt, keyOneLabel, keyTwoLabel, userTextLabel, outputLabel;

        encryptOrDecrypt = new JLabel("Encrypt/Decrypt");
        keyOneLabel = new JLabel("Key One");
        keyTwoLabel = new JLabel("Key Two");
        userTextLabel = new JLabel("User Input");
        outputLabel = new JLabel("Output");

        encryptOrDecrypt.setBounds(10,10,100,30);
        keyOneLabel.setBounds(220,10,240,30);
        keyTwoLabel.setBounds(520,10,240,30);
        userTextLabel.setBounds(800,10,100,30);
        outputLabel.setBounds(1030,10,100,30);

        frame.add(encryptOrDecrypt);
        frame.add(keyOneLabel);
        frame.add(keyTwoLabel);
        frame.add(userTextLabel);
        frame.add(outputLabel);
    }

    History(String userChoice, String keyOneInput, String keyTwoInput, String userText, String output){
        this.userChoice = userChoice;
        this.keyOne = keyOneInput;
        this.keyTwo = keyTwoInput;
        this.userText = userText;
        this.output = output;
    }
}