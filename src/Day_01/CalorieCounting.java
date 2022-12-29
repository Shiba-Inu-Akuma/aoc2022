package Day_01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CalorieCounting {


    public static void main(String[] args) throws IOException {
        System.out.println(getMaxCalories(Paths.get("resources/Day_01.txt")));
        System.out.println(getTopThreeCalories(Paths.get("resources/Day_01.txt")));
    }

    // Part 1
    public static int getMaxCalories(Path path) throws IOException {
        List<String> input = Files.readAllLines(path);
        int sumCal = 0;
        int maxCal = 0;

        for (String calories : input) {
            if (calories.isEmpty()) {
                maxCal = Math.max(sumCal, maxCal);
                sumCal = 0;
            } else sumCal += Integer.parseInt(calories);
        }
        return Math.max(maxCal, sumCal);
    }

    // Part 2
    public static int getTopThreeCalories(Path path) throws IOException {
        List<String> input = Files.readAllLines(path);

        int highest = getMaxCalories(path);
        int topThreeCal = 0;

        for (int i = 0; i < 2; i++) {
            int maxCal = 0, sumCal = 0;

            for (String calories : input) {
                if (calories.isEmpty()) {
                    if (sumCal != highest && sumCal != topThreeCal) maxCal = Math.max(sumCal, maxCal);
                    sumCal = 0;
                } else sumCal += Integer.parseInt(calories);
            }
            topThreeCal += Math.max(maxCal, sumCal);
        }

        topThreeCal += highest;
        return topThreeCal;
    }
}
