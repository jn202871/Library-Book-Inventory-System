package Library;
import java.io.*;
public class BinarySearchTree{
    private LibNode root;

    public BinarySearchTree(){
        root = null;
    }

    public boolean isEmptyTree(){
        return root == null;
    }

    public LibNode search(int key){
        return searchr(root,key);
    }

    private LibNode searchr(LibNode node, int key){
        if (node==null){
            return null;
        } else if (key == node.getKey()){
            return node;
        } else if (key < node.getKey()){
            return searchr(node.getLeft(),key);
        } else {
            return searchr(node.getRight(),key);
        }

    }

    public void insert(LibNode x){
        LibNode temp = root;
        LibNode parent = null;

        while (temp != null){
            parent=temp;
            if (x.getKey()<temp.getKey()){
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        if (parent==null){
            root = x;
        } else if (x.getKey() < parent.getKey()){
            parent.setLeft(x);
        } else {
            parent.setRight(x);
        }
    }

    public void printTree() {
	printTree2(root);
	System.out.println();
    }

    private void printTree2(LibNode tree){
	if (tree != null) {
	    System.out.print(tree.getKey() + " ");
            if (tree.getLeft() != null)
	        System.out.print("Left: " + tree.getLeft().getKey() + " ");
            else
                System.out.print("Left: null ");
            if (tree.getRight() != null)
	        System.out.println("Right: " + tree.getRight().getKey() + " ");
            else
                System.out.println("Right: null ");
	    printTree2(tree.getLeft());
	    printTree2(tree.getRight());
	}
    }

    public void delete(int key){
        root = deleter(root,key);
    }

    private LibNode deleter(LibNode node, int key){
        if (node == null) {
            return null;
        }

        if (key < node.getKey()) {
            node.setLeft(deleter(node.getLeft(), key));
        } else if (key > node.getKey()) {
            node.setRight(deleter(node.getRight(), key));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
            	LibNode temp = node;
            	node = minKey(node.getRight()); // Find Inorder Successor
            	temp.setRight(deleter(temp.getRight(), node.getKey()));
            	node.setRight(temp.getRight());
            	node.setLeft(temp.getLeft());
            }
        }

        return node;
    }

    private LibNode minKey(LibNode x){
        while (x.getLeft() != null){
            x = x.getLeft();
        }
        return x;
    }
    
    public void traverse(){
        traverser(root);
        System.out.println();
    }

    private void traverser(LibNode root){
        if (root != null){
            traverser(root.getLeft());
            System.out.println(root.getName());
            traverser(root.getRight());
        }
    }

    public void write(PrintStream writer) {
        write(root, "", writer);
        writer.close();

  }

   private void write(LibNode root, String code, PrintStream writer) {
          if(root != null) {
              if(root.getLeft() == null && root.getRight() == null) {
                  write(root.getLeft(), code, writer);
                  write(root.getRight(), code, writer);

              }
              writer.println(root.getData() + "\n");
              write(root.getLeft(), code, writer);
              write(root.getRight(), code, writer);
                     // recursive-case 

          }
      }
}
