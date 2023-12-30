package String;
public class String_ShortestPath {

    public static float shortestPath(String str) {
        float x = 0, y = 0;
        for(int i = 0; i < str.length(); i++) {
            // north
            if(str.charAt(i) == 'N') {
                y++;
            } else if(str.charAt(i) == 'S') { // south
                y--;
            } else if(str.charAt(i) == 'E') { // east
                x++;
            }
            else { // west
                x--;
            }
            
        }
        return (float)Math.sqrt(x*x + y*y);
    }
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(shortestPath(path));
    }
}
