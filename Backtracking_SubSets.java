public class Backtracking_SubSets {

    public static void findSubSets(String str, String ans, int index) { // O(n*2^n)
        // Base case
        if(index == str.length()) {
            System.out.println(ans);
            return;
        }
        // Recursion
        // Yes choice
        findSubSets(str, ans+str.charAt(index), index+1);
        // No choice
        findSubSets(str, ans, index+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        String ans = " ";
        findSubSets(str, ans, 0);
    }
}
