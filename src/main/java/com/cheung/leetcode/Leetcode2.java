package com.cheung.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @Author: Kyle
 * @date 2023/5/12 23:48
 */
public class Leetcode2 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }


        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }


    @Test
    public void main() {


//        int[] l1 = new int[]{2, 4, 3};
//        int[] l2 = new int[]{5, 6, 4};


        int[] l1 = new int[]{9,9,9,9,9,9,9};
        int[] l2 = new int[]{9,9,9,9};

        ListNode nextNode1 = null;
        ListNode node1 = null;
        for (int i = l1.length - 1; i >= 0; i--) {
            if (i == l1.length - 1) {
                nextNode1 = new ListNode(l1[l1.length - 1]);
            } else {
                nextNode1 = new ListNode(l1[i], nextNode1);//生成新的节
            }
        }
        node1 = nextNode1;
        System.out.println(JSON.toJSONString(node1));

        ListNode nextNode2 = null;
        ListNode node2 = null;
        for (int i = l2.length - 1; i >= 0; i--) {
            if (i == l2.length - 1) {
                nextNode2 = new ListNode(l2[l2.length - 1]);
            } else {
                nextNode2 = new ListNode(l2[i], nextNode2);//生成新的节
            }
        }
        node2 = nextNode2;
        System.out.println(JSON.toJSONString(node2));


        ListNode result = addTwoNumbers(node1, node2);
        System.out.println(JSON.toJSONString(result));


    }

//
//    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//        //定义一个进位数carry，carry为几就说明要进位多少
//        int carry = 0;
//        //result是结果链表
//        ListNode result = new ListNode();
//        //head为结果链表的头节点，返回的结果就是头节点
//        ListNode head = result;
//        //prev是该节点的上一个节点
//        ListNode prev = null;
//        while (l1 != null || l2 != null) {
//            //获取两个链表同一位的value值，若其中一个为空就取0
//            int a = l1 != null ? l1.val : 0;
//            int b = l2 != null ? l2.val : 0;
//            //存入的结果为a+b+进位数，再对10取余
//            result.val = (a + b + carry) % 10;
//            //计算进位值carry
//            carry = (a + b + carry) / 10;
//            //若两个节点不为null，就取该节点的下一个节点，否则就取null
//            l1 = l1 != null ? l1.next : null;
//            l2 = l2 != null ? l2.next : null;
//            //新添一个节点到结果链表，并将其赋值给result
//            ListNode temp = new ListNode();
//            result.next = temp;
//            prev = result;
//            result = result.next;
//        }
//
//        //判断是否进位，若要进位就把carry存入result节点，若不需要就把最后一个空节点移除
//        if (carry != 0) {
//            result.val = carry;
//        }else {
//            prev.next = null;
//        }
//        return head;
//    }


    /**
     * 自己做的第一版，直接单纯求解
     * @param l1
     * @param l2
     * @return
     */
    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode next1 = l1;
        ListNode next2 = l2;
        int jinwei = 0;
        while (next1 != null || next2 != null){
            int yuanwei = 0;
            if (next1 != null && next2 != null) {
                yuanwei = (jinwei + next1.val + next2.val) % 10;
                jinwei = (jinwei + next1.val + next2.val) / 10;
                next1 = next1.next;
                next2 = next2.next;
                if(result==null){
                    result = new ListNode(yuanwei);
                }else {
                    result = new ListNode(yuanwei,result);
                }
            } else if (next1 != null && next2 == null) {
                yuanwei = (next1.val + jinwei) % 10;
                jinwei = (next1.val + jinwei) / 10;
                result = new ListNode(yuanwei,result);
                next1 = next1.next;
            } else if (next1 == null && next2 != null) {
                yuanwei = (next2.val + jinwei) % 10;
                jinwei = (next2.val + jinwei) / 10;
                result = new ListNode(yuanwei,result);
                next2 = next2.next;
            }else {

            }
            if(next1==null && next2==null){
                if(jinwei!=0){
                    result = new ListNode(jinwei,result);
                }
            }
        }

        //对result进行取反
        ListNode head = new ListNode();
        while (result!=null){
            ListNode listNode = new ListNode(result.val);
            listNode.next = head.next;
            head.next = listNode;
            result = result.next;
        }
        return head.next;
    }


}
