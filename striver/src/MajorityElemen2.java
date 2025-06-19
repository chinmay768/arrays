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



    public static void main(String[] args) {

    }
}
