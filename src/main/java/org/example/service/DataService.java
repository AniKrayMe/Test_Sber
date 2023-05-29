package org.example.service;

import org.example.object.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataService {

    /**
     * принимает путь к папке (String)
     * запускает метод (loadingData)
     */
    public static void showData(String path) {
        for (City city : loadingData(path)) {
            System.out.println(city);

        }
    }

    /**
     * получает файл и пакует в (List)
     */
    public static List<City> loadingData(String path) {
        try {
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
            scanner.close();
            return cityList;
        } catch (FileNotFoundException ignored) {
        }
        return null;
    }
}
