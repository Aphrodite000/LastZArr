import java.util.Arrays;

public class Solution {
    public static void findUnsortedSubarray(int[] nums) {
        int left=0;
        int right=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                System.out.println(nums[i+1]);
                for(int j=0;j<=i+1;j++){
                    if(nums[i+1]<nums[j]){
                        System.out.println(nums[j]);
                        left=j;
                        System.out.println(left);
                        break;
                    }
                }
            }
            if(left!=0){
                break;
            }
        }
        for(int i=nums.length-1;i>=1;i--){
            if(nums[i]<nums[i-1]){
                for(int j=nums.length-1;j>=i-1;j--){
                    if(nums[i-1]>nums[j]){
                        right=j;
                        break;
                    }
                }
            }
            if(right!=0){
                break;
            }
        }
        System.out.println(right-left+1);
    }

    public int findUnsortedSubarray2(int[] nums) {
        int left=0;
        int right=0;
        int[] newNums= Arrays.copyOf(nums,nums.length);
        Arrays.sort(newNums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=newNums[i]){
                left=i;
                break;
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]!=newNums[i]){
                right=i;
                break;
            }
        }
        if(left==right){
            return 0;
        }
        return right-left+1;
    }
}
