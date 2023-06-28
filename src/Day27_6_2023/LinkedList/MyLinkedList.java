package Day27_6_2023.LinkedList;

public class MyLinkedList {

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



    //Connect nodes
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtStart(5);
        myLinkedList.addAtStart(6);
    }
}

//Circular Singly LinkedList


