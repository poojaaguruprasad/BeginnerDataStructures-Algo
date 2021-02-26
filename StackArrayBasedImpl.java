//Driver code
class StackArrayBasedImpl{
    public static void main(String[] args) {

        Stack theSatck = new Stack(10);

        //push
        theSatck.push(10);
        theSatck.push(20);
        theSatck.push(30);
        theSatck.push(40);
        theSatck.push(50);
        theSatck.push(60);
        theSatck.push(70);

        //peek
        System.out.println("Topmost element in the stack is " + theSatck.peek());
        System.out.println("Is the stack full? - " + theSatck.isFull());

        //Deleting each element
        while(!theSatck.isEmpty()){
            System.out.println("Element popped from the stack "+ theSatck.pop());
        }

        System.out.println("Is the stack empty now? - " + theSatck.isEmpty());

        //Overflow scenario
        for(int i=1;i<=11;i++){
            try{
                theSatck.push(i);
                System.out.println("Element inserted " + i);
            }catch(Exception ex){
                System.out.println("The Following exception was caught "+ ex);
            }          
        }   
    }
}

class Stack{

    private int top;                        //stack top
    private int maxSize;                    //max limit of the stack
    private int[] stackArray;

    public Stack(int maxSize){              //constructor
        this.maxSize = maxSize;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int itemToBeInserted){
        if(top >= maxSize-1){
            System.out.println("Stack Overflow");
        }
        stackArray[++top] = itemToBeInserted;
    }

    public int pop(){
        if(top == -1){
            System.out.println("Stack Underflow");
        }
        return stackArray[top--];
    }

    public int peek(){
        System.out.println("When the stack is empty peek returns -1 else returns the stack top");
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize-1);
    }
}
