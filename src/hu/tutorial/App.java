package hu.tutorial;

import java.util.Random;

public class App {

    private static int[] numbers;

    public static void main(String[] args) {
        System.out.println("Progrmozási tételek megvalósítása");
        numbers = init();
        print();
        System.out.println("A sorozat összege: " + summation());
        int divisor = 3;
        boolean isExist = decision(divisor);
        System.out.println("A sorozatban " + (isExist ? "van " : "nincs ") +
                divisor + "-al osztható szám.");
        if (isExist) {
            System.out.println("A sorozat " + (selection(divisor) + 1) +
                    ". eleme osztható " + divisor + "-val.");
        }
    }

    private static int[] init() {
        int[] nums = new int[100];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(99) + 1;
        }
        return nums;
    }

    private static void print() {
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%4d", numbers[i]);
        }
        System.out.println();
    }

    private static int summation() {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];  // sum = sum + numbers[i];
        }
        return sum;
    }

    private static boolean decision(int divisor) {
        int i = 0;
        while (i < numbers.length && !(numbers[i] % divisor == 0)) {
            i++;
        }
        return i < numbers.length;
    }

    private static int selection(int divisor) {
        int i = 0;
        while (!(numbers[i] % divisor == 0)) {
            i++;
        }
        return i;
    }
}
