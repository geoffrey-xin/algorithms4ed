package algorithms4ed;
import java.lang.Iterable;
import java.util.Random;
import java.util.Iterator;
import java.util.NoSuchElementException;
//1.3.35
public class RandomQueue<Item> implements Iterable<Item>{
	private int n;
	private Item[] item=(Item[]) new Object[1];
	
	public RandomQueue(){
		n=0;
	}
	
	public boolean isEmpty(){
		return n==0;
	}
	
	public void enqueue(Item data){
		item[n++]=data;
		if(n==item.length){
			item=Matrix.resize(item, 2*n);
		}
	}
	
	public Item dequeue(){
		Random ran=new Random();
		int r=ran.nextInt(n);
		Item temp=item[r];
		item[r]=item[n-1];
		item[n-1]=null;
		n--;
		return temp;
	}
	
	public Item sample(){
		Random ran=new Random();
		int r=ran.nextInt(n);
		return item[r];
	}
	
	private class ListIterator implements Iterator<Item>{
    	private Item[] iter=(Item[]) Matrix.shuffle(item);
    	private int i=n;
    	public ListIterator(){}
    	public boolean hasNext(){return iter.length>0;}
    	public Item next(){
    		if(!hasNext()){throw new NoSuchElementException();}
    		return iter[--i];}
    	public void remove(){}
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	

	
}
