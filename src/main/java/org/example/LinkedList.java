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

}
