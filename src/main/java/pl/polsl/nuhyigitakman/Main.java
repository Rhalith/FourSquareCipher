package pl.polsl.nuhyigitakman;

import pl.polsl.nuhyigitakman.controller.Controller;
import pl.polsl.nuhyigitakman.model.Coder;
import pl.polsl.nuhyigitakman.model.Matrices;
import pl.polsl.nuhyigitakman.view.View;

import java.util.Scanner;

/**
 *
 * @author Nuh Yigit Akman
 *
 * @version 1.1
 */
public class Main {


    /**
     * Main method for cipher
     * @param args String[]
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Coder coder = new Coder();
        Matrices matrices = new Matrices();
        Controller controller = new Controller(matrices, coder);
        View view = new View(scanner, controller);

        view.run();

    }
}
