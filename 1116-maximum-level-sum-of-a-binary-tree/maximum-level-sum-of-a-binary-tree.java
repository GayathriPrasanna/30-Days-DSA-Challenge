class Solution {
    public int maxLevelSum(TreeNode root) {
        int height = getHeight(root); 
        long maxSum = Long.MIN_VALUE;
        int maxLevel = 1;

        for (int i = 1; i <= height; i++) {
            long currentSum = getLevelSum(root, i); 
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxLevel = i;
            }
        }
        return maxLevel;
    }

    public long getLevelSum(TreeNode node, int level) {
        if (node == null) return 0;
        if (level == 1) return node.val;
        return getLevelSum(node.left, level - 1) + getLevelSum(node.right, level - 1);
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}