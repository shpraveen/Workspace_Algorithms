package com.ps.dataStructure.algorithms.sorting;

import java.util.Arrays;

public class JavaSortMethod {

    public static void main(String[] args) {
        int[] intArray={20,56,-58,1,-9,14};

        //Arrays.sort(intArray);
        Arrays.parallelSort(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}
