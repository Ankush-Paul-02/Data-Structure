package Trie;
public class Trie_StartWith_Problem {

    static class Node {
        Node children[] = new Node[26];    // size 26
        boolean endOfWord = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {    // O(l)     l = length of largest word
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int index = word.charAt(level) - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.endOfWord = true;
    }

    public static boolean startsWith(String prefix) {    // O(l)
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        /*
         *  Create a function boolean startsWith(String prefix) for a trie.
         *  Returns true if there is a previously inserted string word that 
         *  has the prefix, and false otherwise.
         */

        String words[] = {"apple", "app", "mango", "man", "woman"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(startsWith("app"));
        System.out.println(startsWith("moon"));
    }
}
