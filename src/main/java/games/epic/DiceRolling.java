package games.epic;

import java.util.Arrays;
import java.util.Random;

public class DiceRolling {
    public static void main(String[] args) {
        // Program that makes arrays
        Random rand = new Random();
        final int NDICE = 1000;
        final int NFACES = 100;
        // final means that the program cannot change the value, use that for constants, and
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
            // Example: value = 83; (value - 1) = 82; 82 / 100 = 8 in Java
            count[bin] = count[bin] + 1;
        }
        // Print out the result
        System.out.println("Histrogram: " + Arrays.toString(count));

    }
}