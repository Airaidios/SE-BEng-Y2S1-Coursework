package com498_sort_comparison;

import java.util.*;

/*

@author b00758943

 */

@SuppressWarnings({"DuplicatedCode", "InfiniteLoopStatement", "IntegerDivisionInFloatingPointContext"})
class Interface {

    // For user input
    private final Scanner input = new Scanner(System.in);

    // For generation of arrays to be sorted
    private static Integer[] arrayUnsorted;
    private static Integer[] arrayDuplicate;

    public static void main(String[] args) {

        // Initialises interface instance, begins call chain
        Interface frontend = new Interface();
        frontend.Start();

    }

    private void Start() {

        // Calls main menu, in while loop to facilitate continuous use
        while (true) {

            mainMenu();

        }

    }

    // Presents all available options to the user
    private void mainMenu() {

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

    }

    // Generate random, unsorted array of given size
    // If called intentionally by user (option 1 in mainMenu) allow for user input for these variables
    // Otherwise (called by sorting algorithms if there is no pre-existing unsorted array) use default values
    private Integer[] generateArray(int mode) {

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
        for (int i = 0; i < size; i++) { // for every index in arrayUnsorted

            arrayUnsorted[i] = random.nextInt(size + 1); // Inclusive upper bound

        }

        if (scenario.equals("y")) { // If user wants worst case scenario

            // I use built-in methods here as this is not part of the comparative analysis
            Arrays.sort(arrayUnsorted, Collections.reverseOrder());

            if (arrayUnsorted.length % 2 != 0) { // if array has odd number of items, swap middle item with last item

                double arrayHalf = arrayUnsorted.length / 2;
                arrayUnsorted[(int) (Math.floor(arrayHalf) + 1)] = arrayUnsorted[arrayUnsorted.length - 1];

            }

        }

        arrayDuplicate = new Integer[arrayUnsorted.length];

        return arrayUnsorted;

    }

    // Simple bubble sort, uses arrayUnsorted
    // If mode == 1, trace sort, print at each step
    // Otherwise, just sort
    private void bubbleSort(int mode) {

        // Check if arrayUnsorted is populated (or if user entered a stupid length value I guess)
        int temp;
        int swaps = 0; // track how many swaps this algo performs
        int passes = 0; // track how many passes this algo performs
        int comparisons = 0; // track how many comparisons this algo performs

        if (arrayUnsorted ==  null) { // If array is not populated

            generateArray(0); // populate it

        }

        duplicateArray(arrayUnsorted, arrayDuplicate);// Duplicate array

        if (mode == 1) { // just to get initial state of array, for posterity

            System.out.println(Arrays.toString(arrayDuplicate));

        }

        for (int i = 0; i < arrayDuplicate.length; i++) { // For every item in array

            for (int j = 1; j < (arrayDuplicate.length - i); j++) { // except items after the last swap of the pass

                comparisons++;

                if (arrayDuplicate[j - 1] > arrayDuplicate[j]) { // if previous item is greater than current item

                    // swap 'em
                    temp = arrayDuplicate[j - 1];
                    arrayDuplicate[j - 1] = arrayDuplicate[j];
                    arrayDuplicate[j] = temp;
                    swaps++;

                    }

                }

            if (mode == 1) { // If algorithm needs to be traced

                System.out.println(Arrays.toString(arrayDuplicate)); // print current state of array

            }

            passes++;

        }

        System.out.println("Total passes: " + passes);
        System.out.println("Total comparisons: " + comparisons);
        System.out.println("Total swaps: " + swaps);

    }

