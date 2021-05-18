class CircularSinglyLinkedListImpl {
    public static void main(String[] args){
        CircularLL circularLL = new CircularLL();
        circularLL.insertToEmptyList(1);
        circularLL.insertAtBeginning(2);
        circularLL.insertAtBeginning(4);
        circularLL.insertAtEnd(3);
        circularLL.insertAfterGivenPosition(2, 5);
        circularLL.insertAtEnd(6);
        circularLL.insertAtEnd(7);
        circularLL.insertAtEnd(8);
        circularLL.printList();
        circularLL.deleteFirstNode();
        circularLL.printList();
        circularLL.deleteLastNode();
        circularLL.printList();
        circularLL.deleteAtGivenPosition(4);
        circularLL.printList();
        circularLL.deleteAtGivenPosition(1);
        circularLL.printList();
        circularLL.deleteAtGivenPosition(3);
        circularLL.printList();
    }
}

class Node{

    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }

}

class CircularLL{

    //tail is the pointer to the last node of the linkedlist
    Node tail;

    public void insertToEmptyList(int element){
        Node newNode = new Node(element);
        newNode.next = newNode;
        tail = newNode;
    }
    
    public void insertAtBeginning(int element){
        Node newNode = new Node(element);
        newNode.next = tail.next;
        tail.next = newNode;
    }

    public void insertAtEnd(int element){
        Node newNode = new Node(element);
        newNode.next = tail.next;
        tail.next = newNode;
        tail = tail.next;
    }

    public void insertAfterGivenPosition(int givenPosition, int element){  //assumes position != 0 i.e LL is not empty
        Node head = tail.next;
        while(givenPosition > 1){
            head = head.next;
            givenPosition--;
        }
        if(head == tail)insertAtEnd(element);
        else{
            Node newNode = new Node(element);
            newNode.next = head.next;
            head.next = newNode;
        }
    }

    public void deleteFirstNode(){
        if(tail == null)return;
        else if(tail == tail.next){
            tail = null;
        }else{
            Node head = tail.next;
            tail.next = head.next;
            head = null;
        }
    }

    public void deleteLastNode(){
        if(tail == null)return;
        if(tail.next == null){
            tail = null;
        }
        Node current = tail.next;
        while(current.next!=tail){
            current = current.next;
        }
        current.next = tail.next;
        tail = current;
    }

    public void deleteAtGivenPosition(int givenPosition){     //assumes given position is intermediary and not last
        if(tail == null) return;
        else if(tail.next == tail && givenPosition == 1)tail = null;
        else if(givenPosition == 1) {
            deleteFirstNode();
        }else{
        Node current = tail.next;
        Node givenNode;
        int count = 1;
        while(count < givenPosition-1){
            current = current.next;
            count++;
        }
        givenNode = current.next;
        current.next = givenNode.next;
        givenNode.next = null;
      }
    }

    public void printList(){
        Node head = tail.next;
        do{
          System.out.print(head.data + " ");
          head = head.next;
        }while(head!=tail.next);
        System.out.println();
    }

}

