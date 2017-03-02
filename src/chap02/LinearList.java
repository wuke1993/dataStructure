package chap02;

//******************************************
// 线性表   接口
//******************************************

public interface LinearList
{
	//清空线性表
	public void clear();
	//判断线性表是否为空
	public boolean isEmpty();
	//返回线性表中数据元素的个数
	public int length();
	//获取第i个元素的值
	public Object get(int index);
	//定位元素，返回第一个与给定值相同的元素的位置，不存在则返回0
	public int locate(Object element);
	//修改某位置的元素
	public void set(int index, Object element);
	//删除元素
	public void delete(int index);
	//插入元素到尾部
	public void insert(Object element);
	//添加元素到指定位置
	public void insert(int index, Object element);
	//打印线性表
	public void print();
}
