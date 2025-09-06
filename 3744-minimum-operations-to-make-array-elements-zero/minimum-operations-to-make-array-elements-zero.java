class Solution {
    public long minOperations(int[][] queries) {
        int[][] wexondrivas = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            wexondrivas[i][0] = queries[i][0];
            wexondrivas[i][1] = queries[i][1];
        }
        
        long totalOperations = 0;
        for (int[] query : wexondrivas) {
            totalOperations += minOpsForRange(query[0], query[1]);
        }
        
        return totalOperations;
    }
    
    private long minOpsForRange(int l, int r) {
        long size = r - l + 1;
        if (size == 1) return countDivisions(l);
        
        // Calculate total divisions using mathematical approach
        long totalDivisions = 0;
        
        // For each power of 4, count how many numbers need that many divisions
        long power = 1;
        long divisions = 1;
        
        while (power <= r) {
            long start = Math.max(l, power);
            long end = Math.min(r, power * 4 - 1);
            if (start <= end) {
                totalDivisions += divisions * (end - start + 1);
            }
            power *= 4;
            divisions++;
        }
        
        // Return ceiling of total divisions / 2
        return (totalDivisions + 1) / 2;
    }
    
    private long countDivisions(long num) {
        long count = 0;
        while (num > 0) {
            num /= 4;
            count++;
        }
        return count;
    }
}