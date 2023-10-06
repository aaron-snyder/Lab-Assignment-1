// Author: Aaron Snyder
// Lab Assignment 1

class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /*
	   pre-order traversal
	   Prints the value of every node preorder
	   */
	   public void preOrderTraversal(Node root){
			// Base case
			if (root == null) {
				return;
			}
			
			// Print value and a comma to seperate
			System.out.print(root.value + ", ");

			// Recursively go down left of node
			preOrderTraversal(root.left);

			// Recursively go down right of node
			preOrderTraversal(root.right);
	   }

	   
	   
	   /*
	   in-order traversal
	   */
	   public void inOrderTraversal(Node root){
			// Base case
			if (root == null) {
				return;
			}

			// Go down left tree
			inOrderTraversal(root.left);

			// Print value with comma to seperate
			System.out.print(root.value + ", ");

			// Go down right tree
			inOrderTraversal(root.right);
	   }
	   
	   
	   
	   /*
	   post-order traversal
	   */
	  
	   public void postOrderTraversal(Node root){
			// Base case
			if (root == null) {
				return;
			}

			// Go down left tree
			postOrderTraversal(root.left);

			// Go down right tree
			postOrderTraversal(root.right);

			// Print value with comma to seperate
			System.out.print(root.value + ", ");
	   }
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a specific value
	   */
	   public boolean find(Node root, int key){

			boolean result = false;
			// Base case
			if (root == null) {
				return false;
			}

			// Return case
			if (root.value == key) {
				return true;
			}

			// Search right if key is greater than node, left if less than
			if (root.value < key) {
				result = find(root.right, key);
			} else {
				result = find(root.left, key);
			}
			
			return result;
	   }
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a smallest key
	   */
	   public int getMin(Node root){
			int min = 0;
			return min;
	   }
	  
	  
	  
	   /*
	   a method to find the node in the tree
	   with a largest key
	   */
	   public int getMax(Node root){
			int max = 0;
			return max;
	   }
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemo{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
		  System.out.println("Pre-Order Traversal: ");
		  t1.preOrderTraversal(t1.root);
		  System.out.println("In-Order Traversal: ");
		  t1.inOrderTraversal(t1.root);
		  System.out.println("Post-Order Traversal: ");
		  t1.postOrderTraversal(t1.root);
	      System.out.println("Find: 90");
	      System.out.println(t1.find(t1.root, 90));
		  System.out.println("Find 91: ");
		  System.out.println(t1.find(t1.root, 91));
	           
	      
	   }  
	}
