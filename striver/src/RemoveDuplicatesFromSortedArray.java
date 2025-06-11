import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int idx = 0;

        for (int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                idx++;
                nums[idx] = nums[i];
            }
        }

        return idx + 1; // Adding 1 to get no of elms in new arr
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        removeDuplicates(nums);
        System.out.println(removeDuplicates(nums));
    }
}
