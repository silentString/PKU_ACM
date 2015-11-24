package firstPage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;


public class P1002{
    public static void main(String[] args){
    	Map<String, Integer> mapString = new TreeMap<String, Integer>();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        while(n>0){
        	String  phoneNumber =in.next();
        	phoneNumber = dispose(phoneNumber);
        	if (mapString.containsKey(phoneNumber)) {
				int k = mapString.get(phoneNumber);
				k++;
				mapString.put(phoneNumber, k);
			}else {
				mapString.put(phoneNumber, 1);
			}
        	n--;
        }
        Iterator<Entry<String, Integer>>  iter = mapString.entrySet().iterator();
        int flag =0;
		while (iter.hasNext()) {
			Map.Entry<String, Integer> entry = iter.next();
			if (entry.getValue()>=2) {
				System.out.println(entry.getKey()+" "+entry.getValue());
				flag =1;
			}
		}
		if (flag == 0) {
			System.out.println("No duplicates.");
		}
    }

	private static String dispose(String phoneNumber) {
		StringBuffer newNuber = new StringBuffer("") ;
		for (int i = 0; i < phoneNumber.length(); i++) {
			char m = phoneNumber.charAt(i);
			m=transformChar(m);
			if (m!='#') {
				newNuber.append(m);
			}
			if (newNuber.length()==3) {
				newNuber.append('-');
			}
		}
		return newNuber.toString();
	}

	private static char transformChar(char c) {
		if (Character.isDigit(c)) {  
            return c;  
        }  
   
    //如果这个字符是A或B或C，则返回2.以下规则类似
        if (c == 'A' || c == 'B' || c == 'C') {  
            return '2';  
        }  
        if (c == 'D' || c == 'E' || c == 'F') {  
            return '3';  
        }  
        if (c == 'G' || c == 'H' || c == 'I') {  
            return '4';  
        }  
        if (c == 'J' || c == 'K' || c == 'L') {  
            return '5';  
        }  
        if (c == 'M' || c == 'N' || c == 'O') {  
            return '6';  
        }  
        if (c == 'P' || c == 'R' || c == 'S') {  
            return '7';  
        }  
        if (c == 'T' || c == 'U' || c == 'V') {  
            return '8';  
        }  
        if (c == 'W' || c == 'X' || c == 'Y') {  
            return '9';  
        }  
        return '#';  
	}
}