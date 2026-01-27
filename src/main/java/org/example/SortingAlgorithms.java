package org.example;

import java.util.ArrayList;


public class SortingAlgorithms {
    public static void SelectionSort(int[] arr){
        for(int i =0; i<arr.length;i++){
            int smallIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[smallIndex])smallIndex=j;
            }
            swap(arr,i,smallIndex);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
        public static void BubbleSort(int[] arr){
            for(int i=arr.length-1;i>=0;i--){
                for(int j=0;j<i;j++){
                    if(arr[j]>arr[j+1]){
                        swap(arr,j,j+1);
                    }
                }
            }
        }
        public static void InsertionSort(int[] arr){
        for(int i =1;i<arr.length;i++){
            int j =i-1;
            while(j>=0 && arr[j]>arr[j+1]){
                swap(arr,j,j+1);
                j--;
            }
        }
    }
    public static int[] mergeSort(int[] arr,int i, int j){
        if(i==j) {
            return new int[]{arr[i]};
        };
        int mid = (i+j)/2;
        int[] array1 = mergeSort(arr,i,mid);
        int[] array2 = mergeSort(arr,mid+1,j);
        return merge(array1,array2);
    }
    public static int[] merge(int[] arr,int[] arr1){
        int p1=0,p2=0,p3=0;
        int n = arr.length;
        int m = arr1.length;
        int[] ans = new int[n+m];
        while(p1<n && p2<m){
            if(arr[p1]<arr1[p2]) {
                ans[p3] = arr[p1];
                p1++;
                p3++;
            }else{
                ans[p3]=arr1[p2];
                p2++;
                p3++;
            }
        }
        while(p1<n){
            ans[p3]=arr[p1];
            p1++;
            p3++;
        }
        while(p2<m){
            ans[p3]=arr1[p2];
            p2++;
            p3++;
        }
        return ans;
//
//        public class MergeSort {
//
//            public static void mergeSort(int[] arr, int left, int right) {
//                if (left >= right) return;
//
//                int mid = left + (right - left) / 2;
//
//                mergeSort(arr, left, mid);
//                mergeSort(arr, mid + 1, right);
//
//                merge(arr, left, mid, right);
//            }
//
//            private static void merge(int[] arr, int left, int mid, int right) {
//                int[] temp = new int[right - left + 1];
//
//                int i = left, j = mid + 1, k = 0;
//
//                while (i <= mid && j <= right) {
//                    if (arr[i] <= arr[j]) {
//                        temp[k++] = arr[i++];
//                    } else {
//                        temp[k++] = arr[j++];
//                    }
//                }
//
//                while (i <= mid) temp[k++] = arr[i++];
//                while (j <= right) temp[k++] = arr[j++];
//
//                // copy back to original array
//                for (int x = 0; x < temp.length; x++) {
//                    arr[left + x] = temp[x];
//                }
//            }
//        }

    }
    public static void quickSort(int[] arr,int low, int high){
        if(low>=high)return;
        int mid = rearrange(arr,low,high);
        quickSort(arr,low,mid-1);
        quickSort(arr,mid+1,high);
    }
    public static int rearrange(int[] arr,int low, int high){
        int pivot = arr[low];
        int p1=low+1,p2=high;
        while(p1<=p2){
            if(arr[p1]<pivot)p1++;
            else if(arr[p2]>pivot)p2--;
            else{
                swap(arr,p1,p2);
                p1++;
                p2--;
            }
        }
        swap(arr,low,p2);
        return p2;
    }
    public static void countSort(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }

        int[] count = new int[max + 1];

        for (int num : arr) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static int searchInRotatedSortedArray(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target)return mid;
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }return -1;
    }

}
