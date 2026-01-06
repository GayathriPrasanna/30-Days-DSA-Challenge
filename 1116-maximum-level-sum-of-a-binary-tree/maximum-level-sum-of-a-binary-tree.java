class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); 
        
        long maxSum = Long.MIN_VALUE;
        int maxLevel = 1;
        int currentLevel = 1;

        while (!queue.isEmpty()) {
            int size = queue.size(); 
            long levelSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); 
                levelSum += node.val; 

                
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

           
            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = currentLevel;
            }
            currentLevel++; 
        }
        return maxLevel;
    }
}