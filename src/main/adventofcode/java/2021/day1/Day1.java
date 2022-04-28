package day1;

import java.io.File;
import java.util.List;

// import src.main.adventofcode.java.utils.Utils;
import utils.Utils;

/**
 * Day 1: Sonar Sweep
 */
class Day1 {
    public static void main(String[] args) {
        System.out.println("Day 1");
        List<Integer> exampleInput = Utils.inputToIntlist(new File("src/main/recources/2021-example/day1.txt"));
        System.out.println("Part 1 answer: " + part1(exampleInput));
        System.out.println("Part 2 answer: " + part2(exampleInput));
    }

    public static Integer part1(List<Integer> inputs) {
        // System.out.println("Part1");
        // System.out.println(inputs.toString());
        int measurements = 0;
        int secondNumber = 0;
        for (int i = 0; i < inputs.size(); i++) {
            // System.out.println(inputs.get(i));
            int firstNumber = inputs.get(i);
            // System.out.println(firstNumber);

            if (firstNumber > secondNumber) {
                if (secondNumber == 0) {
                    secondNumber = firstNumber;
                } else {
                    secondNumber = firstNumber;
                    measurements += 1;
                }
            } else {
                secondNumber = firstNumber;
            }
        }
        return measurements;
    }

    public static Integer part2(List<Integer> measurements) {
        
        return 0;
    }
}