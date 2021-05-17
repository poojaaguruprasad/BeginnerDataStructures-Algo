class CircularSinglyLinkedListImpl {
    public static void main(String[] args){
        CircularLL circularLL = new CircularLL();
        circularLL.insertToEmptyList(1);
        circularLL.insertAtBeginning(2);
        circularLL.insertAtBeginning(4);
        circularLL.insertAtEnd(3);
        circularLL.insertAfterGivenPosition(2, 5);
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

    }

    public void deleteLastNode(){

    }

    public void deleteAtGivenPosition(int givenPosition){

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

