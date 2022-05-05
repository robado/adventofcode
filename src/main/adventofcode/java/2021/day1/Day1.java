package day1;

import java.io.File;
import java.util.List;

import utils.Utils;

/**
 * Day 1: Sonar Sweep
 */
class Day1 {
    public static void main(String[] args) {
        System.out.println("Day 1");
        List<Integer> inputs = Utils.intTolist(new File("src/main/recources/2021/day1.txt"));
        System.out.println("Part 1: " + part1(inputs));
        System.out.println("Part 2: " + part2(inputs));
    }

    public static Integer part1(List<Integer> inputs) {
        int measurements = 0;
        int secondNumber = 0;

        for (int i = 0; i < inputs.size(); i++) {
            int firstNumber = inputs.get(i);

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
        int sum = sliding_window(measurements, 3);
        return sum;
    }

    public static Integer sliding_window(List<Integer> measurements, int window_size) {
        int measurements_amout = 0;
        int fNum = 0;
        int sNum = 0;

        if (measurements.size() < window_size) {
            System.err.println("too small");
            return -1;
        }

        for (int i = 0; i < measurements.size() - window_size + 1; i++) {
            for (Integer asd : measurements.subList(i, i + window_size)) {
                fNum += asd;
            }

            if (fNum > sNum) {
                if (sNum == 0) {
                    sNum = fNum;
                    fNum = 0;
                } else {
                    sNum = fNum;
                    measurements_amout += 1;
                    fNum = 0;
                }
            } else {
                sNum = fNum;
                fNum = 0;
            }

        }

        return measurements_amout;

    }
}