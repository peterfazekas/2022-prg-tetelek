package hu.tutorial;

import java.util.Random;

public class App {

    private static int[] numbers;

    public static void main(String[] args) {
        System.out.println("Progrmozási tételek megvalósítása");
        numbers = init();
        print();
        System.out.println("A sorozat összege: " + summation());
    }

    private static int[] init() {
        int[] nums = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            nums[i] = random.nextInt(99) + 1;
        }
        return nums;
    }

    private static void print() {
        for (int i = 0; i < 100; i++) {
            System.out.printf("%4d", numbers[i]);
        }
        System.out.println();
    }

    private static int summation() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum = sum + numbers[i];
        }
        return sum;
    }
}
