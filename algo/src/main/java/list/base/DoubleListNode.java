package list.base;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2023/1/18 下午2:19
 * @description DoubleListNode 双向链表节点
 */
public class DoubleListNode {

    int key;
    int value;
    DoubleListNode next;
    DoubleListNode prev;

    public DoubleListNode(){}

    public DoubleListNode(int key ,int value){
        this.value = value;
        this.key = key;
    }
}
