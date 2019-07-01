package com.rick.easy;

import com.alibaba.fastjson.JSONObject;

/**
 * Description
 *
 * @author : Rick Ma at 2019/6/25 10:36
 */
public class SortList {

    public static void main(String[] args) {
        int[] list = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8, 5};
//        System.out.println(JSONObject.toJSONString(list));
//        quickSort(list, 0, list.length - 1);
//        System.out.println(JSONObject.toJSONString(list));


        int[] result = new int[100];

        for (int i = 0; i < list.length; i++) {
            result[list[i]]++;
        }

        System.out.println(JSONObject.toJSONString(result));


    }

    private static void quickSort(int[] list, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int c = list[i];
        while (i < j) {
            System.out.println("-----------------------------");
            while (c < list[j] && i < j) {
                j--;
            }
            while (c >= list[i] && i < j) {
                i++;
            }
            if (i == j) {
                swap(list, low, j);
            } else {
                swap(list, i, j);
            }
            System.out.println("i : " + i + "j : " + j);
            System.out.println(JSONObject.toJSONString(list));
        }
        quickSort(list, low, j - 1);
        quickSort(list, j + 1, high);

    }

    private static void swap(int[] list, int indexI, int indexJ) {
        list[indexI] = list[indexI] ^ list[indexJ];
        list[indexJ] = list[indexI] ^ list[indexJ];
        list[indexI] = list[indexI] ^ list[indexJ];
        System.out.println("swap value:" + list[indexI] + "  " + list[indexJ]);
    }

    public static void bubbleSort() {
        int[] list = new int[]{5, 7, 2, 4, 8, 32, 6};
        for (int j = 0; j < list.length - 1; j++) {
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] > list[i + 1]) {
                    list[i] = list[i] ^ list[i + 1];
                    list[i + 1] = list[i] ^ list[i + 1];
                    list[i] = list[i] ^ list[i + 1];
                }
            }

        }
        System.out.println(JSONObject.toJSONString(list));
    }

}
