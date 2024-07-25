package class03.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();
        LinkedHashMap<String, Long> totalPopulation = new LinkedHashMap<>();
        String input = sc.nextLine();
        while (!input.equals("report")) {
            String[] token = input.split("\\|");
            String city = token[0];
            String country = token[1];
            Long population = Long.parseLong(token[2]);

            if (!countries.containsKey(country)) {
                countries.put(country, new LinkedHashMap<>());
                totalPopulation.put(country, population);
            } else {
                long total = totalPopulation.get(country) + population;
                totalPopulation.put(country, total);
            }

            if (!countries.get(country).containsKey(city)) {
                countries.get(country).put(city, population);
            } else {
                long total = countries.get(country).get(city) + population;
                countries.get(country).put(city, total);
            }
            input = sc.nextLine();
        }

        totalPopulation.entrySet().stream().sorted(Map.Entry.comparingByValue((v1,v2)-> v2.compareTo(v1))).forEach(co -> {
            System.out.printf("%s (total population: %d)%n",co.getKey(), co.getValue());
            LinkedHashMap<String, Long> cities = countries.get(co.getKey());
            cities.entrySet().stream().sorted(Map.Entry.comparingByValue((v1,v2)-> v2.compareTo(v1))).forEach(ci -> {
                System.out.printf("=>%s: %d%n",ci.getKey(), ci.getValue());
            });
        });
    }
}
