package secondPage;

import java.util.Scanner;

public class Square2362 {

	public static int side;
	public static int[] lengths;
	public static boolean[] used;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N=in.nextInt();
		while(N-->0){
			int n=in.nextInt();
			lengths=new int[n];
			int sum=0;
			for(int i=0;i<n;i++){
				lengths[i]=in.nextInt();
				sum+=lengths[i];
			}
			side=sum/4;
			if(side*4!=sum){
				System.out.println("no");
				continue;
			}
			sort(lengths);
			if(lengths[0]>side){
				System.out.println("no");
				continue;
			}
			used=new boolean[n];
			for(int i=0;i<n;i++)
				used[i]=false;
			
			boolean result=true;
			result=splice(side,0,0);
						
			if(result)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}

	private static boolean splice(int lengthneeded,int begin,int dones) {
		int n=lengths.length;
		if(dones==3)
			return true;
		for(int i=begin;i<n;i++){
			if(used[i])
				continue;
			used[i]=true;
			if(lengths[i]==lengthneeded){
				if(splice(side,0,dones+1))
				return true;
			}
			if(lengths[i]<lengthneeded){
				if(splice(lengthneeded-lengths[i],i+1,dones))
				return true;
			}
			used[i]=false;
		}
		return false;
	}

	private static void sort(int[] lengths) {
		int n=lengths.length;
		int loc,max;
		for(int i=0;i<n-1;i++){
			max=lengths[i];
			loc=i;
            for(int j=i+1;j<n;j++){
				if(lengths[j]>max){
					max=lengths[j];
					loc=j;
				}
			}
            int temp=lengths[i];
            lengths[i]=lengths[loc];
            lengths[loc]=temp;
		}
			
	}

}
