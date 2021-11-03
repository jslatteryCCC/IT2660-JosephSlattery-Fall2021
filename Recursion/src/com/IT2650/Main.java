package com.IT2650;
import java.util.Arrays;
import java.util.Random;


public class Main {
    private static int[] origArray = new int[100];
    private static int[] helperArray = new int[origArray.length];
    // private static int counter = 0;



    public static void main(String[] args) {
        populateList(origArray);
        System.out.println(Arrays.toString(origArray));
        mergesort(0, origArray.length - 1);
        System.out.println(Arrays.toString(origArray));
    }

    private static void populateList(int[] array) {
/*        int j = 5;
        for(int i = 0; i < origArray.length; i++) {
            origArray[i] = j;
            j--;
        }*/
        Random ran = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = ran.nextInt(100);
        }
    }

    private static void mergesort(int low, int high) {

        if (low < high) {
            //counter++;
            int tempHigh = low + (high - low) / 2;
            //System.out.println("MergeSort has been called. This is pass #" + counter + " Low = " + low +
            //        " TempHigh = " + tempHigh + " and High = " + high);
            mergesort(low, tempHigh);
            //System.out.println("\nThe first call to merge sort has exited.");
            mergesort(tempHigh + 1, high);
            //System.out.println("\nThe second call to mergesort has exited.");
            merge(low, tempHigh, high);
        }
    }

    private static void merge(int low, int middle, int high) {
        //System.out.println("\nMerge has been called using " + low + " as low, " + middle + " as middle, and "
        //        + high + " as high during pass " + counter + "\n");
        if (high + 1 >= 0) System.arraycopy(origArray, 0, helperArray, 0, high + 1);
        //System.out.println("Copied array! Indexes 0 to " + high + "\n Helper Array:   " + Arrays.toString(helperArray)+ "\n");

        int tempLow = low;
        int tempHigh = middle + 1;
        //System.out.println("Now merging between indexes " + low + " and " + tempHigh + "\n");
        int originalLow = low;

        while(tempLow <= middle && tempHigh <= high){
            if(helperArray[tempLow] < helperArray[tempHigh]){
                /*System.out.println(Arrays.toString(origArray));
                System.out.println("Helper Array:   " + Arrays.toString(helperArray) + "\n");*/
                origArray[originalLow] = helperArray[tempLow];
                tempLow++;

            } else {
/*                System.out.println("-Original Array: " + Arrays.toString(origArray));
                System.out.println("-Helper Array:   " + Arrays.toString(helperArray) + "\n");*/

                origArray[originalLow] = helperArray[tempHigh];
/*                System.out.println("Sorting... ");
                System.out.println("-Original Array: " + Arrays.toString(origArray));
                System.out.println("-Helper Array:   " + Arrays.toString(helperArray) + "\n");*/
                tempHigh++;
            }
            originalLow++;
        }
        while(tempLow <= middle){
/*            System.out.println("Sorting...");
            System.out.println("-Original Array: " + Arrays.toString(origArray));
            System.out.println("-Helper Array:   " + Arrays.toString(helperArray) + "\n");*/

            origArray[originalLow] = helperArray[tempLow];
/*            System.out.println("Sorted 0 through " + originalLow + "!");
            System.out.println("-Original Array: " + Arrays.toString(origArray));
            System.out.println("-Helper Array:   " + Arrays.toString(helperArray) + "\n");*/
            tempLow++;
            originalLow++;
        }
        //System.out.println("Merge exiting.\n\n" );
    }

}