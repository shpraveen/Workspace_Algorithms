package com.ps.dataStructure.algorithms.array;

public class Array1 {

    public static void main(String[] args) {

        int[] intArray= new int[5];

        intArray[0]=12;
        intArray[1]=90;
        intArray[2]=-90;
        intArray[3]=22;
        intArray[4]=45;

        int index=-1;
        for(int i =0; i<intArray.length; i++){
     //   System.out.println(intArray[i]);

            if( intArray[i] == -90){
                index= i;
                break;



            }

        }
        System.out.println("index of -90 is : "+index);

    }
}
