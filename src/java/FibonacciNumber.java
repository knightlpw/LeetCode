/**
 * @author linpeiwen
 * @version 1.0  2020/9/10
 * @since 1.8
 * <p>
 * 斐波那契数 https://leetcode-cn.com/problems/fibonacci-number/
 */
public class FibonacciNumber {


    /**
     * 记忆化自底向上
     * 时间 O(n) 空间O(n)
     *
     * @param N
     * @return
     */
    public int fib(int N) {

        if (N <= 1) {
            return N;
        }

        // 初始化数组保存中间状态
        int[] f = new int[N + 1];

        // 初始化前两位数据
        f[0] = 0;
        f[1] = 1;

        // 迭代累加
        for (int i = 2; i <= N; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        // 返回相应位置的结果
        return f[N];

    }

    /**
     * 非记忆化自底向上
     * 时间 O(n) 空间O(1)
     *
     * @param N
     * @return
     */
    public static int fib2(int N) {

        if (N <= 1) {
            return N;
        }

        //初始化前两位数据
        int first = 0;
        int second = 1;

        int res = 0;

        // 跳过一次循环
        N--;
        while (N > 0) {
            // 累加得到后一位
            res = first + second;

            // 进位 用res更新first和second
            first = second;
            second = res;

            N--;
        }

        return res;

    }


}
