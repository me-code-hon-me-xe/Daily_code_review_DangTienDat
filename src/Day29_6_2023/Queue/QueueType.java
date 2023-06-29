package Day29_6_2023.Queue;

import java.util.*;

public class QueueType {
    // Queue has 3 class implementation

//
//    // Array implementation of Queue
//    static Queue<String> arrayDeque = new ArrayDeque<>();
//
//    // Priority Queue implementation of Queue
//    static Queue<Integer> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args){
        // Priority Queue implementation of Queue
        java.util.Queue<Integer> priorityQueue = new PriorityQueue<>();
        Main(priorityQueue, "PriorityQueue");

        // Array implementation of Queue
        java.util.Queue<Integer> arrayDeque = new ArrayDeque<>();
        Main(arrayDeque, "ArrayDeque");

        // LinkedList implementation of Queue
        java.util.Queue<Integer> linkedList = new LinkedList<>();
        Main(linkedList, "LinkedList");

    }

    static void Main(java.util.Queue type, String nameType){
        type.add(51);
        type.offer(6);
        type.add(72);
        type.add(1);
        type.add(2);
        type.offer(3);
        type.offer(4);
        type.add(11);
        type.add(19);
        System.out.println(nameType + ":" );
        System.out.println("Elements in the queue: " + type);
        System.out.println("Queue after being polled out: ");
        while(!type.isEmpty()){
            System.out.print(type.poll() + " ");
        }
        System.out.println("Elements in the queue: " + type + "\n");
    }
}
