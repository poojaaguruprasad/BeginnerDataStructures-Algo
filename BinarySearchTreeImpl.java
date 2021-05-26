class BinarySearchTreeImpl {

    public static void main(String[] args){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(0);
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(5);
        binarySearchTree.insertIterative(-1);
        binarySearchTree.insertIterative(7);
        binarySearchTree.insertIterative(7);
        binarySearchTree.traverseInOrder();
    }
    
}

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }
}

class BinarySearchTree{

    Node root;

    //INSERTION

    public void insert(int element){
        root = insertRecursive(root, element);
    }

    private Node insertRecursive(Node root, int element){
        if(root == null){
            return new Node(element);
        }

        if(element < root.data){
            root.left = insertRecursive(root.left, element);
        }else if(element > root.data){
            root.right = insertRecursive(root.right, element);
        }else{
            return root; //(duplicate)
        }

        return root;
    }

    public Node insertIterative(int data){

        Node newNode = new Node(data);

        if(root == null){
            return newNode;
        }

        Node parent = null; 
        Node current = root;

        while(current!=null){
            parent = current;
            if(data < current.data){
                current = current.left;
            }else if(data > current.data){
                current = current.right;
            }else{
                return current;                 //if duplicate we handle here
            }
        }

        if(data < parent.data){            
            parent.left = newNode;
        }else{
            parent.right = newNode;
        }

        return root;

    }


    //FIND ELEMENT
     
    public boolean containsNode(int data){

    }

    private boolean containsNodeRecursive(int data){

    }

    //DELETION

    public void delete(int data){

    }

    //DEPTH FIRST SEARCH

    public void traverseInOrder(){
        traverseInOrderWithCurrent(root);
    }

    public void traverseInOrderWithCurrent(Node current){
        if(current!=null){
            traverseInOrderWithCurrent(current.left);
            System.out.print(" " + current.data);
            traverseInOrderWithCurrent(current.right);
        }
    }

    public void traversePreOrder(Node current){

    }

    public void traversePostOrder(Node current){

    }

    //BREADTH FIRST SEARCH
    public void traverserLevelOrder(){



    }

}