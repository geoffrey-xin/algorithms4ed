package algorithms4ed;

import edu.princeton.cs.algs4.*;


public class C1S2 {
	//1.2.1
	public static double randomPoints(int N){
		int ran;
		double rand;
		Point2D[] points =new Point2D[N];
		for(int i=0;i<N;i++){
			rand=StdRandom.uniform(0.0, 4.0);
			ran=(int) rand;
			switch(ran){
			case 0:
				points[i]=new Point2D(rand,0);
				break;
			case 1:
				points[i]=new Point2D(1,rand-1);
				break;
			case 2:
				points[i]=new Point2D(3-rand,1);
				break;
			case 3:
				points[i]=new Point2D(0,4-rand);
				break;
			}
		}
		double[][] dists=new double[N][N];
		double[] allDists=new double[N*(N-1)/2];
		for(int i=1;i<N;i++){
			for(int j=0;j<i;j++){
				dists[i][j]=points[i].distanceTo(points[j]);
				allDists[i*(i-1)/2+j]=dists[i][j];
			}
		}
		double min=StdStats.min(allDists);
		return min;
	}
	
	//1.2.16
	public class Rational{
		private final int numerator,denominator;
		public Rational(int num,int de){
			numerator=num;
			denominator=de;
		};
		public int getNum(){
			return numerator;
		}
		public int getDe(){
			return denominator;
		}
		public Rational plus(Rational b){
			int num2,de2,numResult,deResult;
			num2=b.getNum();
			de2=b.getDe();
			numResult=numerator*de2+num2*denominator;
			deResult=denominator*de2;
			Rational result=new Rational(numResult,deResult);
			return result;
		}
		public Rational minus(Rational b){
			int num2,de2,numResult,deResult;
			num2=b.getNum();
			de2=b.getDe();
			numResult=numerator*de2-num2*denominator;
			deResult=denominator*de2;
			Rational result=new Rational(numResult,deResult);
			return result;			
		}
		public Rational times(Rational b){
			int num2,de2,numResult,deResult;
			num2=b.getNum();
			de2=b.getDe();
			numResult=numerator*num2;
			deResult=denominator*de2;
			Rational result=new Rational(numResult,deResult);
			return result;			
		}
		public Rational devides(Rational b){
			int num2,de2,numResult,deResult;
			num2=b.getNum();
			de2=b.getDe();
			numResult=numerator/num2;
			deResult=denominator/de2;
			Rational result=new Rational(numResult,deResult);
			return result;			
		}
		public boolean equals(Rational b){
			int num2,de2;
			num2=b.getNum();
			de2=b.getDe();
			if(num2==numerator && de2==denominator){
				return true;
			}
			else{
				return false;
			}
		}
		public String toString(){
			String rational;
			rational=Integer.toString(numerator)+"\\"+Integer.toString(denominator);
			return rational;
		}
		
	}	
}
