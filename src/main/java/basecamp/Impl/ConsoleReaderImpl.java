package basecamp.Impl;

import basecamp.ConsoleReader;

import java.util.Scanner;

public class ConsoleReaderImpl implements ConsoleReader {

    public int input() {

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();

        if (inputString.matches("^[0-9]+$")) {
            return Integer.parseInt(inputString);
        } else {
            return -1; //Code of wrong input format
        }
    }
}
