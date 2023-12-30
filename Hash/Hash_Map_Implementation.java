package Hash;
import java.util.ArrayList;
import java.util.LinkedList;

public class Hash_Map_Implementation {  // Array of Linked List

    static class HashMap<K, V> {    // generic <>
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;   // size
        private int N;  
        private LinkedList<Node> buckets[]; // N = buckets.length


        @SuppressWarnings("unchecked")
        public HashMap() {  // constructor
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLinkedList(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for(int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void reHash() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];
            N = 2 * N;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            // node -> add in new bucket
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }


        public void put(K key, V value) {   // O(lambda) ~ O(1)
            int bi = hashFunction(key);
            int di = searchInLinkedList(key, bi); // valid or -1

            if(di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n/N;
            if(lambda > 2.0) {
                reHash();
            }
        }
        
        public boolean containsKey(K key) { // O(1)
            int bi = hashFunction(key);
            int di = searchInLinkedList(key, bi); // valid or -1

            if(di != -1) {  // valid
                return true;
            } else {
                return false;
            }
        }

        public V remove(K key) {    // O(1)
            int bi = hashFunction(key);
            int di = searchInLinkedList(key, bi); // valid or -1

            if(di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public V get(K key) {   // O(1)
            int bi = hashFunction(key);
            int di = searchInLinkedList(key, bi); // valid or -1

            if(di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 100);
        map.put("Japan", 60);
        map.put("Nepal", 50);

        ArrayList<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println(map.get("India"));
        System.out.println(map.remove("India"));
        System.out.println(map.get("India"));
        System.out.println(map.containsKey("India"));
    }
}


