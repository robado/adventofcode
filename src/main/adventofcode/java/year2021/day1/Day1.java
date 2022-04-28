package main.adventofcode.java;

import java.io.File;
import java.util.List;

import src.main.java.year2021.aocutils.AocUtils;

/**
 * Day 1: Sonar Sweep
 */
class Day1 {
    public static void main(String[] args) {
        System.out.println("Day 1"); 
        List<Integer> exampleInput = AocUtils.inputTolist(new File("src/main/recources/2021-example/day1.txt"));
        System.out.println("Part 1 answer: " + part1(exampleInput));
        System.out.println(part2());
    }

    public static Integer part1(List<Integer> inputs) {
        System.out.println("Part1");
        System.out.println(inputs.toString());
        for (int i = 0; i < inputs.size(); i++) {
            System.out.println(inputs.get(i));
            
        }
        return 0;
    }

    public static String part2() {
        System.out.println("Part2");
        return "";
    }
}