package firstPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Intervals1089 {

	public static int n;
	public static boolean[] useful; 
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		n=in.nextInt();
		ArrayList<Intervals> list=new ArrayList<Intervals>();
		for(int i=0;i<n;i++){
			Intervals inter=new Intervals();
			inter.setstart(in.nextInt());
			inter.setend(in.nextInt());
			list.add(inter);
		}
		Collections.sort(list,new Comparator<Intervals>(){
			public int compare(Intervals i1,Intervals i2){
				return i1.getstart()-i2.getstart();
			}
		});
		
		int k=0;
		for(Intervals interval:list){
			Intervals nextinter=new Intervals();
			if(k==list.size()-1){
				System.out.println(""+interval.getstart()+" "+interval.getend());
				break;
			}
			nextinter=list.get(k+1);
			if(interval.getend()<nextinter.getstart())
				System.out.println(""+interval.getstart()+" "+interval.getend());
			else{
				list.get(k+1).setstart(interval.getstart());
				list.get(k+1).setend(interval.getend()>nextinter.getend()?
						interval.getend():nextinter.getend());
			}
			++k;
		}
	}

}

class Intervals {
	private int start;
	private int end;
	public int getstart(){
		return start;
	}
	public void setstart(int start){
		this.start=start;
	}
	public int getend(){
		return end;
	}
	public void setend(int end){
		this.end=end;
	}
}
