package algorithms4ed;
import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Stack;

import java.util.Iterator;

import algorithms4ed.LinkedList;

import java.util.*;
import java.lang.*;

public class C1S3 {
	public class FixedCapacityStackOfStrings{
		private String[] a;
		private int N;
		public FixedCapacityStackOfStrings(int cap){
			a=new String[cap];
		}
		public boolean isEmpty(){return N==0;}
		public int size(){return N;}
		public void push(String item){
			a[N++]=item;
		}
		public String pop(){
			return a[--N];
		}
	}
	
	//1.3.4
	public static boolean isMatched(){
		String[]s;
		String left;
		boolean matched=false;
		Stack<String> parentheses=new Stack<String>();
		s=StdIn.readString().split("");
		if(s.length<2){
			return matched;
		}
		else{
			for(int i=0;i<s.length;i++){
				if(s[i].equals("(") || s[i].equals("[") || s[i].equals("{")){
					parentheses.push(s[i]);				
				}
				else{
					left=parentheses.pop();
					String parenthesis=left+s[i];
					if(parenthesis.equals("()") || parenthesis.equals("[]") || parenthesis.equals("{}")){
						matched=true;
					}
					else{
						matched=false;
						break;
					}
				}
			}
			return matched;
		}
	}
	
	//1.3.9
	public static void supplement(){
		String[] s=StdIn.readString().split("");
		int startIndex=s.length,lcount=1;
		int[] num=new int[(int) s.length/2];
		Stack<String> result=new Stack<String>();
		for(int i=s.length-1;i>=0;i--){
			if(s[i].equals(")")){
				startIndex=i;
				break;
			}
			else{
				result.push(s[i]);
			}
		}
		
		for(int i=startIndex;i>=0;i--){
			if(s[i].equals(")")){
				result.push(s[i]);
				lcount+=1;
				num[lcount]=0;
			}
			else{
				result.push(s[i]);
				num[lcount]+=1;
				while(num[lcount]==3){
					result.push("(");
					lcount-=1;
					num[lcount]+=1;
				}
			}
		}
		if(num[lcount]==3){
			result.push("(");
		}
		for(String re:result){
			StdOut.print(re);
		}
	}
	
	//1.3.10
	public static boolean isOp(String s){
		if(s.equals("+") || s.equals("-") || s.equals("*") ||s.equals("/")){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean isLp(String s){
		if(s.equals("(")){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean isRp(String s){
		if(s.equals(")")){
			return true;
		}
		else{
			return false;
			}
		}
	public static boolean isLowerOp(String a,String b){
		if((a.equals("+") || a.equals("-")) && (b.equals("*") || b.equals("/"))){
			return true;
		}
		else{
			return false;
		}
	}
	public static String InfixToPostfix(){
		String result="";
		String[] expr=StdIn.readString().split("");
		Stack<String> op=new Stack<String>();
		for(int i=0;i<expr.length;i++){
			if(isLp(expr[i])){
				op.push(expr[i]);
			}
			else if(isOp(expr[i])){
				while(!op.isEmpty() && !isLp(op.peek()) && !isLowerOp(op.peek(),expr[i]) ){
					result+=op.pop();
				}
				op.push(expr[i]);
			}
			else if(isRp(expr[i])){
				while(!op.isEmpty() && !isLp(op.peek())){
					result+=op.pop();
				}
				if(isLp(op.peek())){
					op.pop();
				}
			}
			else{
				result+=expr[i];
			}
		}
		while(!op.isEmpty()){
			result+=op.pop();
		}
		return result;
	}
	
	//1.3.11
	public static boolean isPlus(String s){
		if(s.equals("+")){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean isMinus(String s){
		if(s.equals("-")){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean isTimes(String s){
		if(s.equals("*")){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean isDivides(String s){
		if(s.equals("/")){
			return true;
		}
		else{
			return false;
		}
	}
	public static double EvalueatePostfix(String expr){
		String[] postExpr=expr.split("");
		Stack<String> result=new Stack<String>();
		double a,b;
		for(int i=0;i<postExpr.length;i++){
			if(isOp(postExpr[i])){
				b=Double.parseDouble(result.pop());
				a=Double.parseDouble(result.pop());
				if(isPlus(postExpr[i])){
					result.push(Double.toString(a+b));
				}
				if(isMinus(postExpr[i])){
					result.push(Double.toString(a-b));
				}
				if(isTimes(postExpr[i])){
					result.push(Double.toString(a*b));
				}
				if(isDivides(postExpr[i])){
					result.push(Double.toString(a/b));
				}
			}
			else{
				result.push(postExpr[i]);
			}
		}
		return Double.parseDouble(result.pop());
	}
	
	//1.3.12
	public static <Item>Stack<Item> copy(Stack<Item> stack){
		int N=stack.size();
		Stack<Item> copy=new Stack<Item>();
		Item[] item=(Item[]) new Object[N];
		for(int i=0;i<N;i++){
			item[N-i-1]=(Item) stack.pop();
		}
		for(int i=0;i<N;i++){
			copy.push(item[i]);
			stack.push(item[i]);
		}
		return copy;
	}
	
	//1.3.14
	public  class ResizingArrayQueue<Item> implements Iterable<Item>{
		private Item[] item=(Item[]) new Object[1];
		private int N=0;
		public boolean isEmpty(){return N==0;}
		public int size(){return N;}
		private void resize(int max){//move the queue to a new one with the size max
			if(max<N){
				throw new IllegalArgumentException(Integer.toString(max)+"must be more than"+Integer.toString(N));
			}
			else{
				Item[] temp=(Item[]) new Object[max];
				for(int i=0;i<N;i++){
					temp[i]=item[i];
				}
			}
		}
		public void enqueue(Item a){
			if(N==item.length) resize(2*N);//Actually N+1 is also feasible.
			item[N++]=a;
		}
		public Item dequeue(){
			Item temp= item[0];
			for(int i=0;i<N-1;i++){
				item[i]=item[i+1];
			}
			item[N-1]=null;
			if(N>0 && N==item.length/4) resize(item.length/2);
			return temp;
		}		
		public Iterator<Item> iterator(){
			return new QueueArrayIterator();
		}
		public class QueueArrayIterator implements Iterator<Item>{
			private int i=0;
			public boolean hasNext(){return N>i;}
			public Item next(){return item[++i];}
			public void remove(){	}
		}
	}
	
	//1.3.40
	public static LinkedList moveToFront(String reads){
		LinkedList list=new LinkedList();
		String[] read=reads.split("");
		for(int i=0;i<read.length;i++){
			list.remove((Object) read[i]);
			list.addFirst(read[i]);
		}
		return list;
	}
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
