package org.example;

public class LargestElementProblem {
    public static int findLargestElement(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
    public static int findSecondLargest(int[] arr){
        if(arr.length==0 || arr.length==1)return 0;
        int first = arr[0];
        int second =Integer.MIN_VALUE;
        for(int i = 1;i<arr.length;i++){
            if(arr[i]>first){
                second=first;
                first=arr[i];
            }else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }
        return second;
    }
}
