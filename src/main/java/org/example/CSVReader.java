package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class CSVReader {
    public void read(String line) {
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(line);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String sb;

            List<String> data = new ArrayList<>();
            SearchByNthWord search = new SearchByNthWord();

            while ((sb = br.readLine()) != null) {
                data.add(sb);

                if (data.size() == 10) {
                    for (String temp : data) {
                        if (search.startsWithNthColumn(temp, Data.numberColum, Data.inputString)) {
                            addDataMap(temp, Data.numberColum);
                        }
                    }

                    data.clear();
                }
            }

            // Обработка оставшихся строк
            if (!data.isEmpty()) {
                for (String temp : data) {
                    if (search.startsWithNthColumn(temp, Data.numberColum, Data.inputString)) {
                        addDataMap(temp, Data.numberColum);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
    }

    public void addDataMap(String line, int n) {
        String[] words = line.split(",");

        if (!Data.isColumnString) {
            double tempNumber = Double.parseDouble(words[n - 1]);

            Data.dataNumber.put(tempNumber, line);
        } else {
            Data.dataString.put(words[n - 1], line);
        }
    }
}
