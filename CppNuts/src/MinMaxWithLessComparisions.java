public class MinMaxWithLessComparisions {

    public static void minMaxLessComparisions(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i;

        if(arr.length % 2 == 0){
            i = 0;
        }else {
            i = 1;
        }

        while(i < arr.length - 1){
            if(arr[i] > arr[i + 1]){
                if(arr[i] > max)
                    max = arr[i];

                if(arr[i + 1] < min)
                    min = arr[i + 1];
            }else{
                if(arr[i + 1] > max)
                    max = arr[i + 1];

                if(arr[i] < min)
                    min = arr[i];
            }
            i += 2;
        }

        System.out.println(min + " " + max);
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 9, 3, 5, 8, 1};

        minMaxLessComparisions(arr);
    }
}
