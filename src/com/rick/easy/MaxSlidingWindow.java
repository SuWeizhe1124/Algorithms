package com.rick.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author : Rick Ma at 2019/6/12 16:27
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nuns = new int[]{1,3,-1,99,5,3,6,7};
        new MaxSlidingWindow().maxSlidingWindow(nuns, 3);
    }


    //滑动窗口后如果新增的数大于上次窗口内的最大数，则可以抛弃
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> aa=new ArrayList<>();




        int maxVal = nums[0];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (maxVal < nums[i]) {
                maxVal = nums[i];
            }
        }
        result.add(maxVal);
        for (int i = k; i < nums.length; i++) {
            //如果滑动窗口后新增的一个数大于当前最大值
            if (maxVal < nums[i]) {
                maxVal = nums[i];
            }
            result.add(maxVal);
        }

        int[] r=new int[result.size()];

        for(int i=0;i<result.size();i++){
            r[i]=result.get(i);
        }
        return r;
    }

}
