import java.util.ArrayList;
import java.util.LinkedList;

import javax.print.attribute.standard.Finishings;


public class BSTTester {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree(50, "Akshit");
		
		bst.addNode(bst.getRootNode(), 20, "Obama");
		bst.addNode(bst.getRootNode(), 80, "Romney");
		
		bst.addNode(bst.getRootNode(), 60, "Who60");
		bst.addNode(bst.getRootNode(), 90, "Who90");
		
		bst.addNode(bst.getRootNode(), 10, "Who10");
		bst.addNode(bst.getRootNode(), 30, "Who30");
		bst.addNode(bst.getRootNode(), 25, "Who25");		
		bst.addNode(bst.getRootNode(), 70, "Who75");	
		bst.addNode(bst.getRootNode(), 35, "Who35");		


		
		bst.inOrderTraversal(bst.getRootNode());
		
		System.out.println("finding: "+bst.findNode(bst.getRootNode(), 20).parent);
		
		
		System.out.println("Min ="+ bst.findMin(bst.getRootNode()));
		System.out.println("Max ="+ bst.findMax(bst.getRootNode()));
		
		
		bst.findPreAndSuc(bst.getRootNode(), 30, null, null);

		bst.deleteNode(bst.getRootNode(), 30);
		
		bst.inOrderTraversal(bst.root);
		
		
		
		BinarySearchTree bst2 = new BinarySearchTree(50, "Akshit");
		
		bst2.addNode(bst2.getRootNode(), 20, "Obama");
		bst2.addNode(bst2.getRootNode(), 80, "Romney");
		
		bst2.addNode(bst2.getRootNode(), 60, "Who60");
		bst2.addNode(bst2.getRootNode(), 90, "Who90");
		
		bst2.addNode(bst2.getRootNode(), 10, "Who10");
		bst2.addNode(bst2.getRootNode(), 30, "Who30");
		bst2.addNode(bst2.getRootNode(), 25, "Who25");		
		bst2.addNode(bst2.getRootNode(), 70, "Who75");	
		bst2.addNode(bst2.getRootNode(), 35, "Who35");	

		bst2.listLinkedListByLevels(bst2.root);

		System.out.println("lca="+bst2.getLcaInBT(bst2.root, 20, 30));
		
	}

}
