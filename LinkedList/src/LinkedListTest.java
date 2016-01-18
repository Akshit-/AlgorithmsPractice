public class LinkedListTest {
	
	
	public static void main(String args[]){
		
		LinkedList list = new LinkedList();
		
		list.add("a");
		list.add("b");
		list.add("c");
		
		
		list.add("d");
		list.add("e");
		list.add("f");

		
		list.displayList();
		
		System.out.println();

		
		System.out.println("searching= "+list.search("a").data);

		
		list.removeNode("f");
		
		System.out.println("after del,");
		list.displayList();

		System.out.println("");

		//list.removeFirst();
		

		
		list.reverseList();
		
		
		list.displayList();
		
		
		System.out.println("NEw reverse:");
		
		list.displayList(list.recursiveReverse(list.head));
		
		
		
		LinkedList list1 = new LinkedList();
		list1.add(8);
		list1.add(6);
		list1.add(7);
		list1.add(9);
		list1.add(8);
		
		list1.displayList();

		System.out.println("secondnd list:");
		
		LinkedList list2 = new LinkedList();
		list2.add(4);
		list2.add(6);
		list2.add(5);
		
		list2.displayList();
		
		LinkedList list3 = list1.addList(list1.head, list2.head);
		System.out.println("HERE IS 3rd LIST:");
		list3.displayList();
		
		
		LinkedList reverse = new LinkedList();
		reverse.add(8);
		reverse.add(7);
		reverse.add(6);
		reverse.add(5);

		
		
		reverse.add(4);
		reverse.add(3);
		reverse.add(2);
		reverse.add(1);

		
		reverse.head = reverse.kReverseLinkedList(reverse.head, 3);
		
		
		System.out.println("NEW WAY OF REVERSING!=");
		reverse.displayList();
		
	}
	

}


