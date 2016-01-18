import java.util.ArrayList;
import java.util.LinkedList;


public class BinarySearchTree {

	
	public class Node{
		int key;
		String name;
		
		Node parent;
		Node left;
		Node right;
		
		public Node(int key, String name){
			this.key = key;
			this.name = name;
			this.left = null;
			this.right = null;
			this.parent = null;
		}
		@Override
		public String toString(){
			return key + " has key: " + name;
		}
	}
	
	Node root;
	
	public BinarySearchTree(int key, String name){
		this.root = new Node(key, name);
	}
	
	public Node getRootNode(){
		return root;
	}
	
	public Node addNode(Node node, int key, String name){
				
		if(node==null){
			node = new Node(key, name);
			
		}else{
			
			if(key < node.key){
				Node temp = addNode(node.left, key, name);;
		
				node.left = temp;
				temp.parent = node;
				
			}
			else{
				Node temp = addNode(node.right, key, name);
				node.right = temp;
				temp.parent = node;
				
			}
		}	
		
		return node;
		
	}
	
	public Node findNode(Node node, int key){
		if(node==null)
			return null;
		
		if(node.key == key)
			return node;
		
		
		if(key<node.key)
			return findNode(node.left, key);
		else
			return findNode(node.right, key);
		
	}
	
	public Node findMin(Node node){
		
		if(node.left==null)
			return node;
		
		return findMin(node.left);
		 
	}
	
	public Node findMax(Node node){
		
		if(node.right==null)
			return node;
		
		return findMax(node.right);
		 
	}
	
	public void findPreAndSuc(Node root, int key, Node pred, Node suc){
		
		if(root==null)
			return;
		
		if(key == root.key){
			
			if(root.left!=null){
				Node temp = root.left;
				while(temp.right!=null)
					temp = temp.right;
				pred = temp;
				System.out.println("pred: "+pred);

			}else{
				System.out.println("predL: "+ pred );
			}
			
			if(root.right!=null){
				Node temp = root.right;
				while(temp.left!=null)
					temp = temp.left;
				suc = temp;
				System.out.println("suc: "+suc);

			}else{
				System.out.println("sucL: "+ suc );
			}
		}
		
		if(key < root.key){
			suc = root;
			findPreAndSuc(root.left, key, pred, suc);
		}else{
			pred = root;
			findPreAndSuc(root.right, key, pred, suc);
		}
		 
		
	}
	
	
	public Node deleteNode(Node root, int key){
		
		if(root==null)
			return root;
		
		if(key == root.key){
			
			if(root.left!=null && root.right!=null){
				//Node temp = root.right;
				
				Node del = findMin(root.right);
				
				root.key = del.key;
				root.name = del.name;
				
	            System.out.println("1. del: "+del);

				
				root.right = deleteNode(root.right, del.key);
				
				
			} else if (root.left == null){			
	            System.out.println("2. root: "+root.right);
	            
	            return root.right;
	        
			}else if(root.right == null){
	            System.out.println("3. root: "+root.left);
	        	
	        	return root.left;
	        }
			
		} else if(key < root.key){
			root.left = deleteNode(root.left, key);
		} else{
			root.right = deleteNode(root.right, key);		
		}
		 
		return root;
		
	}
	
	public void inOrderTraversal(Node node){
		
		if(node == null)
			return;
		
		inOrderTraversal(node.left);
		System.out.println(node);
		inOrderTraversal(node.right);
		
	}
	
	
	public 	void listLinkedListByLevels(Node root){
		
		int height = getHeightAt(root);
		
		ArrayList<LinkedList<Integer>> arrayLL = new ArrayList<LinkedList<Integer>>();

		for(int d = 1; d<=height; d++){
			LinkedList<Integer> list = new LinkedList<Integer>();
			System.out.println("At level="+d);
			list = printTreeLevelByLevel(root, d, list);
			arrayLL.add(d-1, list);
			
		}
		
		
		System.out.println("what about now: "+arrayLL);
		
		
	}
	
	private LinkedList<Integer> printTreeLevelByLevel(Node root, int level, LinkedList<Integer> list) {

		if(root == null)
		    return null;
		
		if(level==1){
			System.out.print(root.key+", ");
			list.add(root.key);
		}else if(level>1){
			
			printTreeLevelByLevel(root.left, level-1, list);
			printTreeLevelByLevel(root.right, level-1, list);
			
			
		}
		
		System.out.println();

		return list;
		
	}

	public int getHeightAt(Node root){
		
		if(root==null)
			return 0;
		
		return Math.max(getHeightAt(root.left), getHeightAt(root.right)) + 1;
		
		
	}
	
	public int getLcaInBT(Node root, int node1, int node2){
		
		if(root==null)
			return -1;
		
		if((root.key==node1) || (root.key == node2))
			return root.key;
		
		int value = findNodesOnLeft(root.left, node1, node2);
		System.out.println("value="+value);
		if(value==0){
			return root.key;
		}else if(value==1){
			return getLcaInBT(root.left, node1, node2);
		}
			
		
		return getLcaInBT(root.right, node1, node2);
	
		
	}

	private int findNodesOnLeft(Node root, int node1, int node2) {
		
		if(root==null)
			return -1;
		
		boolean val = findNodeAt(root, node1);
		boolean val2 = findNodeAt(root, node2);
		
		System.out.println("value inside="+val);

		
		if(val && val2){
			return 1;
		} else if(val || val2){
			return 0;
		}
		
		return -1;
	}
	
	private boolean findNodeAt(Node root, int node) {

		if(root==null)
			return false;
		
		if(root.key==node)
			return true;
		
		return (findNodeAt(root.left, node) || findNodeAt(root.right, node)) ? true:false;

	
	}
	
	
}
