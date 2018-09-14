package algorithms4ed;
import java.util.Scanner;

import algorithms4ed.C1S3;
import algorithms4ed.LinkedList;

import java.util.*;
import java.util.Iterator;

import edu.princeton.cs.algs4.*;
//import java.lang.*;

public class compute {
	public static void showArray(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		System.out.print("\n");
	}
	public static <T> void showArray(ArrayList<T> array){
		for(int i=0;i<array.size();i++){
			System.out.print(array.get(i)+"\t");
		}
		System.out.print("\n");
	}
	
	public static void show2DArray(boolean[][] array){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[0].length;j++){
				System.out.print(array[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}

	public static void show2DArray(int[][] array){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[0].length;j++){
				System.out.print(array[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}
	
	public static int getAnInt(){
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int n= Integer.parseInt(scan.nextLine());
		return n;
	}
	
	public static void showData(double a){
		System.out.print(a);
	}
	public static void showData(int a){
		System.out.print(a);
	}
	public static void showData(boolean a){
		System.out.print(a);
	}
	public static void showData(String a){
		System.out.print(a);
	}
	public static void showData(String[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\n");
		}
	}
	
	public static void main(String[] args)
	{
		/*1.1.3
		String result=C1S1.equalOrNot();
		System.out.println(result);
		*/
		
		/*1.1.5
		boolean result=C1S1.inIntervel();
		System.out.println(Boolean.toString(result));
		*/
		
		/*1.1.7
		C1S1.printP7();
		*/
		
		/*1.1.9
		C1S1.changeIntToBinaryString();
		*/
		
		/*1.1.11
		C1S1.printBooleanList();
		*/
		
		/*1.1.14
		//选取的整数以底数取幂之后不能超过long类型的最大长度
		int n=C1S1.getNP14();
		System.out.println("最大正整数是:"+C1S1.lg(n, C1S1.getBaseP14(),n));
		*/
		
		/*1.1.15
		 C1S1.showArray(C1S1.histogram(C1S1.getArrayP15(), C1S1.getMP15()));
		*/
		
		/*1.1.20
		System.out.println(C1S1.lnFact(C1S1.getAnInt()));
		*/
		
		/*1.1.30
		C1S1.show2DArray(C1S1.relativelyPrime(C1S1.getAnInt()));
		*/
		
		/*1.1.36
		C1S1.shuffleTest(C1S1.getAnInt(), C1S1.getAnInt());
		*/
		
		/*1.2.1
		showData(C1S2.randomPoints(getAnInt()));
		*/
		
		/*1.3.4
		showData(C1S3.isMatched());
		*/
		
		/*1.3.9
		C1S3.supplement();
		*/
		
		/*1.3.10
		showData(C1S3.InfixToPostfix());
		*/
		
		/*1.3.11
		showData(C1S3.EvalueatePostfix(C1S3.InfixToPostfix()));
		*/
		
		/*1.3.12
		Stack<String> stack=new Stack<String>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		Stack<String> cop=C1S3.copy(stack);
		for(String s:cop){
			StdOut.print(s);
		}
		for(String s:stack){
			StdOut.print(s);
		}
		*/
		
		/*1.3.37
		int n=getAnInt();
		int m=getAnInt();
		Josephus jose=new Josephus(n,m);
		showArray(jose.solution());
		*/
		
		/*1.3.40
		showData(C1S3.moveToFront(StdIn.readLine()).toString());
		*/
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
}
