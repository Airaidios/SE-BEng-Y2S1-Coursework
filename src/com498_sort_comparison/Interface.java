package com498_sort_comparison;

import java.io.IOException;
import java.util.*;

/*

@author b00758943

 */

public class Interface {

    // For user input
    private final Scanner input = new Scanner(System.in);

    // For generation of arrays to be sorted
    private static Integer[] arrayUnsorted;
    private static Integer[] arrayDuplicate;
    private static Integer[] arraySorted;

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

                bubbleSort(1);
                break;

            case "3":

                selectSort(1);
                break;

            case "4":

                shellSort(1);
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
    private Integer[] generateArray(int mode) throws IOException {

        int size = 0; // size of array
        String scenario; // case scenario (average or worst)
        Random random = new Random(); // for generating random integer

        if (mode == 1) { // User input required

            while (size <= 0) {

                // Get size of array
                System.out.println("Size of array?");
                size = input.nextInt();

            }

            // I swear this makes the input.nextLine() below work
            input.nextLine();

            // Should array be worst case scenario?
            System.out.println("Worst case scenario? (y/n)");
            scenario = input.nextLine();

        } else { // User input not required, use default values

            size = 50;
            scenario = "n";

        }

        arrayUnsorted = new Integer[size];

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

    // Simple bubble sort, uses arrayUnsorted
    // If mode == 1, trace sort, print at each step
    // Otherwise, just sort
    private void bubbleSort(int mode) throws IOException {

        // TODO: bubble sort
        // Check if arrayUnsorted is populated (or if user entered a stupid length value I guess)
        int temp;
        boolean swapped = true;

        if (arrayUnsorted.length <= 1) { // If array is not populated

            generateArray(0); // populate it

        }

        arrayDuplicate = arrayUnsorted; // Create duplicate of array to leave original intact for other sorts

        for (int i = 0; i < arrayDuplicate.length; i ++) { // For every item in array

            for (int j = 1; j < (arrayDuplicate.length - i); j ++) { // except items after the last swap of the pass

                if (arrayDuplicate[j - 1] > arrayDuplicate[j]) { // if previous item is greater than current item

                    // swap 'em
                    temp = arrayDuplicate[j - 1];
                    arrayDuplicate[j - 1] = arrayDuplicate[j];
                    arrayDuplicate[j] = temp;

                    if (mode == 1) { // If algorithm needs to be traced

                        System.out.println(Arrays.toString(arrayDuplicate)); // print current state of array

                    }

                }

            }

        }

    }

    // If mode == 1, trace sort, print at each step
    // Otherwise, just sort
    private void selectSort(int mode) throws IOException {

        // TODO: select sort
        if (mode == 1) { // Trace sort



        } else { // Just sort



        }

    }

    // If mode == 1, trace sort, print at each step
    // Otherwise, just sort
    private void shellSort(int mode) throws IOException {

        // TODO: shell sort
        if (mode == 1) { // Trace sort



        } else { // Just sort



        }

    }

    // If mode == 1, trace sort, print at each step
    // Otherwise, just sort
    private void compareAll() throws IOException {

        // TODO: comparative analysis of all algorithms

    }

}