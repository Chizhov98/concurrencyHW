import pogo.Laureate;
import utils.Calculate;
import utils.ConcurrencyCalculate;
import utils.JsonParser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Start {
    private static List<Laureate> laureates = new JsonParser().parseToList().getLaureates();

    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        double firstResult = new Calculate().calculate();
        long after = System.currentTimeMillis();
        System.out.println("Executed in: " + (after - before));
        System.out.println("Result :" + firstResult);

        before = System.currentTimeMillis();
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        List<Integer> ages = new ArrayList<>();
        laureates.stream().mapToInt(Laureate::calculateLauriatedAge).forEach(ages::add);
        BigDecimal secondResult = commonPool.invoke(new ConcurrencyCalculate(ages));
        after = System.currentTimeMillis();
        System.out.println("Executed in: " + (after - before));
        System.out.println("Parallel result :" + secondResult);
    }

}
