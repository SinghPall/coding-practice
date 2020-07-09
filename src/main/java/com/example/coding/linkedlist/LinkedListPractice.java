package com.example.coding.linkedlist;
class LinkedList{
	Node head = null;
	class Node{
		int data;
		Node next;
		Node(int v){ data = v; next = null;}
	}
	public void insertNode(int d){
		Node newNode = new Node(d);
		newNode.next = head;
		head = newNode;
	}
	public void printNodes(){
		if(head == null) System.out.println("List is empty");
		Node temp=head;
		
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	public void removeAllDuplicates(){
		if(head == null) System.out.println("List is empty");
		Node curr = head, prev = new Node(0);
		while(curr != null && curr.next != null){
			if(curr.data == curr.next.data){
				prev = curr;
				curr.next = curr.next.next;
			}curr = curr.next;
		}
		
	}
}
public class LinkedListPractice {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();	
		list.insertNode(13); 		list.insertNode(23); 		list.insertNode(45);
		list.insertNode(44); 		list.insertNode(44); 		list.insertNode(66);
		list.insertNode(23); 		list.insertNode(13); 		list.insertNode(13);
		list.printNodes(); list.removeAllDuplicates(); 
		System.out.println();
		list.printNodes();
	}

}
