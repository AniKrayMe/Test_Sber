package org.example.service;

import org.example.object.City;

import java.util.Comparator;
import java.util.List;

public class SortByCityDistrict implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
        String result = city1.getDistrict() + city1.getName();
        String result2 = city2.getDistrict() + city2.getName();
        return result.compareTo(result2);
    }

    public static void sortDataByCityDistrict(String path) {
        List<City> cityList = DataService.loadingData(path);
        cityList.sort(new SortByCityDistrict());
        for (City city : cityList) {
            System.out.println(city);
        }
    }
}
