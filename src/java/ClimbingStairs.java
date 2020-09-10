/**
 * @author linpeiwen
 * @version 1.0  2020/9/10
 * @since 1.8
 * <p>
 * 爬楼梯 https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    /**
     * 非记忆化自底向上(与斐波那契数列一样)
     * 时间 O(n)
     * 空间 O(1)
     * <p>
     * 与斐波那契数列不一样的地方在于，爬楼梯的数列少了第一位的0，爬楼梯没有f(0) 数列从1 2 3 5...开始
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int p = 1, q = 2, r = 0;
        for (int i = 3; i <= n; ++i) {
            r = p + q;
            p = q;
            q = r;

        }
        return r;
    }

    /**
     * 记忆化自底向上
     * 时间 O(n)
     * 空间 O(n)
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {

        if (n <= 2) {
            return n;
        }

        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
