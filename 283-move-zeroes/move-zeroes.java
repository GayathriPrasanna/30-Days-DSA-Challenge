class Solution {
    public void moveZeroes(int[] nums) {
    int n = nums.length;
    int ans = 0;
    for(int i=0;i<n;i++){
        if(nums[i] != 0){
            int temp = nums[ans];
            nums[ans] = nums[i];
            nums[i] = temp;
            ans++;
        }
    }
    }
}