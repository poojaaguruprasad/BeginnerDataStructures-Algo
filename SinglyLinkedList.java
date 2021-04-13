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

        theList.insertFirst(11);
        theList.insertFirst(22);
        theList.insertFirst(33);
        theList.insertFirst(44);

        theList.displayList();

        Link newLink = theList.find(33);
        if(newLink!=null){
            System.out.println(" Found Link with key " + newLink.data);
        }
        else{
            System.out.println("Can't find Link!");
        }

        Link deletedLink = theList.delete(22);
        if(deletedLink!=null){
            System.out.println(" Deleted Link Link with key " + deletedLink.data);
        }
        else{
            System.out.println("Can't find Link with that key to delete!");
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

    public Link find(int key){
        Link current = head;
        while(current.data != key){
            if(current.next == null){
                return null;
            }else{
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key){
        Link current = head;
        Link previous = head;
        while(current.data!=key){
            if(current.next == null){
                return null;
            }else{
                previous = current;
                current = current.next;
            }
        } 
            if(current == head){
                head = head.next;
            }
            else{
                previous.next = current.next;
            }
        return current;
    }

}
