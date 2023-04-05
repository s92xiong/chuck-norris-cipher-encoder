package com.example.chucknorriscipherencoder.stage3;
import java.util.Scanner;
public class Cipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();
        System.out.println();
        System.out.println("The result:");

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

        // print the encoded string
        System.out.println(encodedString.toString());
    }
}
