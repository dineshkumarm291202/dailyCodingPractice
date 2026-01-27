package org.example;

public class BinarySearch {
    public static int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int ans = arr.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    public static int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int ans = arr.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] > target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    public static int floor(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]<=target){
                ans = arr[mid];
                low = mid+1;
            }else high = mid-1;
        }
        return ans;

    }
    public static int ceil(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        int ans =0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>=target){
                ans = arr[mid];
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

}
