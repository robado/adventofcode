package utils;

import java.io.File;
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
            inputs.add(s.nextInt());
        }
        s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputs;
    }
}
