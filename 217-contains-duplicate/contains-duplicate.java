//brute-force way
//class Solution {
   // public boolean containsDuplicate(int[] nums){
      //  Arrays.sort(nums);
     //   for(int i=1;i<nums.length;i++){
           // for(int j=i+1;j<nums.length;j++){
         //   if(nums[i] == nums[i-1]){
        //         return true;
        //        }
      //      }

      //  }
   //     return false;
  //  }
    
        
//}


import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
