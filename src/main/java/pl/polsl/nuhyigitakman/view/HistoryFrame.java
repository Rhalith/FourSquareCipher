package pl.polsl.nuhyigitakman.view;

import javax.swing.*;
import java.util.List;

/**
 * @author Nuh Yigit Akman
 * @version 1.2
 */
class HistoryFrame {
    /**
     * Data array for history JTable
     */
    String[][] data = new String[1][5];
    /**
     * Column array for history JTable
     */
    String[] column = {"Encrypt/Decrypt", "Key One", "Key Two", "User Input", "Output"};

    /**
     * Constructor of HistoryFrame Class
     *
     * @param frame     JFrame for add JTable
     * @param histories List of variables that performed by user
     */
    HistoryFrame(JFrame frame, List<History> histories) {
        if (histories.size() >= 1) {

            for (int i = 0; i < histories.size(); i++) {
                if (histories.size() > data.length) data = increaseSize(data);
                data[i][0] = histories.get(i).getUserChoice();
                data[i][1] = histories.get(i).getKeyOne();
                data[i][2] = histories.get(i).getKeyTwo();
                data[i][3] = histories.get(i).getUserText();
                data[i][4] = histories.get(i).getOutput();
            }
            JTable table = new JTable(data, column);
            table.setBounds(30, 40, 1100, 480);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(10, 10, 1100, 480);
            frame.add(scrollPane);
            frame.setLayout(null);
            frame.setSize(1200, 500);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else {
            JOptionPane.showMessageDialog(null, "You did not perform any action yet!");
        }

    }

    /**
     * Makes array dynamic for increase size of it.
     *
     * @param original 2D array that needs to be increase it size
     * @return size increased 2D array
     */
    private String[][] increaseSize(String[][] original) {
        String[][] temp = new String[original.length + 1][original[0].length];

        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, temp[i], 0, original[i].length);
        }
        return temp;
    }
}
