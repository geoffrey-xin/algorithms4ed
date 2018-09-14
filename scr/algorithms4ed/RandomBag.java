package algorithms4ed;

import java.util.Iterator;
import java.util.NoSuchElementException;
//1.3.34
public class RandomBag<Item> implements Iterable<Item> {
	private int n;
	private Item[] item=(Item[]) new Object[1];
	
	public RandomBag(){
		n=0;
	}
	
	public boolean isEmpty(){return n==0;}
	
	public int size(){return n;}
	
	public void add(Item data){
		item[n++]=data;
		if(n==item.length){
			item=Matrix.resize(item, 2*n);
		}
	}

	public Iterator<Item> iterator() {
        return new ListIterator(); 
	}
	

    private class ListIterator implements Iterator<Item> {
    	private Item[] iter=(Item[]) Matrix.shuffle(item);
    	private int i=n;
    	
    	public boolean hasNext(){return iter.length>0;}
    	public Item next(){
    		if(!hasNext()){throw new NoSuchElementException();}
    		return iter[--i];}
    	public void remove(){}
    }
	
}
