//Driver code
class QueueWithnitems{
    public static void main(String[] args) {
        Queue theQueue = new Queue(5);

        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);
        theQueue.insert(90);
        theQueue.insert(100);

        theQueue.remove();
        theQueue.remove();

        //wraparound

        System.out.println("Number of items in the Queue "+ theQueue.size());

        theQueue.insert(80);
        theQueue.insert(90);

        System.out.println("Number of items in the Queue "+ theQueue.size());
        
        while(!theQueue.isEmpty()){
            int n = theQueue.remove();
            System.out.println(n);
        }
    }
}
//circular queue covered
class Queue{
    
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int maxSize){
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(int itemToBeInserted){
        if(isFull()){
            System.out.println("Queue is full!");
            return;
        }
        if(rear == maxSize-1){ //wraparound when queue is not full or isFull check can be removed and value in the front can be overriden
            rear = -1;          // (rear+1)%maxSize -> should also work for wraparound
        }
        queueArray[++rear] = itemToBeInserted;
        nItems++;
    }

    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is empty!");
            return 0;
        }
        int temp = queueArray[front++];
        if(front == maxSize){   //wraparound when queue is not full
            front = 0;
        }
        nItems--;
        return temp;
    }

    public int peekFront(){
        return queueArray[front];
    }

    public boolean isEmpty(){
        return (nItems==0);
    }

    public boolean isFull(){
        return (nItems == maxSize);
    }

    public int size(){
        return nItems;
    }
}