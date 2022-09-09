package src;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WeeklyChallenge {
    /**
     * Largest gap in an array:
     * Given an unsorted array of length N, and we have to find the largest gap between any two elements of the array. 
     * In simple words, find max(|Ai-Aj|) where 1 ≤ i ≤ N and 1 ≤ j ≤ N.
     * @author Colby Tang
     * @param arr
     * @return int
     */
    public static int FindLargestGapInArray (Integer[] arr) {
        if (arr.length == 0) return 0;
        int min = Stream.of(arr).min(Integer::compare).get();
        int max = Stream.of(arr).max(Integer::compare).get();
        return Math.abs(min - max);
    }

    /**
     * 
     * @param arr
     * @return int
     */
    public static int FindMaxSumArray (int[] arr) {
        // Check to see if arr is empty or null, if so return 0;
        if (arr == null || arr.length == 0) return 0;
        return FindMaxSumArray(arr, 0, arr.length - 1);
    }

    public static int FindMaxSumArray (int[] arr, int left, int right) {
        // Base Case
        if (left == right) return arr[0];

        // Find the mid index
        int mid = (left + right) / 2;

        // Left Subarray, mid inclusive
        int leftMax = arr[mid];
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            if (sum > leftMax) leftMax = sum;
        }

        // Right Subarray, mid exclusive
        int rightMax = arr[mid+1];
        sum = 0;    // reset sum to 0
        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            if (sum > rightMax) rightMax = sum;
        }

        // Choose 
        return Math.max(
            leftMax + rightMax,
            Integer.max(FindMaxSumArray(arr, left, mid), FindMaxSumArray(arr, mid + 1, right))
        );
    }
}