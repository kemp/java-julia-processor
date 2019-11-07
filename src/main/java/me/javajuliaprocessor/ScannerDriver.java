/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
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
            System.err.println("Usage: java " + ScannerDriver.class.getName() + " [file]");
            return;
        }

        Scanner scanner = new Scanner();

        try {
            List<String> fileLines = Files.lines(Paths.get(args[0]))
                    .collect(Collectors.toList());

            TokenList tokens = scanner.scan(fileLines);

            // Print out the list of tokens.
            for (Token token : tokens) {
                System.out.println("Next token: " + token.getType().getId() + ", Next Lexeme: " + token.getLexeme());
            }

        } catch (IOException e) {
            System.err.println("The file could not be opened.");
            e.printStackTrace();
        } catch (UnknownTokenException e) {
            throw new RuntimeException(e);
        }
    }
}
