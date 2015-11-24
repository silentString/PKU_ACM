package firstPage;

import java.util.Scanner;

public class ToTheMax1050 {

	public static int n;
	public static int[][] nums;
	public static int[][] sum;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		sum=new int[n][n];
		nums=new int[n][n];
		int i,j,width,height;
		for(i=0;i<n;i++)
			for(j=0;j<n;j++){
				nums[i][j]=in.nextInt();
			}
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
		        summing(i,j);
		int max=0;
		int sumsequ=0;
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
				for(width=0;width<n-i;width++)
					for(height=0;height<n-j;height++){
						sumsequ=sum[i+width][j+height]-sum[i][j+height]-sum[i+width][j]+sum[i][j];
						if(sumsequ>max)
							max=sumsequ;
					}
		System.out.println(max);
				
	}
	private static void summing(int m,int n) {
		int sumOfm=0;
		for(int j=0;j<n;j++)
			sumOfm+=nums[m][j];
		if(m>0)
		    sum[m][n]= sumOfm+sum[m-1][n];
		else
			sum[m][n]= sumOfm;	
	}

}

