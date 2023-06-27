package Day27_6_2023.LinkedList;

public class MyLinkedList {

    static class Node {

        // Initialize the Nodes.
        int value;
        Node next;
        Node head = null;
        Node tail = null;


        Node(int value) {
            this.value = value;
        }

        Node getNext() {
            return next;
        }

        void addAtStart(int value) {
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
        }
    }


    //Connect nodes
    public static void main(String[] args) {

        Node node = new Node(3);
        node.addAtStart(5);
        System.out.println(node.value);
        System.out.println(node.getNext());


    }
}

//Circular Singly LinkedList


