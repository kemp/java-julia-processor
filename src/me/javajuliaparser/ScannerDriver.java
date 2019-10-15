package me.javajuliaparser;

public class ScannerDriver {
    public static void main(String[] args) {
        // TODO: Accept file as input
        String input = "a = a + 1";

        Scanner scanner = new Scanner(System.out);
        scanner.scan(input);
    }
}
