package com.cheung.leetcode;

import org.junit.Test;

/**
 *4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Kyle
 * @date 2023/5/15 09:41
 */
public class Leetcode4 {




    @Test
    public void test(){

        int [] nums1 = new int []{1,3};
        int [] nums2 = new int []{0};

//        System.out.println(findMedianSortedArrays());
    }

    //思路：直接放在一个set中，取中位数 o(m+n)

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0;
    }

}
