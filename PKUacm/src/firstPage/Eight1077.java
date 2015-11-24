package firstPage;

import java.util.ArrayList;
import java.util.Scanner;

public class Eight1077 {

	static final int N = 9;
	static int aimStatus = 0;
	static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
	static char[] directions = {'u','d','l','r'};
	static boolean vis[] = new boolean[1000000];
	static int[] fac = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	static String path = "";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] cur = new int[N];
		Node start = new Node();
		for(int i=0; i<N; i++){
			String temp = scanner.next();
			if(temp.equals("x")){
				cur[i] = 0;
				start.loc = i;
			}else {
				cur[i] = Integer.parseInt(temp);
			}
		}
		start.str = cur;
		start.status = calStatus(start.str);
		start.path = "";
		int[] aim = {1,2,3,4,5,6,7,8,0};
		aimStatus = calStatus(aim);
		if(bfs(start)){
			System.out.println(path);
		}else {
			System.out.println("unsolvable");
		}
		scanner.close();
	}
	
	private static boolean bfs(Node cur){
		Node node, next;
		ArrayList<Node> queue = new ArrayList<Node>();
		int curUse = 0;
		queue.add(cur);
		while(curUse<queue.size()){
			node = queue.get(curUse);
			curUse++;
			if(node.status == aimStatus){
				path = node.path;
				return true;
			}
			int x = node.loc/3;
			int y = node.loc%3;
			for(int i=0; i<4; i++){
				int tx = x+move[i][0];
				int ty = y+move[i][1];
				if(tx<0||tx>2||ty<0||ty>2)
					continue;
				next = new Node();
				next.copy(node);
				next.loc = tx*3 + ty;
				next.str[node.loc] = next.str[next.loc];
				next.str[next.loc] = 0;
				next.status = calStatus(next.str);
				if(!vis[next.status]){
					vis[next.status] = true;
					next.path += directions[i];
					if(next.status == aimStatus){
						path = next.path;
						return true;
					}
					queue.add(next);
				}
			}
		}
		return false;
	}
	
	private static int calStatus(int[] s){
		int result = 0;
		for(int i=0; i<N; i++){
			int num = 0;
			for(int j=i+1; j<N; j++){
				if(s[j]>s[i])
					num++;
			}
			result += num * fac[N-i-1];
		}
		return result;
	}

}

class Node{
	int[] str = new int[9];
	int loc;
	int status;
	String path;
	public void copy(Node node){
		for(int i=0; i<9; i++){
			this.str[i] = node.str[i];
		} 
		this.loc = node.loc;
		this.status = node.status;
		this.path = node.path;
	}
}