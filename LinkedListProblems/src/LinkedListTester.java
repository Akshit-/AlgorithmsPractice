
public class LinkedListTester {

	public static void main(String[] args) {

		LinkedList l = new LinkedList();
		
		Node head1 = null;
		head1 = l.addToHead(head1, 8);
		head1 = l.addToHead(head1, 8);
		head1 = l.addToHead(head1, 2);
								
		
		Node head2 = null;
		head2 = l.addToHead(head2, 4);
		head2 = l.addToHead(head2, 4);
		head2 = l.addToHead(head2, 3);
		head2 = l.addToTail(head2, 9);
		head2 = l.addToTail(head2, 9);
		head2 = l.addToTail(head2, 8);


		System.out.print("L1:");
		l.printLL(head1);
		System.out.print("L2:");
		l.printLL(head2);
		
		Node head3 = add2LL(head1, head2);
				 
		System.out.print("sum:");
		l.printLL(head3);
		
		
		
		
		
	}
	
	
	// 2-4-6 + 3-6-2: result = 5-0-9
	public static Node add2LL(Node head1, Node head2){

		Node p1 = head1;
		Node p2 = head2;
		int carry = 0; //initial carry is 0
		
		Node head3 = new Node(-1);
		Node p3 = head3;
		
		while(p1!=null ||  p2!=null){
			
			int sum = 0;
			
			if(p1!=null){
				sum+=p1.data;
				p1 = p1.next;
			}
			if(p2!=null){
				sum+=p2.data;
				p2 = p2.next;
			}
			
			sum += carry;
			int num = sum%10;
			
			Node n = new Node(num);
			p3.next = n;
			p3 = n;
			
			carry = sum/10; //carry for next node
			
		}
		
		head3 = head3.next; //skipping dummy node (-1)
				 		
		return head3;
		
	}

}
