package CodingSites.hacker_Earth;

import java.util.Scanner;


public class Wet_Clothes {
    public static void main(String args[] ) throws Exception
    {

        int n,m,g,c=0;
        Scanner s = new Scanner(System.in);
         n=s.nextInt();
         m=s.nextInt();
         g=s.nextInt();
        int[] t=new int[n];
        int[] a=new int[m];
        for(int i=0;i<n;i++)
        {
            t[i]=s.nextInt();
        }
        for(int j=0;j<m;j++)
        {
            a[j]=s.nextInt();
        }
        int w=0;
        for(int p=1;p<(t.length);p++)
        {
            w=t[p]-t[p-1];
            for(int r=0;r<a.length;r++)
            {
                if(a[r]<=w)
                {
                    a[r]=Integer.MAX_VALUE;
                    c++;
                }
            }
        }
        System.out.println("Maximum Dried Clothes: "+c);
    }
    }
