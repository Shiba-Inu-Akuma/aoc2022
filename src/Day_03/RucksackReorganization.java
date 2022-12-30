package Day_03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RucksackReorganization {

    public static void main(String[] args) throws IOException {
        System.out.println(getSumOfPriorities(Paths.get("resources/Day_03.txt")));
        System.out.println(getSumOfAuthPriorities(Paths.get("resources/Day_03.txt")));
    }

    // Part 1
    public static int getSumOfPriorities(Path path) throws IOException {
        List<String> input = Files.readAllLines(path);
        int sum = 0;

        for (String rucksack : input) {
            String firstComp = rucksack.substring(0, rucksack.length() / 2);
            String secondComp = rucksack.substring(rucksack.length() / 2);

            for (int i = 0; i < firstComp.length(); i++) {
                if (secondComp.contains(firstComp.charAt(i) + "")) {
                    if (firstComp.charAt(i) <= 'Z') sum += firstComp.charAt(i) - ('A' - 27);
                    else sum += firstComp.charAt(i) - ('a' - 1);
                    break;
                }
            }

        }
        return sum;
    }


    // Part 2
    public static int getSumOfAuthPriorities(Path path) throws IOException {
        List<String> input = Files.readAllLines(path);
        int sum = 0;

        for (int line = 0; line < input.size(); line += 3) {
            String rucksack = input.get(line);
            for (int i = 0; i < rucksack.length(); i++) {
                if (input.get(line + 1).contains(rucksack.charAt(i) + "") && input.get(line + 2).contains(rucksack.charAt(i) + "")) {
                    if (rucksack.charAt(i) <= 'Z') sum += rucksack.charAt(i) - ('A' - 27);
                    else sum += rucksack.charAt(i) - ('a' - 1);
                    break;
                }
            }
        }
        return sum;
    }

}
