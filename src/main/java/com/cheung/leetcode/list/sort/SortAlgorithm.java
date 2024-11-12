package com.cheung.leetcode.list.sort;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Kyle
 * @date 2023/9/21 11:51
 */
public class SortAlgorithm {

    private static List dataList = new ArrayList();

    private static int[] num ;

    static{
        dataList.addAll(Arrays.asList());
//        num = new int[]{2,3,5,1,4,6};
        num = new int[]{2,1,3,4,5,6};
    }

    /*
    冒泡排序：思想是从左到右，相邻元素两两进行大小对比，大的数往后移位。
    如果一趟比较下来没有数据进行互换，说明

    算法复杂度：

     */
    public static int[] bubbleSort(int []num){

        int len = num.length;
        for (int i = 0; i < len-1; i++) {
            boolean flag = false;
            for (int j = 0; j < len - 1 - i; j++) {
                int tem;
//                System.out.println(num[j] + " " + num[j+1]);
                if(num[j] > num[j+1]){
                    tem = num[j];
                    num[j] = num[j+1];
                    num[j+1]= tem;
                    flag = true;
                }
            }
            if (!flag){
                System.out.println("第"+(i+1)+"遍已经完全有序");
                break;
            }
        }

        System.out.println(JSON.toJSON(num));
        return num;

    }

    public static void main(String[] args) {
        bubbleSort(num);
    }

}
