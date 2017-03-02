package chap02;

//******************************************
// ���Ա�   �ӿ�
//******************************************

public interface LinearList
{
	//������Ա�
	public void clear();
	//�ж����Ա��Ƿ�Ϊ��
	public boolean isEmpty();
	//�������Ա�������Ԫ�صĸ���
	public int length();
	//��ȡ��i��Ԫ�ص�ֵ
	public Object get(int index);
	//��λԪ�أ����ص�һ�������ֵ��ͬ��Ԫ�ص�λ�ã��������򷵻�0
	public int locate(Object element);
	//�޸�ĳλ�õ�Ԫ��
	public void set(int index, Object element);
	//ɾ��Ԫ��
	public void delete(int index);
	//����Ԫ�ص�β��
	public void insert(Object element);
	//���Ԫ�ص�ָ��λ��
	public void insert(int index, Object element);
	//��ӡ���Ա�
	public void print();
}
