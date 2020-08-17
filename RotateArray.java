/**
 * @author linpeiwen
 * @version 1.0  2020/8/16
 * @since 1.8
 * <p>
 * 旋转数组 https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArray {

    /**
     * 暴力法
     * 时间O(kn) 空间O(1)
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int tmp, pre;
        for (int i = 0; i < k; i++) {
            pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                tmp = nums[j];
                nums[j] = pre;
                pre = tmp;
            }
        }

    }

    /**
     * 暴力法2 更容易理解,稍微快一点
     * 时间O(kn) 空间O(1)
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        k %= length;

        int pre;
        while (k > 0) {
            pre = nums[length - 1];
            for (int i = length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = pre;
            k--;
        }
    }

    /**
     * 反转法
     * 时间O(n) 空间O(1)
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        if (k > 0) {
            reverse(nums,0,length-1);
            reverse(nums,0,k-1);
            reverse(nums,k,length-1);
        }
    }

    private void reverse(int[] nums, int k, int i) {
        int tmp;
        while (k < i){
            tmp = nums[i];
            nums[i] = nums[k];
            nums[k] = tmp;
            k++;
            i--;
        }

    }


}
