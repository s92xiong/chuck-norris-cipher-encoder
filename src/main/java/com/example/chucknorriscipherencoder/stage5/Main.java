package com.example.chucknorriscipherencoder.stage5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            String input = getInput();
            if (input.equals("exit")) break;
        }
    }

    private static String getInput() {
        String input = handleScannerInput("Please input operation (encode/decode/exit):");
        runOperations(input);
        return input;
    }

    private static String handleScannerInput(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextLine();
    }

    private static void runOperations(String input) {
        switch (input) {
            case "encode":
                runEncode();
                break;
            case "decode":
                runDecode();
                break;
            case "exit":
                runExit();
                break;
            default:
                System.out.println(String.format("There is no '%s' operation", input));
                break;
        }
        System.out.println();
    }

    private static void runEncode() {
        String input = handleScannerInput("Input string:");
        Cipher.main(input);
    }

    private static void runDecode() {
        try {
            String input = handleScannerInput("Input encoded string:");
            Decipher.main(input);
        } catch (Exception e) {
            System.out.println("Encoded string is not valid.");
        }
    }

    private static void runExit() {
        System.out.println("Bye!");
    }
}

class Cipher {
    public static void main(String input) {
        StringBuilder binaryString = new StringBuilder();

        // convert input string to binary string
        for (char c : input.toCharArray()) {
            String binaryChar = Integer.toBinaryString(c);
            binaryChar = String.format("%7s", binaryChar).replace(' ', '0');
            binaryString.append(binaryChar);
        }

        // encode binary string using Chuck Norris technique
        StringBuilder encodedString = new StringBuilder();
        int i = 0;
        while (i < binaryString.length()) {
            int j = i + 1;
            while (j < binaryString.length() && binaryString.charAt(j) == binaryString.charAt(i)) {
                j++;
            }
            encodedString.append(binaryString.charAt(i) == '0' ? "00 " : "0 ");
            for (int k = i; k < j; k++) {
                encodedString.append("0");
            }
            if (j < binaryString.length()) {
                encodedString.append(" ");
            }
            i = j;
        }

        System.out.println("Encoded string:");
        System.out.println(encodedString.toString());
    }
}

class Decipher {
    static String errorMsg = "Encoded string is not valid.";
    public static void main(String input) throws Exception {
        if (!isAllZeroes(input)) {
            throw new Exception("An error occurred.");
        }
        // Split ciphered input at the space --> ["0", "0", "00", "0000"]
        String[] cipherStringArr = input.split(" ");

        // Decipher the array of 0s into binary chunks --> ["1", "0000"]
        List<String> binaryChunkList = decipherIntoBinaryChunks(cipherStringArr);

        // Create a string builder and append the binary chunks onto it
        StringBuilder binaryStrBuilder = new StringBuilder();
        binaryChunkList.forEach(binaryStrBuilder::append);

        // Split the binary string into substrings, e.g. "10000111000011" --> ["1000011", "1000011"]
        List<String> sevenDigitBinaryChunks = splitStringIntoSubstrings(binaryStrBuilder.toString(), 7);

        // Print string result
        System.out.println("Decoded string:");
        System.out.println(binaryToChar(sevenDigitBinaryChunks));
    }

    public static boolean isAllZeroes(String input) {
        for (char c : input.toCharArray()) {
            if (c != '0' && c != ' ') {
                // if the character is not '0' or ' ', return false
                return false;
            }
        }
        // if we've made it this far, all characters are either '0' or ' '
        return true;
    }

    static List<String> decipherIntoBinaryChunks(String[] arr) throws Exception {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < arr.length; i+=2) {
            if (!(arr[i].equals("0") || arr[i].equals("00"))) {
                throw new Exception("Incorrect header!");
            }
            char header = (arr[i].equals("0")) ? '1' : '0';
            int strlen = arr[i + 1].length();
            String binaryChunk = duplicateChar(header, strlen);
            stringList.add(binaryChunk);
        }
        return stringList;
    }

    static String duplicateChar(char c, int x) {
        String result = "";
        for (int i = 0; i < x; i++) {
            result += c;
        }
        return result;
    }

    static List<String> splitStringIntoSubstrings(String input, int substringLength) {
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < input.length(); i += substringLength) {
            String substring = input.substring(i, i + substringLength);
            substrings.add(substring);
        }
        return substrings;
    }

    static String binaryToChar(List<String> binaryChunkList) {
        StringBuilder finalStrBuilder = new StringBuilder();
        for (String chunk : binaryChunkList) {
            // The 2 as the second argument specifies that the string should be interpreted as a binary number
            int decimalVal = Integer.parseInt(chunk, 2);
            // Cast decimalVal to a char to get the corresponding ASCII character
            char character = (char) decimalVal;
            finalStrBuilder.append(character);
        }
        return finalStrBuilder.toString();
    }
}