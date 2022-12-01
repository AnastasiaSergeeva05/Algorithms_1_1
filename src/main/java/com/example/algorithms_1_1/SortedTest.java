package com.example.algorithms_1_1;

import java.util.Arrays;
import java.util.Random;

public class SortedTest {
    public static void main(String[] args) {
        int[] array;
        array = new int[100_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int) (Math.random() * 1) + 100);
        }


        long start = System.currentTimeMillis();
        sortBubble(array);
        System.out.println(System.currentTimeMillis() - start);


        long start2 = System.currentTimeMillis();
        sortSelection(array);
        System.out.println(System.currentTimeMillis() - start2);


        long start3 = System.currentTimeMillis();
        sortInsertion(array);
        System.out.println(System.currentTimeMillis() - start3);

        long start4 = System.currentTimeMillis();


    }


    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);

                }
            }
        }
    }

    private static void swapElements(int[] arr, int j, int k) {
        int swap = arr[j];
        arr[j] = arr[k];
        arr[k] = swap;
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
