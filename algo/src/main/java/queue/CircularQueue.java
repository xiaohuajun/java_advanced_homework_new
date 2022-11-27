package queue;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/11/27 下午8:27
 * @description CircularQueue 循环队列实现，循环队列：首位相接的队列，可以避免数据搬移
 * 需要注意：普通队列的队列满的条件是：tail == n，空队列：head == tail
 * 循环队列的队列满的条件：（tail + 1）% n = tail + 1
 * head 的移动：head = （head + 1）% n
 * tail 的移动：tail = （tail + 1）% n
 * 缺点：浪费一个数组元素的存储空间，因为 tail + 1了
 */
public class CircularQueue {

    private String[] items;

    private int capacity = 0;

    private int head = 0;

    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        this.capacity = capacity;
    }


    public boolean enqueue(String item) {
        //判断队列是否满
        if ((tail + 1) % capacity == head) {
            return false;
        }
        items[tail] = item;
        //tail 的移动
        tail = (tail + 1) % capacity;
        return true;
    }


    public String dequeue() {
        //判断队列是否为空
        if (head == tail) {
            return null;
        }
        String item = items[head];
        //head 移动
        head = (head + 1) % capacity;
        return item;
    }

}
