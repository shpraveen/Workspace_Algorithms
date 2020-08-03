package com.ps.dataStructure.algorithms.sorting;

public class RadixSort_String {

    public static void main(String[] args) {
        String[] radixArray={"bcdef","dbaqc","abcde","omadd","bbbbb"};

        radixSort(radixArray,26, 5);

        for (int i = 0; i < radixArray.length; i++) {
            System.out.println(radixArray[i]);
        }
    }

    public static void radixSort(String[] input, int radix, int width){
        for (int i = width -1 ; i >= 0; i--) {
            radixSingleSort(input,i,radix);
        }

    }

        public static void radixSingleSort(String[] input, int position, int radix){

            int numItems = input.length;
            int[] countArray = new int[radix];

            for (String value : input ) {
                countArray[getIndex(position,value)]++;
            }

            // Adjust the count Array
            for(int j=1; j < radix; j++){
                countArray[j] += countArray[j-1];
            }

            // copy to new array
            String[] temp  = new String[numItems];
            for (int tempIndex = numItems - 1; tempIndex >= 0 ; tempIndex--) {

                temp[--countArray[getIndex(position,input[tempIndex])]]=input[tempIndex];
            }

            for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
                input[tempIndex]= temp[tempIndex];
            }
        }

        /*public static int getDigit(int position, int value, int radix){

        return value/ (int) Math.pow(radix,position) % radix;
        }*/

        public static int getIndex(int position, String value){

            return value.charAt(position) - 'a';
        }

}
