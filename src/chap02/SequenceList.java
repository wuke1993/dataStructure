package chap02;

//******************************************
// ���Ա��˳��ʵ�֣���������
//******************************************

public class SequenceList implements LinearList 
{
    private Object[] sList;  // ���飬���Ա��˳���ʾ
    private int size;        // ����Ԫ�صĸ���  �˴�Ӧ���ó�length�õ��  sizeӦ�ô����������Ա�Ŀռ��С
    
    // ���캯��  
    public SequenceList() // �޲�
    {
    	this(3);// Ĭ�ϴ�СΪ3
    	size = 0;
    }
	public SequenceList(int length) // �в�
	{
		if(length <= 0)
		{
			this.sList = new Object[3];
			size = 0;
		}
		
		this.sList = new Object[length];
		size = 0;
	}
	
	// ������Ա�
	public void clear()
	{
		if(size != 0)  // �ж����Ա�Ϊ��
		{
			for(int i=0; i<size; i++)
			{
				sList[i] = null;
			}
			size = 0; // �����Ҫ����
		}
	}

    // �ж����Ա��Ƿ�Ϊ��
	public boolean isEmpty() 
	{
		if(size == 0)
		    return true;
		else
			return false;
	}
    
	// �������Ա�������Ԫ�صĸ���
	public int length()
	{
		return size;
	}
	
	// ��ȡ index ��Ԫ�ص�ֵ
	public Object get(int index) 
	{
		if(index >= 0 && index < size)
			return sList[index];
		else
		{
			System.out.println("Խ���ֵΪ��");
		    return null;
		}
	}

	// ��λԪ�أ����ص�һ�������ֵ��ͬ��Ԫ�ص�λ�ã��������򷵻�0
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

	// �޸�ĳλ�õ�Ԫ��
	public void set(int index, Object element) 
	{
        if(index >= 0 && index < sList.length)
        {
        	sList[index] = element;
        }
        else
        	System.out.println("Խ��");
	}

	// ɾ��Ԫ�أ������Ԫ����ǰ��
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
			System.out.println("Խ��");
	}
	
	// ����Ԫ�ص�β��
	public void insert(Object element) 
	{
		// insert(size,element);
		
		if(size == sList.length)
		{
			//System.out.println("���Ա����������ܲ���"); // �˴��ɽ�������
			
			this.expand(); // ��������
			sList[size] = element;
			size++;
		}
		else
		{
		    sList[size] = element;
		    size++;
		}
	}
	
	// ���Ԫ�ص�ָ��λ��
	public void insert(int index, Object element) 
	{
		if(size == sList.length)
		{
			//System.out.println("���Ա����������ܲ���"); // �˴��ɽ�������
			this.expand();
			for(int i=size;i>index;i--) // index���Լ�����Ԫ�����˳��һλ
			{
				sList[i]=sList[i-1];
			}
			sList[index]=element;
			size++;
		}
		else if(index<0 || index>size) // �����±겻��С��0��Ҳ���ܴ���size����Ϊsize�����Ժ��Ԫ��Ϊ��
			System.out.println("Խ��");
		else
		{
			for(int i=size;i>index;i--) // index���Լ�����Ԫ�����˳��һλ
			{
				sList[i]=sList[i-1];
			}
			sList[index]=element;
			size++;
		}
	}
	
	// ���ݣ�����Ϊ����
	public void expand()
	{
		int len = sList.length;
		Object[] temp = sList;
		
		sList = new Object[len*2];		
		for(int i=0; i<len; i++)
			sList[i] = temp[i];
		
		System.out.println("���Ա�������");
	}
	
	// ��ӡ
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
		
		seq.insert(9, "newone");  // Խ�� // �����±겻��С��0��Ҳ���ܴ���size����Ϊsize�����Ժ��Ԫ��Ϊ��
		seq.print();
		
		seq.delete(1);
		seq.print();
		
		seq.insert(4);seq.insert(5);seq.insert(6);seq.insert(7);
		seq.insert(8);seq.insert(9);seq.insert(10);
		seq.print();
		
		seq.insert(11);  // Խ��,������
		seq.print();
		
		System.out.println(seq.get(3));
		
		System.out.println(seq.locate("three"));
	}
}
