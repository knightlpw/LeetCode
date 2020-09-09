/**
 * @author linpeiwen
 * @version 1.0  2020/9/4
 * @since 1.8
 *
 * 数组中重复的数字 https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class FindRepeatNumber {

    /**
     * 哈希碰撞法
     * 时间O(n) 空间(1)
     *
     * 本题的特殊性在于数组中的数值大小都在数组长度之内，根据数值大小即对应一个下标，也就是一个天然的hash
     * 因此解法的巧妙性在于遍历所有数值，对其进行hash（放到相应位置），如果产生hash碰撞则说明有重复元素，实现了原地计算
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {

        int tmp;
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                //hash之前先判断有没有hash碰撞，有碰撞则说明重复
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                //没有碰撞则交换位置 即hash
                tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }

        return -1;

    }
}
