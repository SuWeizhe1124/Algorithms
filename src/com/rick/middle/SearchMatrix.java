package com.rick.middle;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 *
 * @author : Rick Ma at 2019/6/18 17:59
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int matrixLength = matrix.length;

        int bucket = matrixLength / 2;
        int minIndex;
        int maxIndex;
        if (matrix[bucket][0] < target) {
            bucket = bucket + (matrix.length - bucket) / 2;
            minIndex = bucket;
            maxIndex = matrixLength;
        } else {
            bucket = bucket - (matrix.length - bucket) / 2;


        }

        return true;
    }

    public static void main(String[] args) {


    }

//    public int[] plusOne(int[] digits) {
//
//        digits[digits.length-1]=digits[digits.length-1]++;
//        return
//
//    }
}
