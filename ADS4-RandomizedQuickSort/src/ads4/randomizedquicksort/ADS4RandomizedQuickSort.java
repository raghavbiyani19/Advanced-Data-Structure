package ads4.randomizedquicksort;

//import static ads4.randomizedquicksort.QuickSort.printArray;

import java.util.Random;


public class ADS4RandomizedQuickSort {
    public static void main(String[] args) {
        Random rd = new Random(); // creating Random object
        int[] arr = new int[10000];
        int n = arr.length;
        System.out.println("ARRAY SIZE ====================>"+n);
        int num=20000;
        for (int i = 0; i < arr.length; i++) {
         arr[i] = num--;
        }
        
        QuickSort quickSortObj = new QuickSort(); 
        quickSortObj.sort(arr, 0, n-1);
        System.out.println("Sorted array:"); 
        quickSortObj.printArray(arr);
        System.out.println("TOTAL PARTITIONS IN STANDARD QS: "+quickSortObj.totalPartitions);
        
        RandomizedQuickSort randQuickSortObj = new RandomizedQuickSort();
        randQuickSortObj.sort(arr, 0, n-1);
        System.out.println("Sorted array:"); 
        randQuickSortObj.printArray(arr);
        System.out.println("TOTAL PARTITIONS IN RANDOMIZED QS: "+randQuickSortObj.totalPartitions);
    }   
}