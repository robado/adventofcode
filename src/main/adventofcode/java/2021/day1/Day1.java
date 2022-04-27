package main.adventofcode.java;

import java.io.File;
import java.util.List;

import src.main.adventofcode.java.utils.Utils;

/**
 * Day 1: Sonar Sweep
 */
class Day1 {
    public static void main(String[] args) {
        System.out.println("Day 1"); 
        List<Integer> exampleInput = Utils.inputTolist(new File("src/main/recources/2021-example/day1.txt"));
        System.out.println(part1(exampleInput));
        System.out.println(part2());
    }

    public static String part1(List<Integer> inputs) {
        System.out.println("Part1");
        System.out.println(inputs.toString());
        return "";
    }

    public static String part2() {
        System.out.println("Part2");
        return "";
    }
}