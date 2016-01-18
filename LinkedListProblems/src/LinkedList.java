
public class LinkedList {
	
	//no head control inside the class
	public LinkedList() {
		
	}
	
	public Node addToHead(Node head, int data){
		
		if(head == null){
			head = new Node(data);
			return head;
		}
			
		Node n = new Node(data);
		n.next = head;
		head = n;
		
		return head;
		
	}
	
	public Node addToTail(Node head, int data){
		
		if(head == null){
			head = new Node(data);
			return head;
		}
		
		Node curr = head;
		while(curr.next!=null){
			curr = curr.next;
		}
		curr.next = new Node(data);
		
		return head;
	}
	
	
	public Node removeNodeWithData(Node head, int data){
		
		if(head == null )
			return null;
		
		if(head.data == data){
			head = head.next;
			return head;
		}
		
		Node curr = head;
		
		while(curr.next!=null){
			
			if(curr.next.data==data){
				curr.next = curr.next.next;
				//missed this one
				break;
			}
			
			curr = curr.next;
		}
		
		return head;
		
	}
	
	public Node reverseList(Node head){
		
		if(head == null || head.next == null )
			return head;
		
		Node curr = head;
		Node prev = null;
		
		while(curr!=null){
			
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			temp = null;
		}
		
		head = prev;
		
		return head;
		
	}
	
	public Node insertAfter(Node head, Node elem, int data){
		
		Node newEle = new Node(data);
		
		//if elem is null, we assume to insert at the beginning 
		if(elem==null){
			
			newEle.next = head;
			head = newEle;
			return head;
		}
		
		Node curr = head;
		
		while(curr!=null){
			
			if(curr.equals(elem)){
				newEle.next = curr.next;
				curr.next = newEle;
			}
			curr = curr.next;
		}
				
		return head;
	}
	
	public void printLL(Node head){
		if(head==null)
			return;
		
		Node curr = head;
		
		while(curr.next!=null){
			System.out.print(curr.data+"->");
			curr = curr.next;
		}
		System.out.println(curr.data);
	}
	
	
	
	

}
