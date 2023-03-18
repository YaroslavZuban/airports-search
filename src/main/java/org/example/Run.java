package org.example;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Run {
    public void launch(String[] args, String line) {
        if (args.length != 1) {
            System.out.println("Ошибка: необходимо ввести один аргумент - номер столбца!");
            System.out.println("Использование: java -jar airports-search-*.jar <номер столбца>");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        ProgramTimer timer = new ProgramTimer();
        CSVReader csvReader = new CSVReader();

        while (true) {
            System.out.print("Введите строку: ");

            Data.inputString = scanner.nextLine();
            Data.numberColum = Integer.parseInt(args[0]);

            if (Data.inputString.contains("!quit")) {
                System.out.println("Программа завершена.");
                return;
            }

            timer.startTimer();
            csvReader.read(line);
            timer.stopTimer();

            if (Data.isColumnString) {
                DataMapPrinter.printAndClearData(Data.dataString);
            } else {
                DataMapPrinter.printAndClearData(Data.dataNumber);
            }

            timer.printElapsedTime();
        }
    }
}
