/**
 * @author linpeiwen
 * @version 1.0  2020/9/17
 * @since 1.8
 * <p>
 * 剪绳子 II https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 */
public class CuttingRope {

    /**
     * 贪心法
     * 时间 O(n)
     * 空间 O(1)
     * <p>
     * 可得规律：最后分割成的绳子中，只可能有2，3，4长度的分段，为3最好，因此用贪心法尽量割出3的分段
     * 此题不能用dp的原因是绳子的长度可能会常大，涉及长度溢出，和取模后比较大小的问题，而且dp的时间复杂度会很大
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {

        if (n == 2) {
            return 1;
        }

        if (n == 3) {
            return 2;
        }
        int mod = (int) 1e9 + 7;
        long res = 1;

        // 绳子长度大于4则分割出3 小于等于4则不再分割
        while (n > 4) {
            res *= 3;

            // 每次乘积都取余
            res %= mod;

            // 绳子长度-3
            n -= 3;
        }

        // 乘以最后的长度再取余得到结果
        return (int) (res * n % mod);
    }
}
