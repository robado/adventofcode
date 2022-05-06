package day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
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

        //System.out.println("bingo tables: " + Arrays.toString(bingoTables.toArray()));
        System.out.println("bingotables;");
        for (int[][] table : bingoTables) {
            //System.out.println(table);
            System.out.println(Arrays.deepToString(table).replace("], ", "]\n"));
        }
        
        // draw numbers

        // mark winning numbers? (dunno how yet)

        // check for winners (check winners after each number drawn???)

        // IF there is a winner (1 complete row or column of marked numbers)

        // calculate the score of winning board

        // get the final score of the winning board???

        return null;
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
            //BufferedReader br = new BufferedReader(new FileReader(bingoFile));
            br = new BufferedReader(new FileReader(bingoFile));
            // Trimming on these I think is pointless......
            br.readLine().trim(); // skipping the first line 
            br.readLine().trim(); // skip also the second line??? does this works???
            // Answer: This does work. Adding one of these skips another line. Is there a better way? This can get messy if needed to skip f.ex. 10 or 100 lines...
            
            String line = null;
            int skipLine = 2;
            //String line = br.readLine();

            //System.out.println("tables:");
            while ((line = br.readLine()) != null) { // reading the tables
                //System.out.println("line: " + line);
                if (skipLine++ <= 2) { // This kinda accidentally fixed something... Still not sure how and why...
                    //System.out.println("skipping?");
                    continue;
                }
                if (line.isBlank() || line.isEmpty()) { // Reading broke on a empty line so it needs to be somehow skip?
                    //System.out.println("is blank: " + line);
                    grid = null; // I make grid back to NULL because if it would be int[0][0] then I would give java.lang.ArrayIndexOutOfBoundsException. Because it is 0 and 0 in size.
                    row = 0;
                    column = 0;
                    continue;
                }
                String[] vals = line.trim().split("\\s+"); // Trimming line removed f.ex. whitespaces
                
                //System.out.println("line: " + line);
                //System.out.println("vals: " + vals.length);
                //System.out.println(line.length());

                // Lazy instantiation
                // Can maybe do without this???
                // grid = new int[0][0]; // This might be enought???
                if (grid == null) {
                    size = vals.length;
                    //System.out.println("size: " + size);
                    grid = new int[size][size]; // Maybe for this part I could use int[5][5]. Because I know the length of the tables.
                }

                for (column = 0; column < size; column++) {
                    grid[row][column] = Integer.parseInt(vals[column]);
                    //System.out.println("column: "+column);
                    //System.out.println("row: " + row);
                    //System.out.println("vals columnt: " + vals[column]);
                }
               
                //System.out.println(Arrays.deepToString(grid).replace("], ", "]\n"));

                gridList.add(grid); // Adding every grid to the list of grids
                row++;

            }
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

        // This should pring multidimentional array. One way to do it
        /*for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.println(grid[i][j]);
            }
        }*/

        return gridList;
    }

    private static List<Integer> getDrawingNumbers(File bingoFile) {
        List<Integer> nums = new ArrayList<>();
        BufferedReader br = null;
        /*try {
            BufferedReader br = new BufferedReader(new FileReader(bingoFile));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }*/
        // List<String> strings = new ArrayList<>();
        try {
            //BufferedReader br = new BufferedReader(new FileReader(bingoFile));
            br = new BufferedReader(new FileReader(bingoFile));
            String line = br.readLine(); // read only the first line 
            // dunno should I read the whole file?
            // other option would have been to read all file to Integer. Then just skip the first line 
            
            //strings.add(line);
            //System.out.println(line);

            nums.addAll(Arrays.asList(line.split(",")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList())); 
            
            // br.close(); // REMEMBER TO ALWAYS CLOSE!!!!!
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
