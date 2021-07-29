package day1.codingInterviews;

import javax.swing.tree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/21 10:33
 * description:输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 前序遍历结果分布是二叉树根节点，左子树，右子树。
 *
 * 中序遍历结果分布是左子树，二叉树根节点，右子树。
 *
 * 所以根据前序遍历结果的第一个元素获取到根节点，然后根据根节点把中序遍历结果分为两半，得到左子树的中序遍历结果，然后根据左子树的长度可以去前序遍历结果中分离出左子树的前序遍历结果，右子树也是如此，所以可以递归得构造出整个二叉树。
 */

public class Topic6 {

//    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
//        return reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
//    }
//
//    public static TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
//        if (preStart > preEnd || inStart > inEnd) {
//            return null;
//        }
//        TreeNode treeNode = new TreeNode(pre[preStart]);
//        for (int i = inStart; i <= inEnd; i++) {
//            if (in[i] == pre[preStart]) {
//                int leftLength = i - inStart;//左子树长度
//                treeNode.left = reConstructBinaryTree(pre, preStart + 1, preStart+leftLength, in, inStart, i-1);
//                treeNode.right = reConstructBinaryTree(pre, preStart +leftLength+1, preEnd, in, i+1, inEnd);
//                break;
//            }
//        }
//        return treeNode;
//    }
}
