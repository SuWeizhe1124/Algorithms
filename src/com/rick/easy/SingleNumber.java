package com.rick.easy;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 136. 只出现一次的数字
 *
 * @author : Rick Ma at 2019/6/28 16:50
 */
public class SingleNumber {
    public static void main(String[] args) {

        int a = 2;
        int b = 3;
        int c = 2;

        System.out.println(a ^ b ^ c);


//        int[] nums = new int[]{4, 1, 2, 1, 2};
//
//        System.out.println(singleNumber(nums));


    }

    public static int singleNumber(int[] nums) {
        List<Integer> result = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {
            if (result.contains(nums[i])) {
                result.remove(nums[i]);
            } else {
                result.add(nums[i]);
            }
        }
        return result.get(0);
    }

}
