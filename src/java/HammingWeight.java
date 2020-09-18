/**
 * @author linpeiwen
 * @version 1.0  2020/9/18
 * @since 1.8
 * <p>
 * 二进制中1的个数 https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class HammingWeight {


    /**
     * 时间 O(n) n是1的个数
     * 空间 O(1)
     * <p>
     * 该题的解法略巧妙，n-1可以把二进制最右边的1变成0，最右边的0变成1，然后n&n-1就可以消掉最后一位的1
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            num++;
            n = n & (n - 1);
        }
        return num;
    }
}
