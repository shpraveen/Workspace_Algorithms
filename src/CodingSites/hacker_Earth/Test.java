package CodingSites.hacker_Earth;

import java.util.LinkedList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> numbersList = new LinkedList<Integer>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Number:");

        while (true) {
            if (input.hasNextInt()) {
               // System.out.println("Entered input is integer");
                int numbers = input.nextInt();
                if (numbers < 0 || numbers > 99) {
                    System.out.println("Invalid Input: " + numbers);
                    numbersList.add(numbers);
                    System.out.println("Output: " + numbersList);
                    break;
                } else {
                    if (numbers != 42) {
                        numbersList.add(numbers);
                    } else {
                        System.out.println("Output: " + numbersList);
                        numbersList.add(numbers);
                        System.out.println("Input: " + numbersList);
                        break;
                    }
                }
            } else if (input.hasNext()) {
                /*String string = input.nextLine();
                if (string.length() > 1) {
                    System.out.println("Entered input is String");
                } else {
                    System.out.println("Entered input is Char");
                }*/
                System.out.println("Input Entered is not Integer");
                break;

            }
        }
    }
}
