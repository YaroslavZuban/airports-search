package org.example;
import java.util.Map;
import java.util.TreeMap;
public class DataMapPrinter {
    public static void printAndClearData(Map<?, String> dataMap) {
        for (Map.Entry<?, String> entry : dataMap.entrySet()) {
            System.out.println(entry.getKey() + "[" + entry.getValue() + "]");
        }

        System.out.print("Количество найденных строк: " + dataMap.size()+" ");

        dataMap.clear();
    }
}