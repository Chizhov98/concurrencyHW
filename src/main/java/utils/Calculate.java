package utils;

import pogo.Laureate;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculate {
    private final List<Laureate> laureates = new JsonParser().parseToList().getLaureates();

    public double calculate() {
        double averageAge = laureates.stream().mapToInt(Laureate::calculateLauriatedAge).average().getAsDouble();
        return averageAge;
    }

}
