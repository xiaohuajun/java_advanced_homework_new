package binasearch;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/5/4 下午2:40
 * @description BinarySearch 二分查找-查找近似值：例如ip地址的归属地
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 8, 12, 13, 20, 23, 28, 32, 37, 48, 59, 63, 79};
        int[] b = {1, 3, 4, 5, 8, 12, 13, 20, 23, 29, 32, 37, 48, 48, 48, 79};
        int[] c = {1, 3, 4, 5, 13, 15, 20, 20, 25, 29, 32, 37, 48, 48, 48, 79};
        int[] d = {1, 3, 4, 5, 13, 15, 20, 20, 25, 29, 32, 37, 48, 48, 48, 79};
        int[] e = {8, 9, 24, 48, 58, 79, 82,1, 3, 4, 5, 7};

        int val = 4;
        System.out.println("等值查找--->" + bSearch(a, val));
        System.out.println("查找第一个等于的--->" + findFirstIndexOther(b, val));
        System.out.println("查找最后一个等于的--->" + findLastIndex(c, val));
        System.out.println("查找第一个大于等于的--->" + findFirstGtVal(c, val));
        System.out.println("查找最后一个小于等于的--->" + findLastLtVal(d, val));
        System.out.println("循环数组查找--->" + searchValLoopArray(e, val));


    }

    /**
     * 二分查找：等查找-数组中没有重复的元素
     *
     * @param a     有序数组
     * @param value 查找值
     * @return 数组中的下标
     */
    public static int bSearch(int[] a, int value) {
        int l = 0;
        //错误
        int h = a.length - 1;
        // 必须是等于：防止最后漏掉l == h 的元素
        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] > value) {
                //错误
                h = mid - 1;
            } else {
                //错误
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个等于给定值的下标-数组中有重复数据
     * <p>
     * 近似查找-二分法的变体
     *
     * @param a
     * @param val
     * @return
     */
    public static int findFirstIndex(int[] a, int val) {
        int l = 0;
        int h = a.length - 1;
        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            if (a[mid] > val) {
                h = mid - 1;
            } else if (a[mid] < val) {
                l = mid + 1;
            } else {
                //数组的第一个或者当前找到的等值下标的前一个不等于val：当前就是第一个等于值的下标
                if (mid == 0 || a[mid - 1] != val) {
                    return mid;
                } else {
                    //往左边继续寻找
                    h = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个等于给定值的下标-数组中有重复数据-另外一钟写法
     *
     * @param a
     * @param val
     * @return
     */
    public static int findFirstIndexOther(int[] a, int val) {
        int n = a.length;
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            if (a[mid] >= val) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        //如果val都比数组的元素大，最后一轮结束之后：low = n，会溢出
        //a[mid] >= val 这个条件所有查找一直往左边靠，l 是第一个等于val的
        if (l < n && a[l] == val) {
            return l;
        }
        return -1;
    }


    /**
     * 查找最后一个等于值的元素下标
     *
     * @param a
     * @param val
     * @return
     */
    public static int findLastIndex(int[] a, int val) {
        int n = a.length;
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            if (a[mid] > val) {
                h = mid - 1;
            } else if (a[mid] < val) {
                l = mid + 1;
            } else {
                //数组最后一个或者当前元素的后面的元素不等于：就是最后一个值
                if (mid == n - 1 || a[mid + 1] != val) {
                    return mid;
                } else {
                    //往后找
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于的元素下标
     *
     * @param a
     * @param val
     * @return
     */
    public static int findFirstGtVal(int[] a, int val) {
        int n = a.length;
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            if (a[mid] >= val) {
                //第一个元素或者当前元素的前一个元素小于：当前就是第一个大于等于的元素下标
                if (mid == 0 || a[mid - 1] < val) {
                    return mid;
                } else {
                    h = mid - 1;
                }
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 查找最后小于等于值的元素下标
     *
     * @param a
     * @param val
     * @return
     */
    public static int findLastLtVal(int[] a, int val) {
        int n = a.length;
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            if (a[mid] <= val) {
                //mid是数组的最后一个，或者 当前元素的下一个元素大于的话，那当前元素的下标就是最后一个小于等于的
                if (mid == n - 1 || a[mid + 1] > val) {
                    return mid;
                } else {
                    //mid 的下一个都是小于等于的，那继续往右边找
                    l = mid + 1;
                }
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 给一个循环数组，在数组中查找等于目标值的元素下标
     * [4,5,6,7,8,1,2,3]
     *
     * @param a   循环数组
     * @param val 目标值
     * @return
     */
    public static int searchValLoopArray(int[] a, int val) {
        //循环的把数组一分为二，一部分有序，一部分没有顺序
        //在有序部分查找，且val在这个区间
        //临界条件
        int n = a.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return a[0] == val ? 0 : -1;
        }
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            if (a[mid] == val) {
                return mid;
            }
            //判断哪个部分有序
            if (a[0] <= a[mid]) {
                //判断需要查找的值是否在这个区间
                if (a[0] <= val && val < a[mid]) {
                    //左边寻找
                    h = mid - 1;
                } else {
                    //目标值不在这个有序区间内，往有寻找
                    l = mid + 1;
                }
            } else {
                //左边判断需要查找的值是否在这个区间
                if (a[mid] < val && val <= a[n - 1]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }


}
