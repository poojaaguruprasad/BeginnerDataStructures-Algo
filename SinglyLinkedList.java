class SinglyLinkedList {
    public static void main(String[] args){
        LinkList theList = new LinkList();
        theList.insertFirst(10);
        theList.insertFirst(20);
        theList.insertFirst(30);
        theList.insertFirst(40);

        theList.displayList();

        while(!theList.isEmpty()){
           Link temp = theList.deleteFirst();
           System.out.print("Deleted ");
           temp.displayLink();
           System.out.println("");
        }

        theList.displayList();
    }
}

class Link{
    public int data;
    public Link next;

    public Link(int data){
        this.data = data;
    }

    public void displayLink(){
        System.out.print("{ " + data + " } " );
    }
}

class LinkList{

    private Link head;

    public LinkList(){
        head = null;
    }

    public boolean isEmpty(){
        return (head == null);
    }

    public void insertFirst(int data){
        Link newLink = new Link(data);
        newLink.next = head;
        head = newLink;
    }

    public Link deleteFirst(){
        Link temp = head;
        head = head.next;
        return temp;
    }

    public void displayList(){
        Link current = head;
        while(current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
