import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author linpeiwen
 * @version 1.0  2020/9/14
 * @since 1.8
 * <p>
 * 机器人的运动范围 https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class MovingCount {

    public int[][] offset = {{1, 0}, {0, 1}};

    public int count = 0;

    /**
     * 深度优先搜索
     * 时间 O(mn)
     * 空间 O(mn)
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {

        // 记录走过的点
        boolean[][] visit = new boolean[m][n];

        dfs(visit, 0, 0, k, m, n);

        return count;
    }

    private void dfs(boolean[][] visit, int x, int y, int k, int m, int n) {

        if (x < 0 || y < 0 || x >= m || y >= n || visit[x][y]) return;

        if (getSum(x) + getSum(y) > k) return;

        visit[x][y] = true;
        count++;

        for (int i = 0; i < 2; i++) {
            //向右向下搜索
            int nx = x + offset[i][0];
            int ny = y + offset[i][1];
            dfs(visit, nx, ny, k, m, n);
        }
    }

    /**
     * 计算位数和
     *
     * @param i
     * @return
     */
    private static int getSum(int i) {
        int sum = 0;
        while (i > 0) {
            // 个位累加
            sum += i % 10;
            // 去掉个位
            i /= 10;
        }
        return sum;
    }


    /**
     * 广度优先搜索
     * 时间 O(mn)
     * 空间 O(mn)
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount2(int m, int n, int k) {

        int[][] offset = {{0, 1}, {1, 0}};
        boolean[][] visit = new boolean[m][n];

        Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry(0, 0));

        int count = 0;
        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> poll = queue.poll();
            Integer x = poll.getKey();
            Integer y = poll.getValue();

            if (x < 0 || y < 0 || x >= m || y >= n || visit[x][y]) continue;

            if (getSum(x) + getSum(y) > k) continue;

            visit[x][y] = true;
            count++;

            for (int i = 0; i < 2; i++) {
                int nx = x + offset[i][0];
                int ny = y + offset[i][1];
                queue.add(new AbstractMap.SimpleEntry<>(nx, ny));
            }
        }
        return count;

    }


}
