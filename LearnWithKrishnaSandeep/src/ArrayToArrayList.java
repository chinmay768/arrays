import java.util.*;

public class ArrayToArrayList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        List list = Arrays.asList(arr);

        List<Integer> list2 = new ArrayList<>();
//        Collections.addAll(arr, list2); Works for strings or Wrapper classes

        List<Integer> list3 = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            list3.add(arr[i]);
        }
    }
}
