// class Solution {
//     public int minimumCost(int[] nums) {
//         int first = nums[0];

//         Arrays.sort(nums, 1, nums.length);

//         return first + nums[1] + nums[2];
//     }
// }

class Solution {
    public int minimumCost(int[] nums) {

        int first = nums[0];

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        // find two smallest elements after index 0
        for(int i = 1; i < nums.length; i++){
            
            if(nums[i] < min1){
                min2 = min1;
                min1 = nums[i];
            }
            else if(nums[i] < min2){
                min2 = nums[i];
            }
        }

        return first + min1 + min2;
    }
}
