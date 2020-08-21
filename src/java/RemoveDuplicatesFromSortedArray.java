/**
 * @author linpeiwen
 * @version 1.0  2020/8/15
 * @since 1.8
 *
 * 删除排序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * 快慢双指针法
     * 时间O(n) 空间(1)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int j = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[j]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j+1;
    }
}
