/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

import me.javajuliaprocessor.scanner.Scanner;
import me.javajuliaprocessor.scanner.Token;
import me.javajuliaprocessor.scanner.TokenList;
import me.javajuliaprocessor.scanner.UnknownTokenException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    /**
     * Run a new scanner, accepting a file as input
     *
     * @param args The file
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java " + Main.class.getName() + " [file]");
            return;
        }

        Scanner scanner = new Scanner();

        try {
            List<String> fileLines = Files.lines(Paths.get(args[0]))
                    .collect(Collectors.toList());

            TokenList tokens = scanner.scan(fileLines);
            System.out.println("Beginning to Scan... ");

            // Print out the list of tokens.
            for (Token token : tokens) {
                System.out.println("Next token: " + token.getType().getId() + ", Next Lexeme: " + token.getLexeme());
            }

            System.out.println("Scanning complete! Parsing...");

            // Convert the token list to an ArrayList of objects.
            ArrayList<Object> tokenObjects = new ArrayList<Object>();
            tokenObjects.addAll(tokens);

            Parser parser = new Parser(tokenObjects);

            parser.parse();

            System.out.println("Printing the grammer of the program...");
            parser.printGrammar();
            
            System.out.println("Interpreting the program... \n");
            parser.interpret();

        } catch (IOException e) {
            System.err.println("The file could not be opened.");
            e.printStackTrace();
        } catch (UnknownTokenException e) {
            throw new RuntimeException(e);
        }
    }
}
