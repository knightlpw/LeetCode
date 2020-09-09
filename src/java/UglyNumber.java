/**
 * @author linpeiwen
 * @version 1.0  2020/9/9
 * @since 1.8
 * <p>
 * 丑数 https://leetcode-cn.com/problems/ugly-number/
 */
public class UglyNumber {

    /**
     * 时间 O(n) num越大 循环整除次数越多
     * 空间 O(1)
     * <p>
     * 不断除以三个质数，最后的结果为1的就是丑数
     *
     * @param num
     * @return
     */
    public boolean isUgly(int num) {

        if (num < 1) {
            return false;
        }

        int[] n = new int[]{2, 3, 5};

        for (int i = 0; i < n.length; i++) {
            // 取余判断能不能整除
            while (num % n[i] == 0) {
                num /= n[i];
            }
        }

        return 1 == num;
    }
}
