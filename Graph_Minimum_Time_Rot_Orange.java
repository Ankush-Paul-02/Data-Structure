import java.util.*;


public class Graph_Minimum_Time_Rot_Orange {

    public final static int R = 3;
    public final static int C = 5;

    static class Element {
        int x = 0, y = 0;
        Element(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isValid(int i, int j) {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }

    static boolean isDelim(Element element) {
        return (element.x == -1 && element.y == -1);
    }

    static boolean checkAll(int arr[][]) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(arr[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    static int solution(int arr[][]) {  // O(R*C)
        Queue<Element> queue = new LinkedList<>();
        Element element;
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(arr[i][j] == 2) {
                    queue.add(new Element(i, j));
                }
            }
        }
        queue.add(new Element(-1, -1));

        while(!queue.isEmpty()) {
            boolean rot = false;
            while(!isDelim(queue.peek())) {
                element = queue.peek();
                if(isValid(element.x + 1, element.y) && arr[element.x + 1][element.y] == 1) {
                    if(!rot) {
                        answer++;
                        rot = true;
                    }
                    arr[element.x + 1][element.y] = 2;
                    element.x++;
                    queue.add(new Element(element.x, element.y));
                    element.x--;
                }
                if(isValid(element.x - 1, element.y) && arr[element.x - 1][element.y] == 1) {
                    if(!rot) {
                        answer++;
                        rot = true;
                    }
                    arr[element.x - 1][element.y] = 2;
                    element.x--;
                    queue.add(new Element(element.x, element.y));
                    element.x++;
                }
                if(isValid(element.x, element.y + 1) && arr[element.x][element.y+1] == 1) {
                    if(!rot) {
                        answer++;
                        rot = true;
                    }
                    arr[element.x][element.y+1] = 2;
                    element.y++;
                    queue.add(new Element(element.x, element.y));
                    element.y--;
                }
                if(isValid(element.x, element.y - 1) && arr[element.x][element.y-1] == 1) {
                    if(!rot) {
                        answer++;
                        rot = true;
                    }
                    arr[element.x][element.y+1] = 2;
                    element.y--;
                    queue.add(new Element(element.x, element.y));
                    element.y++;
                }
                queue.remove();
            }
            queue.remove();
            if(!queue.isEmpty()) {
                queue.add(new Element(-1, -1));
            }
        }
        return (checkAll(arr)) ? -1 : answer;
    }

    public static void main(String[] args) {
        /*
         *  We have a matrix of dimension m*n where each cell in the 
         *  matrix can have values 0, 1 or 2 which has the following 
         *  meaning.
         *  0: Empty cell
         *  1: Cells have fresh oranges
         *  2: Cells have rotten oranges.
         *  We have to determine what is the minimum time required so
         *  that all the oranges become rotton. A rotten orange at index
         *  [i, j] can rot other fresh orange at indexes [i-1, j], [i+1, j],
         *  [i, j-1] (up, down, left, right). If it is impossible to rot
         *  every orange then simply return -1.
         */

        int arr[][] = {
            {2, 1, 0, 2, 1},
            {1, 0, 1, 2, 1},
            {1, 0, 0, 2, 1}
        } ;

        int answer = solution(arr);
        if(answer == -1) {
            System.out.println("All oranges can't rot");
        } else {
            System.out.println("Time required for all oranges to rot : " + answer);
        }
    }
}
