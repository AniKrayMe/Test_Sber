package org.example.service;

import org.example.object.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataService {

    /**
     * @param path принимает путь к файлу
     *             запускает метод (loadingData)
     */
    public static void showData(String path) {
        for (City city : loadingData(path)) {
            System.out.println(city);
        }
    }

    /**
     * @param path принимает путь к файлу
     *             зполняет List через Scanner
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

    /**
     * @param path принимает путь к файлу
     *             выводит ID гоородм с наивысшей популяцией
     */
    public static void maxDataByCityPopulationById(String path) {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            int max = 0;
            String cons = null;
            String result = null;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] array = line.split(";");
                if (Integer.parseInt(array[4]) > max) {
                    max = Integer.parseInt(array[4]);
                    cons = array[0];
                }
                result = "[" + cons + "] = " + max;
            }
            System.out.println(result);
        } catch (FileNotFoundException ignored) {
        }
    }
}
