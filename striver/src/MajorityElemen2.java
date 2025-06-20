import java.util.*;
public class MajorityElemen2 {

    // TC: O(n * n) // SC: O(1)
    public List<Integer> majorityElementNaive(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            if(list.size() == 0 || list.get(0) != nums[i]){
                int count = 0;
                for (int j = 0; j < nums.length; j++){
                    if(nums[i] == nums[j]) count++;
                }

                if(count > nums.length / 3) list.add(nums[i]);
            }

            if(list.size() == 2) break;
        }

        return list;
    }

    // TC: O(n) // SC: O(n)
    public List<Integer> majorityElementBetter(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(list.size() == 0 || list.get(0) != nums[i]){
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                if(map.get(nums[i]) > nums.length / 3){
                    list.add(nums[i]);
                }
            }

            if(list.size() == 2) break;
        }
        return list;
    }

    public List<Integer> majorityElementOptimal(int[] nums){
        List<Integer> list = new ArrayList<>();
        int elm1 = Integer.MIN_VALUE, elm2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;

        for(int i = 0; i < nums.length; i++){
            if(count1 == 0 && nums[i] != elm2){
                count1 = 1;
                elm1 = nums[i];
            }else if(count2 == 0 && nums[i] != elm1){
                count2 = 1;
                elm2 = nums[i];
            }else if(elm1 == nums[i]){
                count1++;
            }else if(elm2 == nums[i]){
                count2++;
            }else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for(int i  = 0; i < nums.length; i++){
            if(elm1 == nums[i]) count1++;
            if(elm2 == nums[i]) count2++;
        }

//        int minimin = (int) (nums.length / 3) + 1;
        if(count1 > nums.length / 3) list.add(elm1);
        if(count2 > nums.length / 3) list.add(elm2);

        return list;
    }



    public static void main(String[] args) {

    }
}
