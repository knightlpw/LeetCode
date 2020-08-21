/**
 * @author linpeiwen
 * @version 1.0  2020/8/17
 * @since 1.8
 *
 * 合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {


    /**
     * 尾部排序法
     * 时间O(n+m) 空间O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = i + j + 1;

        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        while (j>=0){
            nums1[k--] = nums2[j--];
        }

    }
}
