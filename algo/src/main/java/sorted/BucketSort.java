package sorted;

import java.util.Arrays;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/18 下午9:43
 * @description BucketSort 桶排序
 */
public class BucketSort {


    /**
     * 桶排序
     *
     * @param a          排序数组
     * @param bucketSize 桶的大小
     */
    public static void bucketSort(int[] a, int bucketSize) {
        int len = a.length;
        if (len <= 1) {
            return;
        }
        //获取数组中的数据范围,用来分桶
        int min = a[0];
        int max = a[0];
        for (int value : a) {
            if (value < min) {
                min = value;
            } else if (value > max) {
                max = value;
            }
        }
        //桶的数量
        int bucketCount = (max - min) / bucketSize + 1;
        //申请二维数组，[桶的个数][每个桶的大小]
        //暂时先不给每个桶分配空间，添加数据的时候再次申请
        int[][] buckets = new int[bucketCount][0];
        //把数据分配到每个桶中
        for (int i : a) {
            //计算数据在哪个桶
            int bucketIndex = (i - min) / bucketSize;
            //给桶里添加数据
            buckets[bucketIndex] = allotDataToBucket(buckets[bucketIndex], i);
        }
        //针对每个桶使用快速排序
        int aIndex = 0;
        for (int[] bucket : buckets) {
            //是空桶不处理
            if (bucket.length == 0) {
                continue;
            }
            QuickSort.quickSort(bucket, 0, bucket.length - 1);
            for (int i : bucket) {
                a[aIndex++] = i;
            }
        }

    }

    private static int[] allotDataToBucket(int[] a, int i) {
        a = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = i;
        return a;
    }


    public static void main(String[] args) {
        int[] a = {11, 35, 14, 99, 7, 1, 28, 15, 11, 10, 36};
        int s = 4;
        bucketSort(a, s);
        for (int i : a) {
            System.out.println("---" + i);
        }
    }

}
