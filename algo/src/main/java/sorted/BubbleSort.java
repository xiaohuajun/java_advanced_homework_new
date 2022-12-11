package sorted;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/12/11 下午4:32
 * @description BubbleSort 冒泡排序，比较、交换
 */
public class BubbleSort {


    /**
     * 冒泡排序：从小到大
     *
     * @param a 数组
     * @param n 数组长度
     */
    public static void bubbleSort(int[] a, int n) {
        //临界条件
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            //判断是否还有需要排序的数据，没有可提前退出
            boolean flag = false;
            //-i：每一轮下来已经排好序的数据
            //-1：没有排序部分最后一个数据不需要遍历
            for (int j = 0; j < n - i - 1; j++) {
                //比较大小
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {3, 5, 9, 3, 2, 1};
        int len = 6;
        bubbleSort(a, len);
        for (int i : a) {
            System.out.println("-----" + i);
        }
    }


}
