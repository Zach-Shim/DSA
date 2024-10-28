import java.util.Arrays;

public class HashMap<K, V> implements MyMap<K, V> {

    private final int INIT_CAPACITY = 101;
    private Node[] elements;
    private int size;

    static class Node<K,V> implements MyMap.Entry<K,V> {
        int hash;
        K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final K setKey(K key)        { this.key = key; return key; }
        public final V getValue()      { return value; }
        public final V setValue(V value)        { this.value = value; return value; }

        public final String toString() { return key + "=" + value; }
        public final int hashCode() { return key.hashCode() ^ value.hashCode(); }
    }

    public HashMap() {
        elements = new Node[INIT_CAPACITY];
    }

 /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     *         (A <tt>null</tt> return can also indicate that the map
     *         previously associated <tt>null</tt> with <tt>key</tt>.)
     */
    public V put(K key, V value) {
        int idx = hash(key);
        Node<K, V> current = elements[idx];
        while (current != null)
        {
            if (equals(key, current.key))
            {
                V r = current.value;
                current.value = value;
                return r;
            }
            else
                current = current.next;
            }
    }


}
