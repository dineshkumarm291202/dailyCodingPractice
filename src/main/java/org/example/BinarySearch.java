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
        public int singleNonDuplicate(int[] nums) {
            int low = 0, high = nums.length - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;

                // make mid even
                if (mid % 2 == 1) {
                    mid--;
                }

                if (nums[mid] == nums[mid + 1]) {
                    // single element is on the right
                    low = mid + 2;
                } else {
                    // single element is on the left (or mid itself)
                    high = mid;
                }
            }
            return nums[low];
    }
    //finding the minimun element
        public int findMin(int[] nums) {
            int low = 0, high = nums.length - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] > nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return nums[low];
        }
        //Finding peak element
    public static int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        // Binary search loop
        while (low < high) {
            // Find mid point
            int mid = (low + high) / 2;

            // If mid element is greater than next
            if (nums[mid] > nums[mid + 1]) {
                // Move to left half
                high = mid;
            } else {
                // Move to right half
                low = mid + 1;
            }
        }

        // Return peak index
        return low;
    }
    //finding squareroot
    public static int findSquareRoot(int x){
        if(x<2)return x;
        int left = 1; int right = x/2;
        int ans =0;
        while(left<=right){
            int mid = (left+right)/2;
            if(mid == x / mid)return mid;
            else if(mid*mid<x) {
                ans = mid;
                left = mid + 1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }
    //Aggressive cows problem
    public static int aggressiveCows(int[] arr,int cows){
        int low = 1;
        int high = arr[arr.length-1]-arr[0];
        int ans =1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(checkCows(arr,mid,cows)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    public static boolean checkCows(int[] arr, int mid, int cows){
        int last_placed = arr[0];
        int count =1;
        for(int i =1;i<arr.length-1;i++){
            if(arr[1]-last_placed>=mid){
                last_placed=arr[i];
                count++;
                if(count==cows)return true;
            }
        }
        return false;
    }
    //PAINTER PARTITION PROBLEM
    public static int painterPartitionProblem(int[] arr, int workers){
        int low = arr[0];
        int ans =0;
        int high = 0;
        for(int i =0;i<arr.length;i++){
            high+=arr[i];
            low = Math.max(low,arr[i]);
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(checkPainters(arr,workers,mid)){
                ans= mid;
                high=mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;

    }
    public static boolean checkPainters(int[] arr, int workers, int mid){
        int worker = 1;
        int timespent = 0;
        for(int i =0;i< arr.length;i++){
            if(arr[i]>mid)return false;
            if(arr[i]+timespent<=mid){
                timespent=arr[i]+timespent;
            }else{
                worker++;
                timespent=arr[i];
            }
        }
        if(worker<=workers)return true;
        return false;
    }
    public static int findNthRoot(int n, int m){
        if(m<=1)return m;
        int low =1;
        int high = m;
        while(low<=high){
            int mid =low+(high-low)/2;
            if(findPower(mid,n,m)==m)return mid;
            if(findPower(mid,n,m)< m)low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
    public static int findPower(int base, int exp, int limit){
        int result = 1;
        for(int i =0;i<exp;i++){
            result*=base;
            if(result>limit)return result;
        }
        return result;
    }
    public static int findKoko(int[] arr, int hour){
        int low =1;
        int high= arr[0];
        for(int i =0;i<arr.length;i++){
            high = Math.max(arr[i],high);
        }
        int ans = high;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(findFeasbilityForKoko(arr,hour,mid)){
                ans = mid;
                high =mid-1;
            }else{
                low =mid+1;
            }
        }return ans;
    }
    public static boolean findFeasbilityForKoko(int[] arr, int hour, int mid){
        int hours = 0;
        for(int i=0;i<arr.length;i++){
            hours += (arr[i] + mid - 1) / mid;
        }
        if(hours<=hour)return true;
        return false;
    }
    //Code to find the SmallestDivisor
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            high = Math.max(high,nums[i]);
        }
        int ans =1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(checkPossible(nums,mid,threshold)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean checkPossible(int[] arr,int mid,int threshold){
        int ans =0;
        for(int i =0;i<arr.length;i++){
            ans+=(arr[i]+mid-1)/mid;
        }
        if(ans<=threshold)return true;
        return false;
    }
    //Minimum Days to Make the bouquet
    public int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num:bloomDay){
            min=Math.min(num,min);
            max=Math.max(num,max);
        }
        int ans = -1;
        while(min<=max){
            int mid = min+(max-min)/2;
            if( checkIfPossible(bloomDay,mid,m,k)){
                ans = mid;
                max=mid-1;
            }
            else min = mid+1;
        }
        return ans;
    }public static boolean checkIfPossible(int[] arr,int mid, int m, int k){
        int count=0;
        int bouquet =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                count++;
                if(count==k){
                    bouquet++;
                    count=0;
                }
            }if(arr[i]>mid){
                count=0;
            }if(bouquet==m)return true;
        }
        return false;
    }
    //Cheating for consistency
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i =0;i<weights.length;i++){
            low = Math.max(low,weights[i]);
            high+=weights[i];
        }
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(checkIsShipmentPossible(weights, days, mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean checkIsShipmentPossible(int[] arr, int days, int mid){
        int count =0;
        int day = 1;
        for(int i =0;i<arr.length;i++){
            if(count+arr[i]>mid){
                day++;                  // CHANGED
                count = arr[i];         // CHANGED (was: count = 0)
                if(day>days) return false;
            }else{
                count += arr[i];        // CHANGED placement
            }

        }
        return true;
    }
    //Book Allocation binary search Problem
    public int findPages(int[] arr, int n, int m) {

        // Not enough books
        if (n < m) return -1;

        int max = 0;
        int sum = 0;

        for (int pages : arr) {
            max = Math.max(max, pages);
            sum += pages;
        }

        int low = max;
        int high = sum;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(arr, m, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canAllocate(int[] arr, int m, int maxPages) {
        int students = 1;
        int pagesSum = 0;

        for (int pages : arr) {
            if (pagesSum + pages > maxPages) {
                students++;
                pagesSum = pages;

                if (students > m) {
                    return false;
                }
            } else {
                pagesSum += pages;
            }
        }
        return true;
    }
}
