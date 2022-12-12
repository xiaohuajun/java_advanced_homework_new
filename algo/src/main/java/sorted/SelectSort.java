package sorted;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/11 下午10:22
 * @description SelectSort 选择排序
 */
public class SelectSort {


    /**
     * 选择排序：分为已排序区，未排区，每次从未排区，选择最小的元素放到已排区的末尾
     *
     * @param a
     * @param n
     */
    public static void selectSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            //未排序区找到最小值的位置
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            //放到已排区
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1};
        int n = 6;
        selectSort(a, n);
        for (int i : a) {
            System.out.println("---->" + i);
        }
    }


}
