package stage4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Decipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input encoded string:");
        String input = scanner.nextLine();
        System.out.println();
        System.out.println("The result:");

        // Split the ciphered string at the space --> ["0", "0", "00", "0000"]
        String[] cipherString = input.split(" ");

        // Create a list containing binary chunks
        List<String> binaryChunkList = new ArrayList<>();

        // Declare a string builder that will have the binary chunks appended to it
        StringBuilder binaryStrBuilder = new StringBuilder();

        for (int i = 0; i < cipherString.length; i+=2) {
            char header = (cipherString[i].equals("0")) ? '1' : '0';
            int strlen = cipherString[i + 1].length();

            String binaryChunk = duplicateChar(header, strlen);
            binaryChunkList.add(binaryChunk);
        }

        // Append chunks to binaryStringBuilder
        binaryChunkList.forEach(binaryStrBuilder::append);

        // Split the binary string into substrings, e.g. "10000111000011" --> ["1000011", "1000011"]
        List<String> sevenDigitBinaryChunks = splitStringIntoSubstrings(binaryStrBuilder.toString(), 7);

        // Print result
        System.out.println(binaryToChar(sevenDigitBinaryChunks));
    }

    private static String binaryToChar(List<String> binaryChunkList) {
        StringBuilder finalStrBuilder = new StringBuilder();
        for (String chunk : binaryChunkList) {
            int decimalVal = Integer.parseInt(chunk, 2);
            char character = (char) decimalVal;
            finalStrBuilder.append(character);
        }
        return finalStrBuilder.toString();
    }

    private static List<String> splitStringIntoSubstrings(String input, int substringLength) {
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < input.length(); i += substringLength) {
            String substring = input.substring(i, Math.min(i + substringLength, input.length()));
            substrings.add(substring);
        }
        return substrings;
    }

    public static String duplicateChar(char c, int x) {
        String result = "";
        for (int i = 0; i < x; i++) {
            result += c;
        }
        return result;
    }
}
