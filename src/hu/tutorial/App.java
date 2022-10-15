package hu.tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class App {

    private static List<Integer> numbers;

    public static void main(String[] args) {
        System.out.println("Progrmozási tételek megvalósítása");
        numbers = init();
        print(numbers);
        System.out.println("A sorozat összege: " + summation());
        int divisor = 3;
        boolean isExist = decision(divisor);
        System.out.println("A sorozatban " + (isExist ? "van " : "nincs ") +
                divisor + "-al osztható szám.");
        if (isExist) {
            System.out.println("A sorozat " + (selection(divisor) + 1) +
                    ". eleme osztható " + divisor + "-val.");
        }
        List<Integer> sortedList = sort(numbers);
        print(sortedList);
    }

    private static List<Integer> init() {
        List<Integer> nums = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            nums.add(random.nextInt(99) + 1);
        }
        return nums;
    }

    private static void print(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            System.out.printf("%4d", nums.get(i));
        }
        System.out.println();
    }

    private static int summation() {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);  // sum = sum + numbers[i];
        }
        return sum;
    }

    private static boolean decision(int divisor) {
        int i = 0;
        while (i < numbers.size() && !(numbers.get(i) % divisor == 0)) {
            i++;
        }
        return i < numbers.size();
    }

    private static int selection(int divisor) {
        int i = 0;
        while (!(numbers.get(i) % divisor == 0)) {
            i++;
        }
        return i;
    }

/*    private static void sort() {
        for (int i = 0; i < numbers.length -1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int p = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = p;
                }
            }
        }
    }*/

    private static List<Integer> sort(List<Integer> nums) {
        return nums.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
