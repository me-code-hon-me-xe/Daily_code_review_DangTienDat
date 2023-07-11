package Day11_7_2023.Project;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class LRUCache {
    private HashMap<Integer, Node> map;
    private int capacity, count;
    private Node head, tail;
    private Book bookList;
    public LRUCache(int capacity){
        this.capacity = capacity;
        bookList = new
        map = new HashMap<>();
        head = new Node()
    }


}
class Node {
    String key;
    Book value;
    Node pre;
    Node next;

    public Node(String key, Book value)
    {
        this.key = key;
        this.value = value;
    }
}
