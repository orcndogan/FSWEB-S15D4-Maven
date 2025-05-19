package org.example;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // Test amaçlı çıktılar
        System.out.println(checkForPalindrome("I did, did I?")); // true
        System.out.println(checkForPalindrome("Racecar"));       // true
        System.out.println(checkForPalindrome("hello"));         // false
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?")); // true

        System.out.println(convertDecimalToBinary(0));  // "0"
        System.out.println(convertDecimalToBinary(5));  // "101"
        System.out.println(convertDecimalToBinary(10)); // "1010"
    }

    public static boolean checkForPalindrome(String text) {
        if (text == null || text.isEmpty()) {
            return false; // Boş veya null string palindrom kabul edilmez
        }

        String cleanedStr = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> charDeque = new LinkedList<>();

        for (char c : cleanedStr.toCharArray()) {
            charDeque.addLast(c);
        }

        while (charDeque.size() > 1) {
            if (!Objects.equals(charDeque.pollFirst(), charDeque.pollLast())) {
                return false;
            }
        }
        return true;
    }

    public static String convertDecimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        StringBuilder binaryString = new StringBuilder();

        while (decimal > 0) {
            binaryString.insert(0, decimal % 2);
            decimal /= 2;
        }

        return binaryString.toString();
    }
}