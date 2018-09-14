package algorithms4ed;
import java.lang.*;

public class CircledLinkedList {
	private int n;//length or size
	private Node first;
	private Node last;
	public CircledLinkedList(){
		n=0;
		first=null;
		last=null;
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
	
	//delete the last node
	/*
	public Object deLast(){
		if(isEmpty()){
			return null;
		}
		else if(n==1){
			Object it=first.item;
			first=null;
			n--;
			return it;
		}
		else{
			Node temp=new Node(null);
			Object it;
			for(Node x=first;x.next!=null;x=x.next){
				temp=x;
			}
			it=temp.next.item;
			temp.next=null;
			n--;
			return it;
		}
	}
	*/
	
	public Object deFirst(){
		if(isEmpty()){
			return null;
		}
		else{
			Object it=first.item;
			first=first.next;
			last.next=first.next;
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
	
	//find the kth node
	public boolean find(Object data){
		Node temp=first;
		int size=n;
		while(size>0){
			if(temp.item.equals(data)){
				return true;
			}
			else{
				temp=temp.next;
			}
			size--;
		}
			return false;		
	}
	
	//delete the node after the parameter
	public Node removeAfter(Node current){
		if(current!=null && current.next!=null && current.next.next!=null){
			Node temp=current.next;
			current.next=current.next.next;
			n--;
			return temp;
		}
		return null;
	}
	
	//insert a node to the parameter
	public boolean insertAfter(Node current,Node insert){
		if(current!=null && current.next!=null){
			Node temp=current.next;
			current.next=insert;
			insert.next=temp;
			n++;
			return true;
		}
		return false;
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
	
	//return the max integer, if every item is an integer.
	public Object max(){
		Object data;
		Node temp;
		temp=first;
		data=first.item;
		int size=n;
		while(size>0){
			if((int) temp.item> (int) data){
				data=temp.item;
			}
			temp=temp.next;
			size--;
		}
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
