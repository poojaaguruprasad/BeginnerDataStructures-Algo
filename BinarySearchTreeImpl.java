import java.util.LinkedList;
import java.util.Queue;

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
        System.out.println();
        binarySearchTree.traversePreOrder();
        System.out.println();
        binarySearchTree.traversePostOrder();
        System.out.println();
        binarySearchTree.traverseLevelOrder();
        System.out.println();
        binarySearchTree.insert(8);
        binarySearchTree.insert(6);
        binarySearchTree.insert(17);
        binarySearchTree.insert(14);
        binarySearchTree.traverseInOrder();
        System.out.println();
        binarySearchTree.delete(17);
        binarySearchTree.traverseInOrder();
        System.out.println();
        binarySearchTree.delete(0);
        binarySearchTree.traverseInOrder();
        System.out.println();
        System.out.println("Does the tree contain 8 ? " + binarySearchTree.containsNode(8));
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
        return containsNodeRecursive(root, data);
    }

    private boolean containsNodeRecursive(Node current, int data){
        if(current == null) return false;
        if(data  == current.data) return true;
        return data < current.data 
            ? containsNodeRecursive(current.left, data)
            : containsNodeRecursive(current.right, data);
    }

    //DELETION - returns root node after deletion

    public void delete(int data){
        root = deleteRecursive(root, data);
    }

    public Node deleteRecursive(Node current, int data){
        if(current == null) return current;
        else if(data < current.data){
            current.left = deleteRecursive(current.left, data);
        }else if(data > current.data){
            current.right = deleteRecursive(current.right, data);
        }else{                          // This is the node to be deleted (actual deletion happens here)          
            //CASE 1: NO CHILD NODE
            if(current.left == null && current.right == null){
                return null;            //we just need to replace this node with null in its parent node
            }
            //CASE 2: ONE CHILD NODE    in the parent node, we replace this node with its only child.
            else if(current.left == null){
                current = current.right;
            }
            else if(current.right == null){
                current = current.left;
            }
            //CASE 3: TWO CHILD NODE 

            /**
             * find minimum node in right subtree/max node in left subtree, copy
             * the value in the node to be deleted, and then apply CASE 1 or CASE 2 accordingly.
            **/
            else{
            Node minElementInRightSubTree = findMinElement(current.right);
            current.data = minElementInRightSubTree.data;
            current.right = deleteRecursive(current.right, minElementInRightSubTree.data);
            }
        }
        return current;
    }

    private Node findMinElement(Node current){
        while(current.left != null){
            current = current.left;
        }
        return current;
    }

    //DEPTH FIRST SEARCH

    //General convention is to travel left to right in the tree
    public void traverseInOrder(){
        traverseInOrderRecursive(root);
    }

    public void traverseInOrderRecursive(Node current){
        if(current!=null){
            traverseInOrderRecursive(current.left);
            System.out.print(current.data + " ");
            traverseInOrderRecursive(current.right);
        }
    }

    public void traversePreOrder(){
        traversePreOrderRecursive(root);
    }

    public void traversePreOrderRecursive(Node current){
        if(current!=null){
            System.out.print(current.data + " ");
            traversePreOrderRecursive(current.left);
            traversePreOrderRecursive(current.right);
        }
    }

    public void traversePostOrder(){
        traversePostOrderRecursive(root);
    }

    public void traversePostOrderRecursive(Node current){
        if(current!=null){
            traversePostOrderRecursive(current.left);
            traversePostOrderRecursive(current.right);
            System.out.print(current.data + " ");
        }
    }

    //BREADTH FIRST SEARCH

    public void traverseLevelOrder(){
        traverserLevelOrderUsingQueue(root);
    }

    
    public void traverserLevelOrderUsingQueue(Node rootNode){
        if(rootNode == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);

        while(!queue.isEmpty()){
            Node current = queue.remove();
            System.out.print(current.data + " ");
            if(current.left!=null){
                queue.add(current.left);
            }
            if(current.right!=null){
                queue.add(current.right);
            }
        }
    }

}