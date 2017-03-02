package chap02;

//******************************************
// 线性表的链式实现    头节点中也存储数据
//******************************************

class Node  // 节点
{
	Object node;
	Node next; //
}

public class LinkedList implements LinearList
{
	private Node header = null;
	private int size; 
	
	// 构造函数
	public LinkedList()
	{
		this.header = new Node();
		size = 0;
	}
	
	// 清空链表
	public void clear() 
	{
		this.header = null; // 此处没有销毁对象
		size = 0;
	}

	// 是否为空
	public boolean isEmpty() 
	{
		if(size == 0)
			return true;
		else
		    return false;
	}

	// 返回链表的长度
	public int length() 
	{
		return size;
	}

	// 判断index的合法性
	public boolean checkIndex(int index)
	{
		if(index>size || index<0)
		{
			System.out.println("索引值有错：" + index);
			return false;
		}
		else
			return true;
	}
	
	// 获取 index 位置上的节点，第一个节点  index即为0
	public Object get(int index) 
	{
		//先判断索引的正确性
	    if(!(this.checkIndex(index))) // 索引值不合法
	    {
	    	
	    	return null;
	    }
	    else // 索引值合法
	    {
	    	Node p = new Node();
	    	p = header;    // 初始化，p指向第一个节点header		
	    	int j = 0;     // j为计数器
		
	    	while(j != index)
	    	{
	    		p = p.next;
	    		j++;
	    	}
	    	return p;
		}
	}

	// 定位，0 1 2 3 4 5 6 7...
	public int locate(Object element) 
	{
		Node p = new Node();
		p = header;
		
		for(int i=0; i<size; i++)
		{
			if(p.node.equals(element))
				return i;
		}			
		return 0;
	}

	//修改某位置的元素
	public void set(int index, Object element) 
	{
		//先判断索引的正确性
	    if(this.checkIndex(index))
	    {
	    	Node p = new Node();
	    	p = header;    // 初始化，p指向第一个节点header		
	    	int j = 0;     // j为计数器
		
	    	while(j != index)
	    	{
	    		p = p.next;
	    		j++;
	    	}
	    	p.node = element;
		}
	}

	// 删除节点  删除第一个节点的情况需注意
	public void delete(int index) 
	{
		//先判断索引的正确性
	    if(!(this.checkIndex(index)))
	    {
	    	//System.out.println("索引值有错：" + index);
	    }
	    
	    else if((size == 1) && (index == 0)) // 删除的是第一个节点，且只有一个节点
	    {
	    	header = null;
	    	size = 0;
	    }
	    else if((size >1) && (index == 0)) // 删除的是第一个节点，不只有一个节点
	    {
	    	header = header.next;
	    	size--;
	    }
	    else
	    {
	    	Node p = new Node();
	    	p = (Node) this.get(index-1); // 调用get()函数获得index前一个节点
	    	p.next = p.next.next;
	    	
	    	size--;
	    }
	}

	// 末端插入
	public void insert(Object element) 
	{
		if(size == 0)
		{
			header.node = element;
			size++;
		}
		else
		{
			Node last = new Node();
			last = (Node) this.get(size-1); // 调用get()函数获得最后一个节点
			
			Node newLast = new Node();
			newLast.node = element;
			
			last.next = newLast;
			size++;
		}
	}

	// 指定位置 插入
	public void insert(int index, Object element) 
	{
		//先判断索引的正确性   可以单独做成一个函数！！！
	    if(!(this.checkIndex(index)))
	    {
	    	//System.out.println("索引值有错：" + index);
	    }
	    else if(index == size) // 末尾插入
	    {
	    	this.insert(element);
	    }
	    else
	    {
	    	Node before = new Node();
			before = (Node) this.get(index-1); // 调用get()函数获得 index 前一节点
			
			Node p = new Node();
			p = (Node) this.get(index);			
			
			Node newNode = new Node();
			newNode.node = element;
			
			before.next = newNode;
			newNode.next = p;
			
			size++;
	    }
	}

	// 打印
	public void print() 
	{
		Node p = new Node();
		p = header;    // 初始化，p指向第一个节点header
		if(size != 0)
		{
		    System.out.print(p.node + "  ");
		    while(p.next != null)
		    {
		    	p = p.next;
		    	System.out.print(p.node + "  ");
		    }
		    System.out.println();
		}
	}

	public static void main(String[] args)
	{
		LinkedList link = new LinkedList();
		link.insert("a");
		link.insert("b");
		link.insert("c");
		link.insert("d");
		link.insert("e");
		link.insert("f");
		link.insert("g");
		link.insert("h");
//		link.print();
//		
//		link.insert(1, "c");
//		link.print();
//		
//		System.out.println(link.locate("a"));
//		
//		link.delete(0);
//		link.print();
//		
//		link.set(1,"a");
//		link.print();
//		
//		Node tem= (Node) (link.get(0));
//		System.out.println(tem.node);
//		
//		link.clear();
//		link.print();
//		
//		System.out.println("end");
	}
}
