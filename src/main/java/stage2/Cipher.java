package stage2;

import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();
        System.out.println();
        System.out.println("The result:");
        printBinary(input);
    }

    public static void printBinary(String input) {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            int asciiCode = convertCharToASCII(currentChar);
            String binaryString = convertAsciiToBinary(asciiCode);
            String result = String.format("%c = %07d", currentChar, Integer.parseInt(binaryString));
            System.out.println(result);
        }
    }

    public static int convertCharToASCII(char c) {
        return (int) c;
    }

    public static String convertAsciiToBinary(int asciiCode) {
        return Integer.toBinaryString(asciiCode);
    }
}
