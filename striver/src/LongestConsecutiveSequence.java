import java.util.*;

public class LongestConsecutiveSequence {

    // Naive TC: O(n * n * n)
    public static int longestConsecutiveNaive(int[] nums) {
        int longest = 1; // Always 1 bc even if we pick any elm

        for(int i = 0; i < nums.length; i++){
            int count = 1;
            int x = nums[i];
            while (linearSearch(nums, x + 1)){
                x++;
                count++;
            }

            if(count > longest) longest = count;
        }
        return longest;
    }

    public static boolean linearSearch(int[] arr, int x){
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == x) return true;
        }

        return false;
    }

    // Better TC: O(nlogn + n)
    public static int longestConsecutiveBetter(int[] nums){
        int longest = 1;
        Arrays.sort(nums);

        int currCount = 0;
        int lastSmaller = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 == lastSmaller){
                currCount++;
                lastSmaller++;
            }else if(nums[i] != lastSmaller){
                currCount = 1;
                lastSmaller = nums[i];
            }

            longest = Math.max(longest, currCount);
        }

        return longest;
    }

    public static int longestSuccessiveElements(int[] a) {
        int n = a.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {102, 4, 10, 1, 101, 3, 2, 1, 1};

        System.out.println(longestConsecutiveBetter(arr));
    }
}