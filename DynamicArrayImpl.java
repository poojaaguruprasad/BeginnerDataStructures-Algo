class DynamicArrayImpl {
    public static void main(String[] args){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addAtEnd(1);
        dynamicArray.addAtEnd(2);
        dynamicArray.addAtEnd(3);
        dynamicArray.addAtEnd(4);
        dynamicArray.addAtEnd(5);
        dynamicArray.printArray();
        dynamicArray.addAtGivenIndex(2, 6);
        dynamicArray.printArray();
        dynamicArray.addAtGivenIndex(6, 7);
        dynamicArray.printArray();
        dynamicArray.removeLastElement();
        dynamicArray.printArray();
        dynamicArray.removeElementAtGivenPosition(2);
        dynamicArray.printArray();
        dynamicArray.decreaseArraySize();
        dynamicArray.printArray();
    }
}
class DynamicArray{

    int size;
    int[] baseArray;
    int count;

    public DynamicArray(){
        size = 1;
        baseArray = new int[1];
        count = 0;
    }


    public void addAtEnd(int element){
        if(count >= baseArray.length){
            baseArray = increaseArraySize();
        }
        baseArray[count] = element;
        count++;
        System.out.println("Element " + element +  " added at index " + count + " successfully!");
    }

    public void addAtGivenIndex(int index, int element){     //assumes that the index size is within the double the size range
        if(count >= baseArray.length){
            baseArray = increaseArraySize();
            
        }
        if(index >= count){
            baseArray[index] = element;
        }
        else{
            for(int i=count-1;i>=index;i--){
                baseArray[i+1] = baseArray[i];
            }
            baseArray[index] = element;
        }   
        count++;
    }

    public void removeLastElement(){
        if(count > 0){
            baseArray[count-1] = 0;
            count--;
        }
    }

    public void removeElementAtGivenPosition(int index){
        if(count > 0){
            for(int i = index; i<count;i++){
                baseArray[i] = baseArray[i+1];
            }
            baseArray[count] = 0;
            count--;
        }
    }

    public int[] increaseArraySize(){
        int[] temp = new int[baseArray.length * 2];
        for(int i=0; i<baseArray.length; i++){
            temp[i] = baseArray[i];
        }
        size = size*2;
        return temp;
    }

    public void decreaseArraySize(){
        int[] temp = new int[count];
        for(int i=0;i<count;i++){
            temp[i] = baseArray[i];
        }
        size = count;
        baseArray = temp;   
    }

    public void printArray(){
        for(int i=0;i<baseArray.length;i++){
            System.out.print(baseArray[i]+ " ");
        }
        System.out.println();
    }

}
