package list.impl;

import list.base.ListNode;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/7/21 下午10:54
 * @description MergeTwoSortedList 合并两个有序链表
 */
public class MergeTwoSortedList {


    /**
     * 分析：每次操作：比较l1 l2的大小，把小的添加到结果中，对应的链表指针向后移动一位
     * 这是一个重复性问题，可以用递归
     * 1、终止条件，链表遍历到末尾
     * 时间复杂度：O(l1 + l2)
     * 空间复杂度：O(l1 + l2):递归的栈深度
     * @param l1 链表1的头节点
     * @param l2 链表2的头节点
     * @return 较小节点
     */
    public ListNode mergeTwoSortedListForRecur(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            //l1 下一个节点
            l1.next = mergeTwoSortedListForRecur(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoSortedListForRecur(l1,l2.next);
            return l2;
        }
    }


    /**
     * 迭代法：
     * 1、添加一个哨兵节点-soldier，方便遍历，最后返回哨兵节点的下一个节点
     * 2、维护一个prev指针，初始化指向soldier
     * 3、每次比较l1，l2当前节点的大小，小的链接在prev指针后面，对应的链表指针向后移动一位
     * 4、最后肯定会有一个链表先到尾部，单独处理
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return
     */
    public ListNode mergeTwoSortedListForIte(ListNode l1,ListNode l2){
        ListNode soldier = new ListNode(-1);
        ListNode prev = soldier;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        //最后处理
        prev.next = l1 == null ? l2 : l1;
        return soldier.next;
    }









}
