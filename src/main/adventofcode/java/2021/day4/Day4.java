package day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import utils.Utils;

public class Day4 {
    public static void main(String[] args) {
        System.out.println("Day 3");
        // List<String> bingo = Utils.stringToFile(new
        // File("src/main/recources/2021-example/day4.txt"));
        File bingoFile = new File("src/main/recources/2021/day4.txt");

        System.out.println("Part 1: " + part1(bingoFile));
        System.out.println("Part 2: " + part2(bingoFile));
    }

    private static Integer part1(File bingoFile) {
        // get the winning numbers
        List<Integer> winningNumbers = getDrawingNumbers(bingoFile); // string or int list
        // maybe int because first line is all int. The bingo grid prob has to be int
        // also

        // System.out.println("winning numbers: " + Arrays.toString(winningNumbers.toArray())); // print winningNumbers

        // get the bingo tables (maybe in 5x5 grid to list)
        List<int[][]> bingoTables = getBingoTables(bingoFile);

        // This is just to print bingo table multidimensional list
        // System.out.println("bingo tables: " +
        // Arrays.toString(bingoTables.toArray()));
        // System.out.println("bingotables;");
        // for (int[][] table : bingoTables) {
        // System.out.println(Arrays.deepToString(table).replace("], ", "]\n"));
        // }

        // THIS DOES NOTHING!!! WAS FOR TESTING
        // draw numbers = With for/while or somekind of a loop
        /* for (int i = 0; i < winningNumbers.size(); i++) { // Get the size of winning numbers list and loop number by
                                                          // number
            int num = winningNumbers.get(i);
            // System.out.println("number: " + num);

            for (int[][] table : bingoTables) { // Loop through tables one table at a time
                for (int row = 0; row < table.length; row++) { // Cycle rows
                    for (int column = 0; column < table.length; column++) { // Cycle columns
                        if (table[row][column] == num) {
                            // System.out.printf("Instance found at [%d, %d]\n", row, column);
                        }
                    }
                }
            }
        }*/

        // mark winning numbers? (dunno how yet)
        // Or I can loop the vertically and horizontally and check if any numbers are in
        // a row

        // check for winners (check winners after each number drawn???)
        // IF there is a winner (1 complete row or column of marked numbers)
        // How can I check if a row or a column is complete????
        // List<Integer> drawNums = new ArrayList<>();
        Set<Integer> drawNums = new HashSet<>();
        int unmarkedNumTotal = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            int num = winningNumbers.get(i);
            // System.out.println("Next number:"+num);
            drawNums.add(num);

            for (int[][] table : bingoTables) {
                boolean win = checkForWins(table, drawNums);

                if (win) { // If boolean value is TRUE
                    // Get/find the sum of all unmarked numbers
                    // System.out.println("\n########## WIN ##########" );
                    // After winning get the table that won and the last number that won and the
                    // drawn number this far
                    // System.out.println("Winning table: \n" +
                    // Arrays.deepToString(table).replace("], ", "]\n"));
                    // System.out.println("Winning number: " + num);
                    // System.out.println("Drawn numbers: " + Arrays.toString(drawNums.toArray()));

                    // I could iterate the numbers again and if there are same numbers as in the
                    // drawn nymbers list then remove?
                    // After removing iterate numbers and get the sum
                    // After the sum multiply with the last called number
                    // == final score

                    // total = Arrays.stream(table).mapToInt(arr -> Arrays.stream(arr).sum()).sum();
                    // IntStream iStream = Stream.of(table).flatMapToInt(n ->
                    // Arrays.stream(n)).filter(a -> !drawNums.contains(a));
                    // iStream.forEach(System.out::println);

                    // https://www.netjstech.com/2017/01/flatmap-in-java.html -- flatMapToInt
                    // 2D array to flatMap - Stream all the values - Filter with the drawnNumbers -
                    // Get the sum
                    unmarkedNumTotal = Stream.of(table).flatMapToInt(row -> Arrays.stream(row))
                            .filter(nums -> !drawNums.contains(nums)).sum();

                    // System.out.println("Total: " + total);
                    // System.out.println(14+21+17+24+4+10+16+15+9+19+18+8+23+26+20+22+11+13+6+5+2+0+12+3+7);
                    // System.out.println(10+16+15+19+18+8+26+20+22+13+6+5+12+3);

                    // System.out.println("Total * winning number: " + unmarkedNumTotal*num);

                    // System.out.println("##### WIN ##### \n" );
                    return unmarkedNumTotal * num;
                }
            }
        }

        // Calculate the score of winning board

        // Get the final score of the winning board???

