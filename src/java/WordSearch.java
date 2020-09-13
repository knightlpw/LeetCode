/**
 * @author linpeiwen
 * @version 1.0  2020/9/12
 * @since 1.8
 * <p>
 * 单词搜索 https://leetcode-cn.com/problems/word-search/
 */
public class WordSearch {

    private int[][] offset = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(board, i, j, 0, chars)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, int y, int x, int index, char[] word) {


        // 返回true的唯一条件 已经遍历到word的最后，说明匹配到了字符串
        if (index == word.length) {
            return true;
        }

        if (y < 0 || x < 0 || y == board.length || x == board[y].length) {
            return false;
        }

        if (board[y][x] != word[index]) {
            return false;
        }

        //board[y][x] == word[index] 后，标记走过的坐标
        // 异或操作改变原值
        board[y][x] ^= 256;

        /**
         * // 这段代码更好理解，但是不够通用，不能应用于8连通图
         * return exist = exist(board, y, x + 1, index + 1, word)
         *                 || exist(board, y, x - 1, index + 1, word)
         *                 || exist(board, y + 1, x, index + 1, word)
         *                 || exist(board, y - 1, x, index + 1, word);
         */
        for (int i = 0; i < 4; i++) {
            int ny = y + offset[i][0];
            int nx = x + offset[i][1];
            // 只要有一条路线走得通就会递归返回true
            if (exist(board, ny, nx, index + 1, word)) {
                return true;
            }
        }

        // 异或操作恢复原值，便于下次遍历
        board[y][x] ^= 256;

        // 如果全部通路都无法匹配，则返回false，然后从下一坐标开始搜索
        return false;
    }


}
