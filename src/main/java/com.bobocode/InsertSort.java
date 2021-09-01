package com.bobocode;

/**
 * Created by Shelupets Denys on 25.08.2021.
 *
 * Type: Incremental Approach
 * Time Complexity: O(n2) - worse case/ O(n) - best case, when array sorted;
 * Space Complexity: O(1);
 * Datasets: Effective for small data sets, and almost sorted array;
 * Peculiarity: Left part of array always will be sorted => Online sorted
 */
public class InsertSort {
    /**
     * @param array like {4, 1, 5, 3, 7, 6, 2}
     *              {4, 1, 5, 3, 7, 6, 2} -> {4, current=1, 5, 3, 7, 6, 2} -> current=1<4?-> {4, 4, 5, 3, 7, 6, 2} -> current=1<4?-> {current=1, 4, 5, 3, 7, 6, 2}
     *              {1, 4, 5, 3, 7, 6, 2} -> {1, 4, current=5, 3, 7, 6, 2} -> current=5<4?->
     *              {1, 4, 5, 3, 7, 6, 2} -> {1, 4, 5, current=3, 7, 6, 2} -> current=3<5? -> {1, 4, 5, 5, 7, 6, 2} -> current=3<4? -> {1, 4, 4, 5, 7, 6, 2} -> current=3<1?->{1, current=3, 4, 5, 7, 6, 2}
     *              {1, 3, 4, 5, 7, 6, 2} -> {1, 3, 4, 5, current=7, 6, 2} -> current=7<5?->
     *              {1, 3, 4, 5, 7, 6, 2} -> {1, 3, 4, 5, 7, curren=6, 2} -> current=6<7?-> {1, 3, 4, 5, 7, 7, 2} ->current=6<5?-> {1, 3, 4, 5, current=6, 7, 2}
     *              {1, 3, 4, 5, 6, 7, 2} -> {1, 3, 4, 5, 6, 7, curren=2} -> curren=2<7? -> {1, 3, 4, 5, 6, 7, 7} ->current=2<6?-> ... {1, current=2, 3, 4, 5, 6, 7}
     */

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;

        }
    }
}
