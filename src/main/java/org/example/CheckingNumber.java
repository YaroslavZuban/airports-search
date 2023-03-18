package org.example;

public class CheckingNumber {
    boolean isNumeric(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        return word.matches("-?\\d+(\\.\\d+)?");
    }
}