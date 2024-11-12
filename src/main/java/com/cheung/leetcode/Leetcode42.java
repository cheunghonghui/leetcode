package com.cheung.leetcode;

import jdk.nashorn.internal.parser.Lexer;
import org.junit.Test;
/*
 * @Author: Kyle
 * @date 2024/5/21 23:21
 */
public class Leetcode42 {




    @Test
    public void test(){

//        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int [] height = {4,2,0,3,2,5};
//        int [] height = {4,2,3};
        int [] height = {1,7,5};
        int trap = trap1(height);
        System.out.println(trap);
    }

    public int trap(int[] height) {
        int len = height.length;
        int sum = 0;
        //存储左侧和右侧符合条件的数据
        int []temp = new int[len];
        int begin = height[0]==0?1:0;
        int low = height[0];
        for (int i = begin; i < len; i++) {
            temp[i] = height[i];
            low = low<height[i]?low:height[i];
            //和后面的数据比较高度
            for (int j = i+1; j < len; j++) {
                if(temp[i]>height[j] || temp[i]<=low){
                    continue;
                }else {
                    int count = 0;
                    for (int k = i; k < j; k++) {
                        count = count + height[k];
                    }
                    //计算雨水
                    if(j-i==1){
                        sum = sum + height[j]*(j-i)-count;
                    }else {
                        sum = sum + height[i]*(j-i)-count;
                    }
                    //最低边缘高度*长度-之间的木块数量
                    //计算完后跳转i至当前右木块位置
                    i = j-1;
                    break;
                }
            }
            //左高右低 选右边
            //左低右高 选左边
        }
        return sum;
    }


    /**
     * 粗暴解决
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int sum = 0;
        //遍历height，计算左边和右边最低的边缘为高，累加
        int len = height.length;
        for (int i = 1; i < len; i++) {
            int lTop = 0;
            int rTop = 0;
            //寻找左边的边缘
            for (int j = i-1; j >= 0 ; j--) {
                lTop = lTop>height[j]?lTop:height[j];
            }
            for (int j = i+1; j < len; j++) {
                rTop = rTop<height[j]?height[j]:rTop;
            }
            int h = lTop>rTop?rTop:lTop;
            if(h>0 && h>height[i]){
                sum = sum + h-height[i];
            }
        }
        return sum;
    }

}
