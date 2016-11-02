package Sorting;

/**
 * Created by aishwaryasrinivasan on 27/10/16.
 */

/*
Best explanation of Quicksort: https://www.youtube.com/watch?v=aQiWF4E8flQ
Implementation is based on the explained logic in the video
 */
public class QuickSort {

    public static void main(String[] args){
        int[] array = {10, 7, 8, 9 ,1 ,5};
        printArray(array);
        quickSort(array, -1, array[array.length-1]);
        printArray(array);

    }

    public static void partition(int[] array, int wall, int pivot){
        for(int i=wall+1; i<array.length-1; i++){
            if(array[i] <= pivot){
                //swap current element with element with the smallest sitting to the right of the wall
                wall++;
                int temp = array[i];
                array[i] = array[wall];
                array[wall] = temp;
            }
        }
        array[array.length-1] = array[wall+1];
        array[wall+1] = pivot;
    }

    public static void quickSort(int[] array, int wall, int pivot){

        pivot = array[array.length-1];

        if(wall < array.length-1){
            partition(array, wall, pivot);
            quickSort(array, wall+1, pivot);
        }
    }

    public static void printArray(int[] array){
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }


}
