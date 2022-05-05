package day3;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Utils;

/**
 * Day 3: Binary Diagnostic
 */
public class Day3 {

    public static void main(String[] args) {
        System.out.println("Day 3");
        List<String> binaries = Utils.stringToFile(new File("src/main/recources/2021/day3.txt"));

        System.out.println("Part 1: " + part1(binaries));
        //System.out.println("Part 2: " + part2(binaries));
    }

    private static Integer part1(List<String> binaries) {
        //System.out.println("part 1");
        //System.out.println(Arrays.toString(binaries.toArray()));
        int power_consumption = 0;
        String gamma_rate = "";
        String epsilon_rate = "";

        /*int lenghtOfBinary = binaries.get(0).length();
        System.out.println(lenghtOfBinary);
        
        for (int i = 0; i < binaries.size(); i++) {
            System.out.println(binaries.get(i).split("(?!^)"));
            //for (int j = 0; j < binaries.get(i).length(); j++) {
            for (int j = 0; j < lenghtOfBinary; j++) {
                System.out.println(binaries.get(i).charAt(j));
            }
        }*/

        /**
         * 1. get list of inputs 
         * 2. create list lenght of 1 input 
         * 3. loop throuhg binary
         */
        List<String> binList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int lenghtOfBinary = binaries.get(0).length();

        // repeats the loop with the lenght of the binary (test is 5 long)
        for (int charIndex = 0; charIndex < lenghtOfBinary; charIndex++) {
            // goes through the list on inputs (binaries)
            for (int i = 0; i < binaries.size(); i++) {
                // splits the list on space (" ") 
                for (String string : binaries.get(i).split(" ")) {
                    //System.out.println(string);
                    sb.append(string.charAt(charIndex)); // takes the first char and appends to sb
                    //System.out.println(sb);
                }
                //binList.add(i, sb);
                //binList.add(sb);
            }
            //System.out.println("ONE LOOP");
            binList.add(charIndex, sb.toString()); // do i need to make this into Integer????
            //System.out.println(Arrays.toString(binList.toArray()));
            sb.setLength(0);
        }
        
        //System.out.println("sb: " + sb);
        //System.out.println(Arrays.toString(binList.toArray()));

        // Get gamma rate && epsilon rate with the list of binarie columns
        for (String byte_list : binList) {
            gamma_rate += getGammaRate(byte_list);
            epsilon_rate += getEpsilonRate(byte_list);
        }
        //System.out.println(gamma_rate);

        // Get the decimal from binary
        int decimal_gamma = Integer.parseInt(gamma_rate, 2);
        int epsilon_gamma = Integer.parseInt(epsilon_rate, 2);

        //System.out.println(decimal_gamma);
        //System.out.println(epsilon_gamma);

        power_consumption = multiply(decimal_gamma, epsilon_gamma);
        return power_consumption;
    }

    private static String getEpsilonRate(String bitString) {
        int zeros = 0;
        int ones = 0;
        String returnValue = "";

        for (int i = 0; i < bitString.length(); i++) {
            char bit = bitString.charAt(i);
            // https://stackoverflow.com/questions/46343616/how-can-i-convert-a-char-to-int-in-java
            if ((bit-'0') == 0) {
                zeros += 1;
            } 
            if ((bit-'0') == 1) {
                ones += 1;
            }
        }

        if (zeros < ones) {
           returnValue = "0";
        }
        else if (zeros > ones) {
            returnValue = "1"; 
        }
        return returnValue;
    }

    private static String getGammaRate(String bitString) {
        //System.out.println("getGammaRate");
        int zeros = 0;
        int ones = 0;
        String returnValue = "";
        /*for (int i = 0; i < binList.size(); i++) {
            String[] splittedBinaries = binList.get(i).split("");
            //System.out.println(binList.get(i));
            for (String bit : splittedBinaries) {
                //System.out.println(bit);
                //System.out.println(Integer.valueOf(bit));
                if (Integer.valueOf(bit) == 0){
                    zeros += 1;
                }
                if (Integer.valueOf(bit) == 1) {
                    ones += 1;
                }
            }
        }*/
        //System.out.println(bitString);
        for (int i = 0; i < bitString.length(); i++) {
            char bit = bitString.charAt(i);
            //System.out.println(c);
            // https://stackoverflow.com/questions/46343616/how-can-i-convert-a-char-to-int-in-java
            if ((bit-'0') == 0) {
                zeros += 1;
            } 
            if ((bit-'0') == 1) {
                ones += 1;
            }
        }

        //System.out.println(zeros);
        //System.out.println(ones);
        if (zeros > ones) {
           //return "0";
           // gamma = gamma + "0";
           returnValue = "0";
        }
        else if (zeros < ones) {
            //return "1";
            //gamma = gamma + "1";
            returnValue = "1"; 
        }
        //System.out.println(gamma);
        //return gamma.toString();
        //System.out.println("returnValue" + returnValue);
        return returnValue;
    }

    private static int multiply(int x, int y) {
        return (x * y);
    }

    private static Integer part2(List<String> directions) {
        return 0;
    }
}
