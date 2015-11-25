package firstPage;

import java.util.Scanner;

public class Hangover1003 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int results[]=new int[100];
		int count=0;
		while(true){
			float length=in.nextFloat();
			if(length==0)
				break;
			float l=0;
			int i=1;
			for(;l<length;i++)
				l=l+1/(float)(i+1);
			results[count++]=i-1;
		}
		for(int j=0;j<count;j++)
			System.out.println(results[j]+" card(s)");
	}

}