    // If mode == 1, trace sort, print at each step, otherwise, just sort
    @SuppressWarnings("DuplicatedCode")
    private void selectSort(int mode) {

        int minItem;
        int swaps = 0; // track how many swaps this algo performs
        int passes = 0; // track how many passes this algo performs
        int comparisons = 0; // track how many comparisons this algo performs

        if (arrayUnsorted == null) {

            generateArray(0);

        }

        duplicateArray(arrayUnsorted, arrayDuplicate);// Duplicate array

        if (mode == 1) { // just to get initial state of array

            System.out.println(Arrays.toString(arrayDuplicate));

        }

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < arrayDuplicate.length - 1; i++) {

            // Find the minimum element in unsorted array
            minItem = i;

            for (int j = i + 1; j < arrayDuplicate.length; j++) {

                comparisons++;

                if (arrayDuplicate[j] < arrayDuplicate[minItem]) {

                    minItem = j;

                }

            }

            // Swap the found minimum element with the first element
            int temp = arrayDuplicate[minItem];
            arrayDuplicate[minItem] = arrayDuplicate[i];
            arrayDuplicate[i] = temp;
            swaps++;

            if (mode == 1) { // Trace algo

                System.out.println(Arrays.toString(arrayDuplicate));

            }

            passes ++;

        }

        System.out.println("Total passes: " + passes);
        System.out.println("Total comparisons: " + comparisons);
        System.out.println("Total swaps: " + swaps);

    }

    // If mode == 1, trace sort, print at each step
    // Otherwise, just sort
    private void shellSort(int mode){

        int j;
        int swaps = 0; // track how many swaps this algo performs
        int passes = 0; // track how many passes this algo performs
        int comparisons = 0;

        if (arrayUnsorted ==  null) { // If array is not populated

            generateArray(0); // populate it

        }

        duplicateArray(arrayUnsorted, arrayDuplicate);// Duplicate array

        if (mode == 1) { // just to get initial state of array

            System.out.println(Arrays.toString(arrayDuplicate));

        }

        // Using original Shell gap sequence
        for (int gap = arrayDuplicate.length / 2; gap > 0; gap /= 2) {

            // Do gapped insert sort for current gap size
            for (int i = gap; i < arrayDuplicate.length; i += 1) {

                // add current item to the elements that have been gap sorted. Save item in temp and make a hole at
                // current pos
                int temp = arrayDuplicate[i];

                comparisons ++;

                // shift earlier gap-sorted elements up until the correct location for current item is found
                for (j = i; j >= gap && arrayDuplicate[j - gap] > temp; j -= gap) {

                    arrayDuplicate[j] = arrayDuplicate[j - gap];
                    comparisons ++;
                    swaps++;

                }

                // put temp in its correct location
                arrayDuplicate[j] = temp;

            }

            if (mode == 1) { // Trace sort

                System.out.println(Arrays.toString(arrayDuplicate));

            }

            passes++;

        }

        System.out.println("Total passes: " + passes);
        System.out.println("Total comparions: " + comparisons);
        System.out.println("Total swaps: " + swaps);

    }

    // If mode == 1, trace sort, print at each step
    // Otherwise, just sort
    private void compareAll() {

        // for wall time
        long startTime;
        long endTime;
        long elapsedTime;

        if (arrayUnsorted ==  null) { // If array is not populated

            generateArray(0); // populate it

        }

        duplicateArray(arrayUnsorted, arrayDuplicate); // Duplicate array

        System.out.println("\n<---BUBBLE SORT--->"); // Measure bubble sort
        startTime = System.nanoTime();

        bubbleSort(0);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println("Array sorted in " + elapsedTime + " nanoseconds (wall time)");

        duplicateArray(arrayUnsorted, arrayDuplicate); // Duplicate array each time, as arrayDuplicate becomes sorted

        System.out.println("\n<---SELECTION SORT--->"); // measure selection sort
        startTime = System.nanoTime();

        selectSort(0);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println("Array sorted in " + elapsedTime + " nanoseconds (wall time)");

        duplicateArray(arrayUnsorted, arrayDuplicate);

        System.out.println("\n<---SHELL SORT (original gap sequence)--->"); // measure shell sort
        startTime = System.nanoTime();

        shellSort(0);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println("Array sorted in " + elapsedTime + " nanoseconds (wall time)");

    }

    // Duplicate array
    private void duplicateArray (Integer[] array, Integer[] arrayClone) {

        System.arraycopy(array, 0, arrayClone, 0, array.length);

    }

}