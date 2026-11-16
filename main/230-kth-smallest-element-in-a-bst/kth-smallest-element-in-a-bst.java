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
    int c=0,ans=-1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return ans;
    }

    private void inorder(TreeNode node,int k){
        if(node==null || c>=k) return;

        inorder(node.left,k);
        c++;
        if(c==k){
            ans = node.val;
            return;
        }
        inorder(node.right,k);
    }
}