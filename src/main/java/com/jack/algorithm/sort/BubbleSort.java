package com.jack.algorithm.sort;

import java.util.Arrays;

/**
 * @author: LiJiakui
 * @Description: 冒泡排序
 * @Dat: Create in 14:09 2019-12-19
 * @Modifiled By:
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * @param array 数组
     */
    private static void sort(int[] array) {
        //循环轮数， 1，2 循环一次； 1，2，3循环两轮。所以循环轮数为数组个数-1
        for (int i = 0; i < array.length - 1; i++) {
            //比较次数，每比较完一轮，最后一个数可以不比较，所以比较次数递减
            for (int j = 0; j < array.length - 1 - i; j++) {
                int temp = array[j];
                if (array[j] > array[j + 1]) {
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }

    }

    public static void main(String[] args) {
        int[] array = {2, 5, 9, 4, 57, 8, 9, 1, 23};
        System.out.println(Arrays.toString(array));
        BubbleSort.sort(array);
        System.out.println(Arrays.toString(array));

    }
}
