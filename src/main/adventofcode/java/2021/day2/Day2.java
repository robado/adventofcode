package day2;

import java.io.File;
import java.util.List;

import utils.Utils;

/**
 * Day 2: Dive!
 */
public class Day2 {
    public static void main(String[] args) {
        System.out.println("Day 2");
        List<String> directions = Utils.stringToFile(new File("src/main/recources/2021/day2.txt"));

        System.out.println("Part 1: " + part1(directions));
        System.out.println("Part 2: " + part2(directions));
    }

    public static int part1(List<String> directions) {
        int horizontal = 0;
        int depth = 0;

        for (int i = 0; i < directions.size(); i++) {
            String[] splitted = directions.get(i).split(" ");
            if (splitted[0].equals("forward")) {
                horizontal += Integer.parseInt(splitted[1]);
            }
            if (splitted[0].equals("down")) {
                depth += Integer.parseInt(splitted[1]);
            }
            if (splitted[0].equals("up")) {
                depth -= Integer.parseInt(splitted[1]);
            }
        }

        return horizontal * depth;
    }

    public static int part2(List<String> directions) {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for (int i = 0; i < directions.size(); i++) {
            String[] splitted = directions.get(i).split(" ");
            if (splitted[0].equals("forward")) {
                horizontal += Integer.parseInt(splitted[1]);
                depth += (aim * Integer.parseInt(splitted[1]));
            }
            if (splitted[0].equals("down")) {
                aim += Integer.parseInt(splitted[1]);
            }
            if (splitted[0].equals("up")) {
                aim -= Integer.parseInt(splitted[1]);
            }
        }

        return multiply(horizontal, depth);
    }

    public static int multiply(int x, int y) {
        return x * y;
    }
}
