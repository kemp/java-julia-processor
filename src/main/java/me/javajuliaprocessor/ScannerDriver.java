package me.javajuliaprocessor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScannerDriver {
    /**
     * Run a new scanner, accepting a file as input
     *
     * @param args The file
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java me.javajuliaprocessor.ScannerDriver [file]");
            return;
        }

        try {
            String input = new String(
                Files.readAllBytes(Paths.get(args[0])
            ), StandardCharsets.UTF_8);

            Scanner scanner = new Scanner(System.out);
            scanner.scan(input);
        } catch (IOException e) {
            System.err.println("The file could not be opened.");
            e.printStackTrace();
        }
    }
}
