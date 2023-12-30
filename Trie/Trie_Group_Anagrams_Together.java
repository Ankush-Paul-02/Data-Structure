package Trie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrieNode {
    List<String> data;
    TrieNode children[];
    boolean endOfWord;

    TrieNode() {
        data = new ArrayList<>();
        children = new TrieNode[26];
        endOfWord = false;
    }
}

public class Trie_Group_Anagrams_Together {

    static TrieNode root;
    List<List<String>> ans;

    public List<List<String>> groupAnagrams(String str[]) {
        ans = new ArrayList<>();
        root = new TrieNode();

        for (String word : str) {
            build(word);
        }

        dfs(root);
        return ans;
    }

    public void build(String str) {
        TrieNode temp = root;
        char word[] = str.toCharArray();
        Arrays.sort(word);

        for (char c : word) {
            TrieNode child = temp.children[c-'a'];
            if (child == null) {
                temp.children[c-'a'] = new TrieNode();
            }
            temp = temp.children[c-'a'];
        }
        temp.endOfWord = true;
        temp.data.add(str);
    }

    public void dfs(TrieNode root) {
        if(root.endOfWord) {
            ans.add(root.data);
        }

        for (int i = 0; i < 26; i++) {
            if(root.children[i] != null) {
                dfs(root.children[i]);
            }
        }
    }

    public static void main(String[] args) {
        /*
         *  Given an array of strings str, group the anagrams together.
         *  You can return the answer in any order.
         *  An Anagram is a word or phase formed by rearranging the letters
         *  of a different word or phrase, typically using all the original 
         *  letters exactly once.
         */

        String str[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Trie_Group_Anagrams_Together together = new Trie_Group_Anagrams_Together();
        System.out.println(together.groupAnagrams(str));
    }
}
