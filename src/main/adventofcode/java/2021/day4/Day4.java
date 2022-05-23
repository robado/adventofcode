package day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Day 4: Giant Squid
 */
public class Day4 {
    public static void main(String[] args) {
        System.out.println("Day 3");
        File bingoFile = new File("src/main/recources/2021/day4.txt");

        System.out.println("Part 1: " + part1(bingoFile));
        System.out.println("Part 2: " + part2(bingoFile));
    }

    private static Integer part1(File bingoFile) {
        List<Integer> winningNumbers = getDrawingNumbers(bingoFile);

        List<int[][]> bingoTables = getBingoTables(bingoFile);

        Set<Integer> drawNums = new HashSet<>();
        int unmarkedNumTotal = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            int num = winningNumbers.get(i);
            drawNums.add(num);

            for (int[][] table : bingoTables) {
                boolean win = checkForWins(table, drawNums);

                if (win) {
                    // https://www.netjstech.com/2017/01/flatmap-in-java.html -- flatMapToInt
                    unmarkedNumTotal = Stream.of(table).flatMapToInt(row -> Arrays.stream(row))
                            .filter(nums -> !drawNums.contains(nums)).sum();

                    return unmarkedNumTotal * num;
                }
            }
        }
        return null; // Returns value if has win. Else I could return 0, -1, NULL.
    }

    private static Integer part2(File bingoFile) {
        List<Integer> winningNumbers = getDrawingNumbers(bingoFile);

        List<int[][]> bingoTables = getBingoTables(bingoFile);

        Set<Integer> drawNums = new HashSet<>();

        List<int[][]> winTable = new ArrayList<>();

        for (int i = 0; i < winningNumbers.size(); i++) {
            int num = winningNumbers.get(i);
            drawNums.add(num);

            for (int[][] table : bingoTables) {
                if (winTable.contains(table)) { // Check if table has won. If true then
                    continue;
                }

                boolean win = checkForWins(table, drawNums);

                if (win) {
                    if (winTable.size() == bingoTables.size() - 1) { // TODO: REMEMBER THIS!!!!

                        int unmarkedNumTotal = Stream.of(table).flatMapToInt(row -> Arrays.stream(row))
                                .filter(nums -> !drawNums.contains(nums)).sum();
                        return unmarkedNumTotal * num;
                    }
                    winTable.add(table); // Add win table to list
                }
            }
        }
        return null;
    }

    private static boolean checkForWins(int[][] table, Set<Integer> drawNum) {
        Set<Integer> rowNumbers = new HashSet<Integer>();
        for (int i = 0; i < table.length; i++) {
            for (Integer rowNumner : table[i]) {
                rowNumbers.add(rowNumner);
            }

            // https://stackoverflow.com/questions/1075656/simple-way-to-find-if-two-different-lists-contain-exactly-the-same-elements
            if (drawNum.containsAll(rowNumbers)) { // Check when the whole row is in list to the already drawn numbers
                return true;
            }
            rowNumbers.clear();
        }

        Set<Integer> colNumbers = new HashSet<>();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                colNumbers.add(table[j][i]);
            }
            if (drawNum.containsAll(colNumbers)) {
                return true;
            }
            colNumbers.clear();
        }

        return false;
    }

    private static List<int[][]> getBingoTables(File bingoFile) {
        List<int[][]> gridList = new ArrayList<>();
        BufferedReader br = null; // These needs to be here so it can reach in finally

        int[][] grid = null;
        int row = 0;
        int column = 0;
        int size = 0;

        try {
            br = new BufferedReader(new FileReader(bingoFile));
            br.readLine(); // skipping the first line

            String line = null;
            int skipLine = 2;

            while ((line = br.readLine()) != null) { // reading the tables
                if (skipLine++ <= 2) { // This kinda accidentally fixed something... Still not sure how and why...
                    continue;
                }
                if (line.isBlank() || line.isEmpty()) { // Reading broke on a empty line so it needs to be somehow skip?
                    gridList.add(grid);
                    grid = null; // I make grid back to NULL because if it would be int[0][0] then I would give
                                 // java.lang.ArrayIndexOutOfBoundsException. Because it is 0 and 0 in size.
                    row = 0;
                    column = 0;
                    continue;
                }
                String[] vals = line.trim().split("\\s+"); // Trimming line removed f.ex. whitespaces

                if (grid == null) {
                    size = vals.length;
                    grid = new int[size][size]; // Maybe for this part I could use int[5][5]. Because I know the length
                                                // of the tables.
                }

                for (column = 0; column < size; column++) {
                    grid[row][column] = Integer.parseInt(vals[column]);
                }

                row++;

            }
            gridList.add(grid);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally { // REMEMBER THIS!!!
            try {
                br.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        return gridList;
    }

    private static List<Integer> getDrawingNumbers(File bingoFile) {
        List<Integer> nums = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(bingoFile));
            String line = br.readLine(); // read only the first line

            nums.addAll(Arrays.asList(line.split(",")).stream().map(s -> Integer.parseInt(s.trim()))
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        return nums;
    }
}
