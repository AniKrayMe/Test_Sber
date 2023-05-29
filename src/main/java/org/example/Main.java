package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String separator = File.separator;
        String path = "C:" + separator + "Users" + separator + "Anikr" + separator + "OneDrive" + separator + "Рабочий стол" + separator + "Задача ВС Java Сбер.csv";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        List<City> cityList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] array = line.split(";");
            try {
                cityList.add(new City(array[1], array[2], array[3], Integer.parseInt(array[4]), array[5]));
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        }
        for (City city : cityList) {
            System.out.println(city + "\n");
        }
        scanner.close();
    }
}