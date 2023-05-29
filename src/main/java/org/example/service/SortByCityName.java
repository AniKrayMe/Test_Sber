package org.example.service;

import org.example.object.City;

import java.util.Comparator;
import java.util.List;

public class SortByCityName implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
        return city1.getName().compareTo(city2.getName());
    }


    /**
     * получает файл сортирует по наименованию Города
     */
    public static void sortDataByCityName(String path) {
        List<City> cityList = DataService.loadingData(path);
        cityList.sort(new SortByCityName());
        for (City city : cityList) {
            System.out.println(city);
        }
    }
}
