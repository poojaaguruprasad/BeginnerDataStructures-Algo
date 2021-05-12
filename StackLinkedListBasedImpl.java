class StackLinkedListBasedImpl{
    public static void main(String[] args) {
        StackLL stackLL = new StackLL();
        System.out.println("Is the stack empty ? True/False: " + stackLL.isEmpty());
        stackLL.push(1);
        stackLL.push(2);
        stackLL.push(3);
        stackLL.push(4);
        stackLL.push(5);
        System.out.println("Is the stack empty ? True/False: " + stackLL.isEmpty());
        stackLL.printStack();
        stackLL.pop();
        stackLL.pop();
        stackLL.pop();
        System.out.println("Is the stack empty ? True/False: " + stackLL.isEmpty());
        stackLL.printStack();
    }    
}
class Node{
    
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class StackLL{

    private Node top;

    public boolean isEmpty(){
        return (top == null);
    }

    public void push(int element){
        Node newNode = new Node(element);
        if(top == null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
    }

    public void pop(){
        if(top == null)return;
        else{
            top = top.next;
        }
    }

    public void printStack(){
        Node current = top;
        while(current!=null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
}
