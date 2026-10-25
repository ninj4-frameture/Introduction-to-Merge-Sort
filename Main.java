import java.util.Arrays;
import  java.util.Scanner;
public class Main {
    // Divide the array into smaller subarrays
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            // Sort the left half
            mergeSort(arr, left, mid);
            // Sort the right half
            mergeSort(arr, mid + 1, right);
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
    // Merge two sorted subarrays
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        // Copy elements into temporary arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        // Compare and merge elements in sorted order
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // Copy any remaining elements from L
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // Copy any remaining elements from R
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {29, 49, 18, 30, 95, 79, 65, 83};
        System.out.println("Original array: "+ Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: "+ Arrays.toString(arr));
    }
}