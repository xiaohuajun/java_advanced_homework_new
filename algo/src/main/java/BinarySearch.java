/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2023/2/13 下午8:36
 * @description BinarySearch
 */
public class BinarySearch {


    /**
     * 有序数组中查找目标值的下标，不存在返回-1
     *
     * @param nums   数组
     * @param target 目标值
     * @return 目标值在数组中的下标
     */
    public static int binarySearch(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
