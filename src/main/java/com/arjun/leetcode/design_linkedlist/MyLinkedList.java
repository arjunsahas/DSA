class MyLinkedList {

    private Node head = null;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node curr = head;
        int count = 0;
        while (curr != null) {
            if (count == index) return curr.val;
            count++;
            curr = curr.next;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = head;
        head = n;
        print();
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node n = new Node(val);
        Node curr = head;
        Node tail = null;
        while (curr != null) {
            tail = curr;
            curr = curr.next;
        }
        tail.next = n;
        print();
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        Node curr = head;
        int count = 0;
        Node prev = null;
        if (index == 0) {
            Node n = new Node(val);
            n.next = curr;
            head = n;
            return;
        }
        if (curr != null) {
            while (curr != null) {
                if (count == index) {
                    Node n = new Node(val);
                    prev.next = n;
                    n.next = curr;
                    return;
                }
                count++;
                prev = curr;
                curr = curr.next;
            }
        }
        int listLength = count;
        if (listLength == index) {
            Node n = new Node(val);
            prev.next = n;
        }
        print();
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        Node curr = head;
        int count = 0;
        Node prev = null;
        while (curr != null) {
            if (count == index) {
                if (index == 0)
                    head = head.next;
                else prev.next = curr.next;
                break;
            }
            count++;
            prev = curr;
            curr = curr.next;
        }
        print();
    }

    private void print() {
        Node curr = head;
        System.out.println("Printing ...");
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */