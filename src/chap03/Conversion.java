package chap03;

//******************************************
// ����ת����ʮ����ת��Ϊ�˽���
// �����ʺ���ջʵ�֣�����ȳ�
//*******************************************

import java.util.Scanner;

public class Conversion 
{

	public static void convertToEight()
	{
		SqStack s = new SqStack();
		
		Scanner scan = new Scanner(System.in);		
		int num = scan.nextInt();
		
		while(num > 0)
		{
			s.push(num%8);
			num = num/8;
			System.out.println(num);
		}
		s.printStack();
	}
	public static void main(String[] args) 
	{
		Conversion.convertToEight();
	}

}
