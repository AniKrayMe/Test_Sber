package org.example;


import org.example.service.DataService;

public class Main {
    public static void main(String[] args) {

        String path = "C:/Users/Anikr/OneDrive/Рабочий стол/Задача ВС Java Сбер.csv";  //сюда скопируйте путь к файлу

        //       DataService.showData(path);                       // => №1 задание

        //       SortByCityName.sortDataByCityName(path);          // => №2 задание

        //       SortByCityDistrict.sortDataByCityDistrict(path);  // => №3 задание

               DataService.maxDataByCityPopulationById(path);    // => №4 задание


    }
}