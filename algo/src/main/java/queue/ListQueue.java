package queue;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/11/26 下午11:08
 * @description ListQueue 链表实现队列，链表实现一般是无界队列（注意内存使用），不需要考虑数据搬移情况
 */
public class ListQueue {

    /**
     * 链表节点
     */
    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }

    private Node head = null;

    private Node tail = null;

    public void enqueue(String item) {
        //队列中还没有元素
        if (tail == null) {
            Node node = new Node(item, null);
            //队列中只有一个元素就是入队元素
            tail = node;
            head = node;
        } else {
            //队列中已经又元素存在
            tail.next = new Node(item, null);
            //tail后移
            tail = tail.next;
        }
    }


    public String dequeue() {
        //队列是否为空
        if (head == null) {
            return null;
        }
        String res = head.getData();
        //后移
        head = head.next;
        //如果出队了，队列为空了，tail = null
        if (head == null) {
            tail = null;
        }
        return res;
    }


}
