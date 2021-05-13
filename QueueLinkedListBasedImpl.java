class QueueLinkedListBasedImpl{
    public static void main(String[] args) {
        QueueLL queueLL = new QueueLL();
        System.out.println("Is the stack empty ? True/False: " + queueLL.isEmpty());
        queueLL.enqueue(1);
        queueLL.enqueue(2);
        queueLL.enqueue(3);
        queueLL.enqueue(4);
        queueLL.enqueue(5);
        System.out.println("Is the stack empty ? True/False: " + queueLL.isEmpty());
        queueLL.printQueue();
        queueLL.dequeue();
        queueLL.dequeue();
        queueLL.dequeue();
        queueLL.dequeue();
        queueLL.dequeue();
        System.out.println("Is the stack empty ? True/False: " + queueLL.isEmpty());
        queueLL.dequeue();
        queueLL.front();
        queueLL.enqueue(1);
        queueLL.enqueue(2);
        queueLL.printQueue();
        queueLL.front();
        queueLL.dequeue();
        System.out.println("Is the stack empty ? True/False: " + queueLL.isEmpty());

    }
}
class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class QueueLL{
    public Node front;
    public Node rear;

    public void enqueue(int element){
        Node newNode = new Node(element);
        if(front == null && rear == null){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode; 
        }
    }

    public void dequeue(){
        if(front == null) System.out.println("Queue is empty!");
        else if(front == rear){
            front = rear = null;
        }
        else{
            front = front.next;
        }
    }

    public void front(){
        if(front == null) System.out.println("Queue is empty!");
        else System.out.println("Front of the queue is " + front.data);
    }

    public boolean isEmpty(){
        return (front == null && rear == null);
    }

    public void printQueue(){
        Node current = front;
        while(current!=null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}