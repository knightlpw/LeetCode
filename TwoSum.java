import java.util.HashMap;
import java.util.Map;

/**
 * @author linpeiwen
 * @version 1.0  2020/8/15
 * @since 1.8
 *
 * 两数之和 https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {

    /**
     * 一遍哈希法
     * 时间O(N) 空间O(N)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashMap = new HashMap();
        for (int i = 0; i <nums.length ; i++) {
            int a = target - nums[i];
            if(hashMap.containsKey(a)){
                return new int[]{hashMap.get(a),i};
            }else {
                hashMap.put(nums[i],i);
            }
        }
        return  null;
    }
}
