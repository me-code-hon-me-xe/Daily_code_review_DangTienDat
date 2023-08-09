package Day14_7_2023.HashMapInternalStrucutre;

import java.util.LinkedList;

public class HashMapBuildByHand<K,V> {
    private static int size = 16;
    private LinkedList<Entry<K, V>>[] buckets;
    public HashMapBuildByHand(){
        buckets = new LinkedList[size];

    }
    public void put(K key, V value){
        int bucketIndex = key.hashCode() % size;
        LinkedList<Entry<K, V>> bucket = new LinkedList<>();
        buckets[bucketIndex] = bucket;
        for (Entry<K, V> entry: bucket
             ) {
            if(entry.getKey().equals(key)){
                entry.setValue(value);
                return;
            }
        }

    }


    private class Entry<K, V>{
        private K key;
        private V value;
        private Entry<K,V> next;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }
}
