import java.util.Arrays;

public class MovePostiveElmsToStart {

    public static void main(String[] args) {
        int[] arr = {1, -2, -4, 2, 9, -1, 3};

        int k = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                k++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
