package firstPage;

import java.util.Scanner;

public class Skee1088 {

	public static int[][] roadLength;
	public static int[][] height;
	public static int r,c;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		r=in.nextInt();
		c=in.nextInt();
		height=new int[r][c];
		roadLength=new int[r][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				height[i][j]=in.nextInt();
				roadLength[i][j]=-1;
			}
		}
		int maxLength=-1;
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				roadLength[i][j]=findRoad(i,j);
				if(roadLength[i][j]>maxLength)
					maxLength=roadLength[i][j];
			}
		}
		System.out.println(maxLength);
	}
	
	private static int findRoad(int i, int j) {
		if(roadLength[i][j]>-1)
			return roadLength[i][j];
		int[] roadHgt={0,0,0,0};//иосробвС
		int[] roadLen={1,1,1,1};
		if(i-1>=0){
			roadHgt[0]=height[i-1][j];
			if(roadHgt[0]<height[i][j])
				roadLen[0]=1+findRoad(i-1,j);
		}
			
		if(j+1<c){
			roadHgt[1]=height[i][j+1];
			if(roadHgt[1]<height[i][j])
				roadLen[1]=1+findRoad(i,j+1);
		}
			
		if(i+1<r){
			roadHgt[2]=height[i+1][j];
			if(roadHgt[2]<height[i][j])
				roadLen[2]=1+findRoad(i+1,j);
		}
			
		if(j-1>=0){
			roadHgt[3]=height[i][j-1];
			if(roadHgt[3]<height[i][j])
				roadLen[3]=1+findRoad(i,j-1);
		}
		int max=-1;
		for(int k=0;k<4;k++)
			if(roadLen[k]>max)
				max=roadLen[k];
		roadLength[i][j]=max;
		return max;
	}

}

