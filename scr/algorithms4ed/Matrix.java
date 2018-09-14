package algorithms4ed;

import java.util.Random;
import java.lang.StringIndexOutOfBoundsException;

//1.1.33
public class Matrix {
	//点乘
	static double dot(double[] y,double [] x){
		double result=0;
		for(int i=0;i<x.length;i++){
			result+=x[i]*y[i];
		}
		return result;
	}
	
	//矩阵乘法
	static double[][] mult(double[][] a,double[][] b){
		double[][] result=new double[a.length][b[0].length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<b.length;j++){
				for(int k=0;k<a[0].length;k++){
					result[i][j]+=a[i][k]*b[k][j];
				}
			}
		}
		return result;
	}
	
	//转置矩阵
	static double[][] transpose(double[][] a){
		double[][] result=new double[a.length][a[0].length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				result[i][j]=a[j][i];
			}
		}
		return result;
	}
	
	//矩阵和向量之积
	static double[] mult(double[][] a,double[] x){
		double[] result=new double[a.length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				result[i]+=a[i][j]*x[j];
			}
		}
		return result;
	}
	
	//向量和矩阵之积
	static double[] mult(double[] y,double[][] a){
		double[] result=new double[a[0].length];
		for(int i=0;i<y.length;i++){
			for(int j=0;j<a.length;j++){
				result[i]+=y[j]*a[j][i];
			}
		}
		return result;
	}
	
	//乱序
	static <Item>Item[] shuffle(Item[] item){
		Item data;
		int n=item.length;
		int r;
		Item[] temp=(Item[]) new Object[n];
		Random ran=new Random();
		for(int i=0;i<n;i++){
			temp[i]=item[i];
		}
		
		for(int i=n;i>0;i--){
			r=ran.nextInt(i);
			data=temp[r];
			temp[r]=temp[i-1];
			temp[i-1]=data;			
		}
		
		return temp;
	}
	
	//重新调整数组大小
	public static <Item>Item[] resize(Item[] item,int length){
		if(length<item.length){
			throw new StringIndexOutOfBoundsException();
		}
		Item[] data=(Item[]) new Object[length];
		for(int i=0;i<item.length;i++){
			data[i]=item[i];
		}
		return data;
		
	}
	
	//把参数指定的索引处的元素放到数组最后
	public static <Item>Item[] backIndex(Item[] item,int index){
		Item[] data=(Item[]) new Object[item.length];
		for(int i=0;i<index;i++){
			data[i]=item[i];
		}
		data[item.length-1]=item[index];
		for(int i=index;i<item.length-1;i++){
			data[i]=item[i+1];
		}
		return data;
	}
	
	
	
	
	
	
	
	
	
	
}
