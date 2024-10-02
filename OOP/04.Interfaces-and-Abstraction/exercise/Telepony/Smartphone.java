package oop04.exercise.Telepony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder str = new StringBuilder();
        Pattern pattern = Pattern.compile("[0-9]+");
        urls.forEach(u -> {
            Matcher matcher = pattern.matcher(u);
            if (matcher.find()) {
                str.append("Invalid URL!").append(System.lineSeparator());
            } else {
                str.append(String.format("Browsing: %s!", u)).append(System.lineSeparator());
            }
        });
        return str.toString();
    }

    @Override
    public String call() {
        StringBuilder str = new StringBuilder();
        Pattern pattern = Pattern.compile("[^0-9]+");
        numbers.forEach(u -> {
            Matcher matcher = pattern.matcher(u);
            if (matcher.find()) {
                str.append("Invalid number!").append(System.lineSeparator());
            } else {
                str.append(String.format("Calling... %s", u)).append(System.lineSeparator());
            }
        });
        return str.toString();
    }
}
