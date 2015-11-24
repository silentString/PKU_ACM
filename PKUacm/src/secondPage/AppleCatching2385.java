package secondPage;

import java.util.Scanner;

public class AppleCatching2385{

	public static int apples;
	public static int[] dropTree;
	public static int standTree;
	public static int[] count;
	public static int[][][][] note;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		apples=in.nextInt();
		int moves=in.nextInt();
		dropTree=new int[apples];
		count=new int[apples];
		for(int i=0;i<apples;i++)
			dropTree[i]=in.nextInt();
		standTree=1;
		boolean theTree;
		if(standTree==dropTree[0])
			theTree=true;
		else 
			theTree=false;
		count[0]=1;
		int i,j;
		for(i=0,j=0;i<apples-1;i++){
			if(dropTree[i+1]==dropTree[i])
				++count[j];
			else{
				count[++j]=1;
			}
		}
		note=new int[2][j+2][j+2][moves+1];
		for(int m=0;m<2;m++)
			for(int n=0;n<j+2;n++)
				for(int l=0;l<j+2;l++)
					for(int k=0;k<moves+1;k++)
						note[m][n][l][k]=-1;
		int catched=0;
		if(moves==0)
			catched=catchApple(theTree,0,j+1,moves);
		else
			catched=Math.max(catchApple(theTree,0,j+1,moves), catchApple(!theTree,0,j+1,moves-1));
		System.out.println(catched);
	}
	private static int catchApple(boolean theTree,int begin, int end,int moves) {
		int num=theTree?1:0;
		if(note[num][begin][end][moves]!=-1)
			return note[num][begin][end][moves];
		if(begin==end)
			return 0;
		int sum=0;
		if(moves==0){
			if(theTree){
				for(int i=begin;i<end;i+=2)
					sum+=count[i];
			}else{
				for(int i=begin+1;i<end;i+=2)
					sum+=count[i];
			}
			note[num][begin][end][moves]=sum;
			return sum;
		}else{
			if(theTree){
				note[num][begin][end][moves]=Math.max(count[begin]+catchApple(true,begin+1,end,moves-1), 
						count[begin]+catchApple(false,begin+1,end,moves));
				return note[num][begin][end][moves];
			}
			else{
				note[num][begin][end][moves]=Math.max(catchApple(false, begin+1,end,moves-1),
						catchApple(true,begin+1,end,moves));
				return note[num][begin][end][moves];
			}
		}
	}

}
