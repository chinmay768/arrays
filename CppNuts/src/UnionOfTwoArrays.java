import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoArrays {

    public static Integer[] union(int[] arr1, int[] arr2){
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int i = 0; i < arr2.length; i++){
            set.add(arr2[i]);
        }

        Integer[] arr = set.toArray(new Integer[0]);

        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5};
        int[] arr2 = {2, 4, 5, 7, 8};

        Integer[] unionArr = union(arr1, arr2);

        System.out.println(Arrays.toString(unionArr));
    }
}
