package chap03;

//******************************************
// 顺序栈的实现
// 借助数组
//*******************************************

public class SqStack
{
	static int STACK_INIT_SIZE = 10; //默认栈的初始长度
	static int STACKINCREMENT = 5;  //每次栈扩容时增加的长度
	int stackSize; // 当前已分配的存储空间
	
	int base; // 栈底指针
	int top;  // 栈顶指针
	
	private Object[] sqStack;  // 数组，栈的顺序表示
	
	// 构造函数，栈的初始化
	SqStack()
	{
		this.sqStack = new Object[STACK_INIT_SIZE];
		top = base = 0;
		stackSize = STACK_INIT_SIZE;
	}
	
	// 清空栈
	public void clearStack()
	{
		top = 0;
	}
	
	// 判断栈是否为空
	public boolean isEmpty()
	{
		if(top == base && top == 0)
			return true;
		else
			return false;
	}
	
	// 栈中元素的个数
	public int length()
	{
		return top-base;
	}
	
	// 获取栈顶元素
	public Object getTop()
	{
		return sqStack[top-1];
	}
	
	// 插入元素
	public void push(Object element)
	{
		// 先判断是否栈满
		if((top-base) == stackSize)
		{
			// 扩容
			this.expand();			
		}

		sqStack[top] = element;
		top++;
		System.out.println("插入了元素：" + element);	
	}
	
	// 栈扩容
	public void expand()
	{
		Object [] temp = new Object[stackSize + STACKINCREMENT];
		for(int i=0; i<top; i++)
		{
			temp[i] = sqStack[i];
		}
		sqStack = temp;
		stackSize += STACKINCREMENT;
		System.out.println("栈已扩容！");
	}
	
	// 弹出元素
	public void pop()
	{
		// 判断栈是否为空
		if(this.isEmpty())
			System.out.println("栈为空！没有元素可弹出！");
		else
		{
			top--;
			System.out.println("弹出元素：" + sqStack[top]);
		}
	}
	
	// 遍历打印
	public void printStack()
	{
		if(top==base)
			System.out.println("栈为空，无元素打印！");
		else
		{
			System.out.print("栈中元素为：  ");
			for(int i=base; i<top; i++)
				System.out.print(sqStack[i] + "  ");
			System.out.println();
		}
	}

	// 主函数 测试
	public static void main(String[] args)
	{
		SqStack s = new SqStack();
		s.push("one");
		s.push("two");
		s.printStack();
		
		s.pop();
		s.printStack();
		
		s.pop();
		s.pop();
		s.printStack();
		
		s.push(1);
		System.out.println("栈顶元素为：  " +s.getTop());
		
		System.out.println("栈中元素个数为：  " + s.length());
		
		s.push(2);s.push(3);s.push(4);s.push(5);s.push(6);s.push(7);s.push(8);s.push(9);s.push(10);
		s.printStack();
		
		s.push(11);
		s.printStack();
	}
}