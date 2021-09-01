package com.bobocode;

import java.util.Arrays;

/**
 * Created by Shelupets Denys on 25.08.2021.
 *
 * Type: Divide and Conque
 * Time Complexity: nlog(n) - worse case/ nLog(n) - average case/ nlog(n) - best case
 * Space Complexity: O(n)
 * Datasets: Preferred for huge data sets
 *
 * If compare with InsertSort - MergeSort more effective for Time complexity, InsertSort for Space complexity
 * InsertSort use only on weak comp.system and no huge data
 * MergeSort use in all other cases
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 3, 5, 6, 1, 7, 0};

        mergeSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int start, int finish) {
        if (start < finish) {
            //find middle position
            int middle = (start + finish) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, finish);

            merge(array, start, middle, finish);
        }

    }

    private static void merge(int[] array, int left, int middle, int right) {
        int sizeL = middle - left + 1;
        int sizeR = right - middle;

        int[] arrayL = new int[sizeL];
        int[] arrayR = new int[sizeR];

        System.arraycopy(array, left, arrayL, 0, sizeL);

        System.arraycopy(array, middle + 1, arrayR, 0, sizeR);

        System.out.println("left array = " + Arrays.toString(arrayL) + " right array = " + Arrays.toString(arrayR));

        int indexL, indexR, currentIndex;
        indexL = 0;
        indexR = 0;
        currentIndex = left;

        while (indexL < sizeL && indexR < sizeR) {
            if (arrayL[indexL] <= arrayR[indexR]) {
                //take item of left size
                array[currentIndex] = arrayL[indexL];
                indexL++;
            } else {
                //take item of right size
                array[currentIndex] = arrayR[indexR];
                indexR++;
            }
            currentIndex++;
        }

        while (indexL < sizeL) {
            array[currentIndex] = arrayL[indexL];
            indexL++;
            currentIndex++;
        }

        while (indexR < sizeR) {
            array[currentIndex] = arrayR[indexR];
            indexR++;
            currentIndex++;
        }
    }

}
