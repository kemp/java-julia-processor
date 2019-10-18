package me.javajuliaprocessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

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

        Scanner scanner = new Scanner(System.out);

        try {
            List<String> fileLines = Files.lines(Paths.get(args[0]))
                    .collect(Collectors.toList());

            scanner.scan(fileLines);
        } catch (IOException e) {
            System.err.println("The file could not be opened.");
            e.printStackTrace();
        }
    }
}
