package firstPage;

import java.math.BigDecimal;
import java.util.Scanner;

public class Exponentiation1001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
		int n;
		BigDecimal r=new BigDecimal(0);
		while(in.hasNext()){
			r=in.nextBigDecimal();
			n=in.nextInt();
			double x=Math.log(n)/Math.log(2);
			int i=(int)x;
			int j=n-(int)Math.pow(2, i);
			BigDecimal remain=r.pow(j);
			for(int k=0;k<i;k++){
				r=r.multiply(r);
			}
			r=r.multiply(remain).stripTrailingZeros();
			System.out.println(r.toPlainString().replaceAll("^0.", "."));
		}
	}
}
