public class LinkedListTasks {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class SinglyLinkedList {
        Node head;

        // 1. Add to beginning
        void addFirst(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        // 2. Add to end
        void addLast(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        // 3. Remove last
        void removeLast() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            if (head.next == null) {
                head = null;
                return;
            }
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }

        // 4. Print all elements
        void printList() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // 5. Search element
        boolean search(int key) {
            Node temp = head;
            while (temp != null) {
                if (temp.data == key) {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }

        // 6. Insert at position
        void insertAtPosition(int data, int position) {
            if (position < 0) {
                System.out.println("Invalid position");
                return;
            }

            if (position == 0) {
                addFirst(data);
                return;
            }

            Node newNode = new Node(data);
            Node temp = head;
            for (int i = 0; temp != null && i < position - 1; i++) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Position out of range");
                return;
            }

            newNode.next = temp.next;
            temp.next = newNode;
        }

        // 7. Remove by value
        void removeByValue(int value) {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            if (head.data == value) {
                head = head.next;
                return;
            }

            Node temp = head;
            while (temp.next != null && temp.next.data != value) {
                temp = temp.next;
            }

            if (temp.next == null) {
                System.out.println("Value not found");
                return;
            }

            temp.next = temp.next.next;
        }

        // 8. Combine two lists
        void combine(SinglyLinkedList other) {
            if (head == null) {
                head = other.head;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = other.head;
        }

        // 9. Reverse list
        void reverse() {
            Node prev = null;
            Node current = head;
            Node next = null;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            head = prev;
        }

        // 10. Sort list (insertion sort)
        void sort() {
            Node sorted = null;
            Node current = head;

            while (current != null) {
                Node next = current.next;
                sorted = insertSorted(sorted, current);
                current = next;
            }

            head = sorted;
        }

        private Node insertSorted(Node sorted, Node newNode) {
            if (sorted == null || newNode.data <= sorted.data) {
                newNode.next = sorted;
                return newNode;
            }

            Node temp = sorted;
            while (temp.next != null && temp.next.data < newNode.data) {
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next = newNode;
            return sorted;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
       //1
        list1.addFirst(10);
        list1.addFirst(5);
       //2
        list1.addLast(20);
        list1.addLast(15);

        //3
        System.out.println("List 1:");
        list1.printList();

        //4
        System.out.println("Search 20: " + list1.search(20));

        //5
        list1.insertAtPosition(12, 2);
        System.out.println("After insert at position 2:");
        list1.printList();

        //6
        list1.removeByValue(10);
        System.out.println("After remove value 10:");
        list1.printList();

        //7
        list1.removeLast();
        System.out.println("After remove last:");
        list1.printList();

        //8
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.addLast(100);
        list2.addLast(200);

        list1.combine(list2);
        System.out.println("After combine:");
        list1.printList();


        //9
        list1.reverse();
        System.out.println("After reverse:");
        list1.printList();

        //10
        list1.sort();
        System.out.println("After sort:");
        list1.printList();
    }
}