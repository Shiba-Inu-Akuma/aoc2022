package Day_04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CampCleanup {

    public static void main(String[] args) throws IOException {
        System.out.println(amountOfRedundantCleanups(Paths.get("resources/Day_04.txt")));
    }


    public static int amountOfRedundantCleanups(Path path) throws IOException {
        List<String> input = Files.readAllLines(path);
        int pairs = 0;

        for (String line : input) {
            String firstElf = line.split(",")[0];
            String secondElf = line.split(",")[1];

            if (Integer.parseInt(firstElf.split("-")[0]) <= Integer.parseInt(secondElf.split("-")[0]) && Integer.parseInt(firstElf.split("-")[1]) >= Integer.parseInt(secondElf.split("-")[1])) pairs++;
            else if (Integer.parseInt(firstElf.split("-")[0]) >= Integer.parseInt(secondElf.split("-")[0]) && Integer.parseInt(firstElf.split("-")[1]) <= Integer.parseInt(secondElf.split("-")[1])) pairs++;
        }
        return pairs;
    }

}
