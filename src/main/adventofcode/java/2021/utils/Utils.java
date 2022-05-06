package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    public static List<Integer> intTolist(File inputFile) {
        List<Integer> inputs = new ArrayList<>();
        Scanner s = null;
        try {
            s = new Scanner(inputFile);
            while (s.hasNextInt()) {
                inputs.add(s.nextInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }

        return inputs;
    }

    public static List<String> stringToFile(File inputFile) {
        List<String> inputs = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = br.readLine()) != null) {
                inputs.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        return inputs;
    }
}
