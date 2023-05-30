package org.example.services;

import org.example.models.City;

import java.util.Comparator;
import java.util.List;

public class SortByCityName implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
        return city1.getName().compareTo(city2.getName());
    }

    /**
     * @param path принимает путь к файлу
     *             сортирует по наименованию Города [А-Я]
     */
    public static void sortDataByCityName(String path) {
        List<City> cityList = DataService.loadingData(path);
        cityList.sort(new SortByCityName());
        for (City city : cityList) {
            System.out.println(city);
        }
    }
}
