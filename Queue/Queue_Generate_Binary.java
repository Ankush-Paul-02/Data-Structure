package Queue;
import java.util.LinkedList;
import java.util.Queue;


public class Queue_Generate_Binary {

    public static void generate(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        while (n-->0) {
            String str = queue.peek();
            queue.remove();
            System.out.println(str);
            String str2 = str;
            queue.add(str + "0");
            queue.add(str2 + "1");
        }
    }

    public static void main(String[] args) {
        generate(5);
    }
}
