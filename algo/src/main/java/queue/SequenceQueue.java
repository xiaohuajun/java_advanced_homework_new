package queue;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/11/24 下午7:06
 * @description SequenceQueue 使用数组实现顺序队列，申请队列大小，入队，出队操作
 * 数组实现的叫做顺序队列，也是有界队列，事先申请好大小
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
     * 因为出队操作head指针往后移动，当入队操作tail指针到最后，队头就产生了空间，导致空间浪费，实际上队列还有空间
     * 因此，对入队操作时候，进行数据搬移，又不能频繁的进行数据搬移，因为这样就会导致入队操作的时间复杂度从O(1) 退化成O(n)
     * 入队操作进行优化，当队列满了 才进行数据搬移
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
     * 所以优化点：只有队列满了 数据才进行数据移动（减少数据搬移操作），入队操作进行优化
     *
     * @return 出队元素
     */
    public boolean enqueueForOptimize(String item) {
        if (head == capacity) {
            //是否搬移数据还需要判断。head 是否=0：=0表示队头没有空间，不需要搬移
            if (head == 0) {
                return false;
            }
            //数据搬移
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            //更新tail、head
            tail -= head;
            head = 0;
        }
        //入队操作
        items[tail] = item;
        //后移tail
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
