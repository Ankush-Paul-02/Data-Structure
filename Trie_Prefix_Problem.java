public class Trie_Prefix_Problem {

    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;
        int frequency;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            frequency = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int index = word.charAt(level) - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new Node();
            } else {
                curr.children[index].frequency++;
            }
            curr = curr.children[index];
        }
        curr.endOfWord = true;
    }

    public static void findPrefix(Node root, String ans) {  // O(L)  levels of the trie = L
        if(root == null) {
            return;
        }
        if(root.frequency == 1) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < root.children.length; i++) {
            if(root.children[i] != null) {
                findPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
    }

    public static void main(String[] args) {
        /*
         *  Find shortest unique prefix for every word in a given list.
         *  Assume no word is prefix of another.
         */

        String arr[] = {"zebra", "dog", "duck", "dove"}; 
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        root.frequency = -1;

        findPrefix(root, "");
    }
}
