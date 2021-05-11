class DoublyLinkedList {
    public static void main(String[] args){
        DLinkList dlinklist = new DLinkList();
        dlinklist.addElementAtFront(1);
        dlinklist.addElementAtEnd(2);
        dlinklist.addElementAtFront(0);
        dlinklist.addElementAtEnd(3);
        dlinklist.addElementAtEnd(4);
        dlinklist.printList();
        dlinklist.addElementAtEnd(5);
        dlinklist.addElementAtEnd(6);
        dlinklist.printList();
        dlinklist.deleteNode(0);  //head
        dlinklist.printList();
        dlinklist.deleteNode(3); //middle
        dlinklist.printList();
        dlinklist.deleteNode(6); //tail
        dlinklist.printList();
        dlinklist.addElementBeforeGivenNode(dlinklist.head, 0);
        dlinklist.printList();
        dlinklist.addElementAfterGivenNode(dlinklist.head.next, 5);
        dlinklist.printList();
        dlinklist.addElementAfterGivenNode(dlinklist.head.next.next.next.next.next, 6);
        dlinklist.printList();
    }
}
class Node{
    int data;
    Node next;
    Node prev;

    public Node(int data){
        this.data = data;
    }
}
class DLinkList{

    Node head; 
    /**The entry point into a linked list is called the head of the list. 
    It should be noted that head is not a separate node, but the reference to the first node. 
    If the list is empty then the head is a null reference.**/

    public void addElementAtFront(int element){
        Node newNode = new Node(element);
        newNode.next = head;
        newNode.prev = null;

        if(head!=null){
            head.prev = newNode;
        }

        head = newNode;
    }

    public void addElementAtEnd(int element){
        if(head == null){
            addElementAtFront(element);
        }
        Node newNode = new Node(element);
        Node current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
        
    }

    public void addElementBeforeGivenNode(Node givenNode, int element){ //assumes head is not null
        Node newNode = new Node(element);
        if(head == givenNode){
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        Node current = head.next;
        Node previous = head;
        while(current!=null){
            if(current == givenNode){
                newNode.prev = previous;
                previous.next = newNode;
                newNode.next = current;
                current.prev = newNode;
            }
            previous = current;
            current = current.next;
        }
    }

    public void addElementAfterGivenNode(Node givenNode, int element){ //assumes head is not null
        Node newNode = new Node(element);
        if(head.next==null && head == givenNode){
            newNode.prev = head;
            head.next = newNode;
        }
        if(head.next==null && head != givenNode){
            System.out.println("givenNode does not exists!");
        }
        Node current = head.next;
        Node nextNode = current.next;
        while(current.next!=null){
            if(current == givenNode){
                newNode.prev = current;
                current.next = newNode;
                newNode.next = nextNode;
                nextNode.prev = newNode;
            }
            current = current.next;
            nextNode = current.next;
        }

        if(current.next == null && current == givenNode){
            newNode.prev = current;
            current.next = newNode;
        }
        
    }

    public void deleteNode(int data){
        
        if(head.data == data){
            head = head.next;
        }
        Node current = head.next;
        Node previous = head;
        while(current.next!=null){
            if(current.data == data){
                current.next.prev = current.prev;
                previous.next = current.next;
            }
            previous = current;
            current = current.next;
        }

        if(current.next == null && current.data == data){
            current.prev = null;
            previous.next = null;
        }

    }

    public void printList(){
        Node current = head;
        while(current!=null){
            System.out.print(current.data + " <==> ");
            current = current.next;
        }
        System.out.println("null ");
    }

}
