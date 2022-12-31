package Day_04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CampCleanup {

    public static void main(String[] args) throws IOException {
        System.out.println(amountOfDuplicateWorks(Paths.get("resources/Day_04.txt")));
        System.out.println(amountOfDuplicatePairs(Paths.get("resources/Day_04.txt")));
    }

    // Part 1
    public static int amountOfDuplicateWorks(Path path) throws IOException {
        List<String> input = Files.readAllLines(path);
        int duplicateWorks = 0;

        for (String line : input) {
            String firstElf = line.split(",")[0];
            String secondElf = line.split(",")[1];

            if (Integer.parseInt(firstElf.split("-")[0]) <= Integer.parseInt(secondElf.split("-")[0]) &&
                    Integer.parseInt(firstElf.split("-")[1]) >= Integer.parseInt(secondElf.split("-")[1])) duplicateWorks++;
            else if (Integer.parseInt(firstElf.split("-")[0]) >= Integer.parseInt(secondElf.split("-")[0]) &&
                     Integer.parseInt(firstElf.split("-")[1]) <= Integer.parseInt(secondElf.split("-")[1])) duplicateWorks++;
        }
        return duplicateWorks;
    }


    // Part 2
    public static int amountOfDuplicatePairs(Path path) throws IOException {
        List<String> input = Files.readAllLines(path);
        int duplicatePairs = 0;

        for (String line : input) {
            String firstElf = line.split(",")[0];
            String secondElf = line.split(",")[1];

            for (int i = Integer.parseInt(firstElf.split("-")[0]); i <= Integer.parseInt(firstElf.split("-")[1]); i++) {
                if (i >= Integer.parseInt(secondElf.split("-")[0]) && i <= Integer.parseInt(secondElf.split("-")[1])) {
                    duplicatePairs++;
                    break;
                }
            }
        }
        return duplicatePairs;
    }

}
