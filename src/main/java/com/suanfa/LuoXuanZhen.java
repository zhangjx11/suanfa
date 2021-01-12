package com.suanfa;

public class LuoXuanZhen {

    public static void main(String[] args) {

        int n = 5;
        int[][] ret = new int[n][n];
        int a = 0, b = 0, c = n - 1, d = n - 1;
        int x = 1;
        while (a <= c) {
            x = fill(a, b, c, d, x, ret);
            a++;
            b++;
            c--;
            d--;
        }

        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[i].length; j++) {
                System.out.print(ret[i][j] + ",");
            }
            System.out.println();
        }

    }

    private static int fill(int a, int b, int c, int d, int n, int[][] ret) {

        for (int i = b; i <= d; i++){
            ret[a][i] = n++;
        }

        for (int i = a + 1; i <= c; i++){
            ret[i][d] = n++;
        }

        for (int i = d - 1; i >= b; i--){
            ret[c][i] = n++;
        }

        for (int i = c - 1; i > a; i--){
            ret[i][b] = n++;
        }

        return n;

    }


}
