import java.util.Arrays;
import java.util.Collections;

public class SortDescending {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Arrays.sort(arr, Collections.reverseOrder());

        int[] arr2 = {1, 2, 3, 4, 5};

        reverse(arr2);

        System.out.println(Arrays.toString(arr2));
    }

    public static void reverse(int[] array)
    {
        // Length of the array
        int n = array.length;

        for (int i = 0; i < n / 2; i++) {

            int temp = array[i];

            array[i] = array[n - i - 1];

            array[n - i - 1] = temp;
        }
    }
}
