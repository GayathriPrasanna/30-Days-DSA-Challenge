class Solution {
    long maxProd = 0;
    long totalSum = 0;

    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);
        findMax(root);
        
        return (int) (maxProd % 1000000007);
    }
    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }

    private long findMax(TreeNode node) {
        if (node == null) return 0;

        long currentSubtreeSum = node.val + findMax(node.left) + findMax(node.right); 
        long currentProduct = currentSubtreeSum * (totalSum - currentSubtreeSum);
        
        if (currentProduct > maxProd) {
            maxProd = currentProduct;
        }

        return currentSubtreeSum;
    }
}