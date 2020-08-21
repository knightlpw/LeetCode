import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author linpeiwen
 * @version 1.0  2020/8/21
 * @since 1.8
 *
 * 三数之和 https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {

    /**
     * 三指针法
     * 时间O(n2) 空间O(n):排序空间，实际情况中或许会用一个n的数组存储排序后的数组
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>>  res = new ArrayList<>();

        //排序的用作——1跳过重复元素，返回不重复的结果，2减少判断次数
        Arrays.sort(nums);

        //整个算法的关键在于控制重复的边界的同时计算所有可能情况
        //三指针法，首部固定一个慢指针，其余两个指针在中间夹逼
        int length = nums.length;
        for (int i = 0; i < nums.length-2; i++) {

            //首个元素大于0时，已经不会有匹配的结果
            if(nums[i]>0){
                return res;
            }

            //如果首指针重复了，继续往前直到不重复为止
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }

            //确定双指针
            int left = i+1;
            int right =length  - 1;

            //双指针夹逼
            while(left < right){

                int tmp = nums[i] + nums[left] + nums[right];

                if(tmp == 0){
                    //符合条件就放入
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //匹配成功后跳过重复元素
                    left++;
                    right--;
                    while (left<right&&nums[left] == nums[left-1]) left++;
                    while (left<right&&nums[right] == nums[right+1]) right--;

                }else if(tmp<0){
                    //小于则增大左指针
                    left++;
                }else {
                    //大于则减小右指针
                    right--;
                }
            }
        }
        return res;
    }


}
