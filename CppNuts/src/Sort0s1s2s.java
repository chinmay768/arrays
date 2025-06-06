import java.util.Arrays;

public class Sort0s1s2s {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void segregateOptimal(int[] arr){
        int i = 0, start = 0, end = arr.length - 1;

        while(i < end){
            if(arr[i] == 0){
                swap(arr, i, start);
                start++;
            }else if(arr[i] == 2) {
                swap(arr, i, end);
                end--;
            }
            i++;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 1, 2, 0, 1, 1, 0};

        segregateOptimal(arr);
    }
}
