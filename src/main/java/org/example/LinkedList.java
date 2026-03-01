package org.example;

import java.util.Stack;

public class LinkedList {
    public static Node insertionInLinkedList(Node head, int value, int position) {
        Node newNode = new Node(value);

        // Case 1: Insert at beginning
        if (position == 1) {
            newNode.next = head;
            return newNode;
        }

        // Case 2: Empty list but position > 1
        if (head == null) {
            return null; // invalid position
        }

        Node temp = head;

        // Traverse to node before insertion point
        for (int place = 1; place < position - 1 && temp.next != null; place++) {
            temp = temp.next;
        }

        // Insert node
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }
    public boolean hasCycle(Node head) {
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null ){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)return true;
        }
        return false;
    }
    public Node reverseDLL(Node head) {
        // If list is empty or has one element, return it
        if (head == null || head.next == null) {
            return head;
        }

        // Stack to store node values
        Stack<Integer> st = new Stack<>();

        // Pointer to traverse list
        Node temp = head;

        // Push all node data to stack
        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }

        // Reset temp to head
        temp = head;

        // Replace node values from stack
        while (temp != null) {
            temp.data = st.pop();
            temp = temp.next;
        }

        // Return updated head
        return head;
    }
    /// added sample line
    //sorry for the day
    public boolean hasCycleLoop(Node head) {
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null ){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)return true;
        }
        return false;
    }
    public Node detectCycle(Node head) {
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null ){
            fast=fast.next.next;
            slow=slow.next;
            if (slow == fast) {   // cycle found

                // Step 2: Find cycle start
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;  // start node of cycle
            }
        }

        return null;
    }
    public int findCycleLength(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {  // Cycle detected
                int length = 1;
                Node temp = slow.next;

                while (temp != slow) {
                    length++;
                    temp = temp.next;
                }

                return length;
            }
        }

        return 0; // No cycle
    }
    public boolean isPalindrome1(Node head) {
        StringBuilder sb=new StringBuilder();
        Node temp = head;
        while(temp!=null){
            sb.append(temp.data);
            temp=temp.next;
        }
        String original = sb.toString();
        String reversed = new StringBuilder(sb).reverse().toString();
        if(original.equals(reversed))return true;
        return false;
    }
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node prev = null;
        while (slow != null) {
            Node next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // Step 3: Compare first and second half
        Node first = head;
        Node second = prev;

        while (second != null) {
            if (first.data != second.data) return false;
            first = first.next;
            second = second.next;
        }

        return true;
    }
}
