package sorted;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/16 下午10:36
 * @description QuickSort 快速排序:设置一个分区函数，主要是分治处理排序
 */
public class QuickSort {


    public static void quickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = partition(a, l, r);
        quickSort(a, l, pivot - 1);
        quickSort(a, pivot + 1, r);
    }

    /**
     * 分区点函数
     *
     * @param a
     * @param l
     * @param r
     * @return 分区点:把数组已经分为两个部分的数组小表
     */
    public static int partition(int[] a, int l, int r) {
        //设置分区点：出现退化n平方
        pivotSet(a, l, r);
        //选取最后一个作为比较的基点
        int pivot = a[r];
        int i = l;
        //遍历元素与pivot比较大小：小于，则a[i] 和 a[j]交换，i++,大于：不交换，j++
        //初始化：i 、j从第一个元素开始
        for (int j = l; j < r; j++) {
            if (a[j] <= pivot) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }
        //遍历到最后一个元素，和当前i所处的位置交换
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        System.out.println("----分区点" + a[i]);
        return i;
    }

    private static void pivotSet(int[] a, int l, int r) {
        //三数取中
        int mid = (l + r) / 2;
        if (a[l] > a[mid]) {
            swap(a, l, mid);
        }
        if (a[l] > a[r]) {
            swap(a, l, r);
        }
        if (a[mid] > a[r]) {
            swap(a, mid, r);
        }
        swap(a, r - 1, mid);

    }

    private static void swap(int[] a, int s, int t) {
        int tmp = a[s];
        a[s] = a[t];
        a[t] = tmp;
    }

    /**
     * 在O(n)的时间复杂度 寻找数据中第k大的数据
     * n/2 + n/4 + .... 1 = 2n + 1
     *
     * @param a
     * @param k
     * @return
     */
    public static int findKthNum(int[] a, int k) {
        int length = a.length;
        if (length < k) {
            return -1;
        }
        int partition = partition(a, 0, length - 1);
        while (partition + 1 != k) {
            if (partition + 1 < k) {
                partition = partition(a, partition + 1, length - 1);
            } else {
                partition = partition(a, 0, partition - 1);
            }
        }
        return a[length - 1 - partition];
    }


    public static void main(String[] args) {
        int[] a = {11, 5, 14, 9, 7, 3, 4, 15};
        int k = 4;
        quickSort(a, 0,7);
        //int kthNum = findKthNum(a, k);
        //System.out.println("第" + k + "大的数：" + kthNum);
        for (int i : a) {
            System.out.println("---" + i);
        }
    }


}
