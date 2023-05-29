package org.example;


import org.example.service.DataService;
import org.example.service.SortByCityDistrict;
import org.example.service.SortByCityName;


public class Main {
    public static void main(String[] args) {

        String path = "C:/Users/Anikr/OneDrive/Рабочий стол/Задача ВС Java Сбер.csv";

        DataService.showData(path);  // => №1 задание

 //       SortByCityName.sortDataByCityName(path); // => №2 задание

 //       SortByCityDistrict.sortDataByCityDistrict(path); // =>  №3 задание


    }
}