package main.java;

import java.util.Arrays;

/**
 *Module 4 Tasks 1-
*/
public class UberShop {
    public void printPrices(float[] prices) {
        for(float price: prices) {
            System.out.println(price + " jup.");
        }
    }

    public void multiplyPrices(float[] prices) {
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < 1000) {
                prices[i] *= 2;
            } else {
                prices[i] *= 1.5f;
            }
        }
        System.out.println(Arrays.toString(prices));
    }

    public int[] findMinMaxPrices(int[] prices) {
        if (prices.length == 0) {
            return new int[0];
        }

        int min = prices[0];
        int max = prices[0];

        for(int price: prices) {
            if (price > max) {
                max = price;
            }

            if (price < min) {
                min = price;
            }
        }

        if (min == max) {
            return new int[] {min};
        }

        return new int[] {min, max};
    }

    public int getMinPriceCount(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int counter = 0;
        int minPrice = prices[0];

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        for (int price: prices) {
            if (price == minPrice) {
                counter++;
            }
        }
        return counter;
    }



    //Test output
    public static void main(String[] args) {
        UberShop shop = new UberShop();

        //Should be [200, 2250]
//        float[] prices = new float[] {100f, 1500f};
//        shop.multiplyPrices(prices);
//        System.out.println(Arrays.toString(prices));


        //Should be [50, 1500]
//        int[] prices = new int[]{100, 1500, 300, 50};
//        int[] minMax = shop.findMinMaxPrices(prices);
//        System.out.println(Arrays.toString(minMax));

//        int[] prices = new int[] {100, 1500, 300, 50, 10, 10, 70};

        int[] prices = new int[0];
        System.out.println(shop.getMinPriceCount(prices)); //Should be 2

    }
}
