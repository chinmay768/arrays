import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    // Generic
    private class TripletGeneric<T, U, V> {

        private final T first;
        private final U second;
        private final V third;

        private TripletGeneric(T first, U second, V third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public T getFirst() { return first; }
        public U getSecond() { return second; }
        public V getThird() { return third; }
    }

    private class Triplet {

        private final Integer first;
        private final Integer second;
        private final Integer third;

        public Triplet(Integer first, Integer second, Integer third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public Integer getFirst() { return first; }
        public Integer getSecond() { return second; }
        public Integer getThird() { return third; }

        public List<Integer> getList() { return Arrays.asList(first, second, third);}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Triplet triplet)) return false;
            return Objects.equals(first, triplet.first) &&
                    Objects.equals(second, triplet.second) &&
                    Objects.equals(third, triplet.third);
        }


        @Override
        public int hashCode() {
            return Objects.hash(first, second, third);
        }
    }

    // TC: O(n^3)  SC: O(N)
    public List<List<Integer>> threeSumNaive(int[] nums) {
        Set<Triplet> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        Triplet trip = new Triplet(list.get(0), list.get(1), list.get(2));
                        set.add(trip); // Set won't add duplicates due to equals and hashcode

                    }
                }
            }
        }

        List<List<Integer>> list = set.stream()
                .map(triplet -> triplet.getList().stream()
                        .map(obj -> (Integer) obj)  // cast Object to Integer
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        return list;
    }


    // TC: O(n^2) SC: O(N)
    public List<List<Integer>> threeSumBetter(int[] nums) {
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> hashset = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                //Calculate the 3rd element:
                int third = -(nums[i] + nums[j]);

                //Find the element in the set:
                if (hashset.contains(third)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    temp.sort(null);
                    st.add(temp); // Set will take care of duplicates
                }
                hashset.add(nums[j]);
            }
        }

        // store the set elements in the answer:
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }

    public List<List<Integer>> threeSumOptimal(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //remove duplicates:
            if (i != 0 && nums[i] == nums[i - 1]) continue;

            //moving 2 pointers:
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    //skip the duplicates:
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {


    }
}
