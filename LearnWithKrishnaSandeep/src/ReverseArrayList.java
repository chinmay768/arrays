import java.util.*;

public class ReverseArrayList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Collections.reverse(list);

        System.out.println(list);
    }
}
