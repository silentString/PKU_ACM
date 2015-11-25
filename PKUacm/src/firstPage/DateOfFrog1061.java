package firstPage;

import java.util.Scanner;

public class DateOfFrog1061 {

	public static long t,p;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		long x=in.nextLong();
		long y=in.nextLong();
		long m=in.nextLong();
		long n=in.nextLong();
		long L=in.nextLong();
		long a=m-n,b=L,c=y-x;
		if(a<0){
			a=-a;
			c=-c;
		}
		long d=extendgcd(a,b);
		if((m==n&&x!=y)||c%d!=0)
			System.out.println("Impossible");
		else{
			a=a/d;
			b=b/d;
			c=c/d;
			extendgcd( a, b);
			t=c*t;
			System.out.println((t%b+b)%b);
		}
	}
	
	public static long extendgcd(long a,long b){
		if(b==0){
			t=1;
			p=0;
			return a;
		}
		long d=extendgcd(b,a%b);
		long temp=t;
		t=p;
		p=temp-a/b*t;
		return d;
	}

}

