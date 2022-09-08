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
        // Check to see if arr is empty to null, if so return 0;
        if (arr.length == 0 || arr == null) return 0;
        return FindMaxSumArray(arr, 0, arr.length - 1);
    }

    public static int FindMaxSumArray (int[] arr, int left, int right) {
        // Base Case
        if (left == right) return arr[0];

        // Find the mid index
        int mid = (left + right) / 2;

        // Left Subarray, mid inclusive
        int leftMaxSoFar = arr[left];
        int leftMaxEndingHere = arr[left];

        // Use Kadane algorithm for left subarray
        for (int i = left + 1; i <= mid; i++) {
            if (arr[i] > leftMaxEndingHere + arr[i]) {
                leftMaxEndingHere = arr[i];
            } else {
                leftMaxEndingHere = leftMaxEndingHere + arr[i];
            }
    
            if (leftMaxSoFar < leftMaxEndingHere) {
                leftMaxSoFar = leftMaxEndingHere;
            }
        }

        // Right Subarray, mid exclusive
        int rightMaxSoFar = arr[right];
        int rightMaxEndingHere = arr[right];

        // Use Kadane algorithm for right subarray
        for (int i = left + 1; i <= mid; i++) {
            if (arr[i] > rightMaxEndingHere + arr[i]) {
                rightMaxEndingHere = arr[i];
            } else {
                rightMaxEndingHere = rightMaxEndingHere + arr[i];
            }
    
            if (rightMaxSoFar < rightMaxEndingHere) {
                rightMaxSoFar = rightMaxEndingHere;
            }
        }

        // Choose 
        return Math.max(
            FindMaxSumArray(arr, left, mid),
            FindMaxSumArray(arr, mid + 1, right)
        );
    }
}