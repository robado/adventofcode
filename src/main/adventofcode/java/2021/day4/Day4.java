package day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import utils.Utils;

public class Day4 {
    public static void main(String[] args) {
        System.out.println("Day 3");
        // List<String> bingo = Utils.stringToFile(new File("src/main/recources/2021-example/day4.txt"));
        File bingoFile = new File("src/main/recources/2021-example/day4.txt");

        System.out.println("Part 1: " + part1(bingoFile));
        //System.out.println("Part 2: " + part2(binaries));
    }

    private static String part1(File bingoFile) {
        System.out.println("part1");

        // get the winning numbers
        List<Integer> winningNumbers = getDrawingNumbers(bingoFile); // string or int list
        // maybe int because first line is all int. The bingo grid prob has to be int also
        
        System.out.println("winning numbers: " + Arrays.toString(winningNumbers.toArray())); // print winningNumbers

        // get the bingo tables (maybe in 5x5 grid to list)
        List<int[][]> bingoTables = getBingoTables(bingoFile);

        // This is just to print bingo table multidimensional list
        // System.out.println("bingo tables: " + Arrays.toString(bingoTables.toArray()));
        // System.out.println("bingotables;");
        for (int[][] table : bingoTables) {
            // System.out.println(Arrays.deepToString(table).replace("], ", "]\n"));
        }
        
        // draw numbers = With for/while or somekind of a loop
        for (int i = 0; i < winningNumbers.size(); i++) { // Get the size of winning numbers list and loop number by number 
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
        }

        // mark winning numbers? (dunno how yet)
        // Or I can loop the vertically and horizontally and check if any numbers are in a row

        // check for winners (check winners after each number drawn???)
        // IF there is a winner (1 complete row or column of marked numbers)
        // How can I check if a row or a column is complete????
        List<Integer> drawNums = new ArrayList<>();
        for (int i = 0; i < winningNumbers.size(); i++) {
            int num = winningNumbers.get(i);
            //System.out.println("Next number:"+num);
            drawNums.add(num);

            for (int[][] table : bingoTables) {
                boolean winNumbers = checkForWins(table, drawNums);
                
                if (winNumbers) { // If boolean value is TRUE
                    // Get/find the sum of all unmarked numbers 
                    System.out.println("win");
                }
            }
        }

        // Calculate the score of winning board

        // Get the final score of the winning board???

        return null;
    }

    private static boolean checkForWins(int[][] table, List<Integer> drawNum) {
        System.out.println("numbers:"+Arrays.toString(drawNum.toArray()));
        System.out.println(Arrays.deepToString(table).replace("], ", "]\n"));
        // Check vertically (row)
        // Create another list to store all row numbers and compare to the drawNum list
        // Compare row list to drawNum list
        // I guess....
        // This should check 1 number at a time. And if it contains 4 
        List<Integer> rowOrColumnNumbers = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            for (Integer rowNumner : table[i]) {
                rowOrColumnNumbers.add(rowNumner);
                //System.out.println("rowOrColumnNumbers:"+rowOrColumnNumbers);
                System.out.println(drawNum.containsAll(rowOrColumnNumbers));
                if (drawNum.containsAll(rowOrColumnNumbers)) {
                    return true;
                }
            }
            rowOrColumnNumbers.clear();
        }

        
        //System.out.println(rowOrColumnNumbers.containsAll(drawNum));

        //System.out.println("row:"+Arrays.toString(rowOrColumnNumbers.toArray())); 
        
        // Check horizontally (column)
        // Create another list to store all column numbers and compare to the drawNum list


        // Return false if no wins with the table
        System.out.println(" ");
        return false;
    }

    private static List<int[][]> getBingoTables(File bingoFile) {
        List<int[][]> gridList = new ArrayList<>();
        BufferedReader br = null; // These needs to be here so it can reach in finally
        //int[][] grid = new int[5][5];
        int[][] grid = null;
        int row = 0;
        int column = 0;
        int size = 0;

        try {
            br = new BufferedReader(new FileReader(bingoFile));
            // Trimming on these I think is pointless......
            br.readLine(); // skipping the first line 
            //br.readLine().trim(); // skip also the second line??? does this works???
            // Answer: This does work. Adding one of these skips another line. Is there a better way? This can get messy if needed to skip f.ex. 10 or 100 lines...
            
            String line = null;
            int skipLine = 2;
            //String line = br.readLine();

            //System.out.println("tables:");
            while ((line = br.readLine()) != null) { // reading the tables
                if (skipLine++ <= 2) { // This kinda accidentally fixed something... Still not sure how and why...
                    continue;
                }
                if (line.isBlank() || line.isEmpty()) { // Reading broke on a empty line so it needs to be somehow skip?
                    //System.out.println("is blank: " + line);
                    gridList.add(grid);
                    grid = null; // I make grid back to NULL because if it would be int[0][0] then I would give java.lang.ArrayIndexOutOfBoundsException. Because it is 0 and 0 in size.
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
                    grid = new int[size][size]; // Maybe for this part I could use int[5][5]. Because I know the length of the tables.
                }

                for (column = 0; column < size; column++) {
                    grid[row][column] = Integer.parseInt(vals[column]);
                    //System.out.println("column: "+column);
                    //System.out.println("row: " + row);
                    //System.out.println("vals columnt: " + vals[column]);
                }
               
                //System.out.println(Arrays.deepToString(grid).replace("], ", "]\n"));

                //gridList.add(grid); // Adding every grid to the list of grids
                row++;
                
            }
            gridList.add(grid);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        } finally { // REMEMBER THIS!!!
            try {
                br.close();
            } catch (Exception e) {
                //TODO: handle exception
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
            // other option would have been to read all file to Integer. Then just skip the first line 
            
            nums.addAll(Arrays.asList(line.split(",")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList())); 
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }

        //System.out.println("strings:"+Arrays.toString(strings.toArray())); // print winningNumbers 
        //System.out.println("int:"+Arrays.toString(nums.toArray())); // print winningNumbers 

        return nums;
    }
}
