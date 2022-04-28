package aocutils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AocUtils {

    public static List<Integer> inputTolist(File inputFile) {
        System.out.println("inputTolist");
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
