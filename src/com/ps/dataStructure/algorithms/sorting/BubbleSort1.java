package com.ps.dataStructure.algorithms.sorting;

public class BubbleSort1 {
    public static void main(String[] args) {
        System.out.println("inside main");
        int intArray[]={20,35,-15,7,55,1,-22};

        for (int lastUnsortedIndex = intArray.length-1 ; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] < intArray[i+1]) { //Desc sort
                //if (intArray[i] > intArray[i+1]) {   //Asc sort
                    swap(intArray,i,i+1);

                    System.out.println("BubbleSort1 = [" + intArray + "]");
                }
                
            }
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
