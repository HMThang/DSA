package Lab10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // Testing reserve
        Integer[] arr = {1, 2, 3, 4, 5};
        System.out.print("Reversed Array: ");
        MyLIFO_App.reserve(arr);

        // Testing isCorrect
        String correctInput = "()(()()){(())}";
        String incorrectInput = "){[]}()";
        System.out.println("Is correct input: " + MyLIFO_App.isCorrect(correctInput)); // Expects true
        System.out.println("Is correct input: " + MyLIFO_App.isCorrect(incorrectInput)); // Expects false

        // Testing evaluateExpression
        String expression = "51 + (54 *(3+2))";
        System.out.println("Result of expression evaluation: " + MyLIFO_App.evaluateExpression(expression));

        // Testing stutter
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3));
        System.out.print("Stuttered Queue: ");
		MyLIFO_App.stutter(queue);

        // Testing mirror
        Queue<String> stringQueue = new LinkedList<>(Arrays.asList("a", "b", "c"));
        System.out.print("Mirrored Queue: ");
		MyLIFO_App.mirror(stringQueue);
    }

}
