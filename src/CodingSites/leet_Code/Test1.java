package CodingSites.leet_Code;

import java.util.ArrayList;

class Interval {
    int buy, sell;
}

class Test1 {
    public int maxProfit(int[] prices)
    {
        int n=prices.length;
        if (n == 1)
            return 0;

        int count = 0;
        ArrayList<Interval> sol = new ArrayList<Interval>();
        int i = 0;
        while (i < n - 1) {
            while ((i < n - 1) && (prices[i + 1] <= prices[i]))
                i++;

            if (i == n - 1)
                break;

            Interval e = new Interval();
            e.buy = i++;
            while ((i < n) && (prices[i] >= prices[i - 1]))
                i++;

            e.sell = i - 1;
            sol.add(e);
            count++;
        }

        // print solution
        if (count == 0)
            System.out.println("There is no day when buying the stock "
                    + "will make profit");
        else
            for (int j = 0; j < count; j++)
                System.out.println("Buy on day: " + sol.get(j).buy
                        + "        "
                        + "Sell on day : " + sol.get(j).sell);

        return count;
    }

    public static void main(String[] args)
    {
        Test1 stock = new Test1();

        // stock prices on consecutive days
        int prices[] = {7,1,5,3,6,4};
//[7,1,5,3,6,4]

        int n = prices.length;

        // fucntion call
        stock.maxProfit(prices);
    }
}


