package Day11_7_2023.LinkedList;

import java.util.LinkedList;

public class DifferenceSLLandDLL {
    private static class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    private static class DoublyNode{
        int value;
        DoublyNode prev;
        DoublyNode next;
        DoublyNode(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        //Singly linked list traversal
        Node singlyHead = createSinglyLinkedList();
        System.out.println("Singly Linked List traversal: ");
        traverseSinglyLinkedList(singlyHead);

        // Doubly Linked List traversal
        DoublyNode doublyHead = createDoublyLinkedList();
        System.out.println("\nDoubly Linked List traversal:");
        reversedTraverseDoublyLinkedList(doublyHead);
    }
    private static Node createSinglyLinkedList(){
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        head.next = second;
        second.next = third;

        return head;
    }

    private static void traverseSinglyLinkedList(Node head){
        Node current = head;
        while(current != null){
            System.out.println(current.value + " ");
            current = current.next;
        }
    }

    private static DoublyNode createDoublyLinkedList(){
        DoublyNode head = new DoublyNode(1);
        DoublyNode second = new DoublyNode(2);
        DoublyNode third = new DoublyNode(3);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;

        return third;
    }

    private static void traverseDoublyLinkedList(DoublyNode head){
        DoublyNode current = head;
        while(current != null){
            System.out.println(current.value + " ");
            current = current.next;
        }
    }

    private static void reversedTraverseDoublyLinkedList(DoublyNode tail){
        DoublyNode current = tail;
        while(current != null){
            System.out.println(current.value + " ");
            current = current.prev;
        }
    }

}
