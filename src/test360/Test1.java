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
		    int n = scan.nextInt(); // �洢�����ַ����ĳ��ȣ�����û���õ���ֱ���� scan.next() ���������ַ���
		    int m = scan.nextInt(); // ��m���������
		
		    String str = scan.next();
		    char[] chars = str.toCharArray();
		    
		    for(int j=0; j<m;j++)
		    {
		    	// �滻
		    	int x = scan.nextInt(); // �滻�ַ���λ��
		    	String c = scan.next(); // �����滻���ַ�
		    	
		    	chars[x-1] = c.toCharArray()[0]; // �����滻
				
				int count = 0; // �����������˼���    ".." -> "." ���滻
	
				Stack s = new Stack(); // ջ
				s.push(chars[0]);      // ��һ���ַ���ջ
				
				// ����ʣ�����е��ַ��������ж��Ƿ����".."������ȽϷ���Ϊ������һ���ַ�������Ϊ'.'����ջ��Ԫ��ҲΪ'.'�������".."
				for(int i=1; i<chars.length;i++)
				{
					if(chars[i] == '.' && s.peek().equals('.'))
					{
							count++; // ����".."������
					}
					else
					{
						s.push(chars[i]); // ������".."���򽫴��ַ���ջ
					}
				}
				
				System.out.println(count);
		    }
		}
	}
}
