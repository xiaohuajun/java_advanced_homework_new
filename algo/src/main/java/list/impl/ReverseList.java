package list.impl;

import list.base.ListNode;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/7/14 下午5:47
 * @description ReverseList 反转链表
 */
public class ReverseList {


    /**
     * 实现一个单链表的反转：1->2->3->null  => 3->2->1->null
     *
     * @param head 头节点
     */
    public ListNode reversList(ListNode head) {
        //定义一个虚拟节点
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //存储下一个节点，为了继续下一个遍历
            ListNode nextNode = curr.next;
            //curr node的指针指向prev
            curr.next = prev;
            //prev指向当前节点
            prev = curr;
            //下一个节点作为当前节点继续遍历
            curr = nextNode;
        }
        return prev;
    }


}
