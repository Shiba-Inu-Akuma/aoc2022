package Day_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RockPaperScissors {

    private static final String opponentCode = "ABC";
    private static final String myCode = "XYZ";

    public static void main(String[] args) throws IOException {
        System.out.println(getMyScoreStratA(Paths.get("resources/Day_02.txt")));
        System.out.println(getMyScoreStratB(Paths.get("resources/Day_02.txt")));
    }


    // Part 1
    public static int getMyScoreStratA (Path path) throws IOException {
        List<String> input = Files.readAllLines(path);
        int myScore = 0;

        for (String line : input) {
            int myResponse = myCode.indexOf(line.split(" ")[1]);
            int opponentResponse = opponentCode.indexOf(line.split(" ")[0]);

            myScore += myResponse + 1;

            if (myResponse == opponentResponse) myScore += 3;
            else if (myResponse == 0 && opponentResponse == 2) myScore += 6;
            else if (myResponse > opponentResponse && myResponse + opponentResponse != 2) myScore += 6;
        }
        return myScore;
    }

    // Part 2
    public static int getMyScoreStratB (Path path) throws IOException {
        List<String> input = Files.readAllLines(path);
        int myScore = 0;

        for (String line : input) {
            int myResponse = myCode.indexOf(line.split(" ")[1]);
            int opponentResponse = opponentCode.indexOf(line.split(" ")[0]);

            if (myResponse == 1) myScore += 3 + opponentResponse + 1;
            else if (myResponse == 0) {
                if (opponentResponse == 0) myScore += 3;
                else myScore += opponentResponse;
            }
            else {
                myScore += 6;
                if (opponentResponse == 2) myScore += 1;
                else myScore += opponentResponse + 2;
            }
        }
        return myScore;
    }
}
