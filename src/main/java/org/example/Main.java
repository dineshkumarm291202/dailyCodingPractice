package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {
                1, 2, 3, 4, 5,
                6, 7, 8, 9, 10,
                11, 12, 13, 14, 15,
                16, 17, 18, 19, 20
        };
        System.out.println("Largest Element in the given array is "+LargestElementProblem.findLargestElement(arr));
        System.out.println("Second largest Element in the given array is "+LargestElementProblem.findSecondLargest(arr));

    }
}