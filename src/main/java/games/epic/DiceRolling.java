package games.epic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DiceRolling {
    public static void main(String[] args) {
        // Program that makes arrays
        Random rand = new Random();
        final int NDICE = 1000;
        final int NFACES = 100;
        // Final means that the program cannot change the value, use that for constants, and
        // use identifiers with all capital letters
        int[] diceValues = new int[NDICE];
        int index = 0;
        while (index < NDICE) {
            diceValues[index] = rand.nextInt(NFACES) + 1;
            index = index + 1;
        }

        // Let's see the results using a Java utility class Arrays
        System.out.println(Arrays.toString(diceValues));
        // Find the maximum value in the Array and set its value to the first value in the Array
        int maxValue = diceValues[0];
        for (int value : diceValues) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        System.out.println("The maximum value is " + maxValue);

        // Build a histogram
        final int NBINS = 10;
        // Initializes a new counting bin
        int[] count = new int[NBINS];
        // We need to know how big each bin is
        int binsize = NFACES / NBINS;

        for (int value : diceValues) {
            int bin = (value - 1) / binsize; // This is the bin the value goes into
            // Example: value = 83; (value - 1) = 82; 82 / 10 = 8 in Java
            count[bin] = count[bin] + 1;
        }
        // Print out the result
        System.out.println("Histrogram: " + Arrays.toString(count));

        // Writing to a file with a FileWriter object, First, define a File object with the name
        // of the file, Next, instantiate a FileWriter object that has the task of writing
        // to the file
        // By default, FileWriter objects overwrite whtats in the file, Use true as the second
        // parameter to append to the file
        File file = new File("histogram.txt");
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write("Bin\tHistogram\n");
            // Writing out the values in count using a while loop
            int bin = 0;
            while (bin < count.length) {
                writer.write(bin + "\t" + count[bin] + "\n");
                bin = bin +1;
            }
            writer.close();
        } catch (IOException e) {
            // Do this if the exception occurs
            e.printStackTrace();
        }

        // To read text files that have tokens or lines, use Scanner, Instantiate a Scanner object
        // that is connected to the file
        try {
            Scanner scan = new Scanner(file);
            // We want to read the lines in the file and print them out as long as the file still
            // has data in it
            while (scan.hasNextLine()) {
                String theLine = scan.nextLine();
                System.out.println(theLine);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            // This happens if exception occurs
            e.printStackTrace();
        }

    }
}