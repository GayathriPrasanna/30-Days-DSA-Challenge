class Solution {
    List<Long> allSums = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        long totalSum = calculateSubtreeSum(root);
        
        long maxProd = 0;
        for (long s : allSums) {
            long currentProduct = s * (totalSum - s);
            maxProd = Math.max(maxProd, currentProduct);
        }
        return (int) (maxProd % 1000000007);
    }
    private long calculateSubtreeSum(TreeNode node) {
        if (node == null) return 0;
        
        long currentSubtreeSum = node.val + calculateSubtreeSum(node.left) + calculateSubtreeSum(node.right);
        
        allSums.add(currentSubtreeSum);
        
        return currentSubtreeSum;
    }
}