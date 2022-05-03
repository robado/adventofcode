package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    public static List<Integer> inputToIntlist(File inputFile) {
        List<Integer> inputs = new ArrayList<>();
        try {
            Scanner s = new Scanner(inputFile);
        while (s.hasNextInt()) {
            System.out.println(s.nextInt());
            inputs.add(s.nextInt());
        }
        s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputs;
    }

    public static List<String> stringToFile(File inputFile) {
        List<String> inputs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = br.readLine()) != null) {
                // sb.append(line).append("\n");
                inputs.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputs;
    }
}
