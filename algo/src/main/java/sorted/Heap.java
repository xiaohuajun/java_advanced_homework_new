package sorted;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/19 下午10:20
 * @description Heap 堆:完全二叉树，任意一个节点的值，大于等于（小于等于）子节点的值
 */
public class Heap {

    /**
     * 使用数组来存储，从1 开始存储
     */
    private int[] a;

    /**
     * 堆的存储容量大小
     */
    private int n;

    /**
     * 堆已经存储的数据个数
     */
    private int count;


    public Heap(int cap) {
        this.n = cap;
        a = new int[cap + 1];
    }

    /**
     * 大顶堆：堆的下面插入，需要从下往上堆化，与父节点比较大小，大的就需要堆化
     *
     * @param val
     */
    public void insert(int val) {
        if (count == n) {
            return;
        }
        count++;
        a[count] = val;
        int i = count;
        //i / 2 表示父节点，自下而上堆化 大顶堆 :a[i/2] > a[i]
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            //父节点 和 当前节点交换位置
            swap(a, i, i / 2);
            //当前节点变为父节点
            i = i / 2;
        }
    }

    /**
     * 删除堆顶元素：把末尾的元素放到堆顶，再进行自上而下的堆化
     * 而不是直接删除堆顶元素，这样可能会出现数据隔断的情况
     */
    public void deleteMax() {
        if (count == 0) {
            return;
        }
        //堆顶删除，尾部交换
        a[0] = a[count];
        count--;
        //从堆顶开始堆化
        heaping(a, count, 0);
    }


    /**
     * 自上而下的堆化
     *
     * @param a     堆
     * @param count 堆的数据个数
     * @param i     堆顶下标
     */
    private static void heaping(int[] a, int count, int i) {
        while (true) {
            // 堆顶下标
            int maxPos = i;
            //左子节点和堆顶比较
            if (2 * i + 1 <= count && a[i] < a[2 * i + 1]) {
                maxPos = 2 * i + 1;
            }
            //右子节点和堆顶比较
            if (2 * i + 2 <= count && a[maxPos] < a[2 * i + 2]) {
                maxPos = 2 * i + 2;
            }
            // 没有发生堆化结束
            if (maxPos == i) {
                break;
            }
            //maxPos交换i交换
            swap(a, i, maxPos);
            //继续堆化，i已经发生改变
            i = maxPos;
        }


    }

    /**
     * 父节点 和 当前节点交换
     *
     * @param a 堆
     * @param i 当前节点下标
     * @param p 父节点下标
     */
    private static void swap(int[] a, int i, int p) {
        int tmp = a[p];
        a[p] = a[i];
        a[i] = tmp;
    }


    /**
     * 构建堆
     * 对于一个堆来说，n / 2 + 1 ~ n 都是叶子节点，不要堆化，只堆 1 ～ n / 2进行堆化
     *
     * @param a 数组
     * @param n 数组大小
     */
    public static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 0; i--) {
            heaping(a, n, i);
        }
    }

    public static void heapSort(int[] a) {
        int n = a.length - 1;
        if (n <= 1) {
            return;
        }
        buildHeap(a, n);
        int k = n;
        while (k > 0) {
            //交换堆顶和堆尾的元素
            swap(a, k, 0);
            k--;
            //堆化剩下的元素 k
            heaping(a, k, 0);
        }
    }


    public static void main(String[] args) {
        int[] a = {7, 5, 19, 8, 4, 1, 20, 13, 16};
        heapSort(a);
        for (int i : a) {
            System.out.println("---" + i);
        }
    }

}
