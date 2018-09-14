package algorithms4ed;
import java.util.*;



public class Josephus {
	private int n;//length or size
	private int numbers;
	private int m;
	private Node first;
	private Node last;
	public Josephus(int a,int b){
		n=0;
		first=null;
		last=null;
		numbers=a;
		m=b;
	}
	//Build a nest node class
	private class Node{
		private Object item;
		private Node next;
		
		//initializing
		public Node(Object data){
			this.item=data;
		}
	}
	
	//add first node
	public Object addFirst(Object data){
		Node newFirst=new Node(data);
		if(n==0){
			first=newFirst;
		}
		else{
			newFirst.next=first;
			first=newFirst;
			//circled
			int size=n;
			last=first;
			while(size>0){
				last=last.next;
				size--;
			}
			last.next=first;
		}
		n++;
		return data;
	}
	
	
	public boolean isEmpty(){return n==0;}
	
	public Object deFirst(){
		if(isEmpty()){
			return null;
		}
		else{
			Object it=first.item;
			first=first.next;
			last.next=first;
			n--;
			return it;
		}
	}
	
	//delete the kth node
	public Object delete(int k){
		if(k>n || k<=0){
			throw new  IndexOutOfBoundsException();
		}
		else if(k==1){
			return deFirst();
		}
		else{
			Object data;
			Node temp=first;
			for(int i=0;i<k-2;i++){
				temp=temp.next;
			}
			data=temp.next.item;
			temp.next=temp.next.next;
			n--;
			return data;
		}
	}
	
	//delete and take place of the first
	public void beFirst(int k){
		if(k>n || k<=1){

		}
		else{
			Node temp=first;
			for(int i=0;i<k-2;i++){
				temp=temp.next;
			}
			last=temp;
			first=last.next;
		}
	}
	public Node get(int index){
		Node temp=first;
		for(int i=0;i<index-1;i++){
			temp=temp.next;
		}
		return temp;
	}
	
	public Node add(Node temp){
		last.next=temp;
		last=temp;
		last.next=first;
		return last;
	}

	//delete all where item==key
	public boolean remove(Object data){
		Node temp=first;
		Node pre=temp;
		int size=n;
		while(size>0){
			if(temp.item!=data){
				pre=temp;
				temp=temp.next;
			}
			else{
				if(n==1){
					first=null;
					n--;
				}
				else{
					pre.next=temp.next;
					temp=pre.next;
					n--;
				}
				return true;
			}
			size--;
		}
		return false;
	}
	public void clear(){
		first=null;
		last=null;
		n=0;
	}
	public int size(){
		return n;
	}
	
	public ArrayList<Integer> solution(){
		if(m>numbers || m<=0){
			throw new IndexOutOfBoundsException();
		}
		ArrayList<Integer> kill=new ArrayList<Integer>(numbers);
		for(int i=numbers;i>0;i--){
			this.addFirst(i);
		}
		while(n>=m){
			this.beFirst(m);
			kill.add((int) this.deFirst());
		}
		ArrayList<Integer> temp=new ArrayList<Integer>(n);
		for(int i=0;i<n;i++){
			temp.add((int) this.get(i+1).item);
		}
		int seat=0,seatno=0;
		int size=n;
		while(size>1){
			for(int count=0;count<size/m;count++){
				for(int i=0;i<size;i++){
					this.add(this.get(i+1));
				}
			}
			for(int i=0;i<m%size;i++){
				this.add(this.get(i+1));					
			}
			seat=(int) this.get(m).item;
			seatno=temp.indexOf(seat);
			kill.add(seat);
			this.clear();
			for(int i=temp.size()-1;i>seatno;i--){
				this.addFirst(temp.get(i));
			}
			for(int i=seatno-1;i>=0;i--){
				this.addFirst(temp.get(i));
			}
			temp.remove(seatno);
			size=this.size();
		}
		kill.add((int) this.get(0).item);
		return kill;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
