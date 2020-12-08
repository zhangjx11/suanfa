package com.suanfa;

/**
 * 螺旋矩阵
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵
 *
 * 填充上行从左到右
 * 填充右列从上到下
 * 填充下行从右到左
 * 填充左列从下到上
 *
 * 由外向内一圈一圈这么画下去。
 */
public class Luoxuanjuzhen {

    public static void main(String[] args) {
        int[][] ret = generateMatrix(8);
        for (int[] ints : ret) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        // 定义每循环一个圈的起始位置
        int startx = 0, starty = 0;

        //每个圈循环几次，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理
        int loop = n / 2;

        // 矩阵中间的位置，例如：n为3， 中间的位置就是(1，1)，n为5，中间位置为(2, 2)
        int mid = n / 2;

        // 用来给矩阵中每一个空格赋值
        int count = 1;

        // 每一圈循环，需要控制每一条边遍历的长度
        int offset = 1;
        int i,j;
        while (loop-- >= 0) {
            i = startx;
            j = starty;

            // 下面开始的四个for就是模拟转了一圈
            // 模拟填充上行从左到右(左闭右开)
            for (j = starty; j < starty + n - offset; j++) {
                res[startx][j] = count++;
            }
            // 模拟填充右列从上到下(左闭右开)
            for (i = startx; i < startx + n - offset; i++) {
                res[i][j] = count++;
            }
            // 模拟填充下行从右到左(左闭右开)
            for (; j > starty; j--) {
                res[i][j] = count++;
            }
            // 模拟填充左列从下到上(左闭右开)
            for (; i > startx; i--) {
                res[i][j] = count++;
            }

            // 第二圈开始的时候，起始位置要各自加1， 例如：第一圈起始位置是(0, 0)，第二圈起始位置是(1, 1)
            startx++;
            starty++;

            // offset 控制每一圈里每一条边遍历的长度
            offset += 2;
        }

        // 如果n为奇数的话，需要单独给矩阵最中间的位置赋值
        if (n % 2 == 1) {
            res[mid][mid] = count;
        }
        return res;
    }
};