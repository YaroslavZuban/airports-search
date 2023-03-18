package org.example;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchByNthWord {
    private final CheckingNumber sorter = new CheckingNumber();
    public boolean startsWithNthColumn(String sentence, int n, String substring) {
        int startIndex = 0;
        int endIndex = 0;
        int wordCount = 1;

        while (endIndex < sentence.length()) {
            endIndex = sentence.indexOf(',', startIndex);

            if (endIndex == -1) {
                endIndex = sentence.length();
            }

            if (wordCount == n) {
                String word = sentence.substring(startIndex, endIndex).toLowerCase();

                if (!sorter.isNumeric(substring)) {
                    Data.isColumnString = true;
                    substring = "\"" + substring;
                }

                if (Data.isFirstIteration) {
                    Data.isFirstIteration = false;

                    if (Data.isColumnString) {
                        Data.dataString = new TreeMap<>();
                    } else {
                        Data.dataNumber = new TreeMap<>();
                    }
                }
                return word.startsWith(substring.toLowerCase());
            }

            startIndex = endIndex + 1;
            wordCount++;
        }

        return false;
    }
}
