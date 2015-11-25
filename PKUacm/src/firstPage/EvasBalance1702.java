package firstPage;

import java.util.Scanner;

public class EvasBalance1702 {
	
	static int i=0;
	public static void main(String arg[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while (n!=0) {
			int W = in.nextInt();
			int[] aLeft = new int[21];
			transfer(W,aLeft);
			System.out.println(balance(aLeft));
			i = 0;
			n--;
		}
	}

	private static String balance(int[] aLeft) {
		String aString = "",bString = "";
		for (int j = 0; j < i+1; j++) {
			if (aLeft[j]==2) {
				aLeft[j]=0;
				aLeft[j+1]++;
				bString = bString + String.valueOf((int)Math.pow(3,j))+",";
			}
			if (aLeft[j]==3) {
				aLeft[j]=0;
				aLeft[j+1]++;
			}
		}
		
		for (int j = 0; j < i+1; j++) {
			if (aLeft[j]==1) {
				aString = aString + String.valueOf((int)Math.pow(3,j))+",";
			}
		}
		return bString.equals("")?"empty"+" "+aString.substring(0,aString.length()-1):bString.substring(0,bString.length()-1)+" "+aString.substring(0,aString.length()-1);
	}

	private static void transfer(int w2, int[] aLeft) {
		if (w2 ==0) {
			return ;
		}else {
			aLeft[i++] = w2%3;
			transfer(w2/3, aLeft);
		}
	}
}