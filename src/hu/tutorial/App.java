package hu.tutorial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class App {

    private static List<Integer> numbers;

    public static void main(String[] args) {
        System.out.println("Progrmozási tételek megvalósítása");
//        numbers = init();
        numbers = convert(readFromFile("szamok.txt"));
        print(numbers);
        System.out.println("A sorozat összege: " + summation());
        int divisor = 3;
        boolean isExist = decision(divisor);
        System.out.println("A sorozatban " + (isExist ? "van " : "nincs ") +
                divisor + "-al osztható szám.");
        if (isExist) {
            System.out.println("A sorozat " + selection(divisor) +
                    " értékű eleme osztható " + divisor + "-val.");
        }
        final int anotherDivisor = 107;
        String value = find(anotherDivisor)
                .map(i -> "A(z) " + i + " érték osztható " + anotherDivisor + "-val.")
                .orElse("Nincs ilyen érték");
        System.out.println(value);
        System.out.println(count(divisor) + " db szám osztható " + divisor + "-val.");
        System.out.println("A sorozat legnagyobb érékű eleme a(z) " + max());
        List<Integer> sortedList = sort(numbers);
        print(sortedList);
    }

    /** Szomok beolvasása állományból
     *
     */
    private static List<String> readFromFile(String filename) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Path.of(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static List<Integer> convert(List<String> lines) {
        return lines.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    /**
     * Inicializálás: A számok létrehozása
     * @return
     */
    private static List<Integer> init() {
        List<Integer> nums = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            nums.add(random.nextInt(99) + 1);
        }
        return nums;
    }

    /**
     * A számsorozat kiírása képernyőre
     * @param nums
     */
    private static void print(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            System.out.printf("%4d", nums.get(i));
        }
        System.out.println();
    }

    /**
     * Sorozatszámítás programozási tétel
     * @return
     */
/*    private static int summation() {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);  // sum = sum + numbers[i];
        }
        return sum;
    }
*/
    private static int summation() {
        return numbers.stream()
                .mapToInt(i -> i)
                .sum();
    }

    /**
     * Eldöntés programozási tétel
     * @param divisor
     * @return
     */
/*    private static boolean decision(int divisor) {
        int i = 0;
        while (i < numbers.size() && !(numbers.get(i) % divisor == 0)) {
            i++;
        }
        return i < numbers.size();
    }*/

    private static boolean decision(int divisor) {
        return numbers.stream()
                .anyMatch(i -> i % divisor == 0);
    }

    /**
     * Kiválasztás programozási tétel
     * @param divisor
     * @return
     */
/*    private static int selection(int divisor) {
        int i = 0;
        while (!(numbers.get(i) % divisor == 0)) {
            i++;
        }
        return i;
    }*/

    private static int selection(int divisor) {
        return numbers.stream()
                .filter(i -> i % divisor == 0)
                .findFirst()
                .get();
    }

    /**
     * Lineáris keresés programozási tétel
     * @param divisor
     * @return
     */
    private static Optional<Integer> find(int divisor) {
        return numbers.stream()
                .filter(i -> i % divisor == 0)
                .findFirst();
    }

    /**
     * Megszámlás programozási tétel
     * @param divisor
     * @return
     */
/*    private static int count(int divisor) {
        int db = 0;
        for (int i = 0; i< numbers.size(); i++) {
            if (i % divisor == 0) {
                db++;
            }
        }
        return db;
    }*/

    private static long count(int divisor) {
        return numbers.stream()
                .filter(i -> i % divisor == 0)
                .count();
    }

    /**
     * Maximumkiválasztás programozási tétel
     * @return
     */
/*    private static int max() {
        int max = 0;
        for(int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > numbers.get(max)) {
                max = i;
            }
        }
        return numbers.get(max);
    }*/

    private static int max() {
        return numbers.stream()
                .mapToInt(i -> i)
                .max()
                .getAsInt();
    }

    /**
     * Rendezés (egyszerű cserés)
     * @param nums
     * @return
     */
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
