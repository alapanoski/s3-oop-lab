import java.util.Scanner;

import javax.swing.SwingConstants;

class Node {
	int data;
	Node prev, next;

	Node(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

class DoublyLinkedList {

	Node head;

	DoublyLinkedList(Node head) {
		this.head = head;
	}

	void print() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		Node node = head;
		while (node.next != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println(node.data);
	}

	void insertAtEnd(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node ptr = head;
		while (ptr.next != null)
			ptr = ptr.next;
		Node node = new Node(data);
		ptr.next = node;
		node.prev = ptr;
	}

	void insertAtBegining(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			return;
		}
		node.next = head;
		head.prev = node;
		head = node;
	}

	void insert(int i, int data) {
		if (i == 0) {
			Node node = new Node(data);
			if (head == null) {
				head = node;
			}
			node.next = head;
			head.prev = node;
			head = node;
			return;
		}
		int index = 0;
		Node ptr = head;
		while (index < i) {
			if (ptr.next == null)
				return;
			ptr = ptr.next;
			index++;
		}
		ptr = ptr.prev;
		Node node = new Node(data);
		node.prev = ptr;
		node.next = ptr.next;
		ptr.next.prev = node;
		ptr.next = node;
	}

	void deleteLastNode() {
		if (head == null)
			return;
		if (head.next == null) {
			head = null;
			return;
		}
		Node ptr = head;
		while (ptr.next != null)
			ptr = ptr.next;
		ptr.prev.next = null;
	}

	void deleteFirstNode() {
		if (head == null)
			return;
		if (head.next == null) {
			head = null;
			return;
		}
		head = head.next;
	}

	void delete(int i) {
		if (i == 0) {
			if (head == null)
				return;
			if (head.next == null) {
				head = null;
				return;
			}
			head = head.next;
			return;
		}
		if (head == null)
			return;
		int index = 0;
		Node ptr = head;
		while (index < i) {
			if (ptr.next == null)
				return;
			ptr = ptr.next;
			index++;
		}

		ptr = ptr.prev;

		ptr.next = ptr.next.next;
		ptr.next.prev = ptr;
	}
}

public class DLL {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		DoublyLinkedList dll = new DoublyLinkedList(null);

		System.out.println("Avialable operations are");
		System.out.println("INSERT FRONT <value>");
		System.out.println("INSERT END <value>");
		System.out.println("INSERT <index> <value>");
		System.out.println("DELETE FRONT");
		System.out.println("DELETE END");
		System.out.println("DELETE <index>");
		System.out.println("PRINT");
		System.out.println("EXIT");
		String ch;
		do {
			ch = scanner.nextLine();
			String[] input = ch.split(" ");
			if (input[0].equals("INSERT")) {
				if (input[1].equals("FRONT")) {
					dll.insertAtBegining(Integer.parseInt(input[2]));
				} else if (input[1].equals("END")) {
					dll.insertAtEnd(Integer.parseInt(input[2]));
				} else {
					dll.insert(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
				}
			} else if (input[0].equals("DELETE")) {
				if (input[1].equals("FRONT")) {
					dll.deleteFirstNode();
				} else if (input[1].equals("END")) {
					dll.deleteLastNode();
				} else {
					dll.delete(Integer.parseInt(input[1]));
				}
			} else if (input[0].equals("PRINT")) {
				dll.print();
			} else {
				System.out.println("Invalid input");
			}
		} while (!ch.equals("EXIT"));
	}
}
