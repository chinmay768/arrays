import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] revArr = new int[arr.length];

        int curr = 0;
        for(int i = arr.length - 1; i >= 0; i--){
            revArr[curr++] = arr[i];
        }

        System.out.println(Arrays.toString(revArr));
    }
}
