package stage4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Decipher {
    public static void main(String[] args) {
        String input = getInput();

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
        System.out.println(binaryToChar(sevenDigitBinaryChunks));
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input encoded string:");
        String input = scanner.nextLine();
        System.out.println();
        System.out.println("The result:");
        return input;
    }

    private static List<String> decipherIntoBinaryChunks(String[] arr) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < arr.length; i+=2) {
            char header = (arr[i].equals("0")) ? '1' : '0';
            int strlen = arr[i + 1].length();
            String binaryChunk = duplicateChar(header, strlen);
            stringList.add(binaryChunk);
        }
        return stringList;
    }

    public static String duplicateChar(char c, int x) {
        String result = "";
        for (int i = 0; i < x; i++) {
            result += c;
        }
        return result;
    }

    private static List<String> splitStringIntoSubstrings(String input, int substringLength) {
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < input.length(); i += substringLength) {
            // Using Math.min is not necessary because the input.length should always be divisible by substringLength
            // It ensures we don't extract a substring that goes beyond the end of the input string
            // However, it is nice to have as a safety measure
            String substring = input.substring(i, Math.min(i + substringLength, input.length()));
            substrings.add(substring);
        }
        return substrings;
    }

    private static String binaryToChar(List<String> binaryChunkList) {
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
