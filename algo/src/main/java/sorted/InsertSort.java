package sorted;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/11 下午9:21
 * @description InsertSort 插入排序：把排序的数据分为已排序区和未排序区，每次都从未排序区取元素到已排序区找到合适的位置并插入
 * 初始化已排序区是第一个元素
 */
public class InsertSort {


    public static void insertSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        //初始化 从1开始，因为第一个元素默认成为已排序区
        for (int i = 1; i < n; i++) {
            //获取未排序区的元素
            int notSortVal = a[i];
            //已经排序区的上边界:未排序区左边界 - 1
            int j = i - 1;
            //已排序区往后往前寻找未notSort元素的插入位置
            for (; j >= 0; j--) {
                if (a[j] > notSortVal) {
                    //已排序区的元素往后移动:腾出插入的位置
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            //找到插入位置的最后一步，一定是与插入点位置前一个元素比较的，所以是在插入点位置下标的后面： 所以+1
            a[j + 1] = notSortVal;
        }
    }


    public static void shellSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        int stepDis = 2;
        //按照步长分组
        for (int step = n / stepDis; step >= 1; step /= stepDis) {
            for (int i = step; i < n; i++) {
                int tmp = a[i];
                int j = i - step;
                while(j >= 0 && a[j] > tmp){
                    a[j + step] = a[j];
                    j -= step;
                }
                a[j + step] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {4, 5, 6, 1, 3, 2};
        int n = 6;
        shellSort(a, n);
        for (int i : a) {
            System.out.println("---->" + i);
        }


    }

}
