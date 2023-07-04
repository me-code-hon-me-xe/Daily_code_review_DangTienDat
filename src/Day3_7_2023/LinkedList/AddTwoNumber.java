package Day3_7_2023.LinkedList;

public class AddTwoNumber {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(3);


        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(3);

        AddTwoNums addTwoNumber = new AddTwoNums();
        addTwoNumber.add(listNode1, listNode2);
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    static class Traverse{
        void print(ListNode head){
            ListNode current = head;

            while(current != null){
                System.out.print(current.val + " " );
                current = current.next;
            }
        }
    }

    static class AddTwoNums {
        void add(ListNode l1, ListNode l2){// l1 = 2, l2 = 2
            ListNode temp = new ListNode(0); // temp = 0
            int carry = 0;
            ListNode current = temp; // current = 0
            while(l1 != null || l2 != null || carry != 0){
                int num1;
                int num2;
                if(l1 != null){
                    num1 = l1.val; //num1 = 2
                }else{
                    num1 = 0;
                }
                if(l2 != null){
                    num2 = l2.val; //num2 = 2
                }else{
                    num2 = 0;
                }
                int sum = num1 + num2 + carry; // sum = 4
                current.next = new ListNode(sum % 10); // current.next = 4
                current = current.next; // current = 4
                carry = sum/10; // carry = 0
                if(l1 != null)
                    l1 = l1.next; // l1 = 3

                if(l2 != null)
                    l2 = l2.next; // l1 = 3
            }
            Traverse traverse = new Traverse();
            traverse.print(temp);
        }
    }

}
