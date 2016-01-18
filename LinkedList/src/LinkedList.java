/**
 * Linked List API
 * @author akshit
 *
 */
public class LinkedList {
	
	Node head;
	Node tail;
	public LinkedList() {
		
		head = null;
		tail = null;
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
				
		//tail = head.next;
		
		node.next = head;
		head = node;
		
		
		
	}
	public void add(int data){
		Node node = new Node(data);
				
		//tail = head.next;
		
		node.next = head;
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
	
	public void displayList(Node h){
		
		Node temp = h;
		
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
	
	public Node removeNode(String data){
		
		Node current = head;
		
		if(head.data == data){
			head = head.next;
			return head;
		}
		
		while(current.next!=null){
			
			if(current.next.data==data){
				current.next = current.next.next;
				break;
			}
			current = current.next;	
		}
		return head;
	}
	
	public void reverseListAnother(){
		
		Node curr = head;
		Node prev = null;
		
		while(curr!=null){
			
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			
		}
		
		head = prev;
		
	}
	
	
	public void reverseList(){
		
		Node p = head;
		
		Node second = null;
		
		while(p!=null){
			Node q = new Node(p);
			
			q.next = second;
			
			second = q;
		
			p = p.next;
			
								
		}
				
		head = second;
		
	}
	
//	 public static Node addTwoNumbers(Node l1, Node l2) {
//	       int carry =0;
//	 
//	        Node p1 = l1, p2 = l2;
//	        Node p3 = new Node((int)0);
//	        
//	       // Node finallisthead = new Node((int)0);
//	       
//	        Node thisoneisshit = new Node((int)10);
//	        
//	        thisoneisshit.next = p3;
//	        
//	        while(p1 != null || p2 != null){
//	            if(p1 != null){
//	                carry += (int)p1.data;
//	                p1 = p1.next;
//	            }
//	 
//	            if(p2 != null){
//	                carry += (int)p2.data;
//	                p2 = p2.next;
//	            }
//	            
//	            
//	            p3.next = new Node(carry%10);
//	            
//	            p3 = p3.next;
//	            carry /= 10;
//	        }
//	 
//	        if(carry==1) 
//	            p3.next=new Node((int)1);
//	 
//	        return thisoneisshit.next;
//	    }
//	
	
	public Node kReverseLinkedList(Node head, int k){
		
		if(head==null) return null;
		
		if(head.next==null) return head;
		
		Node current = head;
		Node next = null;
		Node prev = null;
		
		int count = 0;
				
		while (current != null && count < k)
	    {
	
			System.out.println("At, count="+count+" prev="+prev+", current="+current+", next="+next);
			
			next  = current.next;
		   current.next = prev;
		   prev = current;
		   current = next;
		   count++;
	    }
		
		System.out.println("At, count="+count+" prev="+prev+", current="+current+", next="+next);
		if(next!=null){
			head.next = kReverseLinkedList(next, k);
		}
		
		
		
		return prev;
	}
	
	
	
	public LinkedList addList(Node head1, Node head2){
		
		Node curr1 = head1;
		Node curr2 = head2;
				
		LinkedList newlist = new LinkedList();
		
//		newlist.add((int)curr1.data);
		
		
		while(curr1!=null && curr2!=null){
			int data = (int)curr1.data + (int)curr2.data;			
			System.out.println("data="+data);
			if((int)data>=10){
				
				if(curr1.next==null && curr2.next!=null){
					curr2.next.data = (int)curr2.next.data + data/10;
					newlist.add(data % 10);
					newlist.add((int)curr2.next.data);
					
				}else if(curr2.next==null && curr1.next!=null){
					curr1.next.data = (int)curr1.next.data + data/10;
					newlist.add(data%10);
					newlist.add((int)curr1.next.data);
					
				}else if(curr2.next!=null && curr1.next!=null){
					curr1.next.data = (int)curr1.next.data + data/10;
					newlist.add(data%10);
				}
					
			}else{
			
				newlist.add(data);
			}	
			curr1 = curr1.next;
			curr2 = curr2.next;
		
		}
		
		while(curr1!=null){
			newlist.add((int)curr1.data);
			curr1 = curr1.next;
		}
		while(curr2!=null){
			
			System.out.println("curr2data="+curr2.data);
			newlist.add((int)curr2.data);
			curr2 = curr2.next;
		}
		
		
		newlist.reverseList();
		return newlist;
	}
	
	public Node recursiveReverse(Node p){
		
		if(p==null) return null;
		
		if(p.next==null) 
			return p;
				
		Node rest = p.next;
			
		p.next = null;
		
		Node reverseRest = recursiveReverse(rest);
		
		rest.next = p;
		
		return reverseRest;
	}
	
	public class Node {
		
		Object data;
		Node next;
		
		public Node(Object data){
			this.data = data;
			next = null;
		}
		
		public String toString(){
			return data.toString();
		}
		
	}

}
