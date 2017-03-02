package chap02;

//******************************************
// ���Ա����ʽʵ��    ͷ�ڵ���Ҳ�洢����
//******************************************

class Node  // �ڵ�
{
	Object node;
	Node next; //
}

public class LinkedList implements LinearList
{
	private Node header = null;
	private int size; 
	
	// ���캯��
	public LinkedList()
	{
		this.header = new Node();
		size = 0;
	}
	
	// �������
	public void clear() 
	{
		this.header = null; // �˴�û�����ٶ���
		size = 0;
	}

	// �Ƿ�Ϊ��
	public boolean isEmpty() 
	{
		if(size == 0)
			return true;
		else
		    return false;
	}

	// ��������ĳ���
	public int length() 
	{
		return size;
	}

	// �ж�index�ĺϷ���
	public boolean checkIndex(int index)
	{
		if(index>size || index<0)
		{
			System.out.println("����ֵ�д�" + index);
			return false;
		}
		else
			return true;
	}
	
	// ��ȡ index λ���ϵĽڵ㣬��һ���ڵ�  index��Ϊ0
	public Object get(int index) 
	{
		//���ж���������ȷ��
	    if(!(this.checkIndex(index))) // ����ֵ���Ϸ�
	    {
	    	
	    	return null;
	    }
	    else // ����ֵ�Ϸ�
	    {
	    	Node p = new Node();
	    	p = header;    // ��ʼ����pָ���һ���ڵ�header		
	    	int j = 0;     // jΪ������
		
	    	while(j != index)
	    	{
	    		p = p.next;
	    		j++;
	    	}
	    	return p;
		}
	}

	// ��λ��0 1 2 3 4 5 6 7...
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

	//�޸�ĳλ�õ�Ԫ��
	public void set(int index, Object element) 
	{
		//���ж���������ȷ��
	    if(this.checkIndex(index))
	    {
	    	Node p = new Node();
	    	p = header;    // ��ʼ����pָ���һ���ڵ�header		
	    	int j = 0;     // jΪ������
		
	    	while(j != index)
	    	{
	    		p = p.next;
	    		j++;
	    	}
	    	p.node = element;
		}
	}

	// ɾ���ڵ�  ɾ����һ���ڵ�������ע��
	public void delete(int index) 
	{
		//���ж���������ȷ��
	    if(!(this.checkIndex(index)))
	    {
	    	//System.out.println("����ֵ�д�" + index);
	    }
	    
	    else if((size == 1) && (index == 0)) // ɾ�����ǵ�һ���ڵ㣬��ֻ��һ���ڵ�
	    {
	    	header = null;
	    	size = 0;
	    }
	    else if((size >1) && (index == 0)) // ɾ�����ǵ�һ���ڵ㣬��ֻ��һ���ڵ�
	    {
	    	header = header.next;
	    	size--;
	    }
	    else
	    {
	    	Node p = new Node();
	    	p = (Node) this.get(index-1); // ����get()�������indexǰһ���ڵ�
	    	p.next = p.next.next;
	    	
	    	size--;
	    }
	}

	// ĩ�˲���
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
			last = (Node) this.get(size-1); // ����get()����������һ���ڵ�
			
			Node newLast = new Node();
			newLast.node = element;
			
			last.next = newLast;
			size++;
		}
	}

	// ָ��λ�� ����
	public void insert(int index, Object element) 
	{
		//���ж���������ȷ��   ���Ե�������һ������������
	    if(!(this.checkIndex(index)))
	    {
	    	//System.out.println("����ֵ�д�" + index);
	    }
	    else if(index == size) // ĩβ����
	    {
	    	this.insert(element);
	    }
	    else
	    {
	    	Node before = new Node();
			before = (Node) this.get(index-1); // ����get()������� index ǰһ�ڵ�
			
			Node p = new Node();
			p = (Node) this.get(index);			
			
			Node newNode = new Node();
			newNode.node = element;
			
			before.next = newNode;
			newNode.next = p;
			
			size++;
	    }
	}

	// ��ӡ
	public void print() 
	{
		Node p = new Node();
		p = header;    // ��ʼ����pָ���һ���ڵ�header
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
