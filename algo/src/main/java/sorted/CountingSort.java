package sorted;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/19 上午9:27
 * @description CountingSort 计数排序 时间O(n)，空间O(N)
 */
public class CountingSort {


    /**
     * 计数排序
     * 1、分桶，每个桶记录相同元素个数并累加-计数桶
     * 2、依次对计数桶的元素累加
     * 3、排序桶：排序数据
     * 4、遍历元素，通过元素作为下标 从计数桶中获取数据 - 1（对应排序桶中的下标），放入元素
     * 5、把排序桶的元素拷贝到原数组
     *
     * @param a
     */
    public static void countingSort(int[] a) {
        int len = a.length;
        if (len <= 1) {
            return;
        }

        int max = a[0];

        for (int i : a) {
            if (i > max) {
                max = i;
            }
        }

        //计数桶
        int[] countBucket = new int[max + 1];
        for (int i = 0; i < max; i++) {
            countBucket[i] = 0;
        }

        for (int h : a) {
            countBucket[h]++;
        }

        //计数桶依次累加
        for (int i = 1; i <= countBucket.length - 1; i++) {
            countBucket[i] = countBucket[i - 1] + countBucket[i];
        }

        //申请排序桶
        int[] sortBucket = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            //到排序桶里获取数据的下标
            int sortIndex = countBucket[a[i]] - 1;
            sortBucket[sortIndex] = a[i];
            //计数桶该下标计数-1
            countBucket[a[i]]--;
        }
        //排序桶的数据放回原数组
        for (int i = 0; i < len; i++) {
            a[i] = sortBucket[i];
        }

    }


    public static void main(String[] args) {
        int[] a = {31, 35, 14, 99, 7, 1, 28, 15, 11, 10, 36};
        int s = 4;
        countingSort(a);
        for (int i : a) {
            System.out.println("---" + i);
        }
    }
}
