package firstPage;

import java.util.Scanner;
import java.util.Stack;


public class WebNavigation1028 {
	
	public static void main(String[] args){
		Stack<String> backStack = new Stack<String>();
		Stack<String> forwardStack = new Stack<String>();
        Scanner in = new Scanner(System.in);
        String currentPage = "http://www.acm.org/";
        String word = in.next();
        while (!"QUIT".equals(word)) {
			if (word.equals("VISIT")) {
				backStack.push(currentPage);
				currentPage = in.next();
				if (!forwardStack.isEmpty()) {
					forwardStack.clear();
				}
				System.out.println(currentPage);
			}
			if ("BACK".equals(word)) {
				if (!backStack.isEmpty()) {
					forwardStack.push(currentPage);
					currentPage = backStack.pop();
					System.out.println(currentPage);
				}else {
					System.out.println("Ignored");
				}
				
			}
			if ("FORWARD".equals(word)) {
				if (!forwardStack.isEmpty()) {
					backStack.push(currentPage);
					currentPage = forwardStack.pop();
					System.out.println(currentPage);
				} else {
					System.out.println("Ignored");
				}
				
			}
			word = in.next();
		}
	}
}
	