        return null; // Returns value if has win. Else I could return 0, -1, NULL.
    }

    private static Integer part2(File bingoFile) {
        System.out.println("Part2");
        List<Integer> winningNumbers = getDrawingNumbers(bingoFile);
        
        List<int[][]> bingoTables = getBingoTables(bingoFile);
        
        Set<Integer> drawNums = new HashSet<>();

        List<int[][]> winTable = new ArrayList<>();
        
        for (int i = 0; i < winningNumbers.size(); i++) {
            int num = winningNumbers.get(i);
            drawNums.add(num);

            for (int[][] table : bingoTables) {
                // I think I need to somehow exclude the WON tables
                // Maybe if win add to 'wonTables' set list and on every loop check if that table has won. If yes then 'continue' or skip to the next table.
                // Then take last winning board
                
                // System.out.println("Table:\n" + Arrays.deepToString(table).replace("], ", "]\n"));
                if (winTable.contains(table)) { // Check if table has won. If true then 
                    // System.out.println("winTable.contains(table)");
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
        // System.out.println("Rows");
        // System.out.println("numbers:"+Arrays.toString(drawNum.toArray()));
        // System.out.println(Arrays.deepToString(table).replace("], ", "]\n"));

        // Check vertically (row)
        // Create another list to store all row numbers and compare to the drawNum list
        // Compare row list to drawNum list
        // I guess....
        // This should check 1 number at a time. And if it contains 4

        // List<Integer> rowNumbers = new ArrayList<>();
        Set<Integer> rowNumbers = new HashSet<Integer>();
        for (int i = 0; i < table.length; i++) {
            for (Integer rowNumner : table[i]) {
                rowNumbers.add(rowNumner);
                // System.out.println("rowNumbers:"+rowNumbers);
                // System.out.println(drawNum.containsAll(rowNumbers));

                // https://stackoverflow.com/questions/1075656/simple-way-to-find-if-two-different-lists-contain-exactly-the-same-elements
                // containsAll check for same elements but indepented of order
                // if (drawNum.containsAll(rowOrColumnNumbers)) {
                // return true;
                // }
            }
            // System.out.println("rowOrColumn: " + Arrays.toString(rowNumbers.toArray()));
            // System.out.println("drawNum: " + Arrays.toString(drawNum.toArray()));
            // System.out.println("fore looping after: " + drawNum.containsAll(rowNumbers));
            // System.out.println("fore looping after but reversed: " +
            // rowNumbers.containsAll(drawNum));

            if (drawNum.containsAll(rowNumbers)) { // Check when the whole row is in list to the already drawn numbers
                // System.out.println("Row : " + Arrays.toString(rowNumbers.toArray()) + " won!!!");
                return true;
            }
            rowNumbers.clear();
        }

        // System.out.println(rowOrColumnNumbers.containsAll(drawNum));

        // System.out.println("row:"+Arrays.toString(rowOrColumnNumbers.toArray()));

        // System.out.println("No winning rows");

        // Check horizontally (column)
        // Create another list to store all column numbers and compare to the drawNum
        // list

        Set<Integer> colNumbers = new HashSet<>();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                // System.out.println("Columns: " + table[j][i]);
                colNumbers.add(table[j][i]);
            }
            if (drawNum.containsAll(colNumbers)) {
                // System.out.println("Column : " + Arrays.toString(colNumbers.toArray()) + " won!!!");
                return true;
            }
            colNumbers.clear();
        }

        // System.out.println("No winning columns");

        // Return false if no wins with the table
        // System.out.println(" ");
        return false;
    }

    private static List<int[][]> getBingoTables(File bingoFile) {
        List<int[][]> gridList = new ArrayList<>();
        BufferedReader br = null; // These needs to be here so it can reach in finally
        // int[][] grid = new int[5][5];
        int[][] grid = null;
        int row = 0;
        int column = 0;
        int size = 0;

        try {
            br = new BufferedReader(new FileReader(bingoFile));
            // Trimming on these I think is pointless......
            br.readLine(); // skipping the first line
            // br.readLine().trim(); // skip also the second line??? does this works???
            // Answer: This does work. Adding one of these skips another line. Is there a
            // better way? This can get messy if needed to skip f.ex. 10 or 100 lines...

            String line = null;
            int skipLine = 2;
            // String line = br.readLine();

            // System.out.println("tables:");
            while ((line = br.readLine()) != null) { // reading the tables
                if (skipLine++ <= 2) { // This kinda accidentally fixed something... Still not sure how and why...
                    continue;
                }
                if (line.isBlank() || line.isEmpty()) { // Reading broke on a empty line so it needs to be somehow skip?
                    // System.out.println("is blank: " + line);
                    gridList.add(grid);
                    grid = null; // I make grid back to NULL because if it would be int[0][0] then I would give
                                 // java.lang.ArrayIndexOutOfBoundsException. Because it is 0 and 0 in size.
                    row = 0;
                    column = 0;
                    continue;
                }
                String[] vals = line.trim().split("\\s+"); // Trimming line removed f.ex. whitespaces

                // Lazy instantiation
                // Can maybe do without this???
                // grid = new int[0][0]; // This might be enought???
                if (grid == null) {
                    size = vals.length;
                    grid = new int[size][size]; // Maybe for this part I could use int[5][5]. Because I know the length
                                                // of the tables.
                }

                for (column = 0; column < size; column++) {
                    grid[row][column] = Integer.parseInt(vals[column]);
                    // System.out.println("column: "+column);
                    // System.out.println("row: " + row);
                    // System.out.println("vals columnt: " + vals[column]);
                }

                // System.out.println(Arrays.deepToString(grid).replace("], ", "]\n"));

                // gridList.add(grid); // Adding every grid to the list of grids
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
            // dunno should I read the whole file?
            // other option would have been to read all file to Integer. Then just skip the
            // first line

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

        // System.out.println("strings:"+Arrays.toString(strings.toArray())); // print
        // winningNumbers
        // System.out.println("int:"+Arrays.toString(nums.toArray())); // print
        // winningNumbers

        return nums;
    }
}
