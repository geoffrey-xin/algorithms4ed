package algorithms4ed;
import java.util.Scanner;
import java.util.Random;

public class C1S1 {
	public static void showArray(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
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
	
	//1.1.3
	public static String equalOrNot(){
		int a,b,c;
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入第一个整数:");
		a=Integer.parseInt(scan.nextLine());
		System.out.println("请输入第二个整数:");
		b=Integer.parseInt(scan.nextLine());
		System.out.println("请输入第三个整数:");
		c=Integer.parseInt(scan.nextLine());
		
		if(a==b && b==c){
			return "Equal";
		}
		else{
			return "Not Equal";
		}
	}
	
	//1.1.5
	public static boolean inIntervel(){
		double x,y;
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入第一个数:");
		x=Double.parseDouble(scan.nextLine());
		System.out.println("请输入第二个数:");
		y=Double.parseDouble(scan.nextLine());
		System.out.println("都严格在0到1之间？");
		if (Math.abs(x)<1 && Math.abs(y)<1){
			return true;
		}
		else{
			return false;
		}
	}
	
	//1.1.7
	public static void printP7(){
		double t=9.0;
		while (Math.abs(t-9.0/t)> .001)
			t=(9.0/t+t)/2.0;
		System.out.printf("%.9f\n",t);
		
		int sum1=0;
		for (int i=1;i<1000;i++)
			for (int j=0;j<i;j++)
				sum1++;
		System.out.println(Double.toString(sum1));
		
		int sum2=0;
		for (int i=1;i<1000;i*=2)
			for (int j=0;j<1000;j++)
				sum2++;
		System.out.println(Double.toString(sum2));
		System.out.println("a"+"b");
	}
	
	//1.1.9
	public static void changeIntToBinaryString(){
		int n,remainder = 5;
		String result="";
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入一个整数:");
		n = Integer.parseInt(scan.nextLine());
		while (n>0){
			remainder=Math.floorMod(n, 2);
			n=n/2;
			result=Integer.toString(remainder)+result;
		}
		System.out.println(result);
	}
	
	//1.1.11
	public static void printBooleanList(){
		String[] row1,row2;
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入二维布尔数组的第一行，用英文逗号隔开，不要加空格:");
		row1=scan.nextLine().split(",");
		System.out.println("请输入二维布尔数组的第二行，用英文逗号隔开，不要加空格:");
		row2=scan.nextLine().split(",");
		for(int i=0;i<2;i++){
			if(row1[i].equals("true")){
				row1[i]="*";
			}
			else{
				row1[i]=" ";
			}
		}
		for(int i=0;i<2;i++){
			if(row2[i].equals("true")){
				row2[i]="*";
			}
			else{
				row2[i]=" ";
			}
		}
		String[][] row=new String[3][3];
		row[0][0]=" ";
		row[0][1]="1";
		row[0][2]="2";
		row[1][0]="1";
		row[2][0]="2";
		System.arraycopy(row1, 0, row[1], 1, 2);
		System.arraycopy(row2, 0, row[2], 1, 2);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(row[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	//1.1.14
	public static long powerOfInt(int base,int N){
		if(N==0){
			return 1;
		}
		else{
			return base*powerOfInt(base,N-1);
		}	
	}
	public static int getNP14(){
		int n;
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入一个整数:");
		n = Integer.parseInt(scan.nextLine());
		return n;
	}
	public static int getBaseP14(){
		int base;
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入底数:");
		base =Integer.parseInt(scan.nextLine());
		return base;
	}
	public static int lg(int N,int base,int n){
		if(C1S1.powerOfInt(base,n-N+1)>n){
			return n-N;
		}
		else{
			return lg(N-1,base,n);
		}
	}
	
	//1.1.15
	public static int[] histogram(int[] a,int M){
		int[] count=new int[M];
		for(int i=0;i<a.length;i++){
			if(a[i]<M){
				count[a[i]]+=1;
			}
		}
		return count;
	}
	public static int[] getArrayP15(){
		String[] list;
		System.out.println("请输入一行数组，用逗号隔开");
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		list=scan.nextLine().split(",");
		int[] reArray=new int[list.length];
		for(int i=0;i<list.length;i++){
			reArray[i]=Integer.parseInt(list[i]);
		}
		return reArray;
	}
	public static int getMP15(){
		int M;
		System.out.println("请输入一个整数");
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		M=Integer.parseInt(scan.nextLine());
		return M;
	}
	
	//1.1.20
	public static double lnFact(int N){
		if(N==0){
			return 0;
		}
		else if(N==1){
			return 0;
		}
		else{
			return lnFact(N-1)+Math.log(N);
		}
	}
	
	//1.1.30
	public static boolean[][] relativelyPrime(int N){
		boolean[][] relaPri=new boolean[N][N];
		boolean rePri=true;
		for(int i=0;i<N;i++){
			for(int j=0;j<i;j++){
				for(int k=2;k<=j+1;k++){
					if((i+1)%k==0 && (j+1)%k==0){
						relaPri[i][j]=false;
						rePri=false;
						break;
					}
				}
				if(rePri==true){
					relaPri[i][j]=true;
				}
				rePri=true;
				relaPri[j][i]=relaPri[i][j];
			}
		}
		relaPri[0][0]=true;
		return relaPri;
	}
	
	//1.1.36
	public static void shuffleTest(int M,int N){
		int[] a=new int[M];
		int[][] result =new int[M][M];
		int temp,r;
		Random ran=new Random();
		
		for(int count=1;count<=N;count++){
			for(int i=0;i<M;i++){
				a[i]=i;
			}
			for(int j=M;j>0;j--){
				r=ran.nextInt(j);
				temp=a[r];
				a[r]=a[j-1];
				a[j-1]=temp;
			}
			for(int i=0;i<M;i++){
				result[a[i]][i]+=1;
			}
		}
		show2DArray(result);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
