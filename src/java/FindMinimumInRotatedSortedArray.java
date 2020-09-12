/**
 * @author linpeiwen
 * @version 1.0  2020/9/11
 * @since 1.8
 * <p>
 * 寻找旋转排序数组中的最小值 https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {


    /**
     * 二分法
     * 时间 O(lgn) 空间 O(1)
     * <p>
     * 旋转排序数组的最小值的位置是一个关键节点，最小值左边的数值都比right大，最小值右边的数值都比right小，
     * 由此不断取二分的结果，直到left=right，此节点则为最小值
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {

        int left = 0, right = nums.length - 1;

        while (nums[left] < nums[right]) {

            // 防止数值越界，采用这种计算法
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                // 说明目标值在mid左边，且有可能包括mid，右边左移
                right = mid;
            } else {
                // 说明目标值在mid右边，不可能包括mid，因此左边界右移至mid+1
                left = mid + 1;
            }

        }

        // left = right则退出循环
        return nums[left];
    }

}
