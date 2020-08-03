package interviews.publicisSapient;

import java.util.HashSet;
import java.util.Set;

public class NoOfSubArraysZero {
    static int subArrayExists(int arr[])
    {
        Set<Integer> hs = new HashSet<Integer>();
        int sum = 0;
        int count =0;
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
            if (arr[i] == 0 || sum == 0 || hs.contains(sum)) {
                count++;
                hs.add(sum);
                return count;
            }
            return count;
        }
        return count;
    }

    public static void main(String arg[])
    {
        int arr[] = {-2,0,2,3,-3,4,-7};
       /* if (subArrayExists(arr))
            System.out.println("Found a subarray with 0 sum");
        else
            System.out.println("No Such Sub Array Exists!");*/
       int noOfSubArray = subArrayExists(arr);
        System.out.println("noOfSubArray with 0 sum: "+noOfSubArray);
    }
}
