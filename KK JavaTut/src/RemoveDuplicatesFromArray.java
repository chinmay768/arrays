import java.util.*;

public class RemoveDuplicatesFromArray {

    public static Integer[] removeDuplicatesSet(int[] arr){
        Set<Integer> set = new HashSet<>();


        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }

        Integer[] uniqueElms = set.toArray(new Integer[set.size()]);
        return uniqueElms;
    }

    public static int[] removeDuplicatesStream(int[] arr){
        int[] uniqueElms = Arrays.stream(arr).distinct().toArray();

        return uniqueElms;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 19, 7, 1, 2, 10};

        Integer[] uniqueElms = removeDuplicatesSet(arr);

        System.out.println(Arrays.toString(uniqueElms));
        System.out.println(Arrays.toString(removeDuplicatesStream(arr)));
    }
}
