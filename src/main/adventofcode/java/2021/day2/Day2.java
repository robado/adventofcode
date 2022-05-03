package day2;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import utils.Utils;

/**
 * Day 2: Dive! 
 */
public class Day2 {
   public static void main(String[] args) {
       System.out.println("Day 2");
        List<String> directions = Utils.stringToFile(new File("src/main/recources/2021-example/day2.txt"));

        System.out.println("Part 1: " + part1(directions));
        System.out.println("Part 2: " + part2(directions));
   } 

   public static int part1(List<String> directions){
       System.out.println("part1");
       System.out.println(Arrays.toString(directions.toArray()));

    return 0;
   }

   public static int part2(List<String> directions) {

    return 0;
   }
}
