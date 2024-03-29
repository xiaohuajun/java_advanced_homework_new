package sorted;

import java.util.Arrays;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/4/13 下午8:01
 * @description MergeSort 归并排序:时间复杂度 O(logn) 空间复杂度 O(n)：这也是和快排比劣势;
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] a = {9, 8, 3, 6, 2, 7};
        mergeSort(a, a.length);
        System.out.println("排序后的数组：" + Arrays.toString(a));
    }


    public static void mergeSort(int[] a, int n) {
        mergeSortSplit(a, 0, n - 1);
    }


    /**
     * 1、先把数组一分为二，直到分每个数组都只有一个元素
     * 2、合并排序,时间复杂度：O(nlogn) : 拆分+合并遍历整个排序数据，每次拆分logn
     * 空间复杂度：O(n)：主要是合并新建一个数组来存储临时数据
     *
     * @param a
     * @param p
     * @param r
     */
    public static void mergeSortSplit(int[] a, int p, int r) {
        //分解完成，最后只有一个元素(p = r)，不再需要分解
        if (p >= r) {
            return;
        }
        //每次都取中间值，拆分数组（防止p+r大于整型的最大值）
        int q = p + (r - p) / 2;
        //分治递归
        mergeSortSplit(a, p, q);
        mergeSortSplit(a, q + 1, r);
        //最后合并全部数据
        merge(a, p, q, r);
    }


    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1];
        //如果比较到 q + 1 ~ r 的最后一轮：j > r
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        //判断哪个子数组还有剩余元素
        int start = i;
        int end = q;
        //最后一轮j > r
        if (j <= r) {
            start = j;
            end = r;
        }
        //剩余元素的放入数组
        while (start <= end) {
            tmp[k++] = a[start++];
        }
        //将tmp拷贝到原数组：a[p , r]
        for (int h = 0; h <= r - p; h++) {
            a[p + h] = tmp[h];
        }
    }


}
