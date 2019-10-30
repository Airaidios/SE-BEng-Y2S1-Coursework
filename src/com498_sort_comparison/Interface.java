package com498_sort_comparison;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

/*

@author b00758943

 */

public class Interface {

    // For user input
    private final Scanner input = new Scanner(System.in);

    // For generation of arrays to be sorted
    private static Integer[] arrayUnsorted;

    public static void main(String[] args) throws IOException {

        // Initialises interface instance, begins call chain
        Interface frontend = new Interface();
        frontend.Start();

    }

    private void Start() throws IOException {

        // Calls main menu, in while loop to facilitate continuous use
        while (true) {

            mainMenu();

        }

    }

    // Presents all available options to the user
    private void mainMenu() throws IOException {

        String option;

        // Simple text-based UI
        System.out.println("|-----MAIN MENU-----|"
            + "\n1. Generate random, unsorted array"
            + "\n2. Bubble sort"
            + "\n3. Selection sort"
            + "\n4. Shell sort"
            + "\n5. Compare sorts"
            + "\n6. Quit");
        option = input.nextLine();

        // Decide what function to call based on user's choice
        switch (option) {

            case "1":

                System.out.println(Arrays.toString(generateArray(1)));
                break;

            case "2":

                bubbleSort();
                break;

            case "3":

                selectSort();
                break;

            case "4":

                shellSort();
                break;

            case "5":

                compareAll();
                break;

            case "6":

                System.exit(0);

        }

        return;

    }

    // Generate random, unsorted array of given size
    // If called intentionally by user (option 1 in mainMenu) allow for user input for these variables
    // Otherwise (called by sorting algorithms if there is no pre-existing unsorted array) use default values
    private Integer[] generateArray(int mode) {

        int size; // size of array
        String scenario; // case scenario (average or worst)
        Random random = new Random(); // for generating random integer

        if (mode == 1) { // User input required

            // Get size of array
            System.out.println("Size of array?");
            size = input.nextInt();

            // I swear this makes the input.nextLine() below work
            input.nextLine();

            // Should array be worst case scenario?
            System.out.println("Worst case scenario?");
            scenario = input.nextLine();

        } else { // User input not required, use default values

            size = 50;
            scenario = "n";

        }

        // Populate arrayUnsorted with random integers
        for (int i = 0; i < size; i ++) { // for every index in arrayUnsorted

            arrayUnsorted[i] = random.nextInt(size + 1); // Inclusive upper bound

        }

        if (scenario.equals("y")) { // If user wants worst case scenario

            // I use built-in methods here as this is not part of the comparative analysis
            Arrays.sort(arrayUnsorted, Collections.reverseOrder());

        }

        return arrayUnsorted;

    }

    private void bubbleSort() {

        // TODO: bubble sort

    }

    private void selectSort() {

        // TODO: select sort

    }

    private void shellSort() {

        // TODO: shell sort

    }

    private void compareAll() {

        // TODO: comparative analysis of all algorithms

    }

}