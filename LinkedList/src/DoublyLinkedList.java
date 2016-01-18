
public class DoublyLinkedList {
	
	Node head;
	Node tail;
	public DoublyLinkedList() {
		
		head = null;
		head.next = null;
		head.prev = null;
	}
	
	public boolean isEmpty(){
		if(head == null ){
			return true;
		}else{
			return false;
		}
	}
	
	public void add(String data){
		Node node = new Node(data);
				
		
		node.next = head;
		node.prev = null;
		
		head = node;
		
		
		
	}
	
	public Node removeFirst(){
		
		Node temp = head;
		if(!isEmpty())
			head = head.next;
		else
			System.out.println("List is Empty(), cant remove!!");
		
		return temp;
	}
	
	public void displayList(){
		
		Node temp = head;
		
		while(temp!=null){
			System.out.print(temp.data);
			temp = temp.next;
			if(temp!=null)
				System.out.print("->");
		}
		
	}
	
	public Node search(String data){
		
		Node temp = head;
		while(temp!=null){
			if(temp.data==data){
				return temp;
			}
			temp = temp.next;
		}
	
		
		return null;
	}
	
	public void removeNode(Node node){
		
		if(head == node)
			 head = head.next;
		
		node.prev.next = node.next;
		
		
		
		
	}
	
	public class Node {
		
		Object data;
		Node next;
		Node prev;
		
		public Node(Object data){
			this.data = data;
		}
		
	}

}
