package list.impl;

import list.base.ListNode;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/7/14 下午8:40
 * @description RemoveNthNodeFromEnd 移除链表倒数第n个节点
 * 删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthNodeFromEnd {


    /**
     * 思考：
     * 由于删除一个节点，必须知道节点的前驱节点，头节点没有前驱节点，需要判断
     * 常用解法，增加一个哨兵节点，可以让操作节点可以正常遍历就可以了
     * 解法：
     * 1、从头节点遍历链表获取链表长度：len
     * 2、增加一个哨兵节点指向头节点
     * 3、从哨兵节点开始遍历(len - n)次，就是需要移除节点的前驱节点
     * <p>
     * 另外还可以用栈的特点，后进先出，全部进栈后弹出n个节点后的栈顶节点就是前驱节点
     *
     * @param head 头节点
     * @param n    倒数第n个节点
     * @return 头节点
     */
    public ListNode removeNthNodeFromEndForLen(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        int len = getLength(head);
        for (int i = 0; i < len - n; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next;

    }

    /**
     * 解法：
     * 1、从哨兵节点开始遍历，使用双指针，两个指针相隔n,当在前面的指针到尾部
     * 2、那后面一个指针的节点就是前驱节点
     *
     * @param head 头节点
     * @param n    倒数第n个节点
     * @return 头节点
     */
    public ListNode removeNthNodeFromEndForTwoPoint(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
        ListNode second = dummy;
        //计算步长
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }


}
