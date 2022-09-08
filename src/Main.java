package src;

public class Main {
    public static void main(String[] args) {
        System.out.println("Find largest gap in array results: ");
        Integer[] arr1 = {3, 10, 6, 7};
        int result1 = WeeklyChallenge.FindLargestGapInArray(arr1);
        System.out.println("{3, 10, 6, 7}: " + result1);
        System.out.println("Expected Output: 7");
        
        Integer[] arr2 = {-3, -1, 6, 7, 0};
        int result2 = WeeklyChallenge.FindLargestGapInArray(arr2);
        System.out.println("{-3, -1, 6, 7, 0}: " + result2);
        System.out.println("Expected Output: 10");

        System.out.println("Maximum Sum SubArray using Divide and Conquer: ");
        int[] maxArr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        result1 = WeeklyChallenge.FindMaxSumArray(maxArr1);
        System.out.println("{-2, 1, -3, 4, -1, 2, 1, -5, 4}: " + result1);
        System.out.println("Expected Output: 6");

        int[] maxArr2 = {2, 2, -2};
        result2 = WeeklyChallenge.FindMaxSumArray(maxArr2);
        System.out.println("{2, 2, -2}: " + result2);
        System.out.println("Expected Output: 4");
    }
}
