package Day_05;

import javax.management.OperationsException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SupplyStacks {

    public static void main(String[] args) throws IOException {
        List<String> data = getTopCrates(Paths.get("resources/Day_05.txt"));
        Stack<List<StackOperator>> levels = new Stack<>();
        for(int i = 0; i < data.size()-1; i++) {
            int counter = 2;
            LinkedList<StackOperator> currentLevel = new LinkedList<>();
            while (counter < data.get(i).length()) {
                if(counter+1 % 3 == 0){
                    char element = data.get(i).charAt(counter-1);
                    if (data.get(i).charAt(counter-2) == ' ' && element == ' ' && data.get(i).charAt(counter) == ' ') {
                        currentLevel.add(StackOperator.DO_NOTHING);
                    } else if (data.get(i).charAt(counter-2) == '[' && element >= 65 && element <= 90 && data.get(i).charAt(counter) == ']') {
                        currentLevel.add(StackOperator.ADD);
                    } else { break; }
                    counter += 1;
                    continue;
                } if (counter+1 % 3 == 1){
                    if(data.get(i).charAt(counter-2) == ' '){
                        counter += 3;
                    } else { break; }
                }
            }
            levels.push(currentLevel);
        }
        System.out.println(levels);
    }

    public static List<String> getTopCrates(Path path) throws IOException {
        List<String> input = Files.readAllLines(path);
        return input;
    }

    private enum StackOperator{
        ADD( (stack,character) -> stack.push(character)),
        DO_NOTHING (((stack, character) -> {}));

        private BiConsumer<Stack,Character> consumer;
        private StackOperator(BiConsumer<Stack,Character> consumer){
            this.consumer = consumer;
        }
    }

    private enum Operator{
        START,
        OTHERWISE;

        private Operator(){

        }
    }

}
