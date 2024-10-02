package oop06.exercise.calculators;

import oop06.exercise.products.Product;

import java.util.List;

public interface Calculator {
    double sum(List<Product> products);

    double average(List<Product> products);
}
