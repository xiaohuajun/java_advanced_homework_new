package list.impl;

import list.base.ListNode;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/7/14 下午8:29
 * @description HasCycle 检测链表是否有环
 */
public class HasCycle {


    /**
     * 使用快慢指针，检测链表是否有环
     * 如果快指针和慢指针相遇的话，那就存在环
     *
     * @param head 头节点
     * @return 检测的结果
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


}
