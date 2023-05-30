package org.example.services;

import org.example.models.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


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

    /**
     * @param path принимает путь к файлу
     *             создаёт новый HashMap где String это Регион а Integer количество городов
     *             проверяет есть ли в key регион, если нет то добовляет с value 1,
     *             если есть то увеличивает value на 1
     */
    public static void sumOfCitiesByRegion(String path) {
        List<City> cityList = DataService.loadingData(path);
        Map<String, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < cityList.size(); i++) {
                String regionName = cityList.get(i).getRegion();
                if (!hashMap.containsKey(regionName)) {
                    hashMap.put(regionName, 1);
                } else {
                    hashMap.put(regionName, hashMap.get(regionName) + 1);
                }
            }
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                System.out.println( entry.getKey() + " - " + entry.getValue());
            }

    }

}
