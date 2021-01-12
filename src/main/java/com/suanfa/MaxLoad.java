package com.suanfa;

public class MaxLoad {

    public static void main(String[] args) {

//        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] arr = new int[]{3,2,2,4,1,4};
//        int[] arr = new int[]{1,2,3,1,1};
        int d = 3;

        System.out.println(calMinLoad(arr, d));
    }

    private static int calMinLoad(int[] weights, int d) {

        int leftLoad = 0;
        int rightLoad = 0;
        for (int weight : weights) {
            leftLoad = Math.max(weight, leftLoad);
            rightLoad += weight;
        }

        while (leftLoad < rightLoad) {
            int midLoad = leftLoad + (rightLoad - leftLoad) / 2;
            if (greaterThenD(midLoad, weights, d)) {
                leftLoad = midLoad + 1;
            } else {
                rightLoad = midLoad;
            }
        }
        return leftLoad;
    }

    private static boolean greaterThenD(int maxLoad, int[] weights, int d) {

        int tmp = 0;
        for (int weight : weights) {
            if (d <= 0) {
                return true;
            }

            if (tmp + weight == maxLoad) {
                d--;
                tmp = 0;
            } else if (tmp + weight > maxLoad) {
                d--;
                tmp = weight;
            } else {
                tmp += weight;
            }

        }

        return d <= 0;

    }

}
