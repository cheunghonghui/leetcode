//package com.cheung.leetcode;
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @Author: Kyle
// * @date 2023/9/28 15:36
// */
//public class Exercises010104 {
//
//
//    /**
//     * re
//     * https://leetcode.cn/problems/add-two-integers/
//     * 描述：给定两个整数求和
//     * <p>
//     * 要求：返回这两个整数的和。
//     * 示例 1：
//     * <p>
//     * 输入：num1 = 12, num2 = 5
//     * 输出：17
//     * 解释：num1 是 12，num2 是 5 ，它们的和是 12 + 5 = 17 ，因此返回 17 。
//     */
//
//    public int sum(int num1, int num2) {
//        return num1 + num2;
//    }
//
//
//    /**
//     * https://leetcode.cn/problems/concatenation-of-array/
//     * <p>
//     * 给你一个长度为 n 的整数数组 nums 。请你构建一个长度为 2n 的答案数组 ans ，数组下标 从 0 开始计数 ，对于所有 0 <= i < n 的 i ，满足下述所有要求：
//     * <p>
//     * ans[i] == nums[i]
//     * ans[i + n] == nums[i]
//     * 具体而言，ans 由两个 nums 数组 串联 形成。
//     *
//     * @param nums
//     * @return
//     */
//
//    public int[] getConcatenation(int[] nums) {
//
//        int len = nums.length;
//        int[] ans = new int[2 * len];
//        for (int i = 0; i <= 2 * len - 1; i++) {
//            if (i <= len - 1) {
//                ans[i] = nums[i];
//            } else {
//                ans[i] = nums[i - len];
//            }
//        }
//        return ans;
//    }
//
//
//    /**
//     * https://leetcode.cn/problems/jewels-and-stones/
//     * <p>
//     * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。 stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
//     * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
//     * <p>
//     * 示例 1：
//     * <p>
//     * 输入：jewels = "aA", stones = "aAAbbbb"
//     * 输出：3
//     * 示例 2：
//     * <p>
//     * 输入：jewels = "z", stones = "ZZ"
//     * 输出：0
//     *
//     * @param jewels
//     * @param stones
//     * @return
//     */
//    public int numJewelsInStones(String jewels, String stones) {
//        ArrayList<Character> list = new ArrayList<Character>();
//        for (int i = 0; i < jewels.length(); i++) {
//            list.add(jewels.charAt(i));
//        }
//        int count = 0;
//        for (int i = 0; i < stones.length(); i++) {
//            if (list.contains(stones.charAt(i))) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    /**
//     * https://leetcode.cn/problems/running-sum-of-1d-array/
//     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
//     * <p>
//     * 请返回 nums 的动态和。
//     * <p>
//     * 示例 1：
//     * <p>
//     * 输入：nums = [1,2,3,4]
//     * 输出：[1,3,6,10]
//     * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
//     * 示例 2：
//     * <p>
//     * 输入：nums = [1,1,1,1,1]
//     * 输出：[1,2,3,4,5]
//     * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
//     * 示例 3：
//     * <p>
//     * 输入：nums = [3,1,2,10,1]
//     * 输出：[3,4,6,16,17]
//     *
//     * @param nums
//     * @return
//     */
//    public int[] runningSum(int[] nums) {
//        for (int i = 1; i < nums.length; i++) {
//            int temp = nums[i];
//            nums[i] = nums[i - 1] + temp;
//        }
//        return nums;
//    }
//
//    /**
//     * https://leetcode.cn/problems/to-lower-case/
//     * 709. 转换成小写字母
//     * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
//     * <p>
//     * 示例 1：
//     * <p>
//     * 输入：s = "Hello"
//     * 输出："hello"
//     * 示例 2：
//     * <p>
//     * 输入：s = "here"
//     * 输出："here"
//     * 示例 3：
//     * <p>
//     * 输入：s = "LOVELY"
//     * 输出："lovely"
//     *
//     * @param s
//     * @return
//     */
//
//
//    public String toLowerCase(String s) {
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < s.length(); i++) {
//            int data = Integer.valueOf(s.charAt(i));
//            if (data >= 65 && data <= 90) {
//                sb.append((char) (data + 32));
//            } else {
//                sb.append((char) data);
//            }
//        }
//        return sb.toString();
//    }
//
//    /**
//     * https://leetcode.cn/problems/richest-customer-wealth/
//     * 1672. 最富有客户的资产总量
//     * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
//     * <p>
//     * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
//     * <p>
//     * 示例 1：
//     * <p>
//     * 输入：accounts = [[1,2,3],[3,2,1]]
//     * 输出：6
//     * 解释：
//     * 第 1 位客户的资产总量 = 1 + 2 + 3 = 6
//     * 第 2 位客户的资产总量 = 3 + 2 + 1 = 6
//     * 两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
//     * 示例 2：
//     * <p>
//     * 输入：accounts = [[1,5],[7,3],[3,5]]
//     * 输出：10
//     * 解释：
//     * 第 1 位客户的资产总量 = 6
//     * 第 2 位客户的资产总量 = 10
//     * 第 3 位客户的资产总量 = 8
//     * 第 2 位客户是最富有的，资产总量是 10
//     * 示例 3：
//     * <p>
//     * 输入：accounts = [[2,8,7],[7,1,3],[1,9,5]]
//     * 输出：17
//     *
//     * @param accounts
//     * @return
//     */
//    public int maximumWealth(int[][] accounts) {
//        int max = 0;
//        for (int i = 0; i < accounts.length; i++) {
//            int sum = 0;
//            for (int j = 0; j < accounts[i].length; j++) {
//                sum += accounts[i][j];
//            }
//            if (max < sum) {
//                max = sum;
//            }
//        }
//        return max;
//    }
//
//
//    /**
//     * https://leetcode.cn/problems/plus-one/
//     * 66. 加一
//     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//     * <p>
//     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//     * <p>
//     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
//     * <p>
//     * 示例 1：
//     * <p>
//     * 输入：digits = [1,2,3]
//     * 输出：[1,2,4]
//     * 解释：输入数组表示数字 123。
//     * 示例 2：
//     * <p>
//     * 输入：digits = [4,3,2,1]
//     * 输出：[4,3,2,2]
//     * 解释：输入数组表示数字 4321。
//     * 示例 3：
//     * <p>
//     * 输入：digits = [0]
//     * 输出：[1]
//     *
//     * @param digits
//     * @return
//     */
//    public int[] plusOne(int[] digits) {
//        //前一个不为9，停止进位
//        for (int i = digits.length - 1; i >= 0; i--) {
//            if (i > 1 && digits[i - 1] != 9) {
//                digits[i] = (digits[i] + 1) % 10;
//                break;
//            } else {
//                digits[i] = (digits[i] + 1) % 10;
//
//                if (i == 0 && digits[0] == 9) {
//                    int[] ans = new int[digits.length + 1];
//                    ans[0] = 1;
//                    for (int j = 1; j <= digits.length; j++) {
//                        ans[j] = digits[j - 1];
//                    }
//                    return ans;
//                }
//                digits[i - 1] = (digits[i - 1] + 1) % 10;
//            }
//        }
//        return digits;
//    }
//
//    /*
//    超过long长度会报错
//     */
//    public int[] plusOne2(int[] digits) {
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < digits.length; i++) {
//            sb.append(digits[i]);
//        }
//        long l = Long.parseLong(sb.toString());
//        long ll = l + 1;
//        String str = ll + "";
//        int[] result = new int[str.length()];
//        for (int i = 0; i < str.length(); i++) {
//            result[i] = Integer.valueOf(str.substring(i, i + 1));
//        }
//        return result;
//    }
//
//
//    public int[] plusOne3(int[] digits) {
//        //当前位数模10余数为0 或循环到首位数 时跳出循环
//        int mod = 0;
//        int i = digits.length - 1;
//        while (mod == 0) {
//            mod = (digits[i] + 1) % 10;
//            digits[i] = mod;
//            if (i == 0 && mod == 0) {
//                int[] ans = new int[digits.length + 1];
//                ans[0] = 1;
//                for (int j = 1; j <= digits.length; j++) {
//                    ans[j] = digits[j - 1];
//                }
//                return ans;
//            }
//            i--;
//            if (i == -1) {
//                break;
//            }
//        }
//        return digits;
//    }
//
//    /**
//     * 目前最简便的一版 如果循环到最后还是出现进位的情况，则要扩容数组
//     *
//     * @param digits
//     * @return
//     */
//    public int[] plusOne4(int[] digits) {
//        //当前位数模10余数为0 或循环到首位数 时跳出循环
//        int mod = 0;
//        int i = digits.length - 1;
//        while (mod == 0 && i != -1) {
//            mod = (digits[i] + 1) % 10;
//            digits[i] = mod;
//            if (i == 0 && mod == 0) {
//                digits = new int[digits.length + 1];
//                digits[0] = 1;
//            }
//            i--;
//        }
//        return digits;
//    }
//
//
//    /**
//     * https://leetcode.cn/problems/find-pivot-index/
//     * 724. 寻找数组的中心下标
//     *
//     * @param nums
//     * @return
//     */
//    public int pivotIndex(int[] nums) {//输入[-1,-1,-1,-1,-1,1]报错
//        int sum = 0;
//        //判断边缘为0的情况
//        for (int i = 0; i < nums.length; i++) {
//            sum = sum + nums[i];
//            if (sum == 0) {
//                return (i + nums.length - 1) / 2;
//            }
//        }
//        sum = 0;
//        for (int i = nums.length - 1; i > 0; i--) {
//            sum = sum + nums[i];
//            if (sum == 0) {
//                return i / 2;
//            }
//        }
//
//        //左右之差，如果左右index相交，返回-1
//        int index = -1;
//        int indexL = 0;
//        int indexR = nums.length - 1;
//        int sub = nums[indexL] - nums[indexR];
//        while (indexL < indexR && (indexL - indexR) < -1) {
//            if (sub > 0) {
//                indexR--;
//                sub = sub - nums[indexR];
//            } else if (sub < 0) {
//                indexL++;
//                sub = sub + nums[indexL];
//            } else {
//                if (indexR - indexL == 2) {
//                    return (indexL + indexR) / 2;
//                }
//                return index;
//            }
//        }
//        return index;
//    }
//
//    /*
//    从左向右遍历，找唯一的中心下标
//     */
//    public int pivotIndex2(int[] nums) {//ac，但时间很慢 200ms+
//        int index = 0;
//        while (index < nums.length) {
//            int sumL = 0;
//            int sumR = 0;
//            for (int i = 0; i < index; i++) {
//                sumL = sumL + nums[i];
//            }
//            for (int i = index + 1; i < nums.length; i++) {
//                sumR = sumR + nums[i];
//            }
//            if (sumL == sumR) {
//                return index;
//            }
//            index++;
//        }
//        return -1;
//    }
//
//    public int pivotIndex3(int[] nums) {//ac，3ms
//        int sumLeft = 0, sumRight = Arrays.stream(nums).sum();
//        for (int i = 0; i < nums.length; i++) {
//            sumRight -= nums[i];
//            // 若左侧元素和等于右侧元素和，返回中心下标 i
//            if (sumLeft == sumRight)
//                return i;
//            sumLeft += nums[i];
//        }
//        return -1;
//    }
//
//
//    /**
//     * https://leetcode.cn/problems/rotate-array/
//     * 189. 轮转数组
//     *
//     * @param nums
//     * @param k
//     */
//    public void rotate(int[] nums, int k) {
//        //先写一个最笨的方法,如果输入大数组直接超时
//        for (int i = 0; i < k; i++) {
//            int temp = nums[nums.length - 1];
//            for (int j = nums.length - 2; j > 0; j--) {
//                nums[j] = nums[j + 1];
//            }
//            nums[0] = temp;
//        }
//    }
//
//    public void rotate1(int[] nums, int k) {
//        //先将数组反转，在len位置进行分段，分别对两边的数据进行反转 ac
//        k = k % nums.length;
//        nums = reserve(nums, 0, nums.length - 1);
//        nums = reserve(nums, 0, k - 1);
//        nums = reserve(nums, k, nums.length - 1);
//    }
//
//    public int[] reserve(int[] nums, int startIndex, int endIndex) {
//
//        for (int i = 0; i < (endIndex - startIndex + 1) / 2; i++) {
//            int temp = nums[startIndex + i];
//            nums[startIndex + i] = nums[endIndex - i];
//            nums[endIndex - i] = temp;
//        }
//        return nums;
//
//    }
//
//
//    /**
//     * https://leetcode.cn/problems/rotate-image/description/
//     * 48. 旋转图像
//     *
//     * @param matrix
//     */
//    public void rotate(int[][] matrix) {
//        //空间复杂度为1，使用原地反转
//        //目前还不能主观正面推断出各个下标，需要记忆
//        int n = matrix.length;
//        for (int i = 0; i < n / 2; i++) {
//            for (int j = 0; j < (n + 1) / 2; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[n - 1 - j][i];
//                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
//                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
//                matrix[j][n - 1 - i] = temp;
//            }
//        }
//    }
//
//    /**
//     * https://leetcode.cn/problems/spiral-matrix/
//     * 54. 螺旋矩阵
//     *
//     * @param matrix
//     * @return
//     */
//    public List<Integer> spiralOrder(int[][] matrix) {
//        //难点是要分清楚边界，何时跳出循环
//        ArrayList<Integer> list = new ArrayList<>();
//        String flagStr = "right";
//        int raw = matrix.length;
//        int col = matrix[0].length;
//        int i = 0;
//        int j = 0;
//        int rightIndex = col - 1;
//        int downIndex = raw - 1;
//        int leftIndex = 0;
//        int upIndex = 1;
//        while (list.size() < raw * col) {
//            //改变i、j
//            switch (flagStr) {
//                case "right":
//                    //向右
//                    if (j == rightIndex) {//这里有坑，当matrix为1*n数组时会报错，所以要先判断是否到达边界再添加元素到list中。
//                        rightIndex--;
//                        flagStr = "down";
//                    } else {
//                        list.add(matrix[i][j]);
//                        j++;
//                    }
//                    break;
//                case "down":
//                    //向下
//                    list.add(matrix[i][j]);
//                    i++;
//                    if (i == downIndex) {
//                        downIndex--;
//                        flagStr = "left";
//                    }
//                    break;
//                case "left":
//                    //向左
//                    list.add(matrix[i][j]);
//                    j--;
//                    if (j == leftIndex) {
//                        leftIndex++;
//                        flagStr = "up";
//                    }
//                    break;
//                case "up":
//                    //向上
//                    list.add(matrix[i][j]);
//                    i--;
//                    if (i == upIndex) {
//                        upIndex++;
//                        flagStr = "right";
//                    }
//                    break;
//            }
//
//        }
//        return list;
//    }
//
//
//    /**
//     * https://leetcode.cn/problems/diagonal-traverse/
//     * 498. 对角线遍历
//     *
//     * @param mat
//     * @return
//     */
//    public int[] findDiagonalOrder(int[][] mat) {//有问题，输入一个3*3矩阵，当循环至mat[0,2]时，会沿着对角线i--,j--返回至mat[1,1]，而不是期望的mat[1,2]
//        //和54题类似，这道题更简单，只需要改变两个方向即可
//        int raw = mat.length, col = mat[0].length, len = raw * col;
//        int[] ret = new int[len];
//        String flagStr = "右上";
//        int i = 0, j = 0, index = 0, tempi = -1, tempj = -1;
//        int top = 0, bottom = raw - 1, left = 0, right = col - 1;
//        while (index < len) {
//            if (tempi != i || tempj != j) {
//                ret[index] = mat[i][j];
//                index++;
//            }
//            tempi = i;
//            tempj = j;
//
//            boolean flag1 = false;
//            boolean flag2 = false;
//            switch (flagStr) {
//                case "右上":
//                    if (i > top) {
//                        i--;
//                    } else {
//                        flag1 = true;
//                    }
//
//                    if (j < right) {
//                        j++;
//                    } else {
//                        flag2 = true;
//                    }
//
//                    if (flag1 || flag2) {
//                        flagStr = "左下";
//                    }
//
//                    break;
//                case "左下":
//                    if (i < bottom) {
//                        i++;
//                    } else {
//                        flag1 = true;
//                    }
//                    if (j > left) {
//                        j--;
//                    } else {
//                        flag2 = true;
//                    }
//                    if (flag1 || flag2) {
//                        flagStr = "右上";
//                    }
//                    break;
//            }
//
//        }
//        return ret;
//    }
//
//    public int[] findDiagonalOrder1(int[][] mat) {
//        int raw = mat.length, col = mat[0].length, len = raw * col;
//        int[] ret = new int[len];
//        String flagStr = "右上";
//        int i = 0, j = 0, index = 0, tempi = -1, tempj = -1;
//        int top = 0, bottom = raw - 1, left = 0, right = col - 1;
//        while (index < len) {
//            if (tempi != i || tempj != j) {
//                ret[index] = mat[i][j];
//                index++;
//            }
//            tempi = i;
//            tempj = j;
//            switch (flagStr){
//                case "右上":
//                    if(i==top & j<right){
//                        j++;
//                        flagStr = "左下";
//                    }else if(i==top & j==right){
//                        i++;
//                        j--;
//                        flagStr = "左下";
//                    }else {
//                        i--;
//                        j++;
//                    }
//                    break;
//                case "左下":
//                    if(i==bottom & j>left){
//                        j--;
//                        flagStr = "右上";
//                    }else if(i==bottom & j==left) {
//                        i--;
//                        j++;
//                        flagStr = "右上";
//                    }else {
//                        i++;
//                        j--;
//                    }
//                    break;
//            }
//        }
//        return ret;
//    }
//
//    public int[] findDiagonalOrder2(int[][] mat) {
//        int raw = mat.length, col = mat[0].length, len = raw * col;
//        int[] ret = new int[len];
//        String flagStr = "右上";
//        int i = 0, j = 0, index = 0, tempi = -1, tempj = -1;
//        int top = 0, bottom = raw - 1, left = 0, right = col - 1;
//        while (index < len) {
//            if (tempi != i || tempj != j) {
//                ret[index] = mat[i][j];
//                index++;
//            }
//            tempi = i;
//            tempj = j;
//            switch (flagStr){
//                case "右上":
//                    if(i==top & j<right){
//                        j++;
//                        ret[index] = mat[i][j];
//                        index++;
//                        flagStr = "左下";
//                    }else if(i==top & j==right){
//                        i++;
//                        j--;
//                        ret[index] = mat[i][j];
//                        index++;
//                        flagStr = "左下";
//                    }else {
//                        i--;
//                        j++;
//                        ret[index] = mat[i][j];
//                        index++;
//                    }
//                    break;
//                case "左下":
//                    if(i==bottom & j>left){
//                        j--;
//                        ret[index] = mat[i][j];
//                        index++;
//                        flagStr = "右上";
//                    }else if(i==bottom & j==left){
//                        i++;
//                        j--;
//                        ret[index] = mat[i][j];
//                        index++;
//                        flagStr = "右上";
//                    }
//            }
//
//
//        }
//        return ret;
//    }
//
//
//    @Test
//    public void testCase() {
//        System.out.println(findDiagonalOrder1(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}}));
//    }
//}
