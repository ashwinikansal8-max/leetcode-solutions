/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null) return null;
         rev(root.left,root.right,1);
         return root;
    }

    private void rev(TreeNode left,TreeNode right,int n)
    {
        if(left==null) return;
        if(n%2==1)
        {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
         rev(left.left,right.right,n+1);
         rev(left.right,right.left,n+1);
    }
}