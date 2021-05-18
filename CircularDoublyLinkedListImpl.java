class CircularDoublyLinkedListImpl {
    public static void main(String[] args){
        CircularDLL circularDLL = new CircularDLL();
        circularDLL.insertToEmptyList(1);
        circularDLL.printList();
        circularDLL.insertAtBeginning(2);
        circularDLL.printList();
        circularDLL.insertAtBeginning(3);
        circularDLL.printList();
        circularDLL.insertAtEnd(4);
        circularDLL.printList();
        circularDLL.insertAfterGivenPosition(2, 5);
        circularDLL.printList();
        circularDLL.insertAfterGivenPosition(1, 6);
        circularDLL.printList();
        circularDLL.insertAfterGivenPosition(6, 7);
        circularDLL.printList();
        circularDLL.deleteFirstNode();
        circularDLL.printList();
        circularDLL.deleteLastNode();
        circularDLL.printList();
        circularDLL.deleteAtGivenPosition(3);
        circularDLL.printList();
    }
}

class Node{
    int data;
    Node prev;
    Node next;

    public Node(int data){
        this.data = data;
    }
}

class CircularDLL{

    Node tail;

    public void insertToEmptyList(int element){
        Node newNode = new Node(element);
        newNode.prev = newNode;
        newNode.next = newNode;
        tail = newNode;
    }

    public void insertAtBeginning(int element){
        if(tail == null){
            insertToEmptyList(element);
            return;
        } 
        Node head = tail.next;
        Node newNode = new Node(element);
        newNode.next = head;
        newNode.prev = tail;
        head.prev = newNode;
        tail.next = newNode;
    }

    public void insertAtEnd(int element){
        if(tail == null){
            insertToEmptyList(element);
            return;
        }
        Node newNode = new Node(element);
        Node head = tail.next;
        newNode.next = head;
        newNode.prev = tail;
        head.prev = newNode;
        tail.next = newNode;
        tail = newNode;
    }

    public void insertAfterGivenPosition(int givenPosition, int element){ //assumes given position is not 0 (insert at beginning case)
        Node current = tail.next;
        Node newNode = new Node(element);
        int count = 1;
        while(count!=givenPosition){
            current = current.next;
            count++;
        }
        if(current == tail){
            insertAtEnd(element);
            return;
        }
        newNode.next = current.next;
        current.next.prev = newNode;
        current.next = newNode;
        newNode.prev = current;
    }

    public void deleteFirstNode(){
        if(tail == null) return;
        Node head = tail.next;
        if(head == tail){
            tail = null;
            return;
        }
        tail.next = head.next;
        head.next.prev = tail;
        head = null;
    }

    public void deleteLastNode(){
        if(tail == null)return;
        Node temp = tail.prev;
        if(temp == tail) {
            tail = null;
            return;
        }
        temp.next = tail.next;
        tail.next.prev = temp;
        tail = temp;
    }

    public void deleteAtGivenPosition(int givenPosition){
        if(tail == null) return;
        else if(tail.next == tail && givenPosition == 1)tail = null;
        else if(givenPosition == 1) {
            deleteFirstNode();
        }else{
            Node current = tail.next;
            Node givenNode;
            int count = 1;
            while(count<givenPosition-1){
                current = current.next;
                count++;
            }
            givenNode = current.next;
            current.next = givenNode.next;
            givenNode.next.prev = givenNode.prev;
        }
    }

    public void printList(){
        if(tail == null){
            System.out.println("Empty List!");
            return;
        }
        Node head = tail.next;
        do{
          System.out.print(head.data + " ");
          head = head.next;
        }while(head!=tail.next);
        System.out.println();
    }

}
