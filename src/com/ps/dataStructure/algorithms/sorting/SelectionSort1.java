package com.ps.dataStructure.algorithms.sorting;

public class SelectionSort1 {
    public static void main(String[] args) {
        System.out.println("inside main");
        int intArray[]={20,35,-15,7,55,1,-22};

        for (int lastUnsortedIndex = intArray.length-1 ; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            int largest=0;
            for (int i = 0; i <= lastUnsortedIndex ; i++) {
                if(intArray[i] > intArray[largest]){//desc sorting
                    largest=i;
                }
            }
                swap(intArray,largest,lastUnsortedIndex);
        }
        for (int i = 0; i < intArray.length; i++) {
            System.out.println("intArray : "+intArray[i]);
        }
    }

    public static void swap(int[] array, int i, int j){
        System.out.println("inside swap = [" + array + "], i = [" + i + "], j = [" + j + "]");
        if(i == j){
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
