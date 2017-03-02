package chap03;

import java.util.Scanner;

//******************************************
// 括号匹配  利用栈的特性
//*******************************************

public class CheckBrackets 
{
	// 判断当前输入的右括号是否可以和栈顶的括号匹配
	public static boolean check(char temp,SqStack s)
	{
		if(temp == ')')
		{
			if(s.getTop().toString().equals("(")) // 栈顶的元素是 ( ,则正好可以和 ） 匹配，则弹出栈顶的元素 ）
				s.pop();   
			else                                  // 栈顶的元素不能与右括号 ） 匹配，则返回 false，其实也就可以判定此括号串不合法
				return false;
		}
		else if(temp == ']')
		{
			if(s.getTop().toString().equals("[")) // 栈顶的元素是 [ ,则正好可以和 ] 匹配，则弹出栈顶的元素 ）
			{
				s.pop();
			}
			else                                  // 栈顶的元素不能与右括号 ] 匹配，则返回 false，其实也就可以判定此括号串不合法
				return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		SqStack s = new SqStack(); // 栈，用来存放括号
		String bracket = null; // 存放读入的括号串
		
		Scanner scan = new Scanner(System.in);		
		bracket = scan.nextLine(); // 获取所有的括号串
		
		char [] brackets = bracket.toCharArray(); // 将获取到的括号字符串转化成一个一个的括号，存进一个char类型的数组
		
		s.push(brackets[0]); // 将第一个括号插入栈，此处断言第一个括号是  （ 或 [
		
		for(int i=1; i<brackets.length; i++)
		{
			char temp = brackets[i];
			
			if(temp=='(' || temp=='[') // 左括号，则入栈
			{
			    s.push(temp);
			}
			else                       // 右括号，进行判断
			{
				if(!CheckBrackets.check(temp,s))
					break; // 遇到不合法的括号，则无需再检测后面的括号了，直接跳出循环
			}
		}
		
		if(s.isEmpty())
			System.out.println("合法");
		else
			System.out.println("不合法");
	}
}
/*
 *  测试用例
 *  [([][][([][()])])]   合法
 *  [(])                 不合法
 * 
 * */


