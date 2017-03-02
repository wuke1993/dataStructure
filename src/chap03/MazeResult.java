package chap03;

//*****************************************
// �Թ��������
//*****************************************

class Point  // ͨ����
{
	int x;          // ������
	int y;          // ������
	int direction;  // �Ӵ�ͨ����������һͨ����ġ����򡱣�1 2 3 4 �ֱ����  ��  ��  ��  ��

	public void setDirection(int direction) 
	{
		this.direction = direction;
	}

	public Point(int xx,int yy,int direct)	// ���캯��
	{
		this.x = xx;
		this.y = yy;
		this.direction = direct;
	}
}

public class MazeResult   // ����̬
{   
	// �Թ�,10*10,������һ��Ϊǽ       1����ǽ������ͨ��0����·���ߣ�2�������߹���ͨ���飬3�����߹����ѻ��˵�ͨ���� 
	static final int [][] MAZE = 
		   {{1,1,1,1,1,1,1,1,1,1},
            {1,0,0,1,0,0,0,1,0,1},
            {1,0,0,1,0,0,0,1,0,1},
            {1,0,0,0,0,1,1,0,0,1},
            {1,0,1,1,1,0,0,0,0,1},
            {1,0,0,0,1,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,0,1},
            {1,0,1,1,1,0,1,1,0,1},
            {1,1,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1}};
	                                                
	static SqStack MAZEPATH = new SqStack();        // �洢̽����·�����洢һ��һ����Point����
	
	// �ж��Ƿ񵽴��յ�     ��̬     Ҳ��֪����̬�ò��ã�����
	public static boolean arrive()
	{
		if( ((Point)MAZEPATH.getTop()).x==8 && ((Point)MAZEPATH.getTop()).y==8 )
		    return true;
		else
			return false;
	}
	
	// ��ӡ·��
    public static void printMazePath()
    {
    	for(int i=0; i<10;i++)
    	{
    		for(int j=0;j<10;j++)
    		{
    			System.out.print(MAZE[i][j]);
    		}
    		System.out.println();
    	}
    }
	
	public static void main(String[] args)
	{
		int[][] move = {{0,1},{1,0},{0,-1},{-1,0}}; // �ĸ���ͬ̽�������Ϻ�������ı任
		
	    Point p = new Point(1,1,1);   // ��㣬�����÷���Ϊ1������
	    MAZEPATH.push(p);             // �����ջ
	    
	    // ̽���Թ�
	    while( !(MAZEPATH.isEmpty()) ) // ѭ��������ջ��Ϊ�գ��˴�վ��Ϊ����֤���Ѿ����˵���㣩
	    {
	    	int x = ((Point)MAZEPATH.getTop()).x;            // ��ǰλ�õĺ�����
	    	int y = ((Point)MAZEPATH.getTop()).y;            // ��ǰλ�õ�������
	    	int d = ((Point)MAZEPATH.getTop()).direction;    // ��ǰλ�õ�ǰ������
	    	
	    	// �����̽4������
	    	while(d <= 4)
	    	{
	    		// ���ݷ��������һλ�õ�����ֵ
	    		int tempx = x + move[d-1][0];
	    		int tempy = y + move[d-1][1];
	    		
	    		if(MAZE[tempx][tempy] == 0) // �ɴ�
	    		{	    			
	    			// �ı䵱ǰλ�õ�ǰ������
	    			((Point)MAZEPATH.getTop()).direction = d; 
	    			
	    			// ����µ�λ�õ�ջ��
	    			p = new Point(tempx,tempy,1); 
	    			MAZEPATH.push(p);
	    			System.out.println(p.x + "  " + p.y);
	    			
	    			// ���Թ�����λ�ô���Ϊ2����ʾ�Ѿ�ͨ��	   
	    			MAZE[tempx][tempy] = 2;  			
	    			
	    			if(arrive()) // �ж��Ƿ��Ѿ������յ�
	    			{
	    				System.out.println("�ҵ������ˣ�");
	    				
	    				printMazePath(); // ��ӡ����·��
	    				
	    				return;
	    			}
	    			
	    			break; // ����   while(d <= 4)
	    		}
	    		else // �任����
	    		{
	    			d++;
	    		}
	    	}
	    	// ��Χ4�������߲�ͨ
	    	if(d == 5) 
	    	{
	    		MAZE[x][y] = 3; // ���Թ��е�ǰλ�ô���Ϊ3��3�����߹����ѻ��˵�ͨ���� 
	    		MAZEPATH.pop();
	    		
	    	}
	    }
	    
	    System.out.println("δ�ҵ����ڣ�");
	}
}
