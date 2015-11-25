package firstPage;

import java.util.Scanner;

public class BallToss1234 {

	public static int person;
	public static int first;
	public static int tosses=0;
	public static String[] direction;
	public static boolean[] catched;
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(true){
			person=in.nextInt();
			if(0==person)
				break;			
			first=in.nextInt();
			direction=new String[person];
			catched=new boolean[person];
			for(int i=0;i<person;i++){
				direction[i]=in.next();
				catched[i]=false;
			}
			direction[0]=change(direction[0]);
			int last=playGame(0,first-1,0);
			System.out.println("Classmate "+(last+1)+" got the ball " +
					"last after "+tosses+" tosses.");
			tosses=0;
		}
	}

	private static String change(String str) {
		if(str.equals("L"))
			return "R";
		else
			return "L";
	}

	private static int playGame(int i, int j, int done) {
		++tosses;
		direction[i]=change(direction[i]);
		if(!catched[j]){
			++done;
			catched[j]=true;
		}
		if(done==person)
			return j;
		if(direction[j].equals("L")){
			if((i-1+person)%person!=j)
				return playGame(j,(i-1+person)%person,done);	
			else
				return playGame(j,(j-1+person)%person,done);			
		}
		else{
			if((i+1)%person!=j)
				return playGame(j,(i+1)%person,done);
			else
				return playGame(j,(j+1)%person,done);
		}
	}

}
