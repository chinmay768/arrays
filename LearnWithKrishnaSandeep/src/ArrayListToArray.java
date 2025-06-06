import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListToArray {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(arr); // Works with string
        System.out.println(Arrays.toString(arr));
    }
}
