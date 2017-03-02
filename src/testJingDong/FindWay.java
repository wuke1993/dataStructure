package testJingDong;

import java.util.Scanner;

public class FindWay {
	
    public static void find(char[] c1,char[] c2) {
    	// eight situations
    	int x = c2[0] - c1[0];
    	int y = c1[1] - c2[1];
    	
     	if(x > 0 && y > 0) {
    		System.out.println(c2[0] - c1[0]);
    		
    		if(x >=1 && y >= 1) {
    			while((x--) > 0 && (y--) > 0)
    				System.out.println("RD");
  
    			++x;	
    		}
    		if(x > 0) {
    			while((x--) > 0)
    				System.out.println('R');
    		}
    		if(y > 0) {
    			while((y--) > 0)
    				System.out.println('D');
    		}
    	}
     	else if(x > 0 && y < 0) {
            System.out.println(Math.abs(c2[1] - c1[1]) );
    		
    		if(x >=1 && y <= -1) {
    			while((x--) > 0 && (y++) < 0)
    				System.out.println("RU");
    			
    			++x;
    		}
    		if(x > 0) {
    			while((x--) > 0)
    				System.out.println('R');
    		}
    		if(y < 0) {
    			while((y++) < 0)
    				System.out.println('U');
    		}
     	}
     	else if(x < 0 && y > 0) {
     		System.out.println(c1[0] - c2[0]);
     		
     		if(x <= -1 && y >= 1) {
    			while((x++) < 0 && (y--) > 0)
    				System.out.println("LD");
    			
    			--x;
    		}
     		if(x < 0) {
    			while((x++) < 0)
    				System.out.println('L');
    		}
    		if(y > 0) {
    			while((y--) > 0)
    				System.out.println('D');
    		}
     	}
     	else if(x < 0 && y < 0){
     		System.out.println(c1[0] - c2[0]);
     		if(x <= -1 && y <= -1) {
    			while((x++) < 0 && (y++) < 0)
    				System.out.println("LU");
    			
    			--x;		
    		}
     		if(x < 0) {
    			while((x++) < 0)
    				System.out.println('L');
    		}
    		if(y < 0) {
    			while((y++) < 0)
    				System.out.println('U');
    		}
     	}
    }
    
	public static void main(String[] args) {
		String str1 = null;
		String str2 = null;
		
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			str1 = scan.nextLine();
			str2 = scan.nextLine();
			
			char[] c1 = str1.toCharArray();
			char[] c2 = str2.toCharArray();
			
			find(c1,c2);
		}
	}
}
