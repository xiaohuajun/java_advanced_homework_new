package queue;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/11/24 下午7:06
 * @description SequenceQueue 使用数组实现顺序队列，申请队列大小，入队，出队操作
 */
public class SequenceQueue {

    /**
     * 用数组存储、队列元素
     */
    private String[] items;

    /**
     * 头部下标
     */
    private int head = 0;

    /**
     * 尾部下标
     */
    private int tail = 0;

    /**
     * 容量。数组必须先知道大小
     */
    private int capacity;


    public SequenceQueue(int capacity) {
        items = new String[capacity];
        this.capacity = capacity;
    }

    /**
     * 入队操作
     *
     * @return 入队操作是否成功
     */
    public boolean enqueue(String item) {
        //如果队列已经满，返回false
        if (tail == capacity) {
            return false;
        }
        items[tail] = item;
        //尾指针后移
        ++tail;
        return true;
    }

    /**
     * 出队操作
     *
     * @return 队列取出的元素
     */
    public String dequeue() {
        //如果队列为空，返回null
        if (head == tail) {
            return null;
        }
        //从对头取出队列元素
        String item = items[head];
        //头指针往后移动
        ++head;
        return item;
    }


}
