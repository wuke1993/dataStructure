package test360;

import java.util.Scanner;
import java.util.Stack;

public class Test1 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNext())
		{
		    int n = scan.nextInt(); // 存储输入字符串的长度，但是没有用到，直接用 scan.next() 读入整个字符串
		    int m = scan.nextInt(); // 用m组测试数据
		
		    String str = scan.next();
		    char[] chars = str.toCharArray();
		    
		    for(int j=0; j<m;j++)
		    {
		    	// 替换
		    	int x = scan.nextInt(); // 替换字符的位置
		    	String c = scan.next(); // 用来替换的字符
		    	
		    	chars[x-1] = c.toCharArray()[0]; // 进行替换
				
				int count = 0; // 计数，进行了几次    ".." -> "." 的替换
	
				Stack s = new Stack(); // 栈
				s.push(chars[0]);      // 第一个字符入栈
				
				// 遍历剩余所有的字符，进行判断是否存在".."，具体比较方法为，读入一个字符，若其为'.'并且栈顶元素也为'.'，则存在".."
				for(int i=1; i<chars.length;i++)
				{
					if(chars[i] == '.' && s.peek().equals('.'))
					{
							count++; // 满足".."，计数
					}
					else
					{
						s.push(chars[i]); // 不满足".."，则将此字符入栈
					}
				}
				
				System.out.println(count);
		    }
		}
	}
}
