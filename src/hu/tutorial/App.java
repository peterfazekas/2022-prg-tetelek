package hu.tutorial;

import java.util.Random;

public class App {

    private static int[] numbers;

    public static void main(String[] args) {
        System.out.println("Progrmozási tételek megvalósítása");
    }

    private static int[] init() {
        int[] nums = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            nums[i] = random.nextInt(99);
        }
        return nums;
    }
}
