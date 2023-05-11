package com.cheung.leetcode;

/**
 * @Author: Kyle
 * @date 2023/5/11 23:17
 */


import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode1 {

    public static void main(String[] args) {

//        int[] nums = new int[]{2, 7, 11, 15};
//        int[] nums = new int[]{0, 4, 3, 0};
//        int[] nums = new int[]{-3,4,3,90};
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] result = twoSumV4(nums, target);
        System.out.println(JSON.toJSON(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i==j){
                    break;
                } else {
                    if(nums[i]+nums[j]==target){
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public static int[] twoSumV2(int[] nums, int target) {
        //仅对小于target的数组进行处理,会有负数的情况出现
        int[] result = new int[2];

        boolean flag = false;
        //排除的情况
        for (int num : nums) {
            if (num < 0) {
                flag = false;
                break;
            }
        }

        if (flag) {
            int[] temp = new int[nums.length];
            int[] tempIndex = new int[nums.length];
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= target) {
                    temp[index] = nums[i];
                    tempIndex[index] = i;
                    index++;
                }
            }

            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp.length; j++) {
                    if (i == j) {
                        break;
                    } else {
                        if (temp[i] + temp[j] == target) {
                            result[0] = tempIndex[i];
                            result[1] = tempIndex[j];
                            return result;
                        }
                    }
                }
            }
            return result;

        } else {
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (i == j) {
                        break;
                    } else {
                        if (nums[i] + nums[j] == target) {
                            result[0] = i;
                            result[1] = j;
                            return result;
                        }
                    }
                }
            }
            return result;
        }
    }


    /**
     * int[] nums = new int[]{3,2,4};
     *     int target = 6;
     *     需要考虑3+3=6的情况
     */

    public static int[] twoSumV3(int[] nums,int target){
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])&&(map.get(target-nums[i])!=i)){
                result[0] = i;
                result[1] = map.get(target-nums[i]);
                return result;
            }
        }
        return result;
    }

    /**
     * 优点：先比较，无target-num[i]时再将num[i]存入map中，比V3好
     * @param nums
     * @param target
     * @return
     */

    public static int[] twoSumV4(int[]nums,int target){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }

}
