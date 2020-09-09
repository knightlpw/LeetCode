
import java.util.HashMap;
import java.util.Map;

/**
 * @author linpeiwen
 * @version 1.0  2020/9/8
 * @since 1.8
 *
 * 从前序与中序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private Map<Integer, Integer> map = new HashMap<>();


    /**
     * 递归法
     * 时间 O(n)
     * 空间 O(n)
     *
     * 本题的关键在于理解前序数组和中序数组中二叉树存放的特点，根据两种数组的数值特点定位出根节点，左子树和右子树，然后拆分子问题进行递归
     * 理解了思路之后编码的难点就在于定义左子树和右子树的左右边界，这个熟练即可
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //缓存，便于之后定位节点下标
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, 0, preorder.length - 1);

    }

    /**
     *
     * @param preorder 前序数组
     * @param preL 前序数组左边界
     * @param preR 前序数组右边界
     * @param inL 中序数组左边界
     * @param inR 中序数组右边界
     * @return
     */
    private TreeNode build(int[] preorder, int preL, int preR, int inL, int inR) {

        //先写终止条件 子树为空
        if (preL > preR) {
            return null;
        }

        // 当前前序数组的首位数字就是父节点的值
        int root = preorder[preL];
        // 构造父节点
        TreeNode node = new TreeNode(root);

        // 父节点在中序数组中的下标 用于计算左子树长度
        int root_index = map.get(root);
        // 左子树长度
        int left_tree_size = root_index - inL;
        // 前序数组中左子树右边界的下标
        int pre_left_tree_end = left_tree_size + preL;

        //截取当前 前序数组和中序数组的左子树 递归构建二叉树
        node.left = build(preorder, preL + 1, pre_left_tree_end, inL, root_index - 1);

        //截取当前 前序数组和中序数组的右子树 递归构建二叉树
        node.right = build(preorder, pre_left_tree_end + 1, preR, root_index + 1, inR);

        //返回父节点
        return node;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
