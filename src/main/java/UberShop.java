package main.java;

import javax.print.attribute.standard.OrientationRequested;
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
    public int[] removePrice(int[] prices, int toRemove) {
        int counter = 0;
        int[] priceIsRemoved = new int[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] != toRemove) {
                priceIsRemoved = Arrays.copyOf(priceIsRemoved, priceIsRemoved.length + 1);
                priceIsRemoved[counter] = prices[i];
                counter++;
            }
        }
        return priceIsRemoved;

/*        АБО краще:
        int toRemoveCount = 0;
        for(int price: prices) {
            if (price == toRemove) {
                toRemoveCount++;
            }
        }

        int[] result = new int[prices.length - toRemoveCount];
        int index = 0;
        for(int price: prices) {
            if (price != toRemove) {
                result[index] = price;
                index++;
            }
        }

        return result;*/
    }

    public int[] leavePrice9(int[] prices) {
        if (prices.length  == 0) {
            return prices;
        }
        int newArrayLength = 0;
        for (int price: prices) {
            if (price % 10 == 9) {
                newArrayLength++;
            }
        }

        int[] chornaPyatnytsya = new int[newArrayLength];
        int index = 0;
        for (int price: prices) {
            if (price % 10 == 9) {
                chornaPyatnytsya[index] = price;
                index++;
            }
        }
        return chornaPyatnytsya;
    }
    public String[] mergeStocks(String[] showcaseStocks, String[] warehouseStocks) {
        if ((showcaseStocks.length == 0) && (warehouseStocks.length == 0)) {
            return new String[0];
        }
        int mergeStocksLength = showcaseStocks.length + warehouseStocks.length;
        int index = showcaseStocks.length;
        String[] mergedStock = Arrays.copyOf(showcaseStocks, mergeStocksLength);
        for (int i = 0; i < warehouseStocks.length; i++) {
            mergedStock[index] = warehouseStocks[i];
            index++;
        }
        return mergedStock;

/*        OR
        String[] result = new String[showcaseStocks.length + warehouseStocks.length];

        int index = 0;
        for(String stock: showcaseStocks) {
            result[index] = stock;
            index++;
        }

        for(String stock: warehouseStocks) {
            result[index] = stock;
            index++;
        }

        return result;  */
    }

    public int getPricesSum(int[] prices, int minPrice, int maxPrice) {

        int sum = 0;

        for (int price: prices) {
            if ((price >= minPrice) && (price <= maxPrice)) {
                sum += price;
            }
        }
        return sum;

    }



    //Test output
    public static void main(String[] args) {
        UberShop shop = new UberShop();

        //Should be [200, 2250]
//        float[] prices = new float[] {100f, 1500f};
//        shop.multiplyPrices(prices);
//        System.out.println(Arrays.toString(prices));


/*        //Should be [50, 1500]
        int[] prices = new int[]{100, 1500, 300, 50};
        int[] minMax = shop.findMinMaxPrices(prices);
        System.out.println(Arrays.toString(minMax));*/

/*        //Should be 2
        int[] prices = new int[] {100, 1500, 300, 50, 10, 10, 70};
        System.out.println(shop.getMinPriceCount(prices)); */

/*        //Should be [150, 200]
        int[] prices = new int[]{150, 100, 200};
        int toRemove = 100;
        System.out.println(Arrays.toString(shop.removePrice(prices, toRemove)));*/

/*        //Should be [1599, 399]
        int[] prices = new int[] {399, 1599, 399, 50, 10, 10, 70};
        System.out.println(Arrays.toString(shop.leavePrice9(prices)));*/

/*        //Final result should be ["gun", "firebow", "firegun"]
        String[] showcaseStocks = new String[] {"gun", "firebow"};
        String[] warehouseStocks = new String[] {"firegun"};
        System.out.println(Arrays.toString(shop.mergeStocks(showcaseStocks, warehouseStocks)));*/

        //Should be 144 - 20 + 50 + 40 + 34
        int[] prices = new int[] {10, 20, 50, 40, 34, 500};
        System.out.println(shop.getPricesSum(prices, 20, 50));



    }
}
