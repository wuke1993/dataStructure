package chap03;

//******************************************
// ˳��ջ��ʵ��
// ��������
//*******************************************

public class SqStack
{
	static int STACK_INIT_SIZE = 10; //Ĭ��ջ�ĳ�ʼ����
	static int STACKINCREMENT = 5;  //ÿ��ջ����ʱ���ӵĳ���
	int stackSize; // ��ǰ�ѷ���Ĵ洢�ռ�
	
	int base; // ջ��ָ��
	int top;  // ջ��ָ��
	
	private Object[] sqStack;  // ���飬ջ��˳���ʾ
	
	// ���캯����ջ�ĳ�ʼ��
	SqStack()
	{
		this.sqStack = new Object[STACK_INIT_SIZE];
		top = base = 0;
		stackSize = STACK_INIT_SIZE;
	}
	
	// ���ջ
	public void clearStack()
	{
		top = 0;
	}
	
	// �ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty()
	{
		if(top == base && top == 0)
			return true;
		else
			return false;
	}
	
	// ջ��Ԫ�صĸ���
	public int length()
	{
		return top-base;
	}
	
	// ��ȡջ��Ԫ��
	public Object getTop()
	{
		return sqStack[top-1];
	}
	
	// ����Ԫ��
	public void push(Object element)
	{
		// ���ж��Ƿ�ջ��
		if((top-base) == stackSize)
		{
			// ����
			this.expand();			
		}

		sqStack[top] = element;
		top++;
		System.out.println("������Ԫ�أ�" + element);	
	}
	
	// ջ����
	public void expand()
	{
		Object [] temp = new Object[stackSize + STACKINCREMENT];
		for(int i=0; i<top; i++)
		{
			temp[i] = sqStack[i];
		}
		sqStack = temp;
		stackSize += STACKINCREMENT;
		System.out.println("ջ�����ݣ�");
	}
	
	// ����Ԫ��
	public void pop()
	{
		// �ж�ջ�Ƿ�Ϊ��
		if(this.isEmpty())
			System.out.println("ջΪ�գ�û��Ԫ�ؿɵ�����");
		else
		{
			top--;
			System.out.println("����Ԫ�أ�" + sqStack[top]);
		}
	}
	
	// ������ӡ
	public void printStack()
	{
		if(top==base)
			System.out.println("ջΪ�գ���Ԫ�ش�ӡ��");
		else
		{
			System.out.print("ջ��Ԫ��Ϊ��  ");
			for(int i=base; i<top; i++)
				System.out.print(sqStack[i] + "  ");
			System.out.println();
		}
	}

	// ������ ����
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
		System.out.println("ջ��Ԫ��Ϊ��  " +s.getTop());
		
		System.out.println("ջ��Ԫ�ظ���Ϊ��  " + s.length());
		
		s.push(2);s.push(3);s.push(4);s.push(5);s.push(6);s.push(7);s.push(8);s.push(9);s.push(10);
		s.printStack();
		
		s.push(11);
		s.printStack();
	}
}