package chap03;

import java.util.Scanner;

//******************************************
// ����ƥ��  ����ջ������
//*******************************************

public class CheckBrackets 
{
	// �жϵ�ǰ������������Ƿ���Ժ�ջ��������ƥ��
	public static boolean check(char temp,SqStack s)
	{
		if(temp == ')')
		{
			if(s.getTop().toString().equals("(")) // ջ����Ԫ���� ( ,�����ÿ��Ժ� �� ƥ�䣬�򵯳�ջ����Ԫ�� ��
				s.pop();   
			else                                  // ջ����Ԫ�ز����������� �� ƥ�䣬�򷵻� false����ʵҲ�Ϳ����ж������Ŵ����Ϸ�
				return false;
		}
		else if(temp == ']')
		{
			if(s.getTop().toString().equals("[")) // ջ����Ԫ���� [ ,�����ÿ��Ժ� ] ƥ�䣬�򵯳�ջ����Ԫ�� ��
			{
				s.pop();
			}
			else                                  // ջ����Ԫ�ز����������� ] ƥ�䣬�򷵻� false����ʵҲ�Ϳ����ж������Ŵ����Ϸ�
				return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		SqStack s = new SqStack(); // ջ�������������
		String bracket = null; // ��Ŷ�������Ŵ�
		
		Scanner scan = new Scanner(System.in);		
		bracket = scan.nextLine(); // ��ȡ���е����Ŵ�
		
		char [] brackets = bracket.toCharArray(); // ����ȡ���������ַ���ת����һ��һ�������ţ����һ��char���͵�����
		
		s.push(brackets[0]); // ����һ�����Ų���ջ���˴����Ե�һ��������  �� �� [
		
		for(int i=1; i<brackets.length; i++)
		{
			char temp = brackets[i];
			
			if(temp=='(' || temp=='[') // �����ţ�����ջ
			{
			    s.push(temp);
			}
			else                       // �����ţ������ж�
			{
				if(!CheckBrackets.check(temp,s))
					break; // �������Ϸ������ţ��������ټ�����������ˣ�ֱ������ѭ��
			}
		}
		
		if(s.isEmpty())
			System.out.println("�Ϸ�");
		else
			System.out.println("���Ϸ�");
	}
}
/*
 *  ��������
 *  [([][][([][()])])]   �Ϸ�
 *  [(])                 ���Ϸ�
 * 
 * */


