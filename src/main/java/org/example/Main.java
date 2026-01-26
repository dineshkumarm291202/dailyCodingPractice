package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] original = {
                6, 7, 8, 9, 10,
                16, 17, 18, 19, 20,
                1, 2, 3, 4, 5,
                11, 12, 13, 14, 15,
        };
        System.out.println("Largest Element in the given array is "+LargestElementProblem.findLargestElement(original));
        System.out.println("Second largest Element in the given array is "+LargestElementProblem.findSecondLargest(original));
        int[] arr1 = original.clone();
        SortingAlgorithms.SelectionSort(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = original.clone();
        SortingAlgorithms.BubbleSort(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = original.clone();
        System.out.println(Arrays.toString(arr3));
        SortingAlgorithms.InsertionSort(arr3);
        System.out.println(Arrays.toString(arr3));
      //  int[] ans = SortingAlgorithms.merge(arr1,arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(original));
        int[] arr4 = original.clone();
        System.out.println(Arrays.toString( SortingAlgorithms.mergeSort(arr4,0,arr4.length-1)));
        System.out.println(Arrays.toString(original));
        int[] arr5 = original.clone();
        SortingAlgorithms.quickSort(arr5,0,arr5.length-1);
        System.out.println(Arrays.toString(arr5));
    }

}