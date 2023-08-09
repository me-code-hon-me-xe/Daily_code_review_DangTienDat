package Day28_6_2023.LinkedListUpdate;

import java.util.LinkedList;

public class MyLinkedList_v2 {

    //Connect nodes
    public static void main(String[] args) {
        //  MyLinkedList_v2 myLinkedList = new MyLinkedList_v2();
        //  myLinkedList.addAtStart(5);
        //  myLinkedList.addAtStart(6);

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(one);
        linkedList.add(two);
        linkedList.add(three);
        linkedList.add(four);
        linkedList.add(five);
        linkedList.add(six);
        System.out.println(linkedList.get(0));
    }

    public void addAtStart(int value) {
        Node head = null;
        Node tail = null;
        // Create a new node
        Node newNode = new Node(value);

        // Check if list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // temporarily save the current head to the temp Node
            Node temporary = head;
            // Replace the head node with the new node
            head = newNode;
            // Link the new head node to the temporary node
            head.next = temporary;
        }
        System.out.println(newNode.value);
    }

    static class Node {

        // Initialize the Nodes.
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        Node getNext() {
            return next;
        }
        public String toString(){
            return Integer.toString(value);
        }
    }
}

//Circular Singly LinkedList


