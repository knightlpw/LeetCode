/**
 * @author linpeiwen
 * @version 1.0  2020/9/15
 * @since 1.8
 * <p>
 * 整数拆分 https://leetcode-cn.com/problems/integer-break/
 */
public class IntegerBreak {

    /**
     * 动态规划
     * 时间 O(n2)
     * 空间 O(n)
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i < n; i++) {
            int curMax = 0;

            // 计算dp[i]的最大值
            for (int j = 1; j < i; j++) {
                // dp[i]的两种情况 i拆分成j*(i-j) i拆分成j*dp[i-j] :即i-j再拆分
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }


}
