package pl.polsl.nuhyigitakman.model;

import java.util.Arrays;

/**
 *
 * @author Nuh Yigit Akman
 *
 * @version 1.0
 */
public class Coder {
    /**
     * Encoding by choosing encryption or decryption
     * @param plot Q1/Q4 arrays
     * @param plot1 Q2 array
     * @param plot2 Q3 array
     * @param text text that want to be encode
     * @param isEncryption choose of encryption or decryption
     * @return encoded string
     */

    public String encodeText(char[] plot, char[] plot1, char[] plot2, String text, boolean isEncryption){

        try {
            if(isEncryption){
                return encrypt(plot, plot1, plot2, text);
            }
            else{
                return decrypt(plot, plot1, plot2, text);
            }
        } catch (Exception e){
            return e.toString();
        }

    }
    /**
     * Decrypting the encrypted string by using key arrays
     * @param plot fixed arrays(Q1 and Q4) for four-square cipher
     * @param plot1 array Q2
     * @param plot2 array Q3
     * @param encryptedText encrypted text for decryption
     * @return decrypted string
     */
    private String decrypt(char[] plot, char[] plot1, char[] plot2, String encryptedText) {
        char[] pairs = new char[2];
        String decryptedText = "";
        String[] pairsOfEncryptedText = new String[encryptedText.length() / 2];


        int cursor = 0;
        for (int i = 0; i < pairsOfEncryptedText.length; i++) {
            pairsOfEncryptedText[i] = "" + encryptedText.charAt(cursor) + encryptedText.charAt(cursor + 1);
            // step by two
            cursor = cursor + 2;
        }

        System.out.println("Pairs: " + Arrays.toString(pairsOfEncryptedText));

        // O(nk)
        for (String s : pairsOfEncryptedText) {
            int column_a = 0;
            int row_a = 0;
            int column_b = 0;
            int row_b = 0;

            // get the pairs
            pairs[0] = s.charAt(0);
            pairs[1] = s.charAt(1);

            // find the pairs on key plot 1 NormalAlphabets
            for (int j = 0; j < plot.length; j++) {
                // find the first pair to from the normal alphabets
                if (pairs[0] == plot1[j]) {
                    // the plot is 5 by 25 and we need to find the row, we can convert it to 5x5 (divide 5)
                    row_a = (j / 5) * 5;
                    // We need to find the column by seeing the remainder, therefore we mod it by 5
                    column_a = j % 5;
                }

                // find the second pair to from the normal alphabets
                if (pairs[1] == plot2[j]) {
                    row_b = (j / 5) * 5;
                    column_b = j % 5;
                }
            }

            // we need to reverse the column and the row in the two key plot (ciphered plot)
            decryptedText += plot[row_a + column_b]; // find in the key plot 1 Q1
            decryptedText += plot[row_b + column_a];  // find in the key plot 2 Q4
        }

        // show the encrypted text
        return decryptedText;
    }
    /**
     * Encrypting the decrypted string by using key arrays
     * @param plot fixed arrays(Q1 and Q4) for four-square cipher
     * @param plot1 array Q2
     * @param plot2 array Q3
     * @param plainText decrypted text for decryption
     * @return encrypted string
     */
    private String encrypt(char[] plot, char[] plot1, char[] plot2, String plainText) {
        char[] pairs = new char[2];
        String encryptedText = "";
        plainText = plainText.replaceAll("\\s", "");
        String[] pairsOfEncryptText = new String[plainText.length() / 2];

        int cursor = 0;
        for (int i = 0; i < pairsOfEncryptText.length; i++) {
            pairsOfEncryptText[i] = "" + plainText.charAt(cursor) + plainText.charAt(cursor + 1);
            // step by two
            cursor = cursor + 2;
        }

        // show the pairs
        System.out.println("Pairs: " + Arrays.toString(pairsOfEncryptText));

        // O(nk)
        for (String s : pairsOfEncryptText) {
            int column_a = 0;
            int row_a = 0;
            int column_b = 0;
            int row_b = 0;

            // get the pairs
            pairs[0] = s.charAt(0);
            pairs[1] = s.charAt(1);

            // find the pairs on key fixed alphabet
            for (int j = 0; j < plot.length; j++) {
                // find the first pair to from the fixed alphabets
                if (pairs[0] == plot[j]) {
                    // the plot is 5 by 25 and we need to find the row, we can convert it to 5x5 (divide 5)
                    row_a = (j / 5) * 5;
                    // to find the column we need to see the remainder, we (mod) it by 5 (j % 5)
                    column_a = j % 5;
                }

                // find the second pair to from the fixed alphabets
                if (pairs[1] == plot[j]) {
                    row_b = (j / 5) * 5;
                    column_b = j % 5;
                }
            }
            // we need to reverse the column and the row in the two key plot (ciphered plot)
            encryptedText += plot1[row_a + column_b]; // find in the key plot 1 Q2
            encryptedText += plot2[row_b + column_a];  // find in the key plot 2 Q3
        }

        return encryptedText;
    }
}
