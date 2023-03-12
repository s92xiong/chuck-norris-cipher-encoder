package stage1;

import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String myString = scanner.nextLine();
        String result = "";
        System.out.println();
        for (int i = 0; i < myString.length(); i++) {
            result += myString.charAt(i) + " ";
        }
        System.out.println(result);
    }
}
