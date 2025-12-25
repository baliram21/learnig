package org.nayan.dsa.linkedlist;

public class LinkedList1 {

    Node head;
    class Node{
        String data;
        Node next;

        Node(String data){
            this.data=data;
            this.next=null;
        }

    }
    public void addFirst(String data){
        Node newNode= new Node(data);

        if (head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    public static void main(String[] args) {
        LinkedList1 list1 = new LinkedList1();
        list1.addFirst("is");
        list1.addFirst("a");

        System.out.println(list1.head);
    }
}
