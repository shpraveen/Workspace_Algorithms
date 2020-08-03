package com.ps.dataStructure.algorithms.sorting;

import javax.xml.bind.SchemaOutputResolver;

public class InsertionSort_recursion {
    public static void main(String[] args) {
        System.out.println("inside main");
        int intArray[] = {20, 35, -15, 7, 55, 1, -22};

        insertionSort(intArray, intArray.length);

        /*for (int firstUnsortedIndex = 0; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {

            int newElement=intArray[firstUnsortedIndex];
            int i;
            for (i= firstUnsortedIndex;i > 0 && intArray[i-1] > newElement; i--) {
                intArray[i] = intArray[i-1];
            }

            intArray[i]=newElement;
        }
*/

        for (int i = 0; i < intArray.length; i++) {
            System.out.println("intArray : " + intArray[i]);
        }
    }

    public static void insertionSort(int[] input, int numItems) {

        if (numItems < 2) {
            return;
        }

        insertionSort(input, numItems - 1);

        // for (int firstUnsortedIndex = 0; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {

        int newElement = input[numItems - 1];
        int i;
        for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
               }

            input[i] = newElement;


        }


    }
