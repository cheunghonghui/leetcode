package com.cheung.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: Kyle
 * @date 2023/5/15 01:28
 */
public class Leetcode3 {

    @Test
    public void test(){
        String s = "abba";
        //滑动窗口思想
        System.out.println(lengthOfLongestSubstringV4(s));
    }


    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        ArrayList strList = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!strList.contains(c)){
                strList.add(c);
                maxLength = strList.size()>maxLength?strList.size():maxLength;
            }else {
                int i1 = strList.indexOf(c);
                for (int j = i1; j>=0; j--) {
                    strList.remove(j);
                }
                strList.add(c);
            }
        }
        return maxLength;
    }

    /**
     * 利用map记录最近出现字符在字符串的位置，方便更新窗口的start位置
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    /**
     * 速度更快，可能和测试用例有关
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV3(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();
        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }

    /**
     * time 5ms
     * memory 43.58MB
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV4(String s) {
        //用map存储字符的位置，如果滑窗end出现重复的字符，则修改滑窗start的位置，同时更新字符的位置，更新最大窗口长度
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int start = 0;
        int end;
        int len = s.length();
        int mSize = 0;
        for(end=0;end<len;end++){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                int index = map.get(c);
                start = start>index+1?start:index+1;
            }
            mSize = mSize>end-start+1?mSize:end-start+1;
            map.put(c,end);
        }
        return mSize;
    }
}
