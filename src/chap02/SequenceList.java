package chap02;

//******************************************
// 线性表的顺序实现，借助数组
//******************************************

public class SequenceList implements LinearList 
{
    private Object[] sList;  // 数组，线性表的顺序表示
    private int size;        // 所含元素的个数  此处应设置成length好点儿  size应该代表整个线性表的空间大小
    
    // 构造函数  
    public SequenceList() // 无参
    {
    	this(3);// 默认大小为3
    	size = 0;
    }
	public SequenceList(int length) // 有参
	{
		if(length <= 0)
		{
			this.sList = new Object[3];
			size = 0;
		}
		
		this.sList = new Object[length];
		size = 0;
	}
	
	// 清空线性表
	public void clear()
	{
		if(size != 0)  // 判断线性表不为空
		{
			for(int i=0; i<size; i++)
			{
				sList[i] = null;
			}
			size = 0; // 这个不要忘了
		}
	}

    // 判断线性表是否为空
	public boolean isEmpty() 
	{
		if(size == 0)
		    return true;
		else
			return false;
	}
    
	// 返回线性表中数据元素的个数
	public int length()
	{
		return size;
	}
	
	// 获取 index 处元素的值
	public Object get(int index) 
	{
		if(index >= 0 && index < size)
			return sList[index];
		else
		{
			System.out.println("越界或值为空");
		    return null;
		}
	}

	// 定位元素，返回第一个与给定值相同的元素的位置，不存在则返回0
	public int locate(Object element) 
	{
		for(int i=0; i< size; i++)
		{
			if(sList[i].equals(element))
			{
				return i;
			}
		}
		return 0;
	}

	// 修改某位置的元素
	public void set(int index, Object element) 
	{
        if(index >= 0 && index < sList.length)
        {
        	sList[index] = element;
        }
        else
        	System.out.println("越界");
	}

	// 删除元素，后面的元素向前移
	public void delete(int index) 
	{
		if(index >= 0 && index < size)
		{
			for(int i=index; i<(size-1); i++)
			{
				sList[i] = sList [i+1];
			}
			
			sList[size-1] = null;
			size--;
		}
		else
			System.out.println("越界");
	}
	
	// 插入元素到尾部
	public void insert(Object element) 
	{
		// insert(size,element);
		
		if(size == sList.length)
		{
			//System.out.println("线性表已满，不能插入"); // 此处可进行扩容
			
			this.expand(); // 扩容两倍
			sList[size] = element;
			size++;
		}
		else
		{
		    sList[size] = element;
		    size++;
		}
	}
	
	// 添加元素到指定位置
	public void insert(int index, Object element) 
	{
		if(size == sList.length)
		{
			//System.out.println("线性表已满，不能插入"); // 此处可进行扩容
			this.expand();
			for(int i=size;i>index;i--) // index处以及其后的元素向后顺移一位
			{
				sList[i]=sList[i-1];
			}
			sList[index]=element;
			size++;
		}
		else if(index<0 || index>size) // 数组下标不能小于0，也不能大于size，因为size及其以后的元素为空
			System.out.println("越界");
		else
		{
			for(int i=size;i>index;i--) // index处以及其后的元素向后顺移一位
			{
				sList[i]=sList[i-1];
			}
			sList[index]=element;
			size++;
		}
	}
	
	// 扩容，扩大为两倍
	public void expand()
	{
		int len = sList.length;
		Object[] temp = sList;
		
		sList = new Object[len*2];		
		for(int i=0; i<len; i++)
			sList[i] = temp[i];
		
		System.out.println("线性表已扩容");
	}
	
	// 打印
	public void print() 
	{
		for(int i=0;i<size;i++)
			System.out.print(sList[i] +"  ");
		System.out.println();
	}

	public static void main(String[] args)
	{
		SequenceList seq = new SequenceList(10);
		seq.insert("one");
		seq.insert(2);
		seq.print();
		
		System.out.println(seq.isEmpty());
		
		seq.insert("three");
		seq.insert(0, "newone");
		seq.print();
		
		seq.insert(9, "newone");  // 越界 // 数组下标不能小于0，也不能大于size，因为size及其以后的元素为空
		seq.print();
		
		seq.delete(1);
		seq.print();
		
		seq.insert(4);seq.insert(5);seq.insert(6);seq.insert(7);
		seq.insert(8);seq.insert(9);seq.insert(10);
		seq.print();
		
		seq.insert(11);  // 越界,需扩容
		seq.print();
		
		System.out.println(seq.get(3));
		
		System.out.println(seq.locate("three"));
	}
}
