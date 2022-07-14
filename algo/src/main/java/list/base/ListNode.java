package list.base;


/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/7/14 下午5:45
 * @description ListNode 链表的节点
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val,ListNode head){
        this.val = val;
        this.next = head;
    }

}
