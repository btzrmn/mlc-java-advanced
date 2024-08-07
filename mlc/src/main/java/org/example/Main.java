package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] elements = reader.readLine().substring(10).split(", ");
        int[] universe = Arrays.stream(elements).mapToInt(Integer::parseInt).toArray();
        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));
        List<int[]> sets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++) {
            int[] values = Arrays.stream(reader.readLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            sets.add(values);
        }
        List<int[]> values = chooseSets(sets, universe);
        System.out.printf("Sets to take (%d):%n", values.size());
        for (int[] value : values) {
            System.out.println("{ " + Arrays.toString(value).replaceAll("[\\[\\]]", "") + " }");
        }
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        List<int[]> selectedSets = new ArrayList<>();
        Set<Integer> universeSet = new HashSet<>();
        for (int element : universe) {
            universeSet.add(element);
        }
        while (!universeSet.isEmpty()) {
            int notChosenCount = 0;
            int[] chosenSet = sets.get(0);
            for (int[] set : sets) {
                int count = 0;
                for (int elem : set) {
                    if (universeSet.contains(elem)) {
                        count++;
                    }
                }
                if (notChosenCount < count) {
                    notChosenCount = count;
                    chosenSet = set;
                }
            }
            selectedSets.add(chosenSet);
            for (int elem : chosenSet) {
                universeSet.remove(elem);
            }
        }
        return selectedSets;
    }
}