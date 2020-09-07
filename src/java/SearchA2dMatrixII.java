/**
 * @author linpeiwen
 * @version 1.0  2020/9/7
 * @since 1.8
 * 搜索二维矩阵 II https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class SearchA2dMatrixII {

    /**
     * 无名法
     * 时间(m+n) 二维数组长宽
     * 空间O(1)
     *
     * 此问题的关键在于识别排序二维数组的特点：右>左，下>上 根据此特点，可以跳过大部分的元素比较
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null||matrix.length == 0 ||matrix[0].length == 0){
            return false;
        }

        // 选取右上角为初始遍历点（当然任意一个角都可以）
        int row = 0;
        int col = matrix[0].length - 1;

        // 超出边界则退出
        while (row < matrix.length && col >= 0){

            if(matrix[row][col]>target){
                // 当前值大于目标值则指针左移
                col--;

            }else if(matrix[row][col]<target){
                // 当前值小于目标值则指针下移
                row++;
            }else {
                return true;
            }
        }

        return false;
    }
}
