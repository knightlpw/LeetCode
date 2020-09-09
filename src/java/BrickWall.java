import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linpeiwen
 * @version 1.0  2020/9/3
 * @since 1.8
 *
 * 砖墙 https://leetcode-cn.com/problems/brick-wall/
 */
public class BrickWall {

    /**
     * 哈希法
     * 时间O(n) 墙砖块总数
     * 空间O(m) 墙的最大宽度，map中存储的最多数量
     * 
     * 本题难点在于把穿墙最少转换成缝隙最多，然后用map统计缝隙最多。缝隙位置转换成砖墙的数值累加的思路有点巧妙
     * @param wall
     * @return
     */
    public static int leastBricks(List<List<Integer>> wall){

        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> wa : wall) {
            int sum = 0;

            // i<wa.size()-1 忽略最后一块砖
            for(int i=0;i<wa.size()-1;i++){

                sum += wa.get(i);
                if(map.containsKey(sum)){
                    map.put(sum, map.get(sum) + 1);
                }else {
                    map.put(sum, 1);
                }
            }
        }

        int height = wall.size();
        int max = 0;
        for (Integer value : map.values()) {
            max = Math.max(max, value);
        }
        return height - max;

    }
